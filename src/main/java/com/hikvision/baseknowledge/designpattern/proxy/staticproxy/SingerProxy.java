package com.hikvision.baseknowledge.designpattern.proxy.staticproxy;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 10:47
 * @version V1.0.0
 */
public class SingerProxy implements Singer {

	private Singer singer;

	public SingerProxy(Singer singer) {
		this.singer = singer;
	}

	@Override
	public void sing() {
		singer.sing();
		System.out.println("谢谢大家....");
	}

	@Override
	public void sing1() {
		singer.sing1();
		System.out.println("谢谢大家....");
	}

	public static void main(String[] args) {
		Singer singer = new SingerImpl();
		Singer poxy = new SingerProxy(singer);
		poxy.sing();
		poxy.sing1();
	}

}
