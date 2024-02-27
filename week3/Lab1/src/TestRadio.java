import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class TestRadio extends JFrame implements ActionListener
{
    JButton button1=null;
    String string1=" 1 ";
    String string2=" 2 ";
    String string3=" 3 ";
    public TestRadio ()
    {
        setTitle( "Radio Buttons Application" );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        getContentPane().add( topPanel );
        button1 = new JButton( "Button 1" );
        button1.setMaximumSize( new Dimension( 100, 25 ) );
        topPanel.add( button1 );
//creeaza un grup pentru butoanele radio
        ButtonGroup rgroup=new ButtonGroup();
        JRadioButton radio1 = new JRadioButton ( string1);
        radio1.setActionCommand(string1);
        rgroup.add( radio1 );
        JRadioButton radio2 = new JRadioButton (string2 );
        radio2.setActionCommand(string2);
        rgroup.add( radio2 );
        JRadioButton radio3 = new JRadioButton ( string3);
        radio3.setActionCommand(string3);
        rgroup.add( radio3 );
//inregistreaza un listener pentru butoanele radio
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);
//plaseaza butoanele radio orizontal pe un JPanel
        JPanel radioPanel = new JPanel( );
        radioPanel.setLayout(new BoxLayout(radioPanel,BoxLayout.X_AXIS));
        radioPanel.setPreferredSize( new Dimension( 300, 50 ) );
        radioPanel.setBorder(new TitledBorder(new EtchedBorder(),
                "Radio buttons"));
        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);
        topPanel.add(radioPanel);
    }
    public void actionPerformed(ActionEvent e)
    {
        button1.setText(e.getActionCommand());
        pack();
    }
    public static void main( String args[] )
    {
        TestRadio mainFrame = new TestRadio ();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
} 