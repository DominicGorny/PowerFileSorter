package com.example.powersorter;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileCollector {


    String parentPath = null;
    File parentFile = null;

    TreeItem<IndvFile> parentItem = null;

    FileCollector(String parentPath)
    {
        this.parentPath = parentPath;
        this.parentFile = new File(parentPath);
        this.parentItem = new TreeItem<IndvFile>(new IndvFile(this.parentFile));
    }

    TreeItem<IndvFile> getRootItem()
    {
        return parentItem;
    }

    TreeItem<IndvFile> singleLayerScoop(TreeItem<IndvFile> inputItem)
    {
        for (File file: inputItem.getValue().getEncapsulatedFile().listFiles())
        {
            inputItem.getChildren().add(new TreeItem<IndvFile>(new IndvFile(file)));
        }
        return inputItem;
    }








}
