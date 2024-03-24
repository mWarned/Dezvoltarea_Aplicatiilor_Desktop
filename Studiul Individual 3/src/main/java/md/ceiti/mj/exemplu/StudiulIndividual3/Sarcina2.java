package md.ceiti.mj.exemplu.StudiulIndividual3;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class Sarcina2 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private TableView<String> tableView;

    @FXML
    private TableColumn<String, String> column;

    @FXML
    private void initialize() {
        column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setEditable(true);
    }

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Sarcina2.class.getResource("sarcina2.fxml")));
        Scene scene = new Scene(root, 600, 400);

        Node node = root.lookup("#table");
        if (node instanceof TableView) {
            tableView = (TableView<String>) node;
        } else {
            System.out.println("Element with id-'table' is not a TableView.");
        }

        TableColumn<String, String> column = (TableColumn<String, String>) tableView.getColumns().get(0);
        column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setEditable(true);

        tableView.getSelectionModel().selectFirst();
        tableView.setEditable(true);

        TextArea textArea = (TextArea) root.lookup("#text");
        textArea.setOnKeyPressed(e -> {
            String text = textArea.getText();
        });

        Button btnCorrect = (Button) root.lookup("#btnCorrect");
        btnCorrect.setOnAction(e -> {
            String text = textArea.getText();
            String updatedText = text;

            String selectedWord = tableView.getSelectionModel().getSelectedItem();

            if (selectedWord != null) {
                String[] words = updatedText.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].contains("$")) {
                        words[i] = selectedWord;
                    }
                }
                updatedText = String.join(" ", words);
                textArea.setText(updatedText);
            }
        });

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll("Hi", "Hello", "How's life");
        tableView.setItems(data);

        Button addButton = (Button) root.lookup("#btnAdd");
        addButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Text");
            dialog.setHeaderText("Enter the text to add:");
            dialog.setContentText("Text:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(text -> {
                if (!text.isEmpty()) {
                    data.add(text);
                }
            });
        });

        stage.setTitle("Sarcina 2!");
        stage.setScene(scene);
        stage.show();
    }
}
