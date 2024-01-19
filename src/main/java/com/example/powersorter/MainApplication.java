package com.example.powersorter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

//    @FXML
//    private TreeTableView<String> treeTableView;
//    @FXML
//    private TreeTableColumn<String,String> column;
    MainController myController = new MainController();



    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        fxmlLoader.setController(myController);
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("PowerSorter");
        myController.prepareTreeTable();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }







}