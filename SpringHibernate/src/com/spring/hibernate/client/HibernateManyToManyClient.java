package com.spring.hibernate.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.manytomany.dao.HibernateDAO;
import com.hibernate.manytomany.model.Student;
import com.hibernate.manytomany.model.Subject;

public class HibernateManyToManyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/hibernate/resources/spring.xml");
		
		HibernateDAO manyToManyDao=context.getBean(HibernateDAO.class);
		
		Student student1 = new Student("Sam","Disilva");
        Student student2 = new Student("Joshua", "Brill");
         
        Subject subject1 = new Subject("Economics");
        Subject subject2 = new Subject("Politics");
        Subject subject3 = new Subject("Foreign Affairs");
 
        //Student1 have 3 subjects
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        student1.getSubjects().add(subject3);
         
        //Student2 have 2 subjects
        student2.getSubjects().add(subject1);
        student2.getSubjects().add(subject2);
        
        manyToManyDao.registerStudent(student1,student2);
        
	}

}
