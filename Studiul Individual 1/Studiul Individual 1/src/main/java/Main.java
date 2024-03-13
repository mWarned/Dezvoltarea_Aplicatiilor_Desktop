import controller.mainController;

import javax.swing.*;
import java.awt.*;

import model.mainModel;
import view.mainView;

public class Main extends JFrame {

    public static void main(String[] args) {

        mainModel model = new mainModel();
        mainView view = new mainView(model);
        mainController controller = new mainController(model, view);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
}
