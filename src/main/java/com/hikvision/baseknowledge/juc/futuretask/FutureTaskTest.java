package com.hikvision.baseknowledge.juc.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/18 18:18
 * @version V1.0.0
 */
public class FutureTaskTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		FutureTask<Integer> futureTask = new FutureTask<>(() -> {
			Thread.sleep(2000);
			int result = 1 + 2;
			return result;
		});
		Thread thread = new Thread(futureTask);
		thread.start();
		try {
			Thread.sleep(1000);
			int a = 3 + 5;
			Integer result = futureTask.get();
			System.out.println("result: " + (a + result));
			long endTime = System.currentTimeMillis();
			System.out.println("time : " + (endTime - startTime) + "ms");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
