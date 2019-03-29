package com.hikvision.baseknowledge.juc.stampedlock;

/**
 * <p>
 * StampedLock是Java8引入的一种新的所机制,简单的理解,可以认为它是读写锁的一个改进版本,读写锁虽然分离了读和写的功能,
 * 使得读与读之间可以完全并发,但是读和写之间依然是冲突的,读锁会完全阻塞写锁,它使用的依然是悲观的锁策略.如果有大量的读线程,
 * 他也有可能引起写线程的饥饿
 *      而StampedLock则提供了一种乐观的读策略,这种乐观策略的锁非常类似于无锁的操作,使得乐观锁完全不会阻塞写线程
 * </p>
 *
 * @author wangtianpeng 2019/3/16 10:10
 * @version V1.0.0
 */
public class StampLockedTest {

}
