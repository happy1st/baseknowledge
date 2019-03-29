package com.hikvision.baseknowledge.designpattern.protype;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 19:08
 * @version V1.0.0
 */
public class Address implements Cloneable {

	private String city;

	private String province;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
