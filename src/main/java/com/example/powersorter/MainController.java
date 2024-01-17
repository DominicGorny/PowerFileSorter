package com.example.powersorter;

import javafx.beans.property.SimpleStringProperty;
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
        column.setCellFactory(new Callback<TreeTableColumn<String, String>, TreeTableCell<String, String>>() {
            @Override
            public TreeTableCell<String, String> call(TreeTableColumn<String, String> param) {
                TreeTableCell<String, String> returner = new TreeTableCell<>();
                returner.setText(param.toString());
                return returner;
            }
        });
    }
}