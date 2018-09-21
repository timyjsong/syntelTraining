package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import rms.model.ResourceTypeModel;

public class ResourceTypeMapper implements RowMapper<ResourceTypeModel> {
    public ResourceTypeModel mapRow(ResultSet results, int row) throws SQLException {
        ResourceTypeModel model =  new ResourceTypeModel();
        model.setID(results.getInt("RETID"));
        model.setName(results.getString("RETNAME"));
        model.setIconName(results.getString("RETICONNAME"));
        model.setDescription(results.getString("DESCRIPTION"));
        model.setIsActive(results.getInt("ISACTIVE"));
        return model;
    }
}