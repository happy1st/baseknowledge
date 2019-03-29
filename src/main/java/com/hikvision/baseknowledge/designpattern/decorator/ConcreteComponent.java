package com.hikvision.baseknowledge.designpattern.decorator;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 9:59
 * @version V1.0.0
 */
public class ConcreteComponent extends BaseComponent {

	@Override
	public void display() {
		System.out.println("显示窗体。。。。。");
	}
}
