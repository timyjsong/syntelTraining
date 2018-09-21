package pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String args[]) {

		//loading of configuration file
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Employee emp = (Employee)context.getBean("emp");
		emp.displayEmployee();
		
		//objEmployee.displayEmployee();
	}
	
}
