package org.example.zpo4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.lang.reflect.*;

public class PrimaryController {
    private final ObservableList<Object> data = FXCollections.observableArrayList();

    @FXML
    private TextField inputField;

    @FXML
    private Button classBtn;

    @FXML
    private TableView<Object> objectTable;

    @FXML
    private TableColumn<Object, String> objectCol;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> fieldsCol;

    @FXML
    void classAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException {

       Class c1 = Class.forName(inputField.getText());
       Object o = c1.getConstructor();
       data.add(c1.newInstance());
       System.out.println(o);

        System.out.println(data);
        objectTable.setItems(data);
        
    }

}
