package com.hikvision.baseknowledge.designpattern.protype;

/**
 * <p>
 * 浅克隆 基本数据类型值会重新创建
 * </p>
 *
 * @author wangtianpeng 2019/3/5 18:59
 * @version V1.0.0
 */
public class Student implements Cloneable{

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		return student;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Student student1 = new Student();
		student1.setNumber(123456);

		Student student2 = (Student) student1.clone();
		System.out.println("student1: " + student1.getNumber());
		System.out.println("student2: " + student2.getNumber());

		student2.setNumber(456789);
		System.out.println("student1: " + student1.getNumber());
		System.out.println("student2: " + student2.getNumber());

	}
}
