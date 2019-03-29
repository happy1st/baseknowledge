package com.hikvision.baseknowledge.designpattern.adapter;

/**
 * <p>
 * 类适配：创建新类，继承源类，并实现新接口
 * </p>
 *
 * @author wangtianpeng 2019/3/5 20:14
 * @version V1.0.0
 */
public class Adapter extends UsbImpl implements Ps2 {

	@Override
	public void isPs2() {
		isUsb();
	}

	public static void main(String[] args) {
		Ps2 ps2 = new Adapter();
		ps2.isPs2();
	}
}
