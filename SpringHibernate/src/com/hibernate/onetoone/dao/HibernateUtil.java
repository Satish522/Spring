package com.hibernate.onetoone.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {
		Configuration config=new Configuration();
		config.configure("");
	}
}
