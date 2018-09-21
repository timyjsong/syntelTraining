package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pkg.Employee;

public class MyApplication {

	public static void main (String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Employee emp = (Employee)context.getBean("proxy_emp");
		emp.displayEmployee();
	}
}
