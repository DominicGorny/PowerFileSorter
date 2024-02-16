package com.example.powersorter.actions.lowLevelActions;

import com.example.powersorter.FileStructures.IndvFile;
import javafx.scene.control.TreeItem;

import java.io.File;

/**
 * handles actual moving of files on the OS level
 */
public class LowLevelMoveAction implements LowLevelAction{

    private TreeItem<IndvFile> moveItem;
    private TreeItem<IndvFile> destination;

    public LowLevelMoveAction(TreeItem<IndvFile> itemToMove, TreeItem<IndvFile> parentDirectory)
    {
        moveItem = itemToMove;
        destination = parentDirectory;

    }
    @Override
    public boolean executeAction() {

        String destinationPath = destination.getValue().getEncapsulatedFile().getAbsolutePath() + "\\" + moveItem.getValue().getName();

        System.out.print(moveItem.getValue().getEncapsulatedFile());
        System.out.print(" --> ");
        System.out.println(new File(destinationPath));


        return moveItem.getValue().getEncapsulatedFile().renameTo(new File(destinationPath));

    }
}
