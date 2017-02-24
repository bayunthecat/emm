package com.test.emm.repo.mysql.tools;

import com.test.emm.repo.util.QueryBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MySqlQueryBuilder implements QueryBuilder {

    private static final String Q_MARK = " ? ";
    private static final String ORDER_BY = " ORDER BY ";
    private static final String LIMIT = " LIMIT ";
    private static final String COMMA = ",";
    private static final String WHITESPACE = " ";
    private static final String O_BRACKET = "(";
    private static final String C_BRACKET = ")";
    private static final String INSERT_INTO = "INSERT INTO ";
    private static final String VALUES = " VALUES ";
    public static final String DELETE_FROM = "DELETE FROM ";
    public static final String WHERE = " WHERE ";
    public static final String EQUAL = " = ";

    private final StringBuilder query;

    private List<Object> parameters = new ArrayList<>();

    {
        query = new StringBuilder();
    }

    public MySqlQueryBuilder() {
    }

    public MySqlQueryBuilder(String base) {
        if (!StringUtils.isEmpty(base)) {
            query.append(base);
        }
    }

    @Override
    public QueryBuilder insert(String table, List<String> fields, List<?> values) {
        if (fields.size() <= values.size()) {
            Map<String, Object> valuesMap = new LinkedHashMap<>();
            List<String> qMarks = new ArrayList<>();
            fillFieldValue(fields, values, valuesMap, qMarks);
            query.append(INSERT_INTO)
                    .append(table).append(WHITESPACE).append(O_BRACKET)
                    .append(String.join(COMMA, valuesMap.keySet()))
                    .append(C_BRACKET).append(WHITESPACE).append(VALUES).append(O_BRACKET)
                    .append(String.join(COMMA, qMarks)).append(C_BRACKET);
        }
        return this;
    }

    public MySqlQueryBuilder orderBy(String field, String dir) {
        if (!StringUtils.isEmpty(field)) {
            query.append(ORDER_BY).append(field).append(WHITESPACE);
        }
        if (!StringUtils.isEmpty(dir)) {
            query.append(dir);
        }
        return this;
    }

    public MySqlQueryBuilder limit(int offset, int limit) {
        if (offset >= 0 && limit >= 0) {
            query.append(LIMIT).append(Q_MARK).append(COMMA).append(Q_MARK);
            parameters.add(offset);
            parameters.add(limit);
        }
        return this;
    }

    @Override
    public QueryBuilder delete(String table, String byField, Object value) {
        if (!StringUtils.isEmpty(byField) && value != null) {
            query.append(DELETE_FROM).append(table).append(WHERE).append(byField).append(EQUAL).append(value);
        }
        return this;
    }

    public List<Object> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    public String getQuery() {
        return query.toString();
    }

    private void fillFieldValue(List<String> fields, List<?> values,
                                final Map<String, Object> valuesMap,
                                final List<String> qMarks) {
        for (int i = 0; i < fields.size(); i++) {
            if (values.get(i) != null) {
                valuesMap.put(fields.get(i), values.get(i));
                qMarks.add(Q_MARK);
                parameters.add(values.get(i));
            }
        }
    }
}
