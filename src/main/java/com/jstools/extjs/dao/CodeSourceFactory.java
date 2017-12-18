package com.jstools.extjs.dao;

import com.jstools.extjs.profile.DocumentationSource;
import com.jstools.extjs.profile.DocumentationSourceType;

public class CodeSourceFactory {
    public static ICodeSource getCodeSource(DocumentationSource source)
    {
        ICodeSource codeSource = null;
        if( source.getSourceType() == DocumentationSourceType.API )
        {

        }
        else if ( source.getSourceType() == DocumentationSourceType.DATABASE )
        {

        }
        else if( source.getSourceType() == DocumentationSourceType.FILESYSTEM )
        {
            codeSource = new FlatFileCodeSource( source );
        }
        else if( source.getSourceType() == DocumentationSourceType.FTP )
        {

        }
        return codeSource;
    }
}
