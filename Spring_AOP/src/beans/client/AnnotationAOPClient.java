package beans.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.service.Math;
public class AnnotationAOPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("beans/resources/Spring.xml");
		Math math=context.getBean("math",Math.class);
		math.add(23, 45);
	}

}
