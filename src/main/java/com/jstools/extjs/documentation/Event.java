package com.jstools.extjs.documentation;

import java.util.List;

public class Event extends DocumentElement {
    private List<DocumentElementProperty> eventParameters;

    public List<DocumentElementProperty> getEventParameters() {
        return eventParameters;
    }

    public void setEventParameters(List<DocumentElementProperty> eventParameters) {
        this.eventParameters = eventParameters;
    }
}
