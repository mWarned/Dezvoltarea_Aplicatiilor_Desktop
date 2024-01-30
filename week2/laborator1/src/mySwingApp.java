import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class mySwingApp {

    public static void center(Window w){
        Dimension ws = w.getSize();
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (ss.width - ws.height) / 2;
        int newY = (ss.height - ws.width) / 2;
        w.setLocation(newX, newY);
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
        String[] pos = { "East", "West", "North", "South", "Center" };

        JFrame jf = new JFrame();
        jf.setSize(400, 160); // Problema 5 - 240/200   Problema 6 - 200/200
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        center(jf);

        // Problema 3
        /*
        jf.setLayout(new FlowLayout());

        JLabel label = new JLabel("Color");
        JTextField field1 = new JTextField("White");
        field1.setEditable(false);
        field1.setBorder(new EtchedBorder());
        field1.setBackground(Color.white);
        field1.setPreferredSize(new Dimension(180, 20));

        jf.add(label);
        jf.add(field1);
        */

        // Problema 5
        /*
        jf.setLayout(new BorderLayout());
//        jf.setLayout(new FlowLayout());
        for(String position: pos){
            JButton button = new JButton(position);
            jf.add(button, BorderLayout.WEST);
//            jf.add(button, BorderLayout.EAST);
//            jf.add(button, BorderLayout.NORTH);
//            jf.add(button, BorderLayout.SOUTH);
//            jf.add(button, BorderLayout.CENTER);
        }
        */

        // Problema 6
        /*
        Vector<JButton> buttons = new Vector<>();
        Vector<JPanel> panels = new Vector<>();

        for (int i = 0; i < 8; i++){
            JButton button = new JButton("Buton");
            JPanel panel = new JPanel();
            panel.add(button);
            buttons.add(button);
            panels.add(panel);
        }

        jf.setLayout(new GridLayout(4, 2));

//        buttons.forEach(jf::add);
//        panels.forEach(jf::add);
        panels.forEach(x -> {
            x.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
            jf.add(x);
        });
        */
        jf.setLayout(new GridLayout(3, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        ImageIcon run = new ImageIcon("src/images/run.png");
        ImageIcon resized= new ImageIcon(run.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JLabel iconLabel = new JLabel(resized);
        JLabel explainLabel = new JLabel("<html>Type the name of a program, folder, document, or Internet<br>resource, and Windows will open it for you.</html>");
        panel1.add(iconLabel);
        panel1.add(explainLabel);

        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("Open: ");
        JTextField field = new JTextField("", 30);
        panel2.add(label); panel2.add(field);

        JPanel panel3 = new JPanel(new BorderLayout());
        JPanel container = new JPanel(new FlowLayout());
        JButton button1 = new JButton("OK"); button1.setFocusPainted(false);
        JButton button2 = new JButton("Cancel"); button2.setFocusPainted(false);
        JButton button3 = new JButton("Browse"); button3.setFocusPainted(false);
        container.add(button1); container.add(button2); container.add(button3);
        panel3.add(container, BorderLayout.EAST);

        try { UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName() );
        } catch( Exception ignored) { }

        jf.setIconImage(new ImageIcon("src/images/run.png").getImage());
        jf.add(panel1); jf.add(panel2); jf.add(panel3);
        jf.setTitle("Run");
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
