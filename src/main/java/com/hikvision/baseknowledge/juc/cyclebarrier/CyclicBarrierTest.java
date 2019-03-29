package com.hikvision.baseknowledge.juc.cyclebarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * //parties表示屏障拦截的线程数量，当屏障撤销时，先执行barrierAction，然后在释放所有线程
 * public CyclicBarrier(int parties, Runnable barrierAction)
 * //barrierAction默认为null
 * public CyclicBarrier(int parties)
 *
 *
 *  当前线程等待直到所有线程都调用了该屏障的await()方法
 *  如果当前线程不是将到达的最后一个线程，将会被阻塞。解除阻塞的情况有以下几种
 *     1）最后一个线程调用await()
 *     2）当前线程被中断
 *     3）其他正在该CyclicBarrier上等待的线程被中断
 *     4）其他正在该CyclicBarrier上等待的线程超时
 *     5）其他某个线程调用该CyclicBarrier的reset()方法
 *  如果当前线程在进入此方法时已经设置了该线程的中断状态或者在等待时被中断，将抛出InterruptedException，并且清除当前线程的已中断状态。
 *  如果在线程处于等待状态时barrier被reset()或者在调用await()时 barrier 被损坏，将抛出 BrokenBarrierException 异常。
 *  如果任何线程在等待时被中断，则其他所有等待线程都将抛出 BrokenBarrierException 异常，并将 barrier 置于损坏状态。
 *  *如果当前线程是最后一个将要到达的线程，并且构造方法中提供了一个非空的屏障操作（barrierAction），那么在允许其他线程继续运行之前，当前线程将运行该操作。
 *  如果在执行屏障操作过程中发生异常，则该异常将传播到当前线程中，并将 barrier 置于损坏状态。
 *
 *  返回值为当前线程的索引，0表示当前线程是最后一个到达的线程
 *
 *public int await()throws InterruptedException,BrokenBarrierException
	* //在await()的基础上增加超时机制，如果超出指定的等待时间，则抛出 TimeoutException 异常。如果该时间小于等于零，则此方法根本不会等待。
	*public int await(long timeout,TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException
	*
	* //将屏障重置为其初始状态。如果所有参与者目前都在屏障处等待，则它们将返回，同时抛出一个BrokenBarrierException。
	*public void reset()
 *
 *
 * 实现原理
 *     基于ReentrantLock和Condition机制实现。除了getParties()方法，CyclicBarrier的其他方法都需要获取锁。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/15 13:40
 * @version V1.0.0
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// cyclicBarrier可以重复用
		for (int i = 0; i < 3; i++) {
			executorService.submit(new Thread(new Runner(cyclicBarrier, "1号选手")));
			executorService.submit(new Thread(new Runner(cyclicBarrier, "2号选手")));
			executorService.submit(new Thread(new Runner(cyclicBarrier, "3号选手")));
		}

	}

}

class Runner implements Runnable {

	private CyclicBarrier cyclicBarrier;

	private String name;

	public Runner(CyclicBarrier cyclicBarrier, String name) {
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000* (new Random()).nextInt(8));
			System.out.println(name + " 准备好了");
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + " 起跑！");
	}
}
