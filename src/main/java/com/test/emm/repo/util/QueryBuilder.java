package com.test.emm.repo.util;

import java.util.List;

public interface QueryBuilder {

    QueryBuilder delete(String table, String byField, Object value);

    QueryBuilder insert(String table, List<String> fields, List<?> values);

    QueryBuilder orderBy(String field, String dir);

    QueryBuilder limit(int offset, int limit);

    List<Object> getParameters();

    String getQuery();
}
