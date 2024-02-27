import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MySpinner extends JFrame
{
    public MySpinner()
    {
        setSize(400,400);
        JPanel content=(JPanel)getContentPane();
        content.setLayout(new BorderLayout());
        ImageIcon image=new ImageIcon("Bart.gif");
        final JLabel label=new JLabel("This man is poor", image,
                SwingConstants.CENTER);
        content.add(label,BorderLayout.CENTER);
        JPanel panel=new JPanel();
        final JSpinner spin=new JSpinner();
        panel.add(spin);
        JButton but=new JButton("Ok");
        panel.add(but);
        but.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                label.setText("This man has "+spin.getValue()+"$!");
            }
        });
        content.add(panel,BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new MySpinner();
    }
} 