package com.jstools.extjs.profile;

import com.google.gson.annotations.SerializedName;

public class DocumentationSource {

    @SerializedName("type")
    private DocumentationSourceType sourceType;
    @SerializedName("url")
    private String URL;
    private String username;
    private String password;
    private int port;
    private String connectionHost;

    @SerializedName("root")
    private String documentationRoot; //Specifies the ExtJs Documentation directory with index.html file
    @SerializedName("prefix")
    private String documentationPrefix; //This prefix will be appended to all file names

    //Note that documentationRoot + documentationPrefix + fileName gives the COMPLETE
    //URI for the documentation engine to locate a file

    public DocumentationSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(DocumentationSourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getConnectionHost() {
        return connectionHost;
    }

    public void setConnectionHost(String connectionHost) {
        this.connectionHost = connectionHost;
    }

    public String getDocumentationRoot() {
        return documentationRoot;
    }

    public void setDocumentationRoot(String documentationRoot) {
        this.documentationRoot = documentationRoot;
    }

    public String getDocumentationPrefix() {
        return documentationPrefix;
    }

    public void setDocumentationPrefix(String documentationPrefix) {
        this.documentationPrefix = documentationPrefix;
    }
}
