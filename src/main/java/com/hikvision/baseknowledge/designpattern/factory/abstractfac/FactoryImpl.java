package com.hikvision.baseknowledge.designpattern.factory.abstractfac;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 10:27
 * @version V1.0.0
 */
public class FactoryImpl implements Factory {

	@Override
	public Product1 createProduct1() {
		return new Product1Impl();
	}

	@Override
	public Product2 createProduct2() {
		return new Product2Impl();
	}

	public static void main(String[] args){
		Factory factory = new FactoryImpl();
		factory.createProduct1().show();
		factory.createProduct2().show();
	}
}
