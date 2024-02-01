package com.example.powersorter;

import com.example.powersorter.actions.ActionManager;
import com.example.powersorter.actions.topLevelActions.HighLevelAction;
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
    private HighLevelAction onClickAction = null;
    private Window parentWindow;
    private TreeItem<IndvFile> mockOriginParentItem;
    private TreeItem<IndvFile> mockDestinationParentItem;

    private int focusedTree;


    /**
     * The tree table view on the main window, t1 and all its columns refer to the original data source
     */
    @FXML
    private TreeTableView<IndvFile> t1tableView;
    /**
     * the file name column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> t1column1;

    /**
     * the File Type column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> t1column2;

    /**
     * The tree table view on the main window , t2 and all its columns refer to the data destination
     */
    @FXML
    private TreeTableView<IndvFile> t2tableView;
    /**
     * the file name column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> t2column1;

    /**
     * the File Type column
     */
    @FXML
    private TreeTableColumn<IndvFile,String> t2column2;


    /**
     * Test event to check button selection
     * @param event
     */
    @FXML
    void testSelection(ActionEvent event)
    {
        ActionManager.getManager().executeAll();
    }

    @FXML
    void moveItem(ActionEvent event)
    {
        TopLevelMoveAction moveEvent;
        if (focusedTree == 1) {
            moveEvent = new TopLevelMoveAction(t1tableView.getSelectionModel().getSelectedItem());
        }
        else
        {
            moveEvent = new TopLevelMoveAction(t2tableView.getSelectionModel().getSelectedItem());
        }
        onClickFunction = moveEvent;
        onClickAction = moveEvent;
    }

    @FXML
    void openSourceFile(ActionEvent event)
    {


        DirectoryChooser directoryPicker = new DirectoryChooser();
        File upperDirectory = directoryPicker.showDialog(parentWindow);
        FileCollector newFileDirectory = new FileCollector(upperDirectory.getAbsolutePath());
        newFileDirectory.multiLayerScoop(newFileDirectory.parentItem);

        if (mockOriginParentItem == null)
        {
            mockOriginParentItem = new TreeItem<IndvFile>(new IndvFile(newFileDirectory.getRootItem().getValue().getEncapsulatedFile()));
            mockOriginParentItem.getChildren().add(newFileDirectory.parentItem);
            mockOriginParentItem.getValue().setName("Origin");
            t1tableView.setRoot(mockOriginParentItem);
        }
        else
        {
            mockOriginParentItem.getChildren().add(newFileDirectory.parentItem);
        }
        t1tableView.refresh();
    }

    @FXML
    void openDestinationFile(ActionEvent event)
    {


        DirectoryChooser directoryPicker = new DirectoryChooser();
        File upperDirectory = directoryPicker.showDialog(parentWindow);
        FileCollector newFileDirectory = new FileCollector(upperDirectory.getAbsolutePath());
        newFileDirectory.multiLayerScoop(newFileDirectory.parentItem);

        if (mockDestinationParentItem == null)
        {
            mockDestinationParentItem = new TreeItem<IndvFile>(new IndvFile(newFileDirectory.getRootItem().getValue().getEncapsulatedFile()));
            mockDestinationParentItem.getChildren().add(newFileDirectory.parentItem);
            mockDestinationParentItem.getValue().setName("Destination");
            t2tableView.setRoot(mockDestinationParentItem);
        }
        else
        {
            mockDestinationParentItem.getChildren().add(newFileDirectory.parentItem);
        }
        t2tableView.refresh();
    }



    @FXML
    void t1treeClick(MouseEvent event)
    {
        focusedTree = 1;
        if (!(onClickFunction == null))
        {
            onClickFunction.clickCallback(t1tableView.getSelectionModel().getSelectedItem());
            ActionManager.getManager().addAction(onClickAction);
            onClickFunction = null;
            onClickAction = null;
        }
        t1tableView.refresh();

    }
    @FXML
    void t2treeClick(MouseEvent event)
    {
        focusedTree = 2;
        if (!(onClickFunction == null))
        {
            onClickFunction.clickCallback(t2tableView.getSelectionModel().getSelectedItem());
            ActionManager.getManager().addAction(onClickAction);
            onClickFunction = null;
            onClickAction = null;
        }
        t2tableView.refresh();

    }

    /**
     * An item that has been picked up with the pickup button
     */
    private TreeItem<IndvFile> carriedItem;

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    /**
     * Prepares the content of the tree table view for display
     */
    void prepareTreeTable()
    {
//        FileCollector testFiles = new FileCollector("/Users/kiwi4/Downloads/");
//
//        testFiles.getRootItem().setExpanded(true);
//        tableView.setRoot(testFiles.multiLayerScoop(testFiles.getRootItem()));

        t1tableView.refresh();
        t2tableView.refresh();


        t1column1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getName());
            }
        });

        t1column2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getType());
            }
        });

        t2column1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getName());
            }
        });

        t2column2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getType());
            }
        });


    }





}