module org.example.zpo4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.zpo4 to javafx.fxml;
    exports org.example.zpo4;
}