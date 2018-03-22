package com.hibernate.onetomany.dao;
 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.onetomany.model.Cart;
 

public class HibernateDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public void checkoutCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Session Open");
		
		Transaction tx=session.beginTransaction();
		System.out.println("Begin Transaction");
		session.save(cart);
		System.out.println("Saved");
		tx.commit();
		System.out.println("Transaction committed");
		
		
		
	}

}
