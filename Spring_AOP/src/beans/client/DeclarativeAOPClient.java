package beans.client;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.aop.programatic.SecurityBeforeAspect;
import beans.service.AuthenticateManager;
import beans.service.KeyGenerator;
import beans.service.LoanCalculator;
import beans.service.Math;
public class DeclarativeAOPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("beans/resources/Spring.xml");
		
		//Around Aspect for logging
		/*Math math=context.getBean("math",Math.class);
		System.out.println(math.add(12, 23));*/
		
		
		//Before Aspect for security 
		/*LoanCalculator lc=context.getBean("calc",LoanCalculator.class);
		AuthenticateManager auth=context.getBean("auth",AuthenticateManager.class);
		auth.login("satish", "satish#123");
		System.out.println("Interest value is "+lc.calculateLoan(150000L, 5, 8.9f));*/
		
		//After Aspect for Generate Key
		KeyGenerator keyGen=context.getBean("keyGen",KeyGenerator.class);
		System.out.println(keyGen.generateKey(34));
		
		
	}

}
