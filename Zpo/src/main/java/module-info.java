module org.openjfx.zpo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.openjfx.zpo to javafx.fxml;
    exports org.openjfx.zpo;
}