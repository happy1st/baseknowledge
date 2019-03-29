package com.hikvision.baseknowledge.designpattern.singleton;

/**
 * <p>
 * 饿汉式（静态代码块）[可用]
 * </p>
 *
 * @author wangtianpeng 2019/3/5 11:09
 * @version V1.0.0
 */
public class Hungary0 {

	private static Hungary0 hungry;

	static {
		hungry = new Hungary0();
	}

	private Hungary0() {}

	public static Hungary0 getInstance() {
		return hungry;
	}
}
