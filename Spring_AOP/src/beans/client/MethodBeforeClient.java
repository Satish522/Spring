package beans.client;

import org.springframework.aop.framework.ProxyFactory;

import beans.aop.programatic.SecurityBeforeAspect;
import beans.service.AuthenticateManager;
import beans.service.LoanCalculator;

public class MethodBeforeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoanCalculator lc=new LoanCalculator();
		ProxyFactory pf=new ProxyFactory();
		pf.addAdvice(new SecurityBeforeAspect());
		pf.setTarget(lc);
		
		AuthenticateManager auth=new AuthenticateManager();
		auth.login("satish1", "satish#123");
		
		LoanCalculator loanCal=(LoanCalculator)pf.getProxy();
		System.out.println("Interest value is "+loanCal.calculateLoan(150000L, 5, 8.9f));
		
	}

}
