package com.spring.hibernate.client;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.onetoone.dao.HibernateDAO;
import com.hibernate.onetoone.dao.HibernateUtil;
import com.hibernate.onetoone.model.Customer;
import com.hibernate.onetoone.model.Transactions;
import com.spring.hibernate.dao.PersonDAO;
import com.spring.hibernate.model.Person;

public class SpringHibernateMain {

	@Transactional
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/hibernate/resources/spring.xml");
		
		Transactions txn = buildDemoTransaction();
		
		HibernateDAO hibernateDao=context.getBean(HibernateDAO.class);
		
		hibernateDao.saveOneToOne(txn);
		/*PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		//person.setId(51195943);
		person.setName("Dora");
		person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		*/
		//close resources
		//((ClassPathXmlApplicationContext)context).close();
	}
	
	private static Transactions buildDemoTransaction() {
		Transactions txn = new Transactions();
		txn.setDate(new Date());
		txn.setTotal(100);
		
		Customer cust = new Customer();
		cust.setContact("Chennai, India");
		cust.setEmail("satishsubudhi522@gmail.com");
		cust.setName("Satish Kumar Subudhi");
		
		txn.setCustomer(cust);
		
		cust.setTransaction(txn);
		
		return txn;
	}
	
	

}

/*           */
