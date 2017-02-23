package com.test.emm.repo.preparer;

import com.test.emm.repo.util.QueryBuilder;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementPreparer implements PreparedStatementCreator {

    private final QueryBuilder builder;

    private int keysFlag;

    public StatementPreparer(QueryBuilder builder) {
        this.builder = builder;
        keysFlag = Statement.NO_GENERATED_KEYS;
    }

    public StatementPreparer(QueryBuilder builder, int keysFlag) {
        this.builder = builder;
        this.keysFlag = keysFlag;
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement statement = con.prepareStatement(builder.getQuery(), keysFlag);
        int counter = 1;
        for (Object param : builder.getParameters()) {
            statement.setObject(counter++, param);
        }
        return statement;
    }
}
