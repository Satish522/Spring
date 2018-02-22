package beans.client;

import org.springframework.aop.framework.ProxyFactory;

import beans.aop.programatic.AroundAspect;
import beans.service.Math;

public class MethodInterceptorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math math=new Math();
		ProxyFactory pf=new ProxyFactory();
		pf.addAdvice(new AroundAspect());
		pf.setTarget(math);
		Math m=(Math)pf.getProxy();
		System.out.println(m.multiply(3, 4));
	}

}
