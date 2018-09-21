package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rms.model.*;

public class ResourceMapper implements RowMapper<ResourceModel> {
	public ResourceModel mapRow(ResultSet results, int row) throws SQLException {
		ResourceModel model = new ResourceModel();
		model.setResId(results.getInt("RESID"));
		model.setRoomNumber(results.getInt("ROOMNUMBER"));
		model.setResName(results.getString("RESNAME"));
		model.setResType(results.getInt("RESTYPE"));
		model.setDescription(results.getString("DESCRIPTION"));
		model.setStatus(results.getString("STATUS"));
		model.setAcceptedRole(results.getInt("ACCEPTEDROLE"));
		model.setIsActive(results.getInt("ISACTIVE"));
		return model;
	}
}