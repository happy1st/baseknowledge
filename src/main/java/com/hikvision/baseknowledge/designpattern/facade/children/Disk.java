package com.hikvision.baseknowledge.designpattern.facade.children;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 13:40
 * @version V1.0.0
 */
public class Disk {

	public void start() {
		System.out.println("disk is starting... ");
	}

	public void shutdown() {
		System.out.println("disk is shutdown");
	}
}
