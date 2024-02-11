import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
class Fereastra2 extends JFrame implements ActionListener{

    JLabel output = new JLabel();
    public Fereastra2(String titlu){
        super(titlu);
        setSize(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //închiderea ferestrei
        Container x = getContentPane();
        x.setLayout(new BoxLayout(x, BoxLayout.Y_AXIS));
        x.setBackground(Color.black);
        x.setFont(x.getFont().deriveFont(Font.BOLD));

        JPanel panel1 = new JPanel();
        panel1.setBackground(null);
        JButton A = new JButton("Buton 1"); panel1.add(A);
        JButton B = new JButton("Buton 2"); panel1.add(B);
        JButton C = new JButton("Buton 3"); panel1.add(C);
        //text afișat la trecerea cursorului pe butonul B
        A.setToolTipText("Acesta este butonul 1");
        B.setToolTipText("Acesta este butonul 2");
        C.setToolTipText("Acesta este butonul 3");
        A.addActionListener(this);
        B.addActionListener(this);
        C.addActionListener(this);

        JPanel panel2 = new JPanel();
        panel2.setBackground(null);
        output.setForeground(Color.white);
        panel2.add(output);

        x.add(panel1); x.add(panel2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("Buton 1"))
            output.setText("Ai apasat Buton 1");
        else if(command.equals("Buton 2"))
            output.setText("Ai apasat Buton 2");
        else output.setText("Ai apasat Buton 3");
    }
}

class TestareFereastra2{
    public static void main(String args[ ]){
        new Fereastra2("Doua butoane");
    }
}