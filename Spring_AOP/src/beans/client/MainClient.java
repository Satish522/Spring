package beans.client;



import org.springframework.aop.framework.ProxyFactory;

import beans.aop.programatic.TransactionAspect;
import beans.service.BankTransaction;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BankTransaction bt=new BankTransaction();
		 ProxyFactory proxy=new ProxyFactory();
		 proxy.addAdvice(new TransactionAspect());
		 proxy.setTarget(bt);
		 BankTransaction b= (BankTransaction) proxy.getProxy();
		 b.widthdraw(4000, 118764576);
				 
	}

}
