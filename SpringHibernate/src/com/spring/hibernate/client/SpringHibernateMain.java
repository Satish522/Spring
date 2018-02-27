package com.spring.hibernate.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.PersonDAO;
import com.spring.hibernate.model.Person;

public class SpringHibernateMain {

	@Transactional
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/hibernate/resources/spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setId(51595943);
		person.setName("Dora");
		person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		((ClassPathXmlApplicationContext)context).close();
	}

}
