package com.hikvision.baseknowledge.multithread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 20:20
 * @version V1.0.0
 */
public class LockThread {

	public int inc = 0;

	public Lock lock = new ReentrantLock();

	public void increase() {
		lock.lock();
		try {
			inc++;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final LockThread lockThread = new LockThread();
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					lockThread.increase();
				}
			}).start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("test.inc");
	}


}
