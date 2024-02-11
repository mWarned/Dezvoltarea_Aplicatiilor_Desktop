import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fereastra3 extends JFrame implements ActionListener {

    JTextField nume = new JTextField(8);
    JTextField gen = new JTextField(8);
    JTextField prenume = new JTextField(8);
    JButton show = new JButton("Afiseaza");
    JButton close = new JButton("Inchide");
    public Fereastra3(){
        setTitle("Detalii");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new GridLayout(4, 2));
        add(new JLabel("Nume"));
        add(nume);
        add(new JLabel("Gen"));
        add(gen);
        add(new JLabel("Prenume"));
        add(prenume);

        show.addActionListener(this);
        close.addActionListener(this);

        add(show);
        add(close);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Afiseaza"))
            System.out.printf("Numele: %s, Genul: %s, Prenumele: %s%n", nume.getText(), gen.getText(), prenume.getText());
        else System.exit(0);
    }
    public static void main(String[] args) {
        new Fereastra3 (); }
}
