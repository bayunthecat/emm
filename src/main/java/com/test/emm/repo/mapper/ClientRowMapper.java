package com.test.emm.repo.mapper;

import com.test.emm.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Client client = new Client();
        client.setName(resultSet.getString(""));
        return null;
    }
}
