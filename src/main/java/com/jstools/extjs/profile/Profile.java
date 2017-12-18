package com.jstools.extjs.profile;

import com.google.gson.annotations.SerializedName;
import com.jstools.extjs.documentation.Documentation;

import java.util.List;

public class Profile {
    @SerializedName("profile_id")
    private int id;
    @SerializedName("profile_name")
    private String name;
    @SerializedName("documentation_version")
    private String version;
    @SerializedName("documentation_source")
    private List<DocumentationSource> sources;

    //This is a list of all the 'Documentaion' objects
    //that can be associated with this profile
    private List<Documentation> documentations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DocumentationSource> getSources() {
        return sources;
    }

    public void setSources(List<DocumentationSource> sources) {
        this.sources = sources;
    }

    public List<Documentation> getDocumentations() {
        return documentations;
    }

    public void setDocumentations(List<Documentation> documentations) {
        this.documentations = documentations;
    }

    public String getDocumentationRoot() {
        return this.getSources().get(0).getDocumentationRoot();
    }

    public String getDocumentationPrefix() {
        return this.getSources().get(0).getDocumentationPrefix();
    }
}
