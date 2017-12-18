package com.jstools.extjs.dao;

import com.jstools.extjs.documentation.SourceFile;

import java.util.List;

public interface ICodeSource {
    public String getType();
    public String getNext();
    public List<SourceFile> getAllRecords();
    public void close();
}
