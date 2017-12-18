package com.jstools.extjs.utility;

import com.jstools.extjs.documentation.Class;
import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.documentation.SourceFile;
import com.jstools.extjs.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class ExtJsDocumentationParser {

    Profile activeProfile;

    public ExtJsDocumentationParser()
    {

    }
    public ExtJsDocumentationParser(Profile profile)
    {
        activeProfile = profile;
    }

    /*
        Parsing ExtJS source code meta involves following steps:
        1. Extract all the multi-line comments
        2. Identify a comment block as : config, event, example, method, etc
        3. Populate the correct obj.
    */
    public Documentation parse(SourceFile sourceFile)
    {
        //List<String> comments = this.extractMultilineComments( sourceFile.getContent() );
        Documentation documentation = new Documentation();
        String serverFilePath = activeProfile.getDocumentationPrefix() + sourceFile.getName();
        documentation.setUrl( "/docs/" + serverFilePath );

        //Create class + set name
        Class extJsClass = new Class();
        extJsClass.setName( sourceFile.getName().replace(".html", ""));

        //Get ExtJS class alias
        int aliasBlockStart =  sourceFile.getContent().indexOf("<span class='alias'>");
        if( aliasBlockStart != -1 ) {
            int aliasBlockEnd = sourceFile.getContent().indexOf("</span>", aliasBlockStart);
            String aliasBlock = sourceFile.getContent().substring(aliasBlockStart + 20, aliasBlockEnd);
            aliasBlock = aliasBlock.replace("xtype:", "").replace("alias:", "").trim();
            extJsClass.setAlias(aliasBlock);
        }

        documentation.setDocumentedClass( extJsClass );
        return documentation;
    }
    private List<String> extractMultilineComments(String str )
    {
        //The regex (\/\*\*)(.|\n)+?(\*\/) will match correctly but
        //will cause a StackOverflow Exception. Using 'manual'
        //extraction
        List<String> matches = new ArrayList<String>();
        int startIndex = 0;
        while( ( startIndex = str.indexOf("/**", startIndex) ) != -1 )
        {
            int endIndex = str.indexOf("*/", startIndex );
            String match = str.substring(startIndex + 2 , endIndex );
            match = match.replaceAll("\\*", "");
            matches.add( match );
            startIndex = endIndex + 3;
        }
        return matches;
    }
}
