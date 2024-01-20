package com.example.powersorter;

import java.io.File;
import java.util.List;

public class IndvFile {
    String name = null;
    String type = null;

    File encapsulatedFile = null;



    IndvFile(File representedFile)
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

    String getName()
    {
        return this.name;
    }
    String getType()
    {
        return this.type;
    }

    File getEncapsulatedFile()
    {
        return encapsulatedFile;
    }



}
