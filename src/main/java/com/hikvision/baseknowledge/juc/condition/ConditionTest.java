package com.hikvision.baseknowledge.juc.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/14 16:38
 * @version V1.0.0
 */
public class ConditionTest {

	private int queueSize = 10;

	private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

	private Lock lock = new ReentrantLock();

	private Condition notFull = lock.newCondition();

	private Condition notEmpty = lock.newCondition();


	public static void main(String[] args) throws Exception{
		ConditionTest test = new ConditionTest();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();
		consumer.start();
		producer.start();
		Thread.sleep(0);
		producer.interrupt();
		consumer.interrupt();
	}

	class Consumer extends Thread{

		@Override
		public void run() {
			consumer();
		}

		volatile boolean flag = true;
		private void consumer() {
			while (flag) {
				lock.lock();
				try {
					while (queue.size() == 0) {
						System.out.println("队列为空，等待数据.......");
						notEmpty.await();
					}
					Thread.sleep(900);
					queue.poll();
					notFull.signal();
					System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
				} catch (Exception e) {
					flag = false;
				} finally {
					lock.unlock();
				}
			}
		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			producer();
		}
		volatile boolean flag = true;
		private void producer() {
			while (flag) {
				lock.lock();
				try {
					while (queue.size() == queueSize) {
						System.out.println("队列已满，等待空闲空间........");
						notFull.await();
					}
					Thread.sleep(900);
					queue.offer(1);
					notEmpty.signal();
					System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
				} catch (Exception e) {
					flag = false;
				} finally {
					lock.unlock();
				}

			}
		}
	}

}
