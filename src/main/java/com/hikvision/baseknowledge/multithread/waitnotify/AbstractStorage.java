package com.hikvision.baseknowledge.multithread.waitnotify;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/9 14:15
 * @version V1.0.0
 */
public interface AbstractStorage {

	void consume(int num);
	void produce(int num);

}
