import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class fereastra6 extends JFrame {
    public fereastra6(){
        setTitle("Buton cu iconite");
        setSize(500, 100);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component f = getContentPane();

        ImageIcon usIcon = new ImageIcon("src\\image\\1.png"); //incarca imaginea
        ImageIcon caIcon = new ImageIcon("src\\image\\2.png");
        ImageIcon ukIcon = new ImageIcon("src\\image\\3.png");

        JPanel nrInput = new JPanel(new GridLayout(1,2));
        JTextField nr1 = new JTextField(); nrInput.add(nr1);
        JTextField nr2 = new JTextField(); nrInput.add(nr2);
        add(nrInput);

        JButton jbt = new JButton("Click it!", usIcon);
        jbt.setPressedIcon(caIcon); //cind se executa butonul
        jbt.setRolloverIcon(ukIcon); //cursorul se misca pe buton
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Double max;
                    if (Double.parseDouble(nr1.getText()) > Double.parseDouble(nr2.getText())){
                        max = Double.parseDouble(nr1.getText());
                    }
                    else {
                        max = Double.parseDouble(nr2.getText());
                    }
                    JOptionPane.showMessageDialog(f, "Numarul mai mare este " + max);
                } catch (NumberFormatException er){
                    JOptionPane.showMessageDialog(f, "Introduceti numere");
                }
            }
        });
        add(jbt,BorderLayout.NORTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new fereastra6(); } }
