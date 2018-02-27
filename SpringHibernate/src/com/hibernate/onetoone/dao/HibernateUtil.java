package com.hibernate.onetoone.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class HibernateUtil {
	
	//XML based configuration
	private static SessionFactory sessionFactory;
	
	//Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;
	
	//Property based configuration
	private static SessionFactory sessionJavaConfigFactory;
	
	private static SessionFactory buildSessionFactory() {
		System.out.println("Building sessionFactory...");
		try {
		Configuration config=new Configuration().configure("/com/spring/hibernate/resources/hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
		}catch(Throwable thr) {
			System.err.println("Initial SessionFactory cration fails"+thr);
			throw new ExceptionInInitializerError(thr);
		}
		
	}
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
