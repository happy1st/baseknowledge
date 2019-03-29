package com.hikvision.baseknowledge.designpattern.compose;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 16:52
 * @version V1.0.0
 */
public class Filer extends Node {

	public Filer(String name) {
		super(name);
	}

	@Override
	public void display() {
		System.out.println(name);
	}
}
