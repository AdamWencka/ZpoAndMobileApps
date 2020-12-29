package org.openjfx.zpo_file;

import java.io.IOException;
import java.nio.file.Path;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class PrimaryController {
    private final ObservableList<MyFile> data = FXCollections.observableArrayList();
    private final ObservableList<MyFile> destData = FXCollections.observableArrayList();
    private MyFile storageFile = null;
    private Path current = null;
    private Path currentDest = null;
    @FXML
    private Button upBtn;

    @FXML
    void upBtnAction(ActionEvent event) {

    }

}
