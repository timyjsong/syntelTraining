package mvc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet results, int row) throws SQLException {
		Customer model = new Customer();
		model.setCustId(results.getInt(1));
		model.setCustName(results.getString(2));
		model.setCustPhone(results.getString(3));
		model.setCustCity(results.getString(4));
		model.setIsActive(results.getString(5));
		return model;
	}
}
