package com.jstools.extjs.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResultResponseDTO<T> {
    private String query;
    private double queryTime;
    private List<SearchResult<T>> searchResults;

    public SearchResultResponseDTO()
    {
        this.query = null;
        this.queryTime = -1;
        this.searchResults = new ArrayList<SearchResult<T>>();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(double queryTime) {
        this.queryTime = queryTime;
    }

    public List<SearchResult<T>> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult<T>> searchResults) {
        this.searchResults = searchResults;
    }
}
