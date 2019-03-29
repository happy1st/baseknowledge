package com.hikvision.baseknowledge.designpattern.decorator;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 10:00
 * @version V1.0.0
 */
public class Decorator extends BaseComponent {

	private BaseComponent baseComponent;

	public Decorator(BaseComponent baseComponent) {
		this.baseComponent = baseComponent;
	}

	@Override
	public void display() {
		baseComponent.display();
	}
}
