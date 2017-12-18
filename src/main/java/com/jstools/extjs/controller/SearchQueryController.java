package com.jstools.extjs.controller;

import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.search.SearchEngine;
import com.jstools.extjs.search.SearchResult;
import com.jstools.extjs.search.SearchResultResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/DocumentationServer")
public class SearchQueryController {

    @Autowired
    SearchEngine searchEngine;

    @RequestMapping(value="/getDocumentation", method= RequestMethod.GET)
    @ResponseBody
    public SearchResultResponseDTO<Documentation> getDocumentation(@RequestParam("q") String query)
    {
        return this.doQuery( query );
    }

    //-----Below methods are ONLY to be invoked by the Sublime Editor + UI poller process----

    //Buffers the data returned for last Sublime Text query
    private SearchResultResponseDTO<Documentation> searchResultBuffer = null;

    @CrossOrigin
    @RequestMapping(value="/ui/getDocumentation", method= RequestMethod.GET)
    @ResponseBody
    public SearchResultResponseDTO<Documentation> getUiDocumentation(@RequestParam("q") String query)
    {
        //Whenever a query from Sublime arrives, store the results in the buffer
        //so the UI poller can pick it up
        this.searchResultBuffer = this.doQuery( query );
        return this.searchResultBuffer;
    }

    @CrossOrigin
    @RequestMapping(value="/ui/poller", method= RequestMethod.GET)
    @ResponseBody
    public SearchResultResponseDTO<Documentation> uiPollerEndpoint()
    {
        //Polled by UI. If the UI sees buffered data, clear the buffer before sending it to the UI
        //so the same data is not returned the second time
        SearchResultResponseDTO<Documentation> searchResults = new SearchResultResponseDTO<Documentation>();
        if( searchResultBuffer != null )
        {
            searchResults.getSearchResults().addAll( searchResultBuffer.getSearchResults() );
            searchResults.setQuery( searchResultBuffer.getQuery() );
            searchResults.setQueryTime( searchResultBuffer.getQueryTime() );
            searchResultBuffer = null;
            return searchResults;
        }
        return searchResults;
    }

    //---------------------------------------------------------------------------------------
    /*
        Carries out the passed in query and returns a response object
    */
    private SearchResultResponseDTO<Documentation> doQuery( String query )
    {
        SearchResultResponseDTO<Documentation> searchResultResponse = new SearchResultResponseDTO<Documentation>();
        long startTime = System.nanoTime();
        List<SearchResult<Documentation>> results = searchEngine.search( query );
        long endTime = System.nanoTime();
        searchResultResponse.setQuery( query );
        searchResultResponse.setSearchResults( results );
        searchResultResponse.setQueryTime( (endTime - startTime) / 1000000.0 );
        return searchResultResponse;
    }
}
