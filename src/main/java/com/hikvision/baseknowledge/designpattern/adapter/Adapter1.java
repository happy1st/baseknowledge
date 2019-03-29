package com.hikvision.baseknowledge.designpattern.adapter;

/**
 * <p>
 * 对象适配器模式
 *
 *
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 20:21
 * @version V1.0.0
 */
public class Adapter1 implements Ps2 {

	private Usb usb;

	public Adapter1(Usb usb) {
		this.usb = usb;
	}

	@Override
	public void isPs2() {
		usb.isUsb();
	}
}
