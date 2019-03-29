package com.hikvision.baseknowledge.designpattern.factory.abstractfac;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 10:24
 * @version V1.0.0
 */
public class Product1Impl implements Product1 {

	@Override
	public void show() {
		System.out.println("这是1型产品");
	}
}
