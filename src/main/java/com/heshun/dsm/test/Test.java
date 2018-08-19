package com.heshun.dsm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.heshun.dsm.util.LogFactory;

public class Test {

	public static volatile List<Integer> lists = new ArrayList<Integer>();

	static Random r = new Random();

	public static void main(String[] args) {
		testLog();
		// testNub();
	}

	private static void testLog() {
		int count = 0;
		for (;;) {
			if (count >= 10000) {
				break;
			}
			String message = String.valueOf(count++);
			LogFactory.getLogger(message).info(message);
		}

	}

	static void testNub() {
		System.out.println(30038 / 10000);
	}

	void testList() {

		for (int i = 0, j = 2; i < j; i++) {
			lists.add(r.nextInt());
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < lists.size(); i++) {
					System.out.println(i + "///" + lists.get(i) + "|||" + lists.size());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (;;) {
					lists.add(r.nextInt());
					try {
						Thread.sleep(1100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
