package com.hikvision.baseknowledge;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseknowledgeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {

		Integer a = 126;
		Integer b = 126;
		Integer c = 127;
		Integer d = 127;
		Integer e = 128;
		Integer f = 128;

		System.out.println("a == b: " );
		System.out.println(a == b);
		System.out.println("c == d: " );
		System.out.println(c == d);
		System.out.println("e == f: " );
		System.out.println(e == f);

	}

	@Test
	public void test2() {
		List<String> li = new ArrayList<>();
		li.add("1");
		li.add("2");
		li.add("3");
		li.add("4");
		System.out.println(111);
		ListIterator it = li.listIterator();
		for(String str;it.hasNext();) {
			str = it.next().toString();
			System.out.println(str);
		}
		System.out.println("-----");
		for(String str;it.hasPrevious();) {
			str = it.previous().toString();
			System.out.println(str);
		}
	}

}
