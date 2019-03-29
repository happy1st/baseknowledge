package com.hikvision.baseknowledge.juc.aqs;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/14 10:39
 * @version V1.0.0
 */
public class TestMutex {

	private static CyclicBarrier barrier = new CyclicBarrier(31);
	private static int a = 0;
	private static Mutex mutex = new Mutex();

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 30; i++) {
			Thread t = new Thread(() -> {
				for (int j = 0; j < 10000; j++) {
					increment1();
				}
				try {
					barrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			t.start();
		}

		barrier.await();
		System.out.println("加锁前，a="+a);
		//加锁后
		barrier.reset();//重置CyclicBarrier
		a=0;
		for(int i=0;i<30;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<10000;i++){
						increment2();//a++采用Mutex进行同步处理
					}
					try {
						barrier.await();//等30个线程累加完毕
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		barrier.await();
		System.out.println("加锁后，a="+a);
	}


	private static void increment1() {
		a++;
	}

	private static void increment2() {
		mutex.lock();
		a++;
		mutex.unlock();
	}

}
