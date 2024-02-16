package com.example.powersorter.Controllers;

import com.example.powersorter.Enums.FolderViewTabs;
import com.example.powersorter.IndvFile;
import com.example.powersorter.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class FolderViewController {

    @FXML
    private TabPane folderTypePane;

    @FXML
    private TextField basicFolderName;

    @FXML
    private TextField filterFolderName;

    @FXML
    private TextField filterFolderType;

    @FXML
    private TextField filterFolderNotType;

    @FXML
    private DatePicker createdStartDate;

    @FXML
    private DatePicker createdEndDate;

    @FXML
    private DatePicker modifiedStartDate;

    @FXML
    private DatePicker modifiedEndDate;

    @FXML
    private ComboBox<String> categorisedFolderType;
    private MainApplication mainApplication;

    private FolderViewTabs currentTab = FolderViewTabs.Basic;

    private TreeItem<IndvFile> FolderParent;

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

    public void setFolderParent(TreeItem<IndvFile> folderParent)
    {

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
        System.out.println("made folder of type " + currentTab.code);
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
        String textValueOfSelectedTab = folderTypePane.getSelectionModel().getSelectedItem().getText();
        currentTab = FolderViewTabs.getByName(textValueOfSelectedTab);
        if (currentTab == null)
        {
            throw new IllegalArgumentException("Unexpected Tab Value");
        }
    }


}