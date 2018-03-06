package com.bingo.guidepro.dao;

import com.bingo.guidepro.model.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HunterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Hunter getFirstHunter() {
        return new Hunter(jdbcTemplate.queryForObject("SELECT TOP(1) [first_name] from clients", String.class));
    }

    public int add(String firstName) {
        return jdbcTemplate.update("insert into client_info (client_guid, first_name, middle_initial, last_name, email, cell_number, user_name, passwd, address, city, home_state, zip, dob, social, sex, height, weight, hair_color, eye_color) " +
                "values (UUID(), ?, ?, ?, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)", firstName, "M", "Last");
    }
}
