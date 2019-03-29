package com.hikvision.baseknowledge.juc.condition;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/15 10:46
 * @version V1.0.0
 */
public class PrintABCTest {

	public static void main(String[] args) {

		PrintABC printABC = new PrintABC();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					printABC.printA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					printABC.printB();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					printABC.printC();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();


	}
}
