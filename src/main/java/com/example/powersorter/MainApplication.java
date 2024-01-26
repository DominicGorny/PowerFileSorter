package com.example.powersorter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Runs the main App screen
 */
public class MainApplication extends Application {

    MainController myController = new MainController();


    /**
     * starts the stage and defines the window
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        fxmlLoader.setController(myController);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        myController.setParentWindow(scene.getWindow());

        stage.setTitle("PowerSorter");
        myController.prepareTreeTable();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * launches the app
     * @param args launch rgumrnts
     */
    public static void main(String[] args) {
        launch();
    }







}