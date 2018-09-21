package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rms.model.InvitationModel;

public class InvitationMapper implements RowMapper<InvitationModel> {
    public InvitationModel mapRow(ResultSet results, int row) throws SQLException {
        InvitationModel model =  new InvitationModel();
        model.setID(results.getInt("INVID"));
        model.setUserID(results.getInt("USERID"));
        model.setBookingID(results.getInt("BOOKINGID"));
        model.setStatus(results.getString("STATUS"));
        model.setVisitorID(results.getInt("VISID"));
        model.setDescription(results.getString("DESCRIPTION"));
        model.setIsActive(results.getInt("ISACTIVE"));
        return model;
    }
}