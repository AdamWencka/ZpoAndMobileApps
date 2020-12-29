module org.openjfx.zpo_file {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.zpo_file to javafx.fxml;
    exports org.openjfx.zpo_file;
}