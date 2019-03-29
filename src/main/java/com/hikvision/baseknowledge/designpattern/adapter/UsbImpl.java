package com.hikvision.baseknowledge.designpattern.adapter;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 20:13
 * @version V1.0.0
 */
public class UsbImpl implements Usb {

	@Override
	public void isUsb() {
		System.out.println("USB interface");
	}
}
