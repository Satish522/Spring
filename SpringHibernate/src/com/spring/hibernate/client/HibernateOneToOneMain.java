package com.spring.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.onetoone.dao.HibernateUtil;
import com.hibernate.onetoone.model.Customer;
import com.hibernate.onetoone.model.Transaction;

public class HibernateOneToOneMain {

	public static void main(String[] args) {
		
		Transaction txn = buildDemoTransaction();
		
		SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = (org.hibernate.Transaction) session.beginTransaction();
		 
		//Save the Model object
		session.save(txn);
		System.out.println("Transaction Saved");
		//Commit transaction
		tx.commit();
		System.out.println("Transaction Committed");
		System.out.println("Transaction ID="+txn.getId());
		
		//Get Saved Trasaction Data
		//printTransactionData(txn.getId(), sessionFactory);
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

	/*private static void printTransactionData(long id, SessionFactory sessionFactory) {
		Session session = null;
		Transaction tx = null;
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
			System.out.println("Transaction Details=\n"+txn);
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}
	}*/

	private static Transaction buildDemoTransaction() {
		Transaction txn = new Transaction();
		txn.setDate(new Date());
		txn.setTotal(100);
		
		Customer cust = new Customer();
		cust.setAddress("Chennai, India");
		cust.setEmail("satishsubudhi522@gmail.com");
		cust.setName("Satish Kumar Subudhi");
		
		txn.setCustomer(cust);
		
		cust.setTransaction(txn);
		return txn;
	}

}