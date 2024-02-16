package com.example.powersorter.Controllers;

import com.example.powersorter.FileStructures.IndvFile;
import javafx.scene.control.TreeItem;

/**
 * interface used for functions that require the use of an on clicked item event in the tree view
 */
public interface onTreeClickCallback {

    /**
     * function to call when an item was clicked
     * @param clickedItem the clicked item
     */
    void clickCallback(TreeItem<IndvFile> clickedItem);
}
