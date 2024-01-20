package com.example.powersorter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private TreeTableView<IndvFile> tableView;
    @FXML
    private TreeTableColumn<IndvFile,String> column;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }

    void prepareTreeTable()
    {
        TreeItem<IndvFile> par1 = new TreeItem<>(new IndvFile("p1"));
        TreeItem<IndvFile> chi1 = new TreeItem<>(new IndvFile("c1"));
        TreeItem<IndvFile> chi2 = new TreeItem<>(new IndvFile("c2"));
        par1.getChildren().setAll(chi1,chi2);
        tableView.setRoot(par1);
        tableView.refresh();
        column.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<IndvFile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<IndvFile, String> param) {

                return new SimpleStringProperty(param.getValue().getValue().getName());
            }
        });
    }
}