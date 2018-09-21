package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rms.model.BookingModel;

public class BookingMapper implements RowMapper<BookingModel> {
    public BookingModel mapRow(ResultSet results, int row) throws SQLException {
        BookingModel model =  new BookingModel();
        model.setID(results.getInt("BOOKINGID"));
        model.setLocResID(results.getInt("LOCRESID"));
        model.setUserID(results.getInt("USERID"));
        model.setStartTime(results.getTimestamp("STARTTIME"));
        model.setEndTime(results.getTimestamp("ENDTIME"));
        model.setDescription(results.getString("DESCRIPTION"));
        model.setIsActive(results.getInt("ISACTIVE"));
        return model;
    }
}