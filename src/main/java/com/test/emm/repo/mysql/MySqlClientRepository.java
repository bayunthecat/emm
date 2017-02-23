package com.test.emm.repo.mysql;

import com.test.emm.model.Client;
import com.test.emm.repo.ClientRepository;
import com.test.emm.repo.mapper.ClientRowMapper;
import com.test.emm.repo.mysql.tools.MySqlQueryBuilder;
import com.test.emm.repo.mysql.tools.Query;
import com.test.emm.repo.preparer.StatementPreparer;
import com.test.emm.repo.util.QueryBuilder;
import com.test.emm.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MySqlClientRepository implements ClientRepository {

    private JdbcTemplate template;

    private static final String TABLE_CLIENT = "client";

    @Autowired
    public MySqlClientRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Client add(Client client) {
        QueryBuilder builder = new MySqlQueryBuilder();
        builder.insert(TABLE_CLIENT, Utils.extractFieldsNames(client), Arrays.asList(
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                Optional.ofNullable(client.getBirthDate()).orElse(null),
                client.getGender().name()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = template.update(
                new StatementPreparer(builder, Statement.RETURN_GENERATED_KEYS), keyHolder);
        Client inserted = null;
        if (affectedRows != 0) {
            client.setId(keyHolder.getKey().longValue());
            inserted = client;
        }
        return inserted;
    }

    @Override
    public boolean remove(long id) {
        QueryBuilder builder = new MySqlQueryBuilder();
        builder.delete(TABLE_CLIENT, "id", id);
        return template.update(new StatementPreparer(builder)) != 0;
    }

    @Override
    public List<Client> getAll(int offset, int limit, String sortBy, String dir) {
        QueryBuilder queryBuilder = new MySqlQueryBuilder(Query.GET_ALL_CLIENTS);
        queryBuilder.orderBy(sortBy, dir).limit(offset, limit);
        return template.query(new StatementPreparer(queryBuilder), new ClientRowMapper());
    }

    @Override
    public int getClientCount() {
        return template.queryForObject(Query.GET_CLIENTS_COUNT, Integer.class);
    }
}
