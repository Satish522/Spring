package beans.aop.declarative;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAroundAspect {
	
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String methodName=pjp.getSignature().getName();
		Object arg[]=pjp.getArgs();
		System.out.println("Entering to method "+methodName +"("+arg[0]+10 +" , "+arg[1]+")");
		
		Object ret=pjp.proceed(arg);
		
		ret = (Integer)ret+10;
		
		return ret;
		
	}
}
