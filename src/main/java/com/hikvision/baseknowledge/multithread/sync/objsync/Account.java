package com.hikvision.baseknowledge.multithread.sync.objsync;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 17:22
 * @version V1.0.0
 */
public class Account {

	private String name;

	private Double amount;

	public Account(String name, Double amount) {
		this.name = name;
		this.amount = amount;
	}

	public void deposit(Double amt) {

		amount += amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void withdrow(Double amt) {
		amount -= amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Double getBalance() {
		return amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
