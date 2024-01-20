package com.example.powersorter;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileCollector {

    String parentPath = null;
    File parentFile = null;

    TreeItem<IndvFile> parentItem = null;
    ArrayList<TreeItem<IndvFile>> allChildren = new ArrayList<>();

    FileCollector(String parentPath)
    {
        this.parentPath = parentPath;
        this.parentFile = new File(parentPath);
        this.parentItem = new TreeItem<IndvFile>(new IndvFile(this.parentFile));
    }

    TreeItem<IndvFile> singleLayerScoop()
    {
        for (File file: parentFile.listFiles())
        {
            allChildren.add(new TreeItem<IndvFile>(new IndvFile(file)));
        }
        for (TreeItem<IndvFile> child: allChildren)
        {
            parentItem.getChildren().add(child);
        }
        return parentItem;
    }








}
