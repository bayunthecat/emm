package com.test.emm.repo.mapper;

import com.test.emm.model.Client;
import com.test.emm.model.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getLong("id"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setEmail(resultSet.getString("email"));
        client.setBirthDate(resultSet.getDate("birthDate"));
        client.setGender(Gender.valueOf(resultSet.getString("gender")));
        return client;
    }
}
