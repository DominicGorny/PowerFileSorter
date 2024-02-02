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
    private TreeItem<IndvFile> mockParentItem;

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
        moveEvent = new TopLevelMoveAction(tableView.getSelectionModel().getSelectedItem());
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

        if (mockParentItem == null)
        {
            mockParentItem = new TreeItem<IndvFile>(new IndvFile(newFileDirectory.getRootItem().getValue().getEncapsulatedFile()));
            mockParentItem.getChildren().add(newFileDirectory.parentItem);
            mockParentItem.getValue().setName("Origin");
            tableView.setRoot(mockParentItem);
        }
        else
        {
            mockParentItem.getChildren().add(newFileDirectory.parentItem);
        }
        tableView.refresh();
    }


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