package com.hikvision.baseknowledge.designpattern.facade;

import com.hikvision.baseknowledge.designpattern.facade.children.CPU;
import com.hikvision.baseknowledge.designpattern.facade.children.Disk;
import com.hikvision.baseknowledge.designpattern.facade.children.Memory;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 13:44
 * @version V1.0.0
 */
public class Computer {

	private CPU cpu;
	private Disk disk;
	private Memory memory;

	public Computer() {
		this.cpu = new CPU();
		this.disk = new Disk();
		this.memory = new Memory();
	}

	public void start() {
		this.cpu.start();
		this.disk.start();
		this.memory.start();
	}

	public void shutdown() {
		this.cpu.shutdown();
		this.disk.shutdown();
		this.memory.shutdown();
	}

}
