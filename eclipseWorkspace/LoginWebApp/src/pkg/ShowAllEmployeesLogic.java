package pkg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowAllEmployeesLogic {
	public static List<Customer> selectAllEmployee() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jtemp");
		
		List<Customer> ret = temp.query("Select * from Customer",new CustomerMapper());
		
		return ret;
	}
}
