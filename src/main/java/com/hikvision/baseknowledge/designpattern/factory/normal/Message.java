package com.hikvision.baseknowledge.designpattern.factory.normal;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 10:00
 * @version V1.0.0
 */
public interface Message {

	Map<String, Object> getMessageParam();

	void setMessageParam(Map<String, Object> messageParam);

	void sendMesage() throws Exception;
}
