package com.hikvision.baseknowledge.designpattern.facade;

/**
 * <p>
 * 外观模式
 * 优点
 * 　　- 松散耦合
 * 　　使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护；
 *
 * 　　- 简单易用
 * 　　客户端根本不需要知道子系统内部的实现，或者根本不需要知道子系统内部的构成，它只需要跟Facade类交互即可。
 *
 * 　　- 更好的划分访问层次
 * 　　有些方法是对系统外的，有些方法是系统内部相互交互的使用的。子系统把那些暴露给外部的功能集中到门面中，这样就可以实现客户端的使用，
 *      很好的隐藏了子系统内部的细节。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 13:43
 * @version V1.0.0
 */
public class Client {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.start();
		System.out.println("\n");
		computer.shutdown();
	}

	/**
	 * 从上面的实例来看，有了这个Facade类，也就是Computer类，用户就不用亲自去调用子系统中的Disk,Memory、CPU类了，
	 * 不需要知道系统内部的实现细节，甚至都不用知道系统内部的构成。客户端只需要跟Facade交互就可以了。
	 */
}
