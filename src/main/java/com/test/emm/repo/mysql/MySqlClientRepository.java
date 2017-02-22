package com.test.emm.repo.mysql;

import com.test.emm.model.Client;
import com.test.emm.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MySqlClientRepository implements ClientRepository {

    private JdbcTemplate template;

    @Autowired
    public MySqlClientRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Client add(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = template.update(con -> {
            PreparedStatement ps = con.prepareStatement(Query.INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS);
            int counter = 1;
            ps.setString(counter++, client.getName());
            ps.setString(counter++, client.getSurname());
            ps.setString(counter++, client.getEmail());
            ps.setDate(counter++, new Date(client.getBirthDate().getTime()));
            ps.setString(counter++, client.getGender().name());
            return ps;
        }, keyHolder);
        Client inserted = null;
        if (affectedRows != 0) {
            client.setId(keyHolder.getKey().longValue());
            inserted = client;
        }
        return inserted;
    }

    @Override
    public boolean remove(long id) {
        return template.update(Query.DELETE_CLIENT_BY_ID, id) != 0;
    }

    @Override
    public Client get(long id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        int affectedRows = template.update(Query.UPDATE_CLIENT,
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                new Date(client.getBirthDate().getTime()),
                client.getGender().name(),
                client.getId());
        return affectedRows != 0 ? client : null;
    }

    @Override
    public List<Client> getAll(int offset, int limit) {
        return null;
    }
}
