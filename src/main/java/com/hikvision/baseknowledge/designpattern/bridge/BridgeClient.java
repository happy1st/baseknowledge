package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:48
 * @version V1.0.0
 */
public class BridgeClient {

	public static void main(String[] args) {
		MessageService messageService = new EmailMessage();
		AbstractMessage abstractMessage = new CommonMessage(messageService);
		abstractMessage.send("test nessage", "test user");

		MessageService messageService1 = new MobileMessage();
		AbstractMessage abstractMessage1 = new UrgencyMessage(messageService1);
		abstractMessage1.send("test 1 message", "test 1 user");

	}


}
