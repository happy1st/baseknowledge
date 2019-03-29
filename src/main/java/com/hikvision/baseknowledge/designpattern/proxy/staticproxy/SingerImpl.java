package com.hikvision.baseknowledge.designpattern.proxy.staticproxy;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 10:46
 * @version V1.0.0
 */
public class SingerImpl implements Singer {

	@Override
	public void sing() {
		System.out.println("唱一首《算什么男人》.....");
	}

	@Override
	public void sing1() {
		System.out.println("唱一首《晴天》.....");
	}
}
