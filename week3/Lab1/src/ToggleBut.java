import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ToggleBut extends JFrame
{
    public ToggleBut ()
    {
        setTitle( "ToggleButton Application" );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        getContentPane().add( topPanel );
        JToggleButton button1 = new JToggleButton( "Button 1", true );
        topPanel.add( button1 );
        JToggleButton button2 = new JToggleButton( "Button 2", false );
        topPanel.add( button2 );
        JToggleButton button3 = new JToggleButton( "Button 3", false );
        topPanel.add( button3 );
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add( button1 );
        buttonGroup.add( button2 );
        buttonGroup.add( button3 );
    }
    public static void main( String args[] )
    {
        ToggleBut mainFrame = new ToggleBut ();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}