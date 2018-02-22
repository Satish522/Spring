package my.satish.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.satish.jdbc.sqlquery.PersonDAO;

public class JdbcTestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("my/satish/jdbc/resources/spring.xml");
		/*Person person1=new Person(2, "Satish", "India");
		Person person2=new Person(3, "John", "UK");
		Person person3=new Person(4, "Hidden", "USA");
		Person person4=new Person(5, "Mark", "Sweden");
		Person person5=new Person(6, "Jucker", "Netherland");
		
		List<Person> listPerson=new ArrayList<Person>();
		
		listPerson.add(person1);
		listPerson.add(person2);
		listPerson.add(person3);
		listPerson.add(person4);
		listPerson.add(person5);
		
		PersonDao personDao=context.getBean("personDao",PersonDao.class);
		System.out.println(personDao.insert(listPerson));*/
		
		/*PersonDAO personDAO=context.getBean("personDAO",PersonDAO.class);
		
		List<Person> l = personDAO.serchByName("Satish");
		
		System.out.println(personDAO.update("Hadden", 4));
		
		System.out.println(l);
		*/
		Person person=new Person(7, "Rabi", "Chennai,India");
		SimplePersonInsertDao simplePerson=context.getBean(SimplePersonInsertDao.class);
		
		//simplePerson.insert(person);
		simplePerson.insert(8, "Prakash", "Odisha,India");
		
	}

}
