package md.ceiti.mj.exemplu.StudiulIndividual3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;

public class Sarcina3 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private boolean isDataLoaded = false;
    private Scene scene;
    TextArea textArea;

    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Sarcina3.class.getResource("sarcina3.fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);

            textArea = (TextArea) root.lookup("#text");

            Button upload = (Button) root.lookup("#upload");
            upload.setOnAction(e -> {
                textArea.clear();
                String fileName = "src/main/resources/matrix.txt";
                try {
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        textArea.appendText(line + "\n");
                    }
                    bufferedReader.close();
                    isDataLoaded = true; // Data is loaded successfully
                    updateButtonStatus();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            Button process = (Button) root.lookup("#process");
            process.setOnAction(e -> {
                int[][] matrix = convertTextAreaToMatrix(textArea.getText());
                processMatrix(matrix);
                printMatrixToTextArea(matrix, textArea);
            });
            process.setDisable(true);

            Button save = (Button) root.lookup("#save");
            save.setOnAction(e -> {
                int[][] matrix = convertTextAreaToMatrix(textArea.getText());
                String fileName = "src/main/resources/matrix.txt";
                writeMatrixToFile(matrix, fileName);
            });
            save.setDisable(true);

            textArea.textProperty().addListener((observable, oldValue, newValue) -> updateButtonStatus());

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateButtonStatus() {
        Button processButton = (Button) scene.lookup("#process");
        Button saveButton = (Button) scene.lookup("#save");
        if (isDataLoaded && !textArea.getText().trim().isEmpty()) {
            processButton.setDisable(false);
            saveButton.setDisable(false);
        } else {
            processButton.setDisable(true);
            saveButton.setDisable(true);
        }
    }

    private int[][] convertTextAreaToMatrix(String text) {
        String[] lines = text.split("\n");
        int[][] matrix = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] numbers = lines[i].split("\\s+");
            matrix[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return matrix;
    }

    private void printMatrixToTextArea(int[][] matrix, TextArea textArea) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int[] row : matrix) {
                for (int element : row) {
                    sb.append(element).append(" ");
                }
                sb.append("\n");
            }
            textArea.setText(sb.toString());
        } catch (Exception e) {
            displayErrorWindow("Error occurred while printing matrix to TextArea: " + e.getMessage());
        }
    }

    private void processMatrix(int[][] matrix) {
        try {
            int countOnes = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length > 1 && matrix[i][1] == 1) {
                    countOnes++;
                    if (countOnes == 2) {

                        int max = Integer.MIN_VALUE;
                        for (int k = 0; k < matrix[0].length; k++) {
                            max = Math.max(max, matrix[0][k]);
                        }
                        for (int k = 0; k < matrix[0].length; k++) {
                            if (matrix[0][k] == max) {
                                matrix[0][k] /= 2;
                                break;
                            }
                        }

                        for (int o = 0; o < matrix.length; o++) {
                            for (int k = 0; k < matrix[o].length; k++) {
                                if (matrix[o][k] == 1) {
                                    matrix[o][k] = 0;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            // Displays the error in the console, but not showing the message. TO FIX LATER!
            displayErrorWindow("The matrix can't contain letters. Please check the matrix file!");
        } catch (Exception e) {
            displayErrorWindow("Error occurred while processing matrix: " + e.getMessage());
        }
    }


    private void displayErrorWindow(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }


    private void writeMatrixToFile(int[][] matrix, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.write(String.valueOf(element));
                    writer.write(" ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
