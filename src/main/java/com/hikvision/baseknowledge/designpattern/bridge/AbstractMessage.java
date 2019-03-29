package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:34
 * @version V1.0.0
 */
public abstract class AbstractMessage {

	private MessageService messageService;

	public AbstractMessage(MessageService messageService) {
		this.messageService = messageService;
	}

	public void send(String message, String user) {
		this.messageService.send(message, user);
	}


}
