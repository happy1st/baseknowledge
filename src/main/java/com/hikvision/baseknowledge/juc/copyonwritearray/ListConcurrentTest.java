package com.hikvision.baseknowledge.juc.copyonwritearray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * CopyOnWriteArrayList:CopyOnWriteArrayList这是一个ArrayList的线程安全的变体，其原理大概可以通俗的理解为:
 * 初始化的时候只有一个容器，很常一段时间，这个容器数据、数量等没有发生变化的时候，大家(多个线程)， 都是读取(假设这段时间里只发生读取的操作)同一个容器中的数据，所以这样大家读到的数据都是唯一、一致、安全的，
 * 但是后来有人往里面增加了一个数据，这个时候CopyOnWriteArrayList 底层实现添加的原理是先copy出一个容器(可以简称副本)，
 * 再往新的容器里添加这个新的数据，最后把新的容器的引用地址赋值给了之前那个旧的的容器地址，但是在添加这个数据的期间， 其他线程如果要去读取数据，仍然是读取到旧的容器里的数据。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/13 18:11
 * @version V1.0.0
 */
public class ListConcurrentTest {

	private static final int THREAD_POOL_MAX_NUM = 10;

	//private List<String> mList = new ArrayList<>();
	private List<String> mList = new CopyOnWriteArrayList<>();

	public static void main(String[] args) {
		new ListConcurrentTest().start();
	}

	private void initData() {
		for (int i = 0; i < THREAD_POOL_MAX_NUM; i++) {
			this.mList.add("......Line" + (i + 1) + ".......");
		}
	}

	private void start() {
		initData();
		ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_MAX_NUM);
		for (int i = 0; i < THREAD_POOL_MAX_NUM; i++) {
			service.execute(new ListReader(this.mList));
			service.execute(new ListWriter(this.mList, i));
		}

	}

	private class ListReader implements Runnable {

		private List<String> mList;

		public ListReader(List<String> list) {
			this.mList = list;
		}

		@Override
		public void run() {
			if (this.mList != null) {
				for (String str : this.mList) {
					System.out.println(Thread.currentThread().getName() + " : " + str);
				}
			}
		}
	}

	private class ListWriter implements Runnable {

		private List<String> mList;
		private int mIndex;

		public ListWriter(List<String> list, int index) {
			this.mList = list;
			this.mIndex = index;
		}

		@Override
		public void run() {
			if (this.mList != null) {
				//this.mList.remove(this.mIndex);
				this.mList.add("...... add " + mIndex + " ......");
			}
		}
	}

}
