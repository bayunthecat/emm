package com.test.emm.service;

import com.test.emm.action.form.ClientForm;
import com.test.emm.model.Client;
import org.displaytag.pagination.PaginatedList;

public interface ClientService {

    Client createClient(ClientForm form);

    PaginatedList getClients(int page, int pageSize, String sort, String dir);
}
