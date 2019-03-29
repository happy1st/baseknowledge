package com.hikvision.baseknowledge.designpattern.protype;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 19:07
 * @version V1.0.0
 */
public class DeepStudent implements Cloneable {

	private Integer number;

	private Address address;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		DeepStudent student = (DeepStudent) super.clone(); // 浅拷贝
		/// student.address = (Address) address.clone(); // 深拷贝
		return student;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address();
		address.setCity("hangzhou");
		address.setProvince("zhejiang");
		DeepStudent student1 = new DeepStudent();
		student1.setNumber(123456);
		student1.setAddress(address);

		DeepStudent student2 = (DeepStudent) student1.clone();
		System.out.println("student1: " + student1.getNumber() + " , " + student1.getAddress().getProvince() + " , " + student1.getAddress().getCity());
		System.out.println("student2: " + student2.getNumber() + " , " + student2.getAddress().getProvince() + " , " + student2.getAddress().getCity());

		address.setProvince("beijing");
		address.setCity("beijing");

		System.out.println("student1: " + student1.getNumber() + " , " + student1.getAddress().getProvince() + " , " + student1.getAddress().getCity());
		System.out.println("student2: " + student2.getNumber() + " , " + student2.getAddress().getProvince() + " , " + student2.getAddress().getCity());

	}

}
