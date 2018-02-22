package beans.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationAllAspect {
	
	@Pointcut("execution(* beans.service.Math.*(..))")
	public void methodPointCut() {}
	
	@Before("methodPointCut()")
	public void securityChecking(JoinPoint jp) {
		System.out.println("Security Checking......");
	}
	
	@Around("methodPointCut()")
	public Object transactionMgmt(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Transaction Started ......");
		Object ret=pjp.proceed();
		System.out.println("Transaction Started ......");
		return ret;
	}
	
	@After("methodPointCut()")
	public void closingResources(JoinPoint jp) {
		System.out.println("Closing all resources");
	}
	
	@AfterReturning("methodPointCut()")
	public void messaging(JoinPoint jp) {
		System.out.println("Sending Mails ......");
	}
	
	@AfterThrowing("methodPointCut()")
	public void handlingException(JoinPoint jp) {
		System.out.println("Handling Exception ......");
	}
	
	
}
