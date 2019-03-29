package com.hikvision.baseknowledge.multithread.sync.objsync;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/7 18:20
 * @version V1.0.0
 */
public class Operator implements Runnable{

	private Account account;

	public Operator(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		synchronized (account) {
			account.deposit(500.0);
			account.withdrow(500.0);
			System.out.println(Thread.currentThread().getName() + ": " + account.getBalance());
		}
	}

	public static void main(String[] args) {
		Account account = new Account("zhangsan", 10000.0);
		Operator operator = new Operator(account);
		for (int i = 0; i < 50; i++) {
			Thread thread = new Thread(operator, "thread " + i);
			thread.start();
		}
	}
}
