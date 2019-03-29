package com.hikvision.baseknowledge.designpattern.build;

import java.util.Date;

/**
 * <p>
 * java Build模式
 *
 * Java Builder模式主要是用一个内部类去实例化一个对象，避免一个类出现过多构造函数，而且构造函数如果出现默认参数的话，很容易出错。
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 14:08
 * @version V1.0.0
 */
public class Person {

	private int id;
	private String name;
	private String address;
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public static class Builder {
		private int id;
		private String name;
		private String address;
		private Date birthday;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder birthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

	private Person(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.address = builder.address;
		this.birthday = builder.birthday;
	}

	public static void main(String[] argv){
		Person person = new Builder().name("Liar").id(20).birthday(new Date()).address("hangzhou").build();
		System.out.println(person.getName() + "\n" + person.getId() + "\n" + person.getAddress() + "\n" + person.getBirthday());
	}
}
