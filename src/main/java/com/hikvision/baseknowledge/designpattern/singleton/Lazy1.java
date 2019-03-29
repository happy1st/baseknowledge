package com.hikvision.baseknowledge.designpattern.singleton;

/**
 * <p>
 * 懒汉式(线程安全，同步代码块)[不可用]
 *
 * 由于第四种实现方式同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。
 * 但是这种同步并不能起到线程同步的作用。
 * 跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，
 * 还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 11:49
 * @version V1.0.0
 */
public class Lazy1 {

	private static Lazy1 lazy1;

	private Lazy1() {}

	public Lazy1 getLazy1() {
		if (lazy1 == null) {
			synchronized (Lazy1.class) {
				lazy1 = new Lazy1();
			}
		}
		return lazy1;
	}

}
