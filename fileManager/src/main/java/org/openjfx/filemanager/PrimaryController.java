package org.openjfx.filemanager;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.awt.Desktop;
import java.io.File;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.input.TransferMode;

public class PrimaryController {

    private final ObservableList<MyFile> data = FXCollections.observableArrayList();
    private final ObservableList<MyFile> destData = FXCollections.observableArrayList();
    private MyFile storageFile = null;
    private Path current = null;
    private Path currentDest = null;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu menuDisk;

    @FXML
    private Menu menuAction;

    @FXML
    private MenuItem maCopy;

    @FXML
    private MenuItem maCopyTo;

    @FXML
    private Button upButton;

    @FXML
    private MenuItem maDelete;

    @FXML
    private MenuItem maPaste;

    @FXML
    private MenuItem maProperties;

    @FXML
    private TableView<MyFile> fileTable;

    @FXML
    private TableColumn<MyFile, String> colName;

    @FXML
    private TableColumn<MyFile, String> colExt;

    @FXML
    private TableColumn<MyFile, String> colSize;

    @FXML
    private TableColumn<MyFile, String> colData;

    @FXML
    private Label labelDisk;

    @FXML
    private Label labelTSpace;

    @FXML
    private Label labelUSpace;

    @FXML
    private Label labelFSpace;

    @FXML
    private ProgressBar pBar;

    @FXML
    private Label pFileName;

    @FXML
    private Label pPath;

    @FXML
    private Label pSize;

    @FXML
    private Label pDate;

    @FXML
    private TextField textNF;

    @FXML
    private Button buttonNF;

    @FXML
    private TableView<MyFile> destTable;

    @FXML
    private TableColumn<MyFile, String> colDest;

