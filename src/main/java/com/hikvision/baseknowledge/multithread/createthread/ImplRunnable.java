package com.hikvision.baseknowledge.multithread.createthread;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 16:36
 * @version V1.0.0
 */
public class ImplRunnable implements Runnable {

	private int counter = 0;

	@Override
	public synchronized void run() {

		for (int i = 0; i < 100000; i++) {

			System.out.println(Thread.currentThread().getName() + " count: " + counter++);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

	public static void main(String[] args) {
		ImplRunnable implRunnable = new ImplRunnable();
		Thread thread1 = new Thread(implRunnable, "thread1");
		Thread thread2 = new Thread(implRunnable, "thread2");
		Thread thread3 = new Thread(implRunnable, "thread3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
