module org.openjfx.zpo_fileman {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.io;
    requires java.desktop;

    opens org.openjfx.zpo_fileman to javafx.fxml;
    exports org.openjfx.zpo_fileman;
}