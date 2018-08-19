package com.heshun.dsm.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.global.DataBuffer;

public class FrameCenter implements ActionListener {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final int CONTRAL_PANEL_WIDTH = 100;
	private JButton btnList;
	private JButton btnCommand;
	private JButton btnClearCache;
	private JButton btnCommit;// 命令提交
	private JTextArea tfCommand;// 命令
	private JTextArea tfResult;// 命令
	private int logtype;// 管理机地址
	private IoSession currentSession;
	private JPanel cPanel;
	private CardLayout card;

	public FrameCenter(IoSession session) {
		this.currentSession = session;
		logtype = session.getAttribute("logotype") == null ? -1 : (int) session.getAttribute("logotype");
		tfResult = new JTextArea();
		btnList = new JButton("设备列表");
		btnCommand = new JButton("发送指令");
		btnClearCache = new JButton("清除缓存");
		btnList.addActionListener(this);
		btnCommand.addActionListener(this);
		btnClearCache.addActionListener(this);
	}

	/**
	 * @return 跳转所需窗口
	 */
	public JFrame detailFrame() {

		JFrame frame = new JFrame(logtype + "号管理机");
		frame.setLayout(new BorderLayout());
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel contralPanel = new JPanel();
		contralPanel.setPreferredSize(new Dimension(CONTRAL_PANEL_WIDTH, HEIGHT));
		contralPanel.add(btnList);
		contralPanel.add(btnCommand);
		contralPanel.add(btnClearCache);

		frame.add(contralPanel, BorderLayout.WEST);

		JPanel cardPanel = cardContener();
		frame.add(cardPanel, BorderLayout.CENTER);

		return frame;
	}

	/**
	 * 设备表格
	 * 
	 * @param rowData
	 * @return
	 */
	public JScrollPane devicesTable() {
		String[][] rowData = makeData();
		String[] columnNames = { "设备地址", "设备类型", "数据帧长度" };
		JTable table = new JTable(rowData, columnNames);
		table.setEnabled(false);
		// 禁止鼠标拖动列
		table.getTableHeader().setReorderingAllowed(false);
		return new JScrollPane(table);
	}

	/**
	 * 命令界面
	 * 
	 * @return
	 */
	public JPanel commandPanel() {
		JPanel comPanel = new JPanel();
		JLabel lable = new JLabel("<html>输入16进制命令(不带CRC校验码)以空格隔开<br> 如: 01 04 00 05 1A</html>", JLabel.CENTER);
		tfCommand = limitInput();
		btnCommit = new JButton("查询");

		// tfCommand.setPreferredSize(new Dimension(WIDTH, 50));
		comPanel.setLayout(new BorderLayout());
		comPanel.add(lable, BorderLayout.NORTH);
		JPanel center = new JPanel(new GridLayout(2, 1, 3, 3));

		JPanel commandText = new JPanel(new BorderLayout());
		commandText.add(new JLabel("命令"), BorderLayout.NORTH);
		commandText.add(tfCommand, BorderLayout.CENTER);
		center.add(commandText);

		JPanel resultText = new JPanel(new BorderLayout());
		resultText.add(new JLabel("结果"), BorderLayout.NORTH);
		resultText.add(tfResult, BorderLayout.CENTER);
		center.add(resultText);

		comPanel.add(center, BorderLayout.CENTER);
		comPanel.add(btnCommit, BorderLayout.SOUTH);
		comPanel.setVisible(true);

		btnCommit.addActionListener(this);
		return comPanel;
	}

	/**
	 * 16进制及自动加空格
	 * 
	 * @param tf
	 */
	public JTextArea limitInput() {
		final JTextArea tf = new JTextArea();

		tf.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (!((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)// 0-9
						|| (keyChar >= KeyEvent.VK_A && keyChar <= KeyEvent.VK_F)// A-F
						|| (keyChar >= 97 && keyChar <= 102) || (keyChar == KeyEvent.VK_SPACE)// a-f
				)) {
					e.consume(); // 关键，屏蔽掉非法输入
				}
			}
		});
		return tf;
	}

	public byte[] isIllegal() {
		String input = tfCommand.getText();
		String[] array = input.split(" ");
		byte[] arrayByte = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() == 2) {
				arrayByte[i] = (byte) (Integer.parseInt(array[i].substring(0, 2), 16) & 0xff);
			} else {
				return null;
			}
		}
		return arrayByte;
	}

	/**
	 * card界面 包含"设备表格"界面和"命令"界面
	 */
	public JPanel cardContener() {
		cPanel = new JPanel();
		card = new CardLayout();
		cPanel.setLayout(card);
		cPanel.add(devicesTable(), "table");
		cPanel.add(commandPanel(), "command");
		return cPanel;
	}

	private int hiddenCount = 0;
	private long fistClickTIme;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnList) {

			card.show(cPanel, "table");

		} else if (e.getSource() == btnCommand) {

			card.show(cPanel, "command");
		} else if (e.getSource() == btnCommit) {
			byte[] array = isIllegal();
			if (array != null) {
				currentSession.write(array);
				tfResult.setText("命令：" + Arrays.toString(array));
			} else {
				tfResult.setText("非法命令");
			}
		} else if (e.getSource() == btnClearCache) {
			if (++hiddenCount == 1) {
				fistClickTIme = System.currentTimeMillis();
				if (logtype >= 0) {
					DataBuffer.getInstance().clearCacheByLogotype(logtype);
					hiddenCount = 0;
				}
				return;
			} else {

				long currTime = System.currentTimeMillis();
				if (currTime - fistClickTIme < 2000) {
					if (++hiddenCount >= 8) {
						DataBuffer.getInstance().clearAll();
						fistClickTIme = 0;
						hiddenCount = 0;

					}
				} else {
					fistClickTIme = 0;
					hiddenCount = 0;
				}
			}

		}
	}

	private String[][] makeData() {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Device> devices = (HashMap<Integer, Device>) currentSession.getAttribute("devices");

		String[][] data = new String[devices.size()][3];
		int i = 0;
		for (Entry<Integer, Device> device : devices.entrySet()) {
			data[i][0] = device.getValue().vCpu + "";
			data[i][1] = device.getValue().model;
			data[i++][2] = device.getValue().length + "";
		}
		return data;
	}
}
