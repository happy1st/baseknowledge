package com.hikvision.baseknowledge.designpattern.protype;

import java.io.Serializable;

/**
 * <p>
 * 原型模式
 *
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 16:03
 * @version V1.0.0
 */
public class ProtypeTest implements Cloneable, Serializable {

	private String str;



}
