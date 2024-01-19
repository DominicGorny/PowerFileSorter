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
    private TreeTableView<String> tableView;
    @FXML
    private TreeTableColumn<String,String> column;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }

    void prepareTreeTable()
    {
        TreeItem<String> par1 = new TreeItem<>("Parent1");
        TreeItem<String> chi1 = new TreeItem<>("Child1");
        TreeItem<String> chi2 = new TreeItem<>("Child2");
        par1.getChildren().setAll(chi1,chi2);
        tableView.setRoot(par1);
        tableView.refresh();
        column.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> param) {

                return new SimpleStringProperty(param.getValue().getValue());
            }
        });
    }
}