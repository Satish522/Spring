package beans.aop.declarative;

import org.aspectj.lang.JoinPoint;

import beans.service.AuthenticateManager;



public class SecurityBeforeAspect {
	
	// and args(princpal,noOfYears,rateOfInt)
	public void check(JoinPoint jp , Long princpal, int noOfYears, float rateOfInt) throws Throwable {
		//System.out.println("Principal "+princpal);
		System.out.println("Before calculating..");
		AuthenticateManager auth=new AuthenticateManager();
		boolean flag=auth.isAuthenticate();
		if(!flag) {
			throw new IllegalAccessException("Invalid user name / password");
		}
	}
}
