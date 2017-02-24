package com.test.emm.action.form;

import org.apache.struts.action.ActionForm;
import org.displaytag.pagination.PaginatedList;

public class AllClientsForm extends ActionForm {

    private int page;

    private int pageSize;

    private String sort;

    private String dir;

    private PaginatedList list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public PaginatedList getAllClients() {
        return list;
    }

    public void setList(PaginatedList list) {
        this.list = list;
    }
}
