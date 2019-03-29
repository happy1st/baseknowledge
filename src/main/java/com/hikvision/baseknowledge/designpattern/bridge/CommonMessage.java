package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:44
 * @version V1.0.0
 */
public class CommonMessage extends AbstractMessage {

	public CommonMessage(
		MessageService messageService) {
		super(messageService);
	}

	@Override
	public void send(String message, String user) {
		super.send(message, user);
	}
}
