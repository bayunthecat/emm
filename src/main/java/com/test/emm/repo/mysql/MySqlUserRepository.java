package com.test.emm.repo.mysql;

import com.test.emm.model.User;
import com.test.emm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MySqlUserRepository implements UserRepository {

    private JdbcTemplate template;

    @Autowired
    public MySqlUserRepository(DataSource dataSource) {
        template.setDataSource(dataSource);
    }

    @Override
    public User add(User user) {

        return null;
    }

    @Override
    public User remove(long id) {
        return null;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll(int offset, int limit) {
        return null;
    }
}
