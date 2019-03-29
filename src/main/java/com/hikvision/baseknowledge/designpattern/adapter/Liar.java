package com.hikvision.baseknowledge.designpattern.adapter;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 20:31
 * @version V1.0.0
 */
public class Liar extends AdapterA {

	@Override
	public void a() {
		System.out.println("Liar method a");
	}

	public static void main(String[] args) {
		A a = new Liar();
		a.a();
		a.b();
	}
}
