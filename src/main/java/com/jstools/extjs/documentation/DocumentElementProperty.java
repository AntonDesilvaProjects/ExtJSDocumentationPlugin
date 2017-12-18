package com.jstools.extjs.documentation;

import com.jstools.extjs.common.AccessSpecifiers;

import java.util.List;

public class DocumentElementProperty {
    DocumentElementPropertyType type;
    AccessSpecifiers accessLevel = AccessSpecifiers.PUBLIC;
    List<String> dataType;
    String name;
    String defaultValue;
    String description;

    public DocumentElementPropertyType getType() {
        return type;
    }

    public void setType(DocumentElementPropertyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDataType() {
        return dataType;
    }

    public void setDataType(List<String> dataType) {
        this.dataType = dataType;
    }

    public AccessSpecifiers getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessSpecifiers accessLevel) {
        this.accessLevel = accessLevel;
    }
}
