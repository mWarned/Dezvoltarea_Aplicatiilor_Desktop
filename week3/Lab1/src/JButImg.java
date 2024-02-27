import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class JButImg extends JFrame implements ActionListener
{
    private int iCounter = 0;
    private JButton button = null;
    public JButImg()
    {
        setTitle( "Animated Button Application" );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        getContentPane().add( topPanel );
        ImageIcon image = new ImageIcon("src/images/computers.gif");
        button = new JButton( "Press Me", image );
        button.setPreferredSize( new Dimension( 250, 90 ) );
        ImageIcon image1 = new ImageIcon("src/images/appleguy.gif");
        button.setPressedIcon(image1);
        button.setMnemonic( 'P' );
        topPanel.add( button );
        button.addActionListener( this );
        JButton but1=new JButton(" OK ");
        but1.setEnabled( false );
        topPanel.add(but1);
        JButton but2=new JButton(" OK ");
        but2.setEnabled( true );
        topPanel.add(but2);
    }
    public void actionPerformed( ActionEvent event )
    {
        if( event.getSource() == button )
        {
            iCounter++;
            button.setText( "Pressed " + iCounter + " times" );
            pack();
        }
    }
    public static void main( String args[] )
    {
        JButImg mainFrame = new JButImg ();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}