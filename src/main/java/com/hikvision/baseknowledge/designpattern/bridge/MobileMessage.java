package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:38
 * @version V1.0.0
 */
public class MobileMessage implements MessageService {

	@Override
	public void send(String message, String user) {
		System.out.println("发送mobile消息...." + message + " 接受者：" + user);
	}
}
