package com.hikvision.baseknowledge.multithread.sync;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 20:12
 * @version V1.0.0
 */
public class SynchronizedThread {

	public int inc = 0;

	public synchronized void increase() {
		inc++;
	}

	public static void main(String[] args) {
		SynchronizedThread synchronizedThread = new SynchronizedThread();
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					synchronizedThread.increase();
				}
			}).start();
		}
		System.out.println(Thread.activeCount());

		while(Thread.activeCount() > 1 ) {
			Thread.yield();
		}
		System.out.println("test.inc" );
	}
}
