package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:46
 * @version V1.0.0
 */
public class UrgencyMessage extends AbstractMessage {


	public UrgencyMessage(
		MessageService messageService) {
		super(messageService);
	}

	@Override
	public void send(String message, String user) {
		message = "紧急：" + message;
		super.send(message, user);
	}

	public void watch() {

	}
}
