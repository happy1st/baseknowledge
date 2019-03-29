package com.hikvision.baseknowledge.juc.aqs;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p>
 * AQS定义了两种访问资源的规则：
 *
 * 1 exclusive（独占锁），独占式访问，可以认为是在某某时刻只允许一个线程来操作。比如说写锁，在写的时候不允许其它线程写或者读.
 * 2 share（共享锁）。允许多个线程对同一个资源做操作。使得串行化的任务并行执行。在并发包下的Semaphore，CountDownLatch，
 *  以及ReentrantReadWriteLock都是可以共享执行的。独占锁中的ReentrantLock的则是一个典型的排它锁或者独占锁，
 *  和前面的几个恰好相反。不同的自定义同步器争用共享资源的方式也不同。自定义同步器在实现时只需要实现共享资源状态的获取与释放方式即可，
 *  至于具体线程等待队列的维护（如获取资源失败入队/唤醒出队等），AQS已经在顶层实现好了。
 *  自定义同步器实现时主要实现以下几种方法（这些方法是采用的模板方法来设计的，需要继承的类去实现）：
 *
 * isHeldExclusively（）：该线程是否正在独占资源。只有用到条才才需要去实现它。
 * tryAcquire（int）：独占方式。尝试获取资源，成功则返回true，失败则返回false。
 * tryRelease（int）：独占方式。尝试释放资源，成功则返回true，失败则返回false。
 * tryAcquireShared（int）：共享方式。尝试获取资源。负数表示失败; 0表示成功，但没有剩余可用资源;正数表示成功，且有剩余资源。
 * tryReleaseShared（int）：共享方式。尝试释放资源，成功则返回true，失败则返回false。
 *
 *         以ReentrantLock为例，state初始化为0，表示未锁定状态.A线程lock（）时，会调用tryAcquire（）独占该锁并将状态+ 1。
 *         此后，其他线程再的tryAcquire（）时就会失败，直到甲线程解锁（）到状态= 0（即释放锁）为止，其它线程才有机会获取该锁。
 *         当然，释放锁之前，A线程自己是可以重复获取此锁的（状态会累加），这就是可重入的概念。但要注意，获取多少次就要释放多么次，
 *         这样才能保证状态是能回到零态的。
 *
 * 　　   再以CountDownLatch以例，任务分为Ñ个子线程去执行，状态也初始化为N（注意Ñ要与线程个数一致）。这Ñ个子线程是并行执行的，
 *        每个子线程执行完后COUNTDOWN（）一次，状态会CAS减1.等到所有子线程都执行完后（即状态= 0），会取消驻留（）主调用线程，
 *        然后主调用线程就会从AWAIT（）函数返回，继续后余动作。
 *
 * 　　  一般来说，自定义同步器要么是独占方法，要么是共享方式，他们也只需实现的tryAcquire-tryRelease，tryAcquireShared-tryReleaseShared
 *       中的一种即可。但AQS也支持自定义同步器同时实现独占和共享两种方式，如的ReentrantReadWriteLock。
 *
 * 自定义同步器实现
 * 　　 实现原则：要想去实现一个同步器的实现，那么我么的类应该去继续AQS这个类，然后重写其中的方法，对于独占锁而言，要实现tryAcquire，
 *      tryRelease（），如果要实现共享锁，那么就要实现tryAcquireShared（），tryReleaseShared（）这些方法。最后，
 *      在我们的组件中调用AQS中的模板方法就可以了，而这些模板方法是会调用到我们之前重写的那些方法的。也就是说，
 *      我们只需要很小的工作量就可以实现自己的同步组件，重写的那些方法，仅仅是一些简单的对于共享资源状态的获取和释放操作，
 *      至于像是获取资源失败，线程需要阻塞之类的操作，自然是AQS帮我们完成了。
 *
 * 　　 设计思想：对于使用者来讲，我们无需关心获取资源失败，线程排队，线程阻塞/唤醒等一系列复杂的实现，这些都在AQS中为我们处理好了。
 *      我们只需要负责好自己的那个环节就好，也就是获取/释放共享资源状态 姿势T_T。很经典的模板方法设计模式的应用，
 *      AQS为我们定义好顶级逻辑的骨架，并提取出公用的线程入队列/出队列，阻塞/唤醒等一系列复杂逻辑的实现，
 *      将部分简单的可由使用者决定的操作逻辑延迟到子类中去实现即可。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/14 10:28
 * @version V1.0.0
 */
public class Mutex implements Lock, Serializable {


	private final Sync sync = new Sync() ;

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		try {
			return sync.tryAcquireNanos(1, 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1,TimeUnit.NANOSECONDS.convert(time, unit));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.new ConditionObject();
	}

	private static class Sync extends AbstractQueuedSynchronizer {

		@Override
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			assert arg == 1;
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
	}

}
