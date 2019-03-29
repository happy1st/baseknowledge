package com.hikvision.baseknowledge.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <p>
 *  ForkJoinTask: 我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。它提供在任务中执行fork()和join的操作机制，通常我们不直接继承ForkjoinTask类，只需要直接继承其子类。
 *
 *     1. RecursiveAction，用于没有返回结果的任务
 *
 *     2. RecursiveTask，用于有返回值的任务
 *
 * · ForkJoinPool：task要通过ForkJoinPool来执行，分割的子任务也会添加到当前工作线程的双端队列中，进入队列的头部。当一个工作线程中没有任务时，会从其他工作线程的队列尾部获取一个任务。
 *
 * ForkJoin框架使用了工作窃取的思想（work-stealing），算法从其他队列中窃取任务来执行
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/13 11:26
 * @version V1.0.0
 */
public class SumTask extends RecursiveTask<Long> {

	public static final int threshold = 2;

	private long start;

	private long end;

	public SumTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {

		Long sum = 0L;

		boolean canCompute = (end - start) <= threshold;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			long middle = (start + end) / 2;
			SumTask leftTask = new SumTask(start, middle);
			SumTask rightTask = new SumTask(middle + 1, end);
			leftTask.fork();
			rightTask.fork();

			Long leftResult = leftTask.join();
			Long rightResult = rightTask.join();
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		long start = 1;
		long end = 1000000000L;
		SumTask sumTask = new SumTask(start, end);
		Long startTime = System.currentTimeMillis();
		Future<Long> integerFuture = forkJoinPool.submit(sumTask);
		try {
			System.out.println(integerFuture.get());
			Long endTime = System.currentTimeMillis();
			System.out.println("use time: " + (endTime - startTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
		long sum = 0;
		Long startTime1 = System.currentTimeMillis();
		for (long i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println("sum : " + sum);
		Long endTime = System.currentTimeMillis();
		System.out.println("use time: " + (endTime - startTime1));
	}
}
