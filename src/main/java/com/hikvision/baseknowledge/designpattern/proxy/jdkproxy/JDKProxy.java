package com.hikvision.baseknowledge.designpattern.proxy.jdkproxy;

import com.hikvision.baseknowledge.designpattern.proxy.staticproxy.Singer;
import com.hikvision.baseknowledge.designpattern.proxy.staticproxy.SingerImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * 总结：以上代码只有标黄的部分是需要自己写出，其余部分全都是固定代码。由于java封装了newProxyInstance这个方法的实现细节，所以使用起来才能这么方便，具体的底层原理将会在下一小节说明。
 *
 * 缺点：可以看出静态代理和JDK代理有一个共同的缺点，就是目标对象必须实现一个或多个接口，加入没有，则可以使用Cglib代理
 * </p>
 *
 * @author wangtianpeng 2019/3/6 11:10
 * @version V1.0.0
 */
public class JDKProxy {

	public static void main(String[] args) {
//		Singer singer = new SingerImpl();
//		Singer singer1 = (Singer) Proxy.newProxyInstance(singer.getClass().getClassLoader(),
//			singer.getClass().getInterfaces(),
//			new InvocationHandler() {
//				@Override
//				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					System.out.println("大家好。。。。");
//					Object returnValue = method.invoke(singer, args);
//					System.out.println("谢谢大家！.....");
//					return returnValue;
//				}
//			});
//		singer1.sing();
//		singer1.sing1();
		Singer singer = new SingerImpl();
		Singer singer1 = (Singer) Proxy.newProxyInstance(singer.getClass().getClassLoader(),
			singer.getClass().getInterfaces(),
			(proxy, method, args0) -> {
				System.out.println("大家好。。。。");
					Object returnValue = method.invoke(singer, args0);
					System.out.println("谢谢大家！.....");
					return returnValue;
			});
		singer1.sing();
		singer1.sing1();
	}

}
