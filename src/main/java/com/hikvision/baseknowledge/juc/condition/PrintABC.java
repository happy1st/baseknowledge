package com.hikvision.baseknowledge.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/15 10:37
 * @version V1.0.0
 */
public class PrintABC {

	private Lock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();
	private String type = "A";

	public void printA() throws InterruptedException {
		lock.lock();
		while (!"A".equals(type)) {
			conditionA.await();
		}
		System.out.println(Thread.currentThread().getName() + "正在打印A  " + type);
		type = "B";
		conditionB.signal();
		lock.unlock();
	}

	public void printB() throws InterruptedException {
		lock.lock();
		while (!"B".equals(type)) {
			conditionB.await();
		}
		System.out.println(Thread.currentThread().getName() + "正在打印B  " + type);
		type = "C";
		conditionC.signal();
		lock.unlock();
	}

	public void printC() throws InterruptedException {
		lock.lock();
		while (!"C".equals(type)) {
			conditionC.await();
		}
		System.out.println(Thread.currentThread().getName() + "正在打印C  " + type);
		type = "A";
		conditionA.signal();
		lock.unlock();
	}

}
