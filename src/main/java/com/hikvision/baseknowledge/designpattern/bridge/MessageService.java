package com.hikvision.baseknowledge.designpattern.bridge;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 15:35
 * @version V1.0.0
 */
public interface MessageService {

	void send(String message, String user);

}
