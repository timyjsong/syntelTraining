package jdbcspring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyJDBCTemplate {

	public void fun() {
		//JdbcTemplate obj = new JdbcTemplate();
		//DriverManagerDataSource obj1 = new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jtemp");
		
		List<Customer> custList = temp.query("select * from Customer",new CustomerMapper());
		for(Customer c : custList) {
			c.display();
		}
		
		//temp.update("Insert into Customer values(?,?,?,?,?)","50","Zach","9393939393","PHoneix","yes");

	}
	public static void main(String args[]) {
		new MyJDBCTemplate().fun();
	}
	
}
