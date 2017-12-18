package com.jstools.extjs.dao;

import com.jstools.extjs.documentation.Documentation;
import com.jstools.extjs.documentation.SourceFile;
import com.jstools.extjs.profile.Profile;

import java.util.List;

public interface IDocumentationReader {
    public List<Documentation> read(List<SourceFile> fileContents, Profile profile);
}
