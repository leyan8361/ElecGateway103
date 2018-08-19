package com.heshun.dsm.handler.strategy.switchmodule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.cmd.Command;
import com.heshun.dsm.handler.helper.IgnorePackageException;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.util.ELog;
import com.heshun.dsm.util.SessionUtils;

public class SwitchModuleProxy {

	protected void handleControl(IoSession s, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws IgnorePackageException, PacketInCorrectException {

		HashMap<String, byte[]> config = SessionUtils.getSwitchConfig(s);
		if (config != null && !config.isEmpty()) {
			for (Entry<Integer, byte[]> entry : yxData.entrySet()) {
				int index = entry.getKey();
				int flag = entry.getValue()[0];

				// 获取构造控制命令的参数
				byte[] commandParams = config.get(index + "-" + flag);

				if (commandParams != null) {
					byte[] msg = Command.getControlCommand(commandParams);
					s.write(msg);
					String log = "[control]需要远程联动,从配置文件构造遥控命令====>>>>" + Arrays.toString(msg);
					ELog.getInstance().log(log, s);
				}
			}
		}

	}
}
