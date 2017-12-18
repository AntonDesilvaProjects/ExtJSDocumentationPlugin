package com.jstools.extjs.search;

import com.jstools.extjs.documentation.Documentation;

import java.util.List;

public interface ISearcher<T> {
    /*
        Returns a float between 0.0 and 1.0 indicating how strongly the @param query
        matches with the @param searchObject. A value of 0.0 indicates no match and
        value of 1.0 indicates exact match. The criteria for matching is determined
        by the implementor.
    */
    public double getMatchRatio(T searchObject, String query );
    /*
        Returns a ranked list of T objects ordered from strong matches to
        weak matches.
    */
    public List<SearchResult<T>> getRankedMatches(List<T> searchObjects, String query);
}
