package com.example.powersorter.actions.lowLevelActions;

import com.example.powersorter.IndvFile;
import javafx.scene.control.TreeItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

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
