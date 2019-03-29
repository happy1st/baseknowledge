package com.hikvision.baseknowledge.designpattern.proxy.cglib;

import com.hikvision.baseknowledge.designpattern.proxy.staticproxy.Singer;
import com.hikvision.baseknowledge.designpattern.proxy.staticproxy.SingerImpl;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * <p>
 *
 * </p>
 *
 * @author wangtianpeng 2019/3/6 11:33
 * @version V1.0.0
 */
public class CglibProxyFactory implements MethodInterceptor {

	private Object target;

	public CglibProxyFactory(Object target) {
		this.target = target;
	}

	public Object getPoxyInstance() {
		// 工具类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		// 创建子类
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
		throws Throwable {
		System.out.println("向观众问好！。。。。");
		Object returnValue = method.invoke(target, objects);
		System.out.println("谢谢大家！.0.0.0.0.0.");
		return returnValue;
	}

	public static void main(String[] args) {
		Singer singer = new SingerImpl();
		Singer proxy = (Singer) new CglibProxyFactory(singer).getPoxyInstance();
		proxy.sing();
		proxy.sing1();
	}
}
