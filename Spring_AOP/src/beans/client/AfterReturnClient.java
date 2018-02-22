package beans.client;

import org.springframework.aop.framework.ProxyFactory;

import beans.aop.programatic.ExceptionLoggerThrowsAspect;
import beans.aop.programatic.WeakKeyAfterCheck;
import beans.service.KeyGenerator;

public class AfterReturnClient {
 public static void main(String[] args) {
	KeyGenerator key=new KeyGenerator();
	ProxyFactory pf=new ProxyFactory();
	////pf.addAdvice(new WeakKeyAfterCheck());
	pf.addAdvice(new ExceptionLoggerThrowsAspect());
	pf.setTarget(key);
	
	KeyGenerator keyGen=(KeyGenerator)pf.getProxy();
	
	System.out.println(keyGen.generateKey(45));
	
}
}
