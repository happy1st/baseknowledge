package com.hikvision.baseknowledge.multithread.lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/8 9:17
 * @version V1.0.0
 */
public class ReadWriteLockDemo {

	// 模拟共享资源
	private int number;

	// 实际实现类ReentrantReadWriteLock，默认非公平模式
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	// 读
	public void get() {
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " : " + number);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	// 写
	public void set(int number) {
		readWriteLock.writeLock().lock();
		try {
			this.number = number;
			System.out.println(Thread.currentThread().getName() + " : " + number);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

}
