package pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegistrationLogic {
	
	public static int insertCustomer(int custid, String name, String phone, String city, String isActive) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jtemp");
		
		int ret = temp.update("Insert into Customer values(?,?,?,?,?)",custid,name,phone,city,isActive);
		
		return ret;
	}
	
}
