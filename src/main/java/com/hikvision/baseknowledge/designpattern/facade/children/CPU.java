package com.hikvision.baseknowledge.designpattern.facade.children;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 11:55
 * @version V1.0.0
 */
public class CPU {

	public void start() {
		System.out.println("CPU is starting.....");
	}

	public void shutdown() {
		System.out.println("CPU is shutdown");
	}

}
