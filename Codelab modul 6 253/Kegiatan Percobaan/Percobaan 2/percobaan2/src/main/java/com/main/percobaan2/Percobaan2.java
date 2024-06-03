package com.main.percobaan2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

public class Percobaan2 extends Application {

    private TableView<Mahasiswa> table = new TableView<>();
    private final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa("Topek Ramadan", "202410370311200", "radan@gmail.com"),
            new Mahasiswa("Sutrisno Adit Pratama", "202410370311203", "adit@gmail.com"),
            new Mahasiswa("Wempy Aditya Wirawan", "202410370311233", "radan@gmail.com"),
            new Mahasiswa("Maylani Ku", "202410370311311", "maylani@gmail.com")
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Test TableView");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Mahasiswa, String> nameCol = new TableColumn<>("Nama");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setMinWidth(100);
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.setItems(data);
        table.getColumns().addAll(nameCol, nimCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Mahasiswa {
        private final SimpleStringProperty name;
        private final SimpleStringProperty nim;
        private final SimpleStringProperty email;

        private Mahasiswa(String name, String nim, String email) {
            this.name = new SimpleStringProperty(name);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getNim() {
            return nim.get();
        }

        public void setNim(String nim) {
            this.nim.set(nim);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String email) {
            this.email.set(email);
        }
    }
}