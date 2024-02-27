import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class TestCheckBox extends JFrame
{
    public TestCheckBox ()
    {
        setTitle( "BoxLayout Application" );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        getContentPane().add( topPanel );
        JButton button1 = new JButton( "Button 1" );
        button1.setMaximumSize( new Dimension( 100, 25 ) );
        topPanel.add( button1 );
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel,BoxLayout.Y_AXIS));
        innerPanel.setPreferredSize( new Dimension( 150, 120 ) );
        innerPanel.setBorder(new TitledBorder(new EtchedBorder(),
                "Checkboxes"));
        topPanel.add( innerPanel );
        JCheckBox check1 = new JCheckBox( "Checkbox 1" );
        check1.setSelected(true);
        innerPanel.add( check1 );
        JCheckBox check2 = new JCheckBox( "Checkbox 2" );
        innerPanel.add( check2 );
        JCheckBox check3 = new JCheckBox( "Checkbox 3" );
        innerPanel.add( check3 );
        JCheckBox check4 = new JCheckBox( "Checkbox 4" );
        innerPanel.add( check4 );
        JPanel textPanel = new JPanel( new BorderLayout() );
        textPanel.setBorder(new TitledBorder(new EtchedBorder(),"TextArea"));
        JTextArea area = new JTextArea( "", 10, 30 );
        area.setPreferredSize( new Dimension( 170, 130 ) );
        textPanel.add( area );
        topPanel.add( textPanel );
    }
    public static void main( String args[] )
    {
        TestCheckBox mainFrame = new TestCheckBox ();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}
