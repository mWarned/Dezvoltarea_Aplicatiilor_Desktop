import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TestJBut extends JFrame implements ActionListener
{
    private int iCounter = 0; // Keep track of button presses
    private JButton button = null;
    public TestJBut()
    {
        setTitle( "ActionListener Application" );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        topPanel.setPreferredSize( new Dimension( 300, 200 ) );
        getContentPane().add( topPanel );
        button = new JButton( "Press Me" );
        topPanel.add( button );
        button.addActionListener( this );
    }
    public void actionPerformed( ActionEvent event )
    {
        if( event.getSource() == button )
        {
            iCounter++;
            button.setText( "Pressed " + iCounter + " times" );
            System.out.println( "Click" );
            pack();
        }
    }
    public static void main( String args[] )
    {
        TestJBut mainFrame = new TestJBut();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}
