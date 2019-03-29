package com.hikvision.baseknowledge.designpattern.singleton;

/**
 * <p>
 * 单例模式在多线程的应用场合下必须小心使用。如果当唯一实例尚未创建时，有两个线程同时调用创建方法，
 * 那么它们同时没有检测到唯一实例的存在，从而同时各自创建了一个实例，这样就有两个实例被构造出来，
 * 从而违反了单例模式中实例唯一的原则。
 * 解决这个问题的办法是为指示类是否已经实例化的变量提供一个互斥锁(虽然这样会降低效率)。
 *
 * 饿汉模式
 *
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 *
 * （静态常量）[可用]
 * </p>
 *
 * @author wangtianpeng 2019/3/5 11:05
 * @version V1.0.0
 */
public class Hungary {

	private static final Hungary HUNGRY = new Hungary();

	private Hungary() {}

	public static Hungary getHungry() {
		return HUNGRY;
	}

}
