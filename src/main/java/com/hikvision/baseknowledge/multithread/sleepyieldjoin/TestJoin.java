package com.hikvision.baseknowledge.multithread.sleepyieldjoin;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/11 15:02
 * @version V1.0.0
 */
public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()-> {
			for (int i = 0; i < 10; i++) {
				System.out.println("线程第 " + i + " 次执行");
			}
		});
		thread.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("主线程第 " + i + "次执行");
			if (i >= 2) {
				thread.join();
			}
		}
	}
}
