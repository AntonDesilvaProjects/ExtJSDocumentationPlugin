package com.jstools.extjs.search;

import com.jstools.extjs.common.DocumentationConstants;
import com.jstools.extjs.documentation.Class;
import com.jstools.extjs.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtJSDocumentationSearcher implements ISearcher<Documentation> {

    @Override
    public double getMatchRatio(Documentation searchObject, String query) {
        return calculateMatchRatio( searchObject, query );
    }

    @Override
    public List<SearchResult<Documentation>> getRankedMatches(List<Documentation> searchObjects, String query) {
        List<SearchResult<Documentation>> rankedSearchResult = new ArrayList<SearchResult<Documentation>>();
        for( Documentation document : searchObjects )
            rankedSearchResult.add( new SearchResult<Documentation>( document, this.getMatchRatio(document, query) ) );
        Collections.sort( rankedSearchResult );
        return rankedSearchResult;
    }
    /*
        A simple approach to compute the how much the query is related to a particular
        document object.
    */
    private double calculateMatchRatio( Documentation searchObj, String query )
    {
        double classNameMatchFraction = 0.0;
        double xtypeMatchFraction = 0.0;

        //Match the query against the class name
        String extJSClassName = searchObj.getDocumentedClass().getName().toLowerCase();
        if( extJSClassName.contains(query) )
           classNameMatchFraction = ( query.length() * 1.0 ) / extJSClassName.length();

        //Match the query against the class's aliases and take maximum
        String[] aliases = searchObj.getDocumentedClass().getAlias();
        double partialMatchFraction = 0.0;
        for( String alias : aliases )
        {
            if( alias.trim().contains( query ) ) {
                partialMatchFraction = (query.length() * 1.0) / alias.length();
                xtypeMatchFraction = ( partialMatchFraction > xtypeMatchFraction ) ? partialMatchFraction : xtypeMatchFraction;
            }
        }

        //Return a total match value between 0 - 1 based on weight assigned to the class name and alias
        //NOTE that value may never be 1 since ExtJS class names are never equal to their xtypes
        return DocumentationConstants.EXTJS_CLASSNAME_WEIGHT * classNameMatchFraction +
                ( 1 - DocumentationConstants.EXTJS_CLASSNAME_WEIGHT ) * xtypeMatchFraction;
    }

    public static void main(String[] args)
    {
        Documentation a = new Documentation();
        a.setDocumentedClass( new Class() );
        a.getDocumentedClass().setAlias("panel");
        a.getDocumentedClass().setName("Ext.panel.Panel");

        Documentation b = new Documentation();
        b.setDocumentedClass( new Class() );
        b.getDocumentedClass().setAlias("gpanel,panel");
        b.getDocumentedClass().setName("Ext.ux.Panel");

        ArrayList<Documentation> x = new ArrayList<Documentation>();
        x.add( a );
        x.add( b );

        List<SearchResult<Documentation>> k = new ExtJSDocumentationSearcher().getRankedMatches( x, "panel");

    }

}
