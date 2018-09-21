package mvc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowAllCustomerLogic {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	JdbcTemplate temp = (JdbcTemplate)context.getBean("jtemp");
	
	public List<Customer> selectAllCustomer() {
		
		List<Customer> ret = temp.query("Select * from Customer where isActive=?",new CustomerMapper(),"yes");
		
		return ret;
	}
	
	public int insertCustomer(Customer obj) {
		
		return temp.update("insert into Customer values(?,?,?,?,?)",
				obj.getCustId(),obj.getCustName(),obj.getCustPhone(),obj.getCustCity(),obj.getIsActive());
	}
	
	public int deleteCustomer(int custId) {
		
		return temp.update("update customer set isActive=? where custId=?","no",custId);
	}
	
	public Customer getCustomer(int custId) {
		
		Customer ret = (Customer)temp.queryForObject("Select * from Customer where custId = ?",new CustomerMapper(),custId);
		
		return ret;
	}
	
	public int updateCustomer(Customer obj) {
		
		return temp.update("update customer set custPhone=?,custCity=? where custId=?",obj.getCustPhone(),obj.getCustCity(),obj.getCustId());
	}
	
	
	/*
	public static void main(String args[]) {
		
		System.out.println(
		new ShowAllCustomerLogic().deleteCustomer(2));
	}
	*/
}
