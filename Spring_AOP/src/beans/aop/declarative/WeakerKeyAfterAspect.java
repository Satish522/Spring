package beans.aop.declarative;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

public class WeakerKeyAfterAspect {
	 
	public void afterReturning(JoinPoint jp,int generatedKey) {
		// TODO Auto-generated method stub
		Object[] args=jp.getArgs();
		String methodName=jp.getSignature().getName();
		System.out.println("After Return Exiting method called "+methodName +" ("+args[0]+")");
		
		/*if(generatedKey<=0) {
			throw new IllegalArgumentException("Weak Key generated");
		}*/
		
	}
	public void afterExiting(JoinPoint jp) {
		// TODO Auto-generated method stub
		Object[] args=jp.getArgs();
		String methodName=jp.getSignature().getName();
		System.out.println("After Exiting method called "+methodName +" ("+args[0]+")");
		
		 
	}
}
