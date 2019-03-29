package com.hikvision.baseknowledge.designpattern.compose;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 16:59
 * @version V1.0.0
 */
public class Clienter {

	public static void main(String[] args) {
		Node node = new Noder("E:\\kaifa");
		try {
			createTree(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
		node.display();
	}

	public static void createTree(Node node) throws Exception {
		File file = new File(node.name);
		File[] f = file.listFiles();
		for (File fi : f) {
			if (fi.isFile()) {
				Filer filer = new Filer(fi.getAbsolutePath());
				node.addNode(filer);
			}
			if (fi.isDirectory()) {
				Noder noder = new Noder(fi.getAbsolutePath());
				node.addNode(noder);
				//使用递归生成树结构
				createTree(noder);
			}
		}
	}
}
