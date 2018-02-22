package beans.aop.declarative;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
 
public class HandleThrowsAspect {
	public void afterException(Method method,Object args[],Object target,Throwable thr) {
		// TODO Auto-generated method stub
		 
		System.out.println("After throwing method called "/*+method.getName()+"("+args+")"*/+thr);
		
		/*if(generatedKey<=0) {
			throw new IllegalArgumentException("Weak Key generated");
		}*/
		
	}
	
	public void afterException(JoinPoint jp,Throwable thr) {
		// TODO Auto-generated method stub
		Object[] args=jp.getArgs();
		String methodName=jp.getSignature().getName();
		System.out.println("After throwing method called "+methodName+"("+args+") throws"+thr);
		
		/*if(generatedKey<=0) {
			throw new IllegalArgumentException("Weak Key generated");
		}*/
		
	}
}
