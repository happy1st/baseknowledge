package com.hikvision.baseknowledge.multithread.waitnotify;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/9 14:17
 * @version V1.0.0
 */
public class Storage1 implements AbstractStorage {

	private static final int MAX_SIZE = 100;
	private LinkedList linkedList = new LinkedList();


	@Override
	public void produce(int num) {

		synchronized (linkedList) {
			while (linkedList.size() + num > MAX_SIZE) {
				System.out.println(
					"【要生产的产品数量】: " + num + "\t【库存量】: " + linkedList.size() + "\t【暂时不能执行生产任务】");
				try {
					linkedList.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < num; i++) {
			linkedList.add(new Object());
		}

		System.out.println("【已经生产产品数】: " + num + "\t【现在仓储量为】: " +linkedList.size() );
	}

	@Override
	public void consume(int num) {
		synchronized (linkedList) {
			while (num > linkedList.size()) {
				System.out.println("【要消费的数量】: " + num + "\t【库存储量】: " + linkedList.size() + "\t暂时不能执行消费任务");
				try {
					linkedList.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < num; i++) {
				linkedList.remove();
			}
			System.out.println("【消费产品数】: " + num + "\t【现仓储量为】: " + linkedList.size());
			linkedList.notifyAll();
		}
	}
}
