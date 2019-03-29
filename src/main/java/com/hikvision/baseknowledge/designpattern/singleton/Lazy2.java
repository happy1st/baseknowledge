package com.hikvision.baseknowledge.designpattern.singleton;

/**
 * <p>
 * 双重检查[推荐用]
 *
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，
 * 我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
 *
 * 优点：线程安全；延迟加载；效率较高。
 * </p>
 *
 * @author wangtianpeng 2019/3/5 11:52
 * @version V1.0.0
 */
public class Lazy2 {

	private static Lazy2 lazy2;

	private Lazy2() {}

	public static Lazy2 getInstance() {
		if (lazy2 == null) {
			synchronized (Lazy2.class) {
				if (lazy2 == null) {
					lazy2 = new Lazy2();
				}
			}
		}
		return lazy2;
	}

}
