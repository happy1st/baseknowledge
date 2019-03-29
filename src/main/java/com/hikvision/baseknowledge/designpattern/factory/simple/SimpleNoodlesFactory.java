package com.hikvision.baseknowledge.designpattern.factory.simple;

/**
 * <p>
 * 简单工厂模式
 * 特点
 * 1 它是一个具体的类，非接口 抽象类。有一个重要的create()方法，利用if或者 switch创建产品并返回。
 *
 * 2 create()方法通常是静态的，所以也称之为静态工厂。
 *
 * 缺点
 * 1 扩展性差（我想增加一种面条，除了新增一个面条产品类，还需要修改工厂类方法）
 *
 * 2 不同的产品需要不同额外参数的时候 不支持。
 * </p>
 *
 * @author wangtianpeng 2019/3/5 9:16
 * @version V1.0.0
 */
public class SimpleNoodlesFactory{

	public static final int TYPE_BEAF = 1;
	public static final int TYPE_XX = 2;


	public static Noodles createNoodles(int type) {
		switch (type) {
			case TYPE_BEAF:
				return new BeafNoodles();
			case TYPE_XX:
				return new XXNoodles();
			default:
				return null;
		}
	}

	public static void main(String[] args) {
		Noodles noodles = SimpleNoodlesFactory.createNoodles(1);
		noodles.desc();
	}
}
