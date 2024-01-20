package com.example.powersorter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.File;

public class MainController {

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
     * Prepares the content of the tree table view for display
     */
    void prepareTreeTable()
    {
        FileCollector testFiles = new FileCollector("/Users/kiwi4/Downloads/");


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