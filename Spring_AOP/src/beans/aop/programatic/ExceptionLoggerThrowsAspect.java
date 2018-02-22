package beans.aop.programatic;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionLoggerThrowsAspect implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException iae) {
		System.out.println("Exception thrown "+iae.getMessage());
	}
	public void afterThrowing(Method method,Object[] arg, Object target,IllegalArgumentException iae) {
		System.out.println("Exception thrown "+method.getName());
	}
}
