package com.jstools.extjs.profile;

import com.google.gson.annotations.SerializedName;

public enum DocumentationSourceType {
    @SerializedName("db")
    DATABASE,
    @SerializedName("api")
    API,
    @SerializedName("file")
    FILESYSTEM,
    @SerializedName("ftp")
    FTP
}
