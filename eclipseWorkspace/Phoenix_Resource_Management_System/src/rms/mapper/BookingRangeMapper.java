package rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import rms.model.BookingRangeModel;

public class BookingRangeMapper implements RowMapper<BookingRangeModel> {
    public BookingRangeModel mapRow(ResultSet results, int row) throws SQLException {
        BookingRangeModel model =  new BookingRangeModel();
        model.setStartTime(results.getTimestamp("STARTTIME"));
        model.setEndTime(results.getTimestamp("ENDTIME"));
        return model;
    }
}
