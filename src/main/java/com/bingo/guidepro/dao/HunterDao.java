package com.bingo.guidepro.dao;

import com.bingo.guidepro.model.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HunterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hunter> getHunters() {
        return jdbcTemplate.query("SELECT * from hunter", new HunterRowMapper());
    }

    public Hunter getHunter(String id) {
        return jdbcTemplate.queryForObject("SELECT * from hunter where guid = ?", new HunterRowMapper(), id);
    }

    public Hunter deleteHunter(String id) {
        return jdbcTemplate.queryForObject("delete from hunter where guid = ?", new HunterRowMapper(), id);
    }

    public int add(String firstName) {
        return jdbcTemplate.update("insert into client_info (client_guid, first_name, middle_initial, last_name, email, cell_number, user_name, passwd, address, city, home_state, zip, dob, social, sex, height, weight, hair_color, eye_color) " +
                "values (UUID(), ?, ?, ?, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)", firstName, "M", "Last");
    }

    public class HunterRowMapper implements RowMapper<Hunter> {
        public Hunter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hunter hunter = new Hunter();
            hunter.setGuid(rs.getString("GUID"));
            hunter.setFirstName(rs.getString("FIRST_NAME"));
            hunter.setMiddleInitial(rs.getString("MIDDLE_INITIAL").charAt(0));
            hunter.setLastName(rs.getString("LAST_NAME"));
            hunter.setEmail(rs.getString("EMAIL"));
            hunter.setCellNumber(rs.getString("CELL_NUMBER"));
            hunter.setUserName(rs.getString("USER_NAME"));
            hunter.setPassword(rs.getString("PASSWD"));
            hunter.setAddress(rs.getString("ADDRESS"));
            hunter.setCity(rs.getString("CITY"));
            hunter.setState(rs.getString("HOME_STATE"));
            hunter.setZipCode(rs.getString("ZIP"));
            hunter.setDateOfBirth(rs.getDate("DOB"));
            // todo missing social
            hunter.setSex(rs.getString("sex").charAt(0));
            hunter.setHeight(rs.getInt("HEIGHT"));
            hunter.setWeight(rs.getInt("WEIGHT"));
            hunter.setHairColor(rs.getString("HAIR_COLOR"));
            hunter.setEyeColor(rs.getString("EYE_COLOR"));
            return hunter;
        }

    }
}
