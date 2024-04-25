package com.example.powersorter.Enums;

public enum FileAttributes {

    Name("File Name"),
    Created("File Creation Time"),
    Modified("File Modification Time");


    public final String name;
    FileAttributes(String name  )
    {
        this.name = name;
    }
}
