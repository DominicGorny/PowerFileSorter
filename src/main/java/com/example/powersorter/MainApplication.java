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

    MainController myHomeViewController = new MainController(this);
    FolderViewController myFolderViewController = new FolderViewController(this);

    private Scene homeScreen;
    private Scene folderEditor;
    private Stage myStage;


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
        myStage = stage;

        FXMLLoader defaultFxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        FXMLLoader folderViewFxmlLoader = new FXMLLoader(MainApplication.class.getResource("folder-editor.fxml"));

        defaultFxmlLoader.setController(myHomeViewController);
        folderViewFxmlLoader.setController(myFolderViewController);

        Scene defaultScene = new Scene(defaultFxmlLoader.load(), 800, 600);
        Scene folderScene = new Scene(folderViewFxmlLoader.load(), 800, 600);
        myHomeViewController.setParentWindow(defaultScene.getWindow());
        myHomeViewController.setParentWindow(folderScene.getWindow());

        stage.setTitle("PowerSorter");
        myHomeViewController.prepareTreeTable();
        stage.setScene(defaultScene);
        stage.show();


        homeScreen = defaultScene;
        folderEditor = folderScene;

    }

    /**
     * launches the app
     * @param args launch rgumrnts
     */
    public static void main(String[] args) {
        launch();
    }

    public void folderView()
    {
        myStage.setScene(folderEditor);
    }

    public void homeView()
    {
        myStage.setScene(homeScreen);
    }







}