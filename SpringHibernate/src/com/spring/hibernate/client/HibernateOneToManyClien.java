package com.spring.hibernate.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.onetomany.dao.HibernateDAO;
import com.hibernate.onetomany.model.Cart;
import com.hibernate.onetomany.model.Items;

public class HibernateOneToManyClien {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/hibernate/resources/spring.xml");
		
		Cart cart = new Cart();
		cart.setName("MyCart2");
		
		Items item1 = new Items("I16", 10, 1, cart);
		Items item2 = new Items("I26", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		HibernateDAO hibernateDAO=context.getBean(HibernateDAO.class);
		hibernateDAO.checkoutCart(cart);
		
		 
		/*
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory =context.getBean("sessionFactory",SessionFactory.class);
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(cart);
		//session.save(item1);
		//session.save(item2);
		//Commit transaction
		tx.commit();
		System.out.println("Cart1 ID="+cart.getId());
		System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
		System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}*/
	 
	}
}
