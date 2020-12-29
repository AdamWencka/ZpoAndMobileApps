package org.openjfx.hellofx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PrimaryController implements EmployeeDAO {

    String host = "localhost";
    int port = 3306;
    String db = "zpo0";
    String username = "root";
    String password = "";
    MyConnector myconn = new MyConnector(host, port, db, username, password);

    private ResultSet rs = null;
    private ObservableList<Employee> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Integer> idCol;

    @FXML
    private TableColumn<Employee, String> nameCol;

    @FXML
    private TableColumn<Employee, String> emailCol;

    @FXML
    private TableColumn<Employee, Double> salaryCol;

    @FXML
    private Tab tab1;

    @FXML
    private ChoiceBox<String> idname1;

    @FXML
    private TextField idname2;

    @FXML
    private Button searchB;

    @FXML
    private Button deleteB;

    @FXML
    private Tab tab2;

    @FXML
    private TextField idInput;

    @FXML
    private TextField salaryInput;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private Button saveB;

    @FXML
    private Text infoText;

    @FXML
    private Button refreshB;

    @FXML
    void deleteAction(ActionEvent event) {
        if (!idname2.getText().isEmpty()) {
            Optional op = findOne(Integer.parseInt(idname2.getText()));
            op.ifPresent(action
                    -> {
                delete((Employee) op.get());
                infoText.setText("Employee deleted");
            });
        } else {
            infoText.setText("No ID entered");
        }
    }

    @FXML
    void deleteDisable(MouseDragEvent event) {
        deleteB.setDisable(true);
    }

    @FXML
    void refreshAction(ActionEvent event) {
        table.refresh();
        infoText.setText("Table refreshed");
    }

    @FXML
    void saveAction(ActionEvent event) {
        Integer id = Integer.parseInt(idInput.getText());
        String name = nameInput.getText();
        String email = emailInput.getText();
        Double salary = Double.parseDouble(salaryInput.getText());
        if (!idInput.getText().isEmpty() && !nameInput.getText().isEmpty() && !emailInput.getText().isEmpty() && !salaryInput.getText().isEmpty()) {
            save(new Employee(id, name, email, salary));
            infoText.setText("Employee saved / modifiyed");
        }else infoText.setText("No blank fields allowed");
    }

    @FXML
    void searchAction(ActionEvent event) {
        Optional<Employee> op = Optional.empty();
        if (!idname2.getText().isEmpty()) {
            switch (idname1.getValue()) {
                case "ID":
                    op = findOne(Integer.parseInt(idname2.getText()));
                    break;

                case "NAME":
                    op = findByName(idname2.getText());
                    break;
            }
        }
        data.clear();
        if (op.isPresent()) {
            data.add(op.get());
        }
        table.refresh();
    }

    @FXML
    void showallAction(ActionEvent event) {
        //String statement = "SELECT * FROM Employee";
        //table.setItems(resultSetToList(myconn.getResultSet(statement)));
        data.clear();
        data.addAll(findAll());
        table.refresh();
        infoText.setText("All employees showed");
    }

    @Override
    public Optional<Employee> findOne(Integer id) {
        Optional<Employee> one = Optional.empty();
        String statement = "SELECT * FROM Employee WHERE id=" + id;
        try {
            rs = myconn.getResultSet(statement);
            if (rs.next()) {
                one = Optional.of(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return one;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String statement = "SELECT * FROM Employee";
        try {
            rs = myconn.getResultSet(statement);
            while (rs.next()) {
                list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return list;
    }

    @Override
    public Optional<Employee> findByName(String name) {
        Optional<Employee> one = Optional.empty();
        String statement = "SELECT * FROM Employee WHERE name LIKE \"" + name + "\"";
        try {
            rs = myconn.getResultSet(statement);
            if (rs.next()) {
                one = Optional.of(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return one;
    }

    @Override
    public void delete(Employee employee) {
        String statement = "DELETE FROM Employee WHERE id=" + employee.getId();
        myconn.executeStatement(statement);
    }

    @Override
    public void save(Employee employee) {
        String statement = "SELECT * FROM Employee WHERE id=" + employee.getId();
        try {
            if (myconn.getResultSet(statement).next()) {
                statement = "UPDATE Employee SET name=\"" + employee.getName()
                        + "\", email=\"" + employee.getEmail()
                        + "\", salary=" + employee.getSalary()
                        + "WHERE id=" + employee.getId();
            } else {
                statement = "INSERT INTO Employee(id, name, email, salary) VALUES ("
                        + employee.getId() + ", \""
                        + employee.getName() + "\", \""
                        + employee.getEmail() + "\", "
                        + employee.getSalary() + ")";
            }
            myconn.executeStatement(statement);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void init() {
        idname1.setItems(FXCollections.observableArrayList(
                "ID", "NAME")
        );
        idname1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value) {
                deleteB.setDisable(new_value.intValue() > 0);
            }
        });

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        String statement = "SELECT * FROM Employee";
        data = resultSetToList(myconn.getResultSet(statement));
        table.setItems(data);
        table.refresh();
    }

    ObservableList<Employee> resultSetToList(ResultSet rs) {
        ObservableList<Employee> data = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                data.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {

        }
        return data;
    }

    @FXML
    public void initialize() {
        init();
    }
}
