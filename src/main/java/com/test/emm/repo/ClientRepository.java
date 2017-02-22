package com.test.emm.repo;

import com.test.emm.model.Client;

import java.util.List;

public interface ClientRepository {

    Client add(Client client);

    boolean remove(long id);

    Client get(long id);

    Client update(Client client);

    List<Client> getAll(int offset, int limit);

}
