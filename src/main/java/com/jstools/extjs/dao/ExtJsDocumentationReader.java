package com.jstools.extjs.dao;

import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.documentation.SourceFile;
import com.jstools.extjs.profile.Profile;
import com.jstools.extjs.utility.ExtJsDocumentationParser;

import java.util.ArrayList;
import java.util.List;

public class ExtJsDocumentationReader implements IDocumentationReader {
    /*
        Go through each fileContent string and parse it into a Documentation
        object
    */
    @Override
    public List<Documentation> read(List<SourceFile> sourceFiles, Profile profile) {
        ExtJsDocumentationParser extJsParser = new ExtJsDocumentationParser( profile );
        List<Documentation> documentationList = new ArrayList<Documentation>();
        for(SourceFile sourceFile : sourceFiles )
            documentationList.add( extJsParser.parse( sourceFile ) );
        return documentationList;
    }
}
