package com.hikvision.baseknowledge.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/15 18:57
 * @version V1.0.0
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(2);
		new Thread(() -> {
			System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
			try {
				Thread.sleep(3000);
				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
			try {
				Thread.sleep(3000);
				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		System.out.println("等待2个子线程执行完毕.....");
		latch.await();
		System.out.println("2个子线程执行完毕！");
		System.out.println("继续执行主线程。");
	}


}