    @FXML
    void buttonNFAction(ActionEvent event) throws IOException {
        if (!textNF.getText().isEmpty()) {
            File file = Paths.get(current + "\\" + textNF.getText()).toFile();
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    @FXML
    void maCopyAction(ActionEvent event) {
        storageFile = fileTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    void maCopyToAction(ActionEvent event) throws IOException {
        if (fileTable.getSelectionModel().getSelectedItem() != null) {
            Path tmp = fileTable.getSelectionModel().getSelectedItem().getPath();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File sd = directoryChooser.showDialog(new Stage());

            if (sd == null) {
                areYouSure("No directory selected");
            } else {
                File tmp2 = new File(sd.getPath() + "\\" + tmp.getFileName());
                if (tmp2.exists()) {
                    if (areYouSure("File with this name already exits. \n"
                            + "Are you sure you want to override it?")) {
                        Files.delete(tmp2.toPath());
                        Files.copy(tmp, tmp2.toPath());
                        setFileList(current, data);
                    }
                } else {
                    Files.copy(tmp, tmp2.toPath());
                    setFileList(current, data);
                }
            }
        } else {
            areYouSure("No selected file to copy");
        }
    }

    @FXML
    void dragDetected(MouseEvent event) {
        Dragboard db = fileTable.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putString(fileTable.getSelectionModel().getSelectedItem().getPath().toString());
        db.setContent(cb);
        event.consume();
        System.out.println(current.toString());
    }

    @FXML
    void dragDropped(DragEvent event) throws IOException {
        String str = event.getDragboard().getString();
        System.out.println(str);
        System.out.println(currentDest);
        Path source = Paths.get(str);
        Path dest = Paths.get(currentDest + "\\" + source.getFileName());
        Files.copy(source, dest);
        setFileList(currentDest, destData);
    }

    @FXML
    void dragOver(DragEvent event) {
        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    void maDeleteAction(ActionEvent event) throws IOException {
        if (areYouSure("Are you sure you want to delete this file?")) {
            Files.delete(fileTable.getSelectionModel().getSelectedItem().getPath());
            setFileList(current, data);
        }
    }

    @FXML
    void maPasteAction(ActionEvent event) throws IOException {
        Path tmp = Paths.get(current.toString() + "\\" + storageFile.getPath().getFileName());
        if (tmp.toFile().exists()) {
            if (areYouSure("File with this name already exits. \n"
                    + "Are you sure you want to override it?")) {
                Files.delete(tmp);
                Files.copy(storageFile.getPath(), tmp);
                setFileList(current, data);
            }
        } else {
            Files.copy(storageFile.getPath(), tmp);
            setFileList(current, data);
        }
    }

    @FXML
    void maPropertiesAction(ActionEvent event) throws IOException, InterruptedException {
        MyFile file = fileTable.getSelectionModel().getSelectedItem();
        if (file != null) {
            updateProperties(file);
        } else {
            areYouSure("No file selected");
        }
    }

    @FXML
    void tableClickAction(MouseEvent event) throws IOException {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                TableView view = (TableView) (event.getSource());
                MyFile file = (MyFile) view.getSelectionModel().getSelectedItem();
                Path path = file.getPath();
                if (path.toFile().isDirectory()) {
                    setFileList(path, view.getItems());
                } else if (path.toFile().isFile()) {
                    Desktop.getDesktop().open(path.toFile());
                }
            }
        }
    }

    @FXML
    void upAction(ActionEvent event) throws IOException {

        if (event.getSource().equals(upButton)) {
            if (current != null) {
                current = current.getParent();
                if (current != null) {
                    setFileList(current, data);
                }
            }
        } else {
            if (currentDest != null) {
                currentDest = currentDest.getParent();
                if (currentDest != null) {
                    setFileList(currentDest, destData);
                }
            }
        }

    }

    public void updateProperties(MyFile file) throws InterruptedException {
        Path path = file.getPath();
        pFileName.setText(file.getName());
        pPath.setText(file.getPath().toString());
        pDate.setText(file.getModified());
        if (path.toFile().isDirectory()) {
            MySize ms = new MySize(file, file.getPath());
            ms.start();
            ms.join();
        }
        pSize.setText(file.getSizeString());
    }

    public void setFileList(Path path, ObservableList<MyFile> ol) throws IOException {
        try {
            List<Path> list = new ArrayList<>();
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            stream.forEach(p -> list.add(p));
            ol.clear();
            list.stream()
                    .filter(p -> !p.toFile().isHidden() && p.toFile().canRead())
                    .filter(p -> !Pattern.matches("\\..*", p.getName(p.getNameCount() - 1).toString()))
                    .forEach(p -> ol.add(new MyFile(p)));
            if (ol.equals(data)) {
                current = path;
            } else if (ol.equals(destData)) {
                currentDest = path;
            }
        } catch (AccessDeniedException ex) {
            areYouSure("Access Denied");
        }
    }

    public boolean areYouSure(String mes) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Risky action");
        alert.setContentText(mes);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    public void setDiskMenu() throws IOException {
        for (Path root : FileSystems.getDefault().getRootDirectories()) {
            MenuItem tmp = new MenuItem(root.toString());
            FileStore store = Files.getFileStore(root);
            tmp.setOnAction(eh -> {
                try {
                    labelDisk.setText(root.toString());
                    labelTSpace.setText(MyFile.bytesConverter(store.getTotalSpace()));
                    labelUSpace.setText(MyFile.bytesConverter(store.getTotalSpace() - store.getUsableSpace()));
                    labelFSpace.setText(MyFile.bytesConverter(store.getUsableSpace()));
                    pBar.setProgress(1 - ((double) store.getUsableSpace() / (double) store.getTotalSpace()));
                } catch (IOException ex) {
                }
                try {
                    setFileList(root, data);
                    setFileList(root, destData);
                } catch (IOException ex) {
                }
            });
            menuDisk.getItems().add(tmp);
        }
    }

    public void init() throws IOException {
        setDiskMenu();

        data.addListener((Observable il) -> fileTable.refresh());
        destData.addListener((Observable il) -> destTable.refresh());
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colExt.setCellValueFactory(new PropertyValueFactory<>("ext"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("sizeString"));
        colData.setCellValueFactory(new PropertyValueFactory<>("modified"));
        colDest.setCellValueFactory(new PropertyValueFactory<>("name"));
        fileTable.setItems(data);
        destTable.setItems(destData);
        fileTable.refresh();
        menuDisk.getItems().get(0).fire();
        setFileList(Paths.get("C:/Users/Admin/Desktop"), data);
        setFileList(Paths.get("C:/Users/Admin/Desktop"), destData);
    }

    @FXML
    public void initialize() throws IOException {
        init();
    }
}
