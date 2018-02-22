package beans.aop.programatic;

 

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
 
 
public class TransactionAspect implements MethodBeforeAdvice {

	 
	@Override  
    public void before(Method method, Object[] args, Object target)throws Throwable {  
        System.out.println("Method name "+method); 
        System.out.println("arguments of method "+args);  
        System.out.println("target class "+target);  
        
    }   
	 

}
