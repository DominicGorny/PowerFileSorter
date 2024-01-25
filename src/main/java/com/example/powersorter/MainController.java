package com.example.powersorter;

import com.example.powersorter.topLevelActions.topLevelMoveAction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.controlsfx.control.action.Action;

import java.io.File;

public class MainController {

    private onTreeClickCallback onClickAction = null;

    /**
     * The tree table view on the main window
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
        System.out.println(tableView.getSelectionModel().getSelectedItem().getValue().getName());
    }

    @FXML
    void moveItem(ActionEvent event)
    {
        topLevelMoveAction moveEvent = new topLevelMoveAction(tableView.getSelectionModel().getSelectedItem());
        onClickAction = moveEvent;
    }

    @FXML
    void treeClick(MouseEvent event)
    {
        if (!(onClickAction == null))
        {
            onClickAction.clickCallback(tableView.getSelectionModel().getSelectedItem());
            onClickAction = null;
        }

    }

    /**
     * An item that has been picked up with the pickup button
     */
    private TreeItem<IndvFile> carriedItem;


    /**
     * Prepares the content of the tree table view for display
     */
    void prepareTreeTable()
    {
        FileCollector testFiles = new FileCollector("/Users/kiwi4/Downloads/");

        testFiles.getRootItem().setExpanded(true);
        tableView.setRoot(testFiles.multiLayerScoop(testFiles.getRootItem()));
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