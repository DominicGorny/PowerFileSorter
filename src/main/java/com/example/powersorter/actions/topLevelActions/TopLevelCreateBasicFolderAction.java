package com.example.powersorter.actions.topLevelActions;

import com.example.powersorter.IndvFile;
import javafx.scene.control.TreeItem;

import java.io.File;

/**
 * This is a top level action class meaning it determines actions that can be made by the user but those do not
 * necessarily translate to individual actions done on the computer.
 * This action class allows the user to create a new vanilla folder
 */
public class TopLevelCreateBasicFolderAction implements TopLevelAction{

    String newFolderName;
    TreeItem<IndvFile> newFoldersParent;

    TreeItem<IndvFile> newFolderTreeItem;

    private boolean isValid;

    public TopLevelCreateBasicFolderAction(String folderName, TreeItem<IndvFile> parentItem)
    {
        if (!parentItem.getValue().getEncapsulatedFile().isDirectory())
        {
            parentItem = parentItem.getParent();
        }
        newFolderName = folderName;
        newFoldersParent = parentItem;
        String newFolderPath = parentItem.getValue().getEncapsulatedFile().getAbsolutePath();
        newFolderPath += "\\";
        newFolderPath += newFolderName;
        IndvFile newFolder = new IndvFile(new File(newFolderPath));
        newFolderTreeItem = new TreeItem<IndvFile>(newFolder);

        parentItem.getChildren().add(newFolderTreeItem);
        System.out.println("making folder at" + newFolder.getEncapsulatedFile().getAbsolutePath());
    }

    @Override
    public boolean executeAction() {
        //Placeholder
        return false;
    }

    @Override
    public boolean getActionValid() {
        return isValid;
    }
}
