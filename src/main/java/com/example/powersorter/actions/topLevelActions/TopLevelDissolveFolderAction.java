package com.example.powersorter.actions.topLevelActions;

import com.example.powersorter.IndvFile;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * The top level (gui) action object for dissolving folders.
 * (deleting folers and moving all content to upper folders)
 */
public class TopLevelDissolveFolderAction implements TopLevelAction {

    /**
     * the true false state of weather this action should be executed when the user commits their changes
     */
    boolean actionValid = true;

    /**
     * the tree item representing the folder being dissolved
     */
    TreeItem<IndvFile> actionFolder;

    /**
     * the constructor for the action, which checks if the item selected is valid for being dissolved, and dissolves the
     * item on the gui screen (if valid)
     * @param folderToDissolve the folder that should be dissolved
     */
    public TopLevelDissolveFolderAction(TreeItem<IndvFile> folderToDissolve)
    {
        //check operation legality
        if (folderToDissolve.getValue().isMock())
        {
            actionValid = false;
            return;
        }
        if (!folderToDissolve.getValue().getEncapsulatedFile().isDirectory())
        {
            actionValid = false;
            return;
        }
        actionFolder = folderToDissolve;
        updateTree();

    }

    /**
     * update the tgreeView with the new changes (dissolved folder)
     */
    private void updateTree()
    {
        ObservableList<TreeItem<IndvFile>> actionFolderChildren = actionFolder.getChildren();
        TreeItem<IndvFile> actionFolderParent = actionFolder.getParent();
        actionFolderParent.getChildren().remove(actionFolder);
        for (TreeItem<IndvFile> item: actionFolderChildren)
        {
            actionFolderParent.getChildren().add(item);
        }

    }
    @Override
    public boolean executeAction() {
        // placeholder
        return false;
    }

    @Override
    public boolean getActionValid() {
        return actionValid;
    }
}
