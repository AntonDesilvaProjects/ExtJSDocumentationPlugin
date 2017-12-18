package com.jstools.extjs.dao;

import com.jstools.extjs.documentation.SourceFile;
import com.jstools.extjs.profile.DocumentationSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlatFileCodeSource implements ICodeSource {

    private List<SourceFile> records = null;
    private String dataSourceURL = null;

    public FlatFileCodeSource()
    {
        records = new ArrayList<SourceFile>();
    }

    public FlatFileCodeSource(DocumentationSource source)
    {
        records = new ArrayList<SourceFile>();
        this.dataSourceURL = source.getURL();
        this.records = this.getSourceFileContent();
    }

    @Override
    public String getType() {
        return "FLAT_FILE";
    }

    @Override
    public String getNext() {
        return null;
    }

    @Override
    public List<SourceFile> getAllRecords() {
        return records;
    }

    @Override
    public void close() {
        //File reading resources are automatically closed
    }

    private List<SourceFile> getSourceFileContent()
    {
        List<SourceFile> records = new ArrayList<SourceFile>();
        if( this.dataSourceURL != null )
        {
            File[] files = new File(this.dataSourceURL).listFiles();
            this.traverseAndReadFiles(files,records);
        }
        return records;
    }
    private void traverseAndReadFiles(File[] files, List<SourceFile> records)
    {
        FileReader fileReader;
        StringBuilder stringBuilder = new StringBuilder();
        for(File file : files )
        {
            if( file.isDirectory() )
            {
                //For now, no recursive directory searching
                continue;
                //System.out.println("Entering directory: " + file.getName() );
                //traverseAndReadFiles(file.listFiles(), records);
            }
            else
            {
                System.out.println("Reading file: " + file.getName() );
                SourceFile sourceFile;
                try
                {
                    fileReader = new FileReader( file.getAbsoluteFile() );
                    BufferedReader bufferedReader = new BufferedReader( fileReader );
                    stringBuilder.setLength(0);
                    String currentLine = null;
                    while( (currentLine = bufferedReader.readLine() ) != null )
                    {
                        stringBuilder.append( currentLine );
                        //These files are too big...just read up to the header section
                        //les we run out of heap memory
                        if( currentLine.contains("<div class=\"context-menu-ct\">") )
                            break;
                    }
                    sourceFile = new SourceFile();
                    sourceFile.setName( file.getName() );
                    sourceFile.setPath( file.getPath() );
                    sourceFile.setContent( stringBuilder.toString() );

                    records.add( sourceFile );
                    bufferedReader.close();
                }
                catch(FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] arsg)
    {
        List<SourceFile> a = new FlatFileCodeSource().getSourceFileContent();
        System.out.println();
    }
}
