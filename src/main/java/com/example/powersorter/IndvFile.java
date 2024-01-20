package com.example.powersorter;

import java.io.File;

public class IndvFile {

    IndvFile(String name)
    {
        this.name = name;
    }

    IndvFile(File representedFile)
    {
        this.name = representedFile.getName();
    }

    String getName()
    {
        return this.name;
    }
    File filePath = null;
    String name = null;

}
