package com.test.emm.repo.mysql.tools;

public interface Query {

    String INSERT_CLIENT = "INSERT INTO client (name, surname, email, birthDate, gender) VALUES (?, ?, ?, ?, ?)";

    String DELETE_CLIENT_BY_ID = "DELETE FROM client WHERE id = 1;";

    String UPDATE_CLIENT = "UPDATE CLIENT client SET name=?, surname=?, email=?, birthDate=?, gender=? WHERE id=?";

    String GET_ALL_CLIENTS = "SELECT * FROM client";

    String ORDER_BY = "ORDER BY";

    String LIMIT = "LIMIT ?, ?";

    String GET_CLIENTS_COUNT = "SELECT count(*) FROM client";
}
