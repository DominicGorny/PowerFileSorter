package com.example.powersorter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.File;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private TreeTableView<IndvFile> tableView;
    @FXML
    private TreeTableColumn<IndvFile,String> column1;

    @FXML
    private TreeTableColumn<IndvFile,String> column2;


    void prepareTreeTable()
    {
        FileCollector testFiles = new FileCollector("/Users/kiwi4/Downloads/");


//        TreeItem<IndvFile> par1 = new TreeItem<>(new IndvFile("p1"));
//        TreeItem<IndvFile> chi1 = new TreeItem<>(new IndvFile("c1"));
//        TreeItem<IndvFile> chi2 = new TreeItem<>(new IndvFile("c2"));
//        par1.getChildren().setAll(chi1,chi2);
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