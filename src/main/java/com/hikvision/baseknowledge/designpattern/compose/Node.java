package com.hikvision.baseknowledge.designpattern.compose;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 16:46
 * @version V1.0.0
 */
public abstract class Node {

	protected String name;

	public Node(String name) {
		this.name = name;
	}

	public void addNode(Node node) throws Exception {
		throw new Exception("invalid exception");
	}

	abstract void display();

}
