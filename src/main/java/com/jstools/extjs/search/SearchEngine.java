package com.jstools.extjs.search;

import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.profile.Profile;
import com.jstools.extjs.profile.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngine {

    @Autowired
    ProfileManager profileManager;

    public List<SearchResult<Documentation>> search(String query)
    {
        ISearcher<Documentation> searcher = new ExtJSDocumentationSearcher();
        Profile defaultProfile = profileManager.getProfile(1);
        List<Documentation> documentations = defaultProfile.getDocumentations();
        return searcher.getRankedMatches( documentations, query );
    }
}
