package beans.aop.programatic;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

public class AroundAspect implements MethodInterceptor  {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		Object[] args=mi.getArguments();
		String methodName=mi.getMethod().getName();
		
		System.out.println("Entering method called "+methodName +" ("+args[0]+" , "+ args[1]+")");
		
		Object ret=mi.proceed();
		
		System.out.println("Exiting method called "+methodName +" ("+args[0]+" , "+ args[1]+") with return "+ret);
		
		Integer i=null;
		if(ret!=null) {
			i=(Integer) ret;
		}
		
		return i;
	}

	 

}
