import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.function.DoubleToLongFunction;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import static java.lang.Math.pow;

class ButtonExample{
    ButtonExample(){
        JFrame f=new JFrame("Button Example");
        f.setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JLabel label = new JLabel("Introduceti un numar"); panel1.add(label);
        JTextField input = new JTextField(12); panel1.add(input);

        JPanel panel2 = new JPanel();
        ImageIcon icon = new ImageIcon("src\\image\\calculeaza.png" );
        JButton b=new JButton(icon);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(f,"Patratul este " + pow(Double.parseDouble(input.getText()), 2));
                } catch (NumberFormatException er){
                    JOptionPane.showMessageDialog(f, "Introduceti un numar!");
                }
            }
        });
        panel2.add(b);

        f.add(panel1); f.add(panel2);
        f.setSize(300,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private MaskFormatter getMaskFormatter(String format) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(format);
            mask.setPlaceholderCharacter('0');
        }catch (ParseException ex) {
            ex.printStackTrace();
        }
        return mask;
    }
    public static void main(String[] args) { new ButtonExample(); }
} 