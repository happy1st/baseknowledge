package com.hikvision.baseknowledge.designpattern.compose;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 16:54
 * @version V1.0.0
 */
public class Noder extends Node {

	List<Node> nodeList = new ArrayList<>();

	public Noder(String name) {
		super(name);
	}

	@Override
	public void addNode(Node node) throws Exception {
		nodeList.add(node);
	}

	@Override
	public void display() {
		System.out.println(name);
		for (Node node: nodeList) {
			node.display();
		}
	}
}
