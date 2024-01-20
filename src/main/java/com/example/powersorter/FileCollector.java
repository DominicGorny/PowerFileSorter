package com.example.powersorter;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import javax.xml.transform.Source;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * object that is given a specific file path (to a folder) and contains functions to build a sub directory
 * tree of the folder using TreeItems<IndvFile>
 */
public class FileCollector {

    /**
     * String to the File path of the parent object
     */
    String parentPath = null;
    /**
     * a java File object made using the parent File Path
     */
    File parentFile = null;

    /**
     * A Tree Iten holding an IndvFile object which encapsulates the parent file object
     */
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

    TreeItem<IndvFile> multiLayerScoop(TreeItem<IndvFile> inputItem)
    {
        for (File childFile: inputItem.getValue().getEncapsulatedFile().listFiles())
        {

            if (childFile.isDirectory())
            {
                TreeItem<IndvFile> newChild = new TreeItem<>(new IndvFile(childFile));
                multiLayerScoop(newChild);
                inputItem.getChildren().add(newChild);
            }
            else
            {
                inputItem.getChildren().add(new TreeItem<IndvFile>(new IndvFile(childFile)));
            }
        }

        return inputItem;
    }






}
