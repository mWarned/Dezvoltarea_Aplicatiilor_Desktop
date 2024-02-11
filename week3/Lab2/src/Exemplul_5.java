import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Exemplul_5 extends JFrame{
    Exemplul_5 (){
        JFrame f = new JFrame();
        f.setSize(300,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        JButton button = new JButton("Click"); f.add(button, BorderLayout.NORTH);
        JLabel label = new JLabel(); f.add(label, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(JOptionPane.showInputDialog("Introduceti un cuvant").toUpperCase());
            }
        });

        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Exemplul_5 ();
    }}
