package com.hikvision.baseknowledge.multithread.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 20:25
 * @version V1.0.0
 */
public class AtomicIntegerThread {

	public AtomicInteger inc = new AtomicInteger();

	public void increase() {
		inc.getAndIncrement();
	}

	public static void main(String[] args) {
		AtomicIntegerThread atomicIntegerThread = new AtomicIntegerThread();
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					atomicIntegerThread.increase();
				}
			}).start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("test.inc");
	}


}
