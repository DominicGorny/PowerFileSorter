package com.example.powersorter;

import java.io.File;
import java.util.List;

/**
 * A class that represents and induvidual file in a directory and stores information relating to this file
 */
public class IndvFile {

    private String name = null;
    private String type = null;

    private File encapsulatedFile = null;


    /**
     * Constructor that builds and individual file class by using the information from a java file type object
     * @param representedFile the file that this object represents
     */
    public IndvFile(File representedFile)
    {
        this.name = representedFile.getName();
        if (representedFile.isDirectory())
        {
            this.type = "Folder";
        }
        else {
            String[] nameSegments = this.name.split("\\.");
            this.type = "." +  nameSegments[nameSegments.length - 1];
        }

        this.encapsulatedFile = representedFile;
    }

    /**
     * get File name
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * get the type of the file as a string
     * @return file type
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * return the actual file object that this class represents
     * @return Java File object
     */
    public File getEncapsulatedFile()
    {
        return encapsulatedFile;
    }



}
