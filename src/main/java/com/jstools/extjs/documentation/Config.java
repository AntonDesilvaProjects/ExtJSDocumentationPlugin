package com.jstools.extjs.documentation;

/*
    @cfg {String} [text='']
    The plain text to display within the label. If you need to include HTML
    tags within the label's innerHTML, use the {@link #html} config instead.
*/

public class Config extends DocumentElement {

    private DocumentElementProperty configProperty;

    public DocumentElementProperty getConfigProperty() {
        return configProperty;
    }

    public void setConfigProperty(DocumentElementProperty configProperty) {
        this.configProperty = configProperty;
    }
}
