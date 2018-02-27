package com.spring.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.onetoone.dao.HibernateUtil;
import com.hibernate.onetoone.model.Customer;
import com.hibernate.onetoone.model.Transactions;

public class HibernateOneToOneMain {

	public static void main(String[] args) {
		
		Transactions txn = buildDemoTransaction();
		System.out.println(txn.toString());
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created ");
		//start transaction
		tx = session.beginTransaction();
		System.out.println("Begin Transaction ");
		//Save the Model object
		session.save(txn);
		System.out.println("Transactions Saved");
		//Commit transaction
		//tx.commit();
		System.out.println("Transactions Committed");
		System.out.println("Transactions ID="+txn.getId());
		
		//Get Saved Trasaction Data
		//printTransactionData(txn.getId(), sessionFactory);
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing Session Factory");
				sessionFactory.close();
			}
		}
	}

	/*private static void printTransactionData(long id, SessionFactory sessionFactory) {
		Session session = null;
		Transactions tx = null;
		try{
			//Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			//start transaction
			tx = session.beginTransaction();
			//Save the Model object
			Txn txn = (Txn) session.get(Txn.class, id);
			//Commit transaction
			tx.commit();
			System.out.println("Transactions Details=\n"+txn);
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}
	}*/

	private static Transactions buildDemoTransaction() {
		Transactions txn = new Transactions();
		txn.setDate(new Date());
		txn.setTotal(100);
		
		Customer cust = new Customer();
		cust.setAddress("Chennai, India");
		cust.setEmail("satishsubudhi522@gmail.com");
		cust.setName("Satish Kumar Subudhi");
		
		//txn.setCustomer(cust);
		
		//cust.setTransaction(txn);
		
		return txn;
	}

}