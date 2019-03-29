package com.hikvision.baseknowledge.designpattern.factory.normal;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/5 10:03
 * @version V1.0.0
 */
public abstract class AbstractMessage implements Message  {

	// 这里可以理解为生产产品所需要的原材料库。最好是个自定义的对象，这里为了不引起误解使用Map。
	private Map<String, Object> messageParam;

	@Override
	public Map<String, Object> getMessageParam() {
		return messageParam;
	}

	@Override
	public void setMessageParam(Map<String, Object> messageParam) {
		this.messageParam = messageParam;
	}
}
