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
     * A Tree Item holding an IndvFile object which encapsulates the parent file object
     */
    TreeItem<IndvFile> parentItem = null;

    /**
     * creates a file collector at the path passed in
     * @param parentPath
     */
    FileCollector(String parentPath)
    {
        this.parentPath = parentPath;
        this.parentFile = new File(parentPath);
        this.parentItem = new TreeItem<IndvFile>(new IndvFile(this.parentFile));
    }

    /**
     * gets the file collectors parent item
     * @return parent item
     */
    TreeItem<IndvFile> getRootItem()
    {
        return parentItem;
    }

    /**
     * Lists all files directly available in the folder encapsulated by the item passed in
     * @param inputItem the folder passed in
     * @return the folder as a tree item with all sub
     */
    TreeItem<IndvFile> singleLayerScoop(TreeItem<IndvFile> inputItem)
    {
        for (File file: inputItem.getValue().getEncapsulatedFile().listFiles())
        {
            inputItem.getChildren().add(new TreeItem<IndvFile>(new IndvFile(file)));
        }
        return inputItem;
    }

    /**
     * Lists all the files directly available in the folder encapsulated by the item
     *  passed in as well as any folders and attaches them as children.
     * @param inputItem the folder passed in
     * @return the folder as a tree item with all items, sub-folders and items in folders attached as children
     * in a representative hierarchy
     */
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
