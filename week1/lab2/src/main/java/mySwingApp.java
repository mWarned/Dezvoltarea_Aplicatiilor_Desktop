import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class mySwingApp extends JFrame {
    private JLabel selectLabel;
    private JComboBox comboBox1;
    private JLabel flagLable;

    public mySwingApp(){
        setTitle("My Swing App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static void createWindow(){
        String[] countries = {"Brazilia", "Anglia", "Japonia", "Egypt", "Mexica", "Noua Zeelanda"};

        JFrame frame = new JFrame("My Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel selectLabel = new JLabel("Select World Cup 2023 Country");
        JComboBox<String> selectBox = new JComboBox<>(countries);
        JLabel flagLabel = new JLabel("Select World Cup 2023 Country");
        ImageIcon icon = createResizedImageIcon("src/main/images/brazilia.png", 400, 200);
        JLabel label = new JLabel(icon);
        panel.add(selectLabel);
        panel.add(selectBox);
        panel.add(flagLabel);
        panel.add(label);
        frame.getContentPane().add(panel);

        Map<String, String> imageMap = new HashMap<>();
        imageMap.put("Brazilia", "src/main/images/brazilia.png");
        imageMap.put("Anglia", "src/main/images/anglia.png");
        imageMap.put("Japonia", "src/main/images/japonia.png");
        imageMap.put("Egypt", "src/main/images/egypt.png");
        imageMap.put("Mexica", "src/main/images/mexica.png");
        imageMap.put("Noua Zeelanda", "src/main/images/nouaZeelanda.png");

        selectBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change the image based on the selected item in the JComboBox
                String selectedValue = (String) selectBox.getSelectedItem();
                String imagePath = imageMap.get(selectedValue);
                if (imagePath != null) {
                    ImageIcon selectedIcon = createResizedImageIcon(imagePath, 400, 200);
                    label.setIcon(selectedIcon);
                    frame.pack();
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private static ImageIcon createResizedImageIcon(String imagePath, int width, int height) {
        ImageIcon resized;
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            resized = new ImageIcon(img.getScaledInstance(400, 200, Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return resized;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createWindow();
            }
        });
    }
}
