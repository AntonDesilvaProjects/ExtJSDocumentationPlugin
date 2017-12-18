package com.jstools.extjs.search;

public class SearchResult<T> implements Comparable<SearchResult> {
    private double rank = 0.0;
    private T match;

    public SearchResult(T match, double rank)
    {
        this.match = match;
        this.rank = rank;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public T getMatch() {
        return match;
    }

    public void setMatch(T match) {
        this.match = match;
    }

    @Override
    public int compareTo(SearchResult searchResult)
    {
       if( this.getRank() == searchResult.getRank() )
           return 0;
       else if( this.getRank() < searchResult.getRank() )
           return 1;
       else
           return -1;
    }
}
