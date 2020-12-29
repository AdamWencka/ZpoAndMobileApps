module org.openjfx.filemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.io;
    requires java.desktop;

    
    opens org.openjfx.filemanager to javafx.fxml;
    exports org.openjfx.filemanager;
}