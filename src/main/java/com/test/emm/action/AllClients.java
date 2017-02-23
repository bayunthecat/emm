package com.test.emm.action;

import com.test.emm.service.ClientService;
import org.displaytag.pagination.PaginatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("allClients")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AllClients {

    private int pageNum;

    private String dir;

    private String sort;

    @Autowired
    private ClientService clientService;

    public PaginatedList getAllClients() {
        return clientService.getClients(pageNum, 20, sort, dir);
    }

    public void setPage(int page) {
        this.pageNum = page > 0 ? page : 1;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
