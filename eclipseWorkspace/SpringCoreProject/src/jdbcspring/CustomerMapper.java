package jdbcspring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet result, int arg1) throws SQLException {
		
		Customer cust = new Customer();
		cust.setCustId(result.getInt(1));
		cust.setCustName(result.getString(2));
		cust.setCustPhone(result.getString(3));
		cust.setCustCity(result.getString(4));
		cust.setIsActive(result.getString(5));
		
		return cust;
	}

	
	
}
