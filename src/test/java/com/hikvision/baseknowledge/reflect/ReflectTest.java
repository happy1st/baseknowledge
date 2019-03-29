package com.hikvision.baseknowledge.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/4 11:48
 * @version V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectTest {

	@Test
	public void test()
		throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = Class.forName("com.hikvision.baseknowledge.reflect.Address");
		Address address = (Address) clazz.newInstance();
		address.setProvince("zhejiang");
		System.out.println(address.getProvince());

		Class clazzUser = Class.forName("com.hikvision.baseknowledge.reflect.ReflectUser");
		Constructor constructor = clazzUser.getConstructor(Integer.class, String.class);
		ReflectUser reflectUser = (ReflectUser) constructor.newInstance(1, "a");
		System.out.println(reflectUser.getId());

	}

	@Test
	public void test0() throws ClassNotFoundException {
		Class clazz = Class.forName("com.hikvision.baseknowledge.reflect.ReflectUser0");
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor: constructors) {
			Class[] parameterTypes = constructor.getParameterTypes();
			for (Class parameterType: parameterTypes) {
				System.out.println(parameterType.getName());
			}
			System.out.println("----------------");
		}
	}

	@Test
	public void test1()
		throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
		Class clazz = Class.forName("com.hikvision.baseknowledge.reflect.ReflectUser");
		ReflectUser reflectUser = (ReflectUser) clazz.newInstance();
		Field field = clazz.getDeclaredField("id");
		field.setAccessible(true);
		field.setInt(reflectUser, 2);  // Integer会报错 int不报错
		System.out.println(field.getInt(reflectUser));
	}

	@Test
	public void test2()
		throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = Class.forName("com.hikvision.baseknowledge.reflect.ReflectUser");
		ReflectUser reflectUser = (ReflectUser) clazz.newInstance();
		Method method = clazz.getMethod("eat");
		String str = (String) method.invoke(reflectUser);
		System.out.println("str: " + str);

		Method method0 = clazz.getMethod("eat", String.class);
		String str0 = (String) method0.invoke(reflectUser, "apple");
	}

}
