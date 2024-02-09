package com.example.powersorter;

import com.example.powersorter.actions.ActionManager;
import com.example.powersorter.actions.topLevelActions.TopLevelAction;
import com.example.powersorter.actions.topLevelActions.TopLevelCreateBasicFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelDissolveFolderAction;
import com.example.powersorter.actions.topLevelActions.TopLevelMoveAction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.File;

public class FolderViewController {

    MainApplication mainApplication;

    public FolderViewController(MainApplication mainApp)
    {
        mainApplication = mainApp;
    }



}