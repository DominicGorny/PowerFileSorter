package com.example.powersorter.actions.topLevelActions;

import com.example.powersorter.IndvFile;
import com.example.powersorter.actions.lowLevelActions.LowLevelMoveAction;
import com.example.powersorter.onTreeClickCallback;
import javafx.scene.control.TreeItem;

/**
 * This is a top level action class meaning it determines actions that can be made by the user but those do not
 * necessarily translate to individual actions done on the computer.
 * This action class allows the user to move one file to another location.
 */
public class TopLevelMoveAction implements onTreeClickCallback, TopLevelAction {
    private TreeItem<IndvFile> fileToMove;
    private TreeItem<IndvFile> fileToTarget;

    boolean actionValid = true;

    /**
     * called when the user selects the first item to move
     * @param fileToMove the item to move
     */
    public TopLevelMoveAction(TreeItem<IndvFile> fileToMove)
    {
        this.fileToMove = fileToMove;
    }

    /**
     * called when the user calls the item that the first item should be moved to
     * @param targetFile the target file selected.
     */
    public void clickCallback(TreeItem<IndvFile> targetFile)
    {

        if (moveSafetyCheck(targetFile)) {
            updateTreeView(targetFile);
        }
        else
        {
            System.out.println("Failed Move safety check");
            actionValid = false;
        }
    }

    /**
     * manages the ui effects of the move action
     * @param targetFile the location where the fileToMove should be moved
     */
    private void updateTreeView(TreeItem<IndvFile> targetFile)
    {

        if (targetFile.getValue().getEncapsulatedFile().isDirectory())
        {
            fileToTarget = targetFile;
            this.fileToMove.parentProperty().get().getChildren().remove(fileToMove);
            targetFile.getChildren().add(fileToMove);
        }
        else
        {
            fileToTarget = targetFile.getParent();
            this.fileToMove.parentProperty().get().getChildren().remove(fileToMove);
            targetFile.getParent().getChildren().add(fileToMove);
        }
    }

    /**
     * ensures that folders cannot be moved into their own subdirectories
     * (because that just doesn't make sense)
     * @param targetFile the location where the fileToMove should be moved
     * @return true if the operation is safe, false if it is unsafe
     */
    private boolean moveSafetyCheck(TreeItem<IndvFile> targetFile)
    {
        if (targetFile == fileToMove)
        {
            return false;
        }
        if (targetFile.getParent() == null)
        {
            return true;
        }
        return moveSafetyCheck(targetFile.getParent());
    }

    @Override
    public boolean executeAction() {
        LowLevelMoveAction lowLevelMove = new LowLevelMoveAction(fileToMove,fileToTarget);
        return lowLevelMove.executeAction();
    }

    @Override
    public boolean getActionValid() {
        return actionValid;
    }
}
