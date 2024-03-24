package md.ceiti.mj.exemplu.StudiulIndividual3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Sarcina1 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sarcina1.fxml"));
        Scene scene = new Scene(root, 374, 245);

        ImageView equation = (ImageView) root.lookup("#imgEquation");
        equation.setImage(new Image("image.png"));

        TextField textFieldX = (TextField) root.lookup("#txtXfield");
        TextField textFieldA = (TextField) root.lookup("#txtAfield");
        TextField textFieldB = (TextField) root.lookup("#txtBfield");

        TextField resultTXT = (TextField) root.lookup("#txtResult");

        Button solveButton = (Button) root.lookup("#btnSolve");
        solveButton.setOnAction(e -> {
            double x = Double.parseDouble(textFieldX.getText());
            double a = Double.parseDouble(textFieldA.getText());
            double b = Double.parseDouble(textFieldB.getText());
            double result;

            if (x <= 7) {
                if (a == 0 && b == 0) {
                    showErrorDialog("A si B nu pot fi ambele egale cu 0!");
                } else {
                    result = (x + 4) / (Math.pow(a, 2) + Math.pow(b, 2));
                    resultTXT.setText(String.valueOf(result));
                }
            } else {
                result = x * Math.pow((a + b), 2);
                resultTXT.setText(String.valueOf(result));
            }
        });

        Button clearButton = (Button) root.lookup("#btnClear");
        clearButton.setOnAction(e -> {
            textFieldX.setText("");
            textFieldA.setText("");
            textFieldB.setText("");
            resultTXT.setText("");
        });

        Button quitButton = (Button) root.lookup("#btnQuit");
        quitButton.setOnAction(e -> {
            System.exit(0);
        });

        stage.setTitle("Sarcina 1!");
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}