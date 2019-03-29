package com.hikvision.baseknowledge.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/15 19:26
 * @version V1.0.0
 */
public class SemaphoreTest {

	public static void main(String[] args) {
	    int n = 8;
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < n; i++) {
			new Worker(i, semaphore).start();
		}


	}

	static class Worker extends Thread{
		private int num;
		private Semaphore semaphore;
		public Worker(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人" + this.num + "占用一个机器在生产...");
				Thread.sleep(2000);
				System.out.println("工人" + this.num + "释放出机器");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
