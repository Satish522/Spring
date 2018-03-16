package com.hibernate.onetomany.dao;

import org.hibernate.SessionFactory;

public class HibernateDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
