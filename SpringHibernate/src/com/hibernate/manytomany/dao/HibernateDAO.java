package com.hibernate.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.manytomany.model.Student;


public class HibernateDAO {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void registerStudent(Student... students) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
 
        for(Student student: students) {
        	System.out.println(student);
        	session.persist(student);
        }
         
        session.getTransaction().commit();
        session.close();  
	}
}
