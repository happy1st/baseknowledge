package com.hikvision.baseknowledge.reflect;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/4 11:42
 * @version V1.0.0
 */
public class ReflectUser {

	private Integer id;
	private String name;
	private String password;
	private Date birthday;
	private String phone;
	private Address address;

	public ReflectUser() {
	}

	public ReflectUser(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public String eat() {
		System.out.println("I am eating");
		return "I am eating";
	}

	public String eat(String sth) {
		System.out.println("I am eating " + sth);
		return "I am eating " + sth;
	}
}
