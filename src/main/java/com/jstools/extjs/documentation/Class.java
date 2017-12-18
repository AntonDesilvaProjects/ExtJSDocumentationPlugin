package com.jstools.extjs.documentation;

import com.jstools.extjs.common.AccessSpecifiers;

import java.util.List;

public class Class extends DocumentElement {

    private String className;
    private String alias;
    private AccessSpecifiers classAccess;

    private List<Config> configs;
    private List<Property> properties;
    private List<Method> methods;
    private List<Event> events;
    private List<Example> examples;

    public List<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public String[] getAlias() {
        if( alias == null )
            return new String[0];
        return alias.split(",");
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AccessSpecifiers getClassAccess() {
        return classAccess;
    }

    public void setClassAccess(AccessSpecifiers classAccess) {
        this.classAccess = classAccess;
    }

    @Override
    public String getName() {
        return className;
    }

    @Override
    public void setName(String name) {
        this.className = name;
    }
}
