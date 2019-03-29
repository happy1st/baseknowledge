package com.hikvision.baseknowledge.multithread.lock.readwrite;

/**
 * <p>
 * 读写锁
 *
 * ① ReadWriteLock同Lock一样也是一个接口，提供了readLock和writeLock两种锁的操作机制，一个是只读的锁，一个是写锁。
 *
 * 读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的(排他的)。 每次只能有一个写线程，但是可以有多个线程并发地读数据。
 *
 * 所有读写锁的实现必须确保写操作对读操作的内存影响。换句话说，一个获得了读锁的线程必须能看到前一个释放的写锁所更新的内容。
 *
 * 理论上，读写锁比互斥锁允许对于共享数据更大程度的并发。与互斥锁相比，读写锁是否能够提高性能取决于读写数据的频率、读取和写入操作的持续时间、以及读线程和写线程之间的竞争。
 *
 * ② 使用场景
 *
 * 假设你的程序中涉及到对一些共享资源的读和写操作，且写操作没有读操作那么频繁。
 *
 * 例如，最初填充有数据，然后很少修改的集合，同时频繁搜索（例如某种目录）是使用读写锁的理想候选项。
 *
 * 在没有写操作的时候，两个线程同时读一个资源没有任何问题，所以应该允许多个线程能在同时读取共享资源。但是如果有一个线程想去写这些共享资源，就不应该再有其它线程对该资源进行读或写。这就需要一个读/写锁来解决这个问题。
 *
 * ③ 互斥原则：
 *
 * 读-读能共存，
 * 读-写不能共存，
 * 写-写不能共存。
 *
 *
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/8 9:15
 * @version V1.0.0
 */
public class ReadWriteTest {

	public static void main(String[] args) {
		ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				readWriteLockDemo.get();
			}, "read").start();
		}

		new Thread(() -> {
			readWriteLockDemo.set(100);
		}, "write").start();

	}
}
