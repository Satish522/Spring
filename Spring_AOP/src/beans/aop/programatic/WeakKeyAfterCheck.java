package beans.aop.programatic;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyAfterCheck implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object ret, Method method, Object[] arg, Object target) throws Throwable {
		// TODO Auto-generated method stub
		Object[] args=method.getParameters();
		String methodName=method.getName();
		System.out.println("Exiting method called "+methodName +" ("+args[0]+")");
		if((Integer)ret<=0) {
			throw new IllegalArgumentException("Weak Key generated");
		}
		
	}

}
