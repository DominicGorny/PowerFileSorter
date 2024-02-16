package com.example.powersorter;

import com.example.powersorter.actions.ActionManager;
import com.example.powersorter.actions.topLevelActions.TopLevelAction;
import com.example.powersorter.actions.topLevelActions.TopLevelCreateBasicFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelDissolveFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelMoveAction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.File;



public class FolderViewController {

    @FXML
    TabPane folderTypePane;

    @FXML
    TextField basicFolderName;

    @FXML
    TextField filterFolderName;

    @FXML
    TextField filterFolderType;

    @FXML
    TextField filterFolderNotType;

    @FXML
    DatePicker createdStartDate;

    @FXML
    DatePicker createdEndDate;

    @FXML
    DatePicker modifiedStartDate;

    @FXML
    DatePicker modifiedEndDate;

    @FXML
    ComboBox<String> categorisedFolderType;
    MainApplication mainApplication;

    public FolderViewController(MainApplication mainApp)
    {

        mainApplication = mainApp;


    }

    /**
     * Function run when chaning to this window
     */
    public void initController()
    {
        ObservableList<String> categorisationAttributes = FXCollections.observableArrayList("Type",
                "Last Modified","Created");
        categorisedFolderType.setItems(categorisationAttributes);

    }


    /**
     * Closes the folder screen and re-opens the main window
     * @param event
     */
    @FXML
    void cancelFolderCreation(ActionEvent event)
    {

        mainApplication.homeView();
    }

    @FXML
    void createFolder(ActionEvent event)
    {
        System.out.println("made folder");
        System.out.println("basic folder name: " + basicFolderName.getText());
        System.out.println("Filter Folder Name: " + filterFolderName.getText());
        System.out.println("crated between: " + createdStartDate.getValue() + " and " + createdEndDate.getValue());
        System.out.println("modified between: " + modifiedStartDate.getValue() + " and " + modifiedEndDate.getValue());
        System.out.println("is Type: " + filterFolderType.getText());
        System.out.println("not type: " + filterFolderNotType.getText());
        System.out.println("categorised type: " + categorisedFolderType.getValue());
    }



    @FXML
    void tabSelectionChange(Event event)
    {
        System.out.println(folderTypePane.getSelectionModel().getSelectedItem().getText());

    }


}