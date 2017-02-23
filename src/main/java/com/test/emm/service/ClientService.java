package com.test.emm.service;

import org.displaytag.pagination.PaginatedList;

public interface ClientService {

    PaginatedList getClients(int page, int pageSize, String sort, String dir);
}
