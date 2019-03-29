package com.hikvision.baseknowledge.multithread.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/11 18:43
 * @version V1.0.0
 */
public class Son implements Cloneable {

	public static void main(String[] args) {
		Son p = new Son();
		System.out.println(p);
		Thread t = new Thread(() -> {
			ThreadLocal<Son> threadLocal = new ThreadLocal<>();
			System.out.println(threadLocal);
			threadLocal.set(p);
			System.out.println(threadLocal.get());
			threadLocal.remove();
			try {
				threadLocal.set((Son)p.clone());
				System.out.println(threadLocal.get());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			System.out.println(threadLocal);
		});
		t.start();
	}
}
