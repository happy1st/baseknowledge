package com.hikvision.baseknowledge.designpattern.singleton;

/**
 * <p>
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 可能是因为枚举在JDK1.5中才添加，所以在实际项目开发中，很少见人这么写过。
 *
 * 传统的两私有一公开（私有构造方法、私有静态实例(懒实例化/直接实例化)、公开的静态获取方法）涉及线程安全问题（即使有多重检查锁也可以通过反射破坏单例），
 *
 * 目前最为安全的实现单例的方法是通过内部静态enum的方法来实现，因为JVM会保证enum不能被反射并且构造器方法只执行一次。
 *
 *
 * 单例模式：
 * 优点
 * 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能。
 *
 * 缺点
 * 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new，可能会给其他开发人员造成困扰，特别是看不到源码的时候。
 *
 * 适用场合
 * 需要频繁的进行创建和销毁的对象；
 * 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
 * 工具类对象；
 * 频繁访问数据库或文件的对象。
 *
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 13:05
 * @version V1.0.0
 */
public class EnumSingle {

	private EnumSingle() {}

	public static EnumSingle getInstance() {
		return Singleton.INSTANCE.enumSingle;
	}

	private enum Singleton{
		/**
		 *
		 */
		INSTANCE;
		private EnumSingle enumSingle;
		private Singleton() {
			enumSingle = new EnumSingle();
		}
		public EnumSingle getInstance() {
			return enumSingle;
		}

	}

	public static void main(String[] args) {
		EnumSingle obj1 = EnumSingle.getInstance();
		EnumSingle obj2 = EnumSingle.getInstance();
		//输出结果：obj1==obj2?true
		System.out.println("obj1==obj2?" + (obj1==obj2));
	}

}
