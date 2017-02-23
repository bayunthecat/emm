package com.test.emm.dto;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

import java.util.List;

public class PaginatedListImpl<T> implements PaginatedList {

    private int fullListSize;

    private int objectsPerPage;

    private int pageNumber;

    private String searchId;

    private String sortCriterion;

    private SortOrderEnum sortDirection;

    private List<T> list;

    public PaginatedListImpl() {
    }

    public PaginatedListImpl(List<T> list) {
        this.list = list;
    }

    @Override
    public List getList() {
        return list;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getObjectsPerPage() {
        return objectsPerPage;
    }

    @Override
    public int getFullListSize() {
        return fullListSize;
    }

    @Override
    public String getSortCriterion() {
        return sortCriterion;
    }

    @Override
    public SortOrderEnum getSortDirection() {
        return sortDirection;
    }

    @Override
    public String getSearchId() {
        return searchId;
    }

    public void setFullListSize(int fullListSize) {
        this.fullListSize = fullListSize;
    }

    public void setObjectsPerPage(int objectsPerPage) {
        this.objectsPerPage = objectsPerPage;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public void setSortDirection(SortOrderEnum sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
