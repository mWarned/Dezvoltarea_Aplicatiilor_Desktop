import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Exemplul_6 extends JFrame{
    Exemplul_6(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Sunteti siguri?","Selectati o optiune",JOptionPane.YES_NO_OPTION);
                if(a==JOptionPane.YES_OPTION){
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }}});
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        Component x = getContentPane();

        JButton galben = new JButton("Galben"); add(galben, BorderLayout.WEST);
        galben.setBackground(Color.yellow);
        galben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setBackground(Color.yellow);
            }
        });
        JButton verde = new JButton("Verde"); add(verde, BorderLayout.NORTH);
        verde.setBackground(Color.green);
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setBackground(Color.green);
            }
        });
        JButton albastru = new JButton("Albastru"); add(albastru, BorderLayout.EAST);
        albastru.setBackground(Color.blue);
        albastru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.setBackground(Color.blue);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Exemplul_6();
    } }