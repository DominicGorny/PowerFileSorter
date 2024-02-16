package com.example.powersorter.Controllers;

import com.example.powersorter.Enums.IndvFileType;
import com.example.powersorter.FileCollector;
import com.example.powersorter.FileStructures.IndvFile;
import com.example.powersorter.MainApplication;
import com.example.powersorter.actions.ActionManager;
import com.example.powersorter.actions.topLevelActions.TopLevelAction;
import com.example.powersorter.actions.topLevelActions.TopLevelCreateBasicFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelDissolveFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelMoveAction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.File;

public class MainController {

    private onTreeClickCallback onClickFunction = null;
    private TopLevelAction onClickAction = null;
    private Window parentWindow;
    private TreeItem<IndvFile> treeRootItem;

    private MainApplication mainApplication;

    /**
     * The tree table view on the main window, t1 and all its columns refer to the original data source
     */
    @FXML
    private TreeTableView<IndvFile> tableView;
    /**
     * the file name column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> column1;

    /**
     * the File Type column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> column2;

    public MainController (MainApplication MainApp)
    {
        mainApplication = MainApp;
    }


    /**
     * Test event to check button selection
     * @param event
     */
    @FXML
    void testSelection(ActionEvent event)
    {
        System.out.println("changing view");
       mainApplication.folderView();
    }

    /**
     * the on button click event for moving an item on the table view
     * @param event
     */
    @FXML
    void moveItem(ActionEvent event)
    {
        TopLevelMoveAction moveEvent;
        moveEvent = new TopLevelMoveAction(tableView.getSelectionModel().getSelectedItem());
        onClickFunction = moveEvent;
        onClickAction = moveEvent;
    }

    /**
     * the on button click event for dissolving a folder
     * @param event
     */
    @FXML
    void dissolveFolder(ActionEvent event)
    {
        TopLevelDissolveFolderAction folderAction = new  TopLevelDissolveFolderAction(tableView.getSelectionModel().getSelectedItem());
        tableView.refresh();
    }

    /**
     * the on button click event for making a new vanilla folder
     * @param event
     */
    @FXML
    void makeBasicFolder(ActionEvent event)
    {
        TopLevelCreateBasicFolderAction basicFolderAction = new TopLevelCreateBasicFolderAction("New_Folder",
                tableView.getSelectionModel().getSelectedItem());
    }

    /**
     * the on button click event for open a file
     * @param event
     */
    @FXML
    void openSourceFile(ActionEvent event)
    {


        DirectoryChooser directoryPicker = new DirectoryChooser();
        File upperDirectory = directoryPicker.showDialog(parentWindow);
        FileCollector newFileDirectory = new FileCollector(upperDirectory.getAbsolutePath());
        newFileDirectory.multiLayerScoop(newFileDirectory.getParentItem());

        if (treeRootItem == null)
        {
            treeRootItem = new TreeItem<IndvFile>(new IndvFile(IndvFileType.Origin));
            treeRootItem.getChildren().add(newFileDirectory.getParentItem());
            treeRootItem.getValue().setName("Origin");
            treeRootItem.setExpanded(true);
            tableView.setRoot(treeRootItem);
        }
        else
        {
            treeRootItem.getChildren().add(newFileDirectory.getParentItem());
        }
        tableView.refresh();
    }

    /**
     * allows the user to close a top level directory they have opened
     * @param event
     */
    @FXML
    void closeSourceFile(ActionEvent event)
    {
        if(treeRootItem.getChildren().contains(tableView.getSelectionModel().getSelectedItem()))
        {
            treeRootItem.getChildren().remove(tableView.getSelectionModel().getSelectedItem());
        }
        else
        {
            System.out.println("only top level directories (the ones you chose with the open action) can be closed");
        }

        //remove mock parent on empty origin list so that the table shows "no contents"
        if (treeRootItem.getChildren().isEmpty())
        {
            tableView.setRoot(null);
            treeRootItem = null;
        }

        tableView.refresh();



    }

    /**
     * action event function that is triggered if the user clicks on any item in the tree.
     * Is used for actions thqat require multiple inputs e.g for the move action where multiple files are chosen,
     * @param event
     */
    @FXML
    void treeClick(MouseEvent event)
    {
        if (!(onClickFunction == null))
        {
            onClickFunction.clickCallback(tableView.getSelectionModel().getSelectedItem());
            ActionManager.getManager().addAction(onClickAction);
            onClickFunction = null;
            onClickAction = null;
        }
        tableView.refresh();
    }





    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    /**
     * Prepares the content of the tree table view for display
     */
    public void prepareTreeTable()
    {
//        FileCollector testFiles = new FileCollector("/Users/kiwi4/Downloads/");
//
//        testFiles.getRootItem().setExpanded(true);
//        tableView.setRoot(testFiles.multiLayerScoop(testFiles.getRootItem()));

        tableView.refresh();


        column1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getName());
            }
        });

        column2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getType());
            }
        });


    }





}