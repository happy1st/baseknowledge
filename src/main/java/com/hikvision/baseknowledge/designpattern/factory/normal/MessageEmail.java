package com.hikvision.baseknowledge.designpattern.factory.normal;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 10:05
 * @version V1.0.0
 */
public class MessageEmail extends AbstractMessage {

	@Override
	public void sendMesage() throws Exception {
		// TODO Auto-generated method stub
		if (null == getMessageParam() || null == getMessageParam().get("EMAIL")
			|| "".equals(getMessageParam().get("EMAIL"))) {
			throw new Exception("发送短信,需要传入EMAIL参数");
		}// 另外邮件内容，以及其他各种协议参数等等都要处理

		System.out.println("我是邮件，发送通知给" + getMessageParam().get("EMAIL"));
	}
}
