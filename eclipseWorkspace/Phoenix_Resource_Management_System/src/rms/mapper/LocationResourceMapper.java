package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rms.model.LocationResourceModel;

public class LocationResourceMapper implements RowMapper<LocationResourceModel> {
    public LocationResourceModel mapRow(ResultSet results, int row) throws SQLException {
        LocationResourceModel model =  new LocationResourceModel();
        model.setID(results.getInt("LOCRESID"));
        model.setResourceID(results.getInt("RESID"));
        model.setLocationID(results.getInt("LOCID"));
        model.setDescription(results.getString("DESCRIPTION"));
        model.setIsActive(results.getInt("ISACTIVE"));
        return model;
    }
}