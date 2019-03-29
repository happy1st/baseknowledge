package com.hikvision.baseknowledge.multithread.createthread;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 16:26
 * @version V1.0.0
 */
public class ExtendThread extends Thread {

	private String name;

	private int ticket;

	public ExtendThread(String name) {
		this.name = name;
	}

	@Override
	public synchronized void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + this.name + " " + ticket++ );
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

	public static void main(String[] args) {
		ExtendThread extendThread1 = new ExtendThread("thread1");
		ExtendThread extendThread2 = new ExtendThread("thread2");
		ExtendThread extendThread3 = new ExtendThread("thread3");
		extendThread1.start();
		extendThread2.start();
		extendThread3.start();

	}
}
