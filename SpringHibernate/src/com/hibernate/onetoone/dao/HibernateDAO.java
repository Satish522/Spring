package com.hibernate.onetoone.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.onetoone.model.Transactions;

public class HibernateDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void saveOneToOne(Transactions txn) {
		//sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session created ");
		//start transaction
		Transaction tx = session.beginTransaction();
		System.out.println("Begin Transaction ");
		//Save the Model object
		session.save(txn);
		
		System.out.println("Transactions Saved");
		//Commit transaction
		tx.commit();
		System.out.println("Transactions Committed");
		System.out.println("Transactions ID="+txn.getId());
	}
}
