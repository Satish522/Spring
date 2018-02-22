package beans.aop.programatic;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import beans.service.AuthenticateManager;

public class SecurityBeforeAspect implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		// TODO Auto-generated method stub
		Object[] args=method.getParameters();
		String methodName=method.getName();
		System.out.println("Entering method called "+methodName +" ("+args[0]+" , "+ args[1]+" , "+ args[2]+")");
		AuthenticateManager auth=new AuthenticateManager();
		if(!auth.isAuthenticate()) {
			throw new IllegalAccessException("Invalid username/password");
		}
		arg1[1]=(Integer)arg1[1]+10;
	}

}
