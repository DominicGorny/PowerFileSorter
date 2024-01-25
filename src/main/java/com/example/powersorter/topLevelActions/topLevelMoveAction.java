package com.example.powersorter.topLevelActions;

import com.example.powersorter.IndvFile;
import com.example.powersorter.onTreeClickCallback;
import javafx.scene.control.TreeItem;

/**
 * This is a top level action class meaning it determines actions that can be made by the user but those do not
 * necessarily translate to individual actions done on the computer.
 * This action class allows the user to move one file to another location.
 */
public class topLevelMoveAction implements onTreeClickCallback {
    private TreeItem<IndvFile> fileToMove;

    /**
     * called when the user selects the first item to move
     * @param fileToMove the item to move
     */
    public topLevelMoveAction(TreeItem<IndvFile> fileToMove)
    {
        this.fileToMove = fileToMove;
    }

    /**
     * called when the user calls the item that the first item should be moved to
     * @param targetFile the target file selected.
     */
    public void clickCallback(TreeItem<IndvFile> targetFile)
    {
        System.out.println("moving from");
        System.out.println(this.fileToMove.getValue().getName());
        System.out.println("to");
        System.out.println(targetFile.getValue().getName());
    }
}
