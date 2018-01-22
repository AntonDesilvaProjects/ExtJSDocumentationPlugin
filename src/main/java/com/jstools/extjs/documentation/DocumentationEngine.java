package com.jstools.extjs.documentation;

import com.jstools.extjs.dao.CodeSourceFactory;
import com.jstools.extjs.dao.ExtJsDocumentationReader;
import com.jstools.extjs.dao.ICodeSource;
import com.jstools.extjs.dao.IDocumentationReader;
import com.jstools.extjs.profile.DocumentationSource;
import com.jstools.extjs.profile.Profile;
import com.jstools.extjs.profile.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentationEngine {

    @Autowired
    ProfileManager profileManager;

    public DocumentationEngine()
    {
    }

    /*
        Accomplishes the following tasks in order:
        1. Starts the ProfileManager which will load all the
        profiles.
        2. Enrich each profile by:
            a) Getting appropriate code source which will read the source code
            files.
            b) Pass the data into a Documentation Reader which will parse and
            generate Documentation objects.
    */
    @PostConstruct
    private void initializeDocumentation() {
        //Enrich each profile
        for(Profile profile : profileManager.getProfiles() )
        {
            this.enrichProfile( profile );
        }
    }
    private Profile enrichProfile( Profile profile )
    {
        List<SourceFile> completeSourceCode = new ArrayList<SourceFile>();
        for(DocumentationSource docSource : profile.getSources() )
        {
            ICodeSource codeSource = CodeSourceFactory.getCodeSource( docSource );
            completeSourceCode.addAll( codeSource.getAllRecords() );
        }
        IDocumentationReader extJsDocReader = new ExtJsDocumentationReader();
        profile.setDocumentations( extJsDocReader.read( completeSourceCode, profile ) );
        return profile;
    }

//    public static void main(String[] args)
//    {
//        new DocumentationEngine().initializeDocumentation();
//    }
}
