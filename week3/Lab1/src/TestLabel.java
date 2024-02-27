import java.awt.*;
import javax.swing.*;
class TestLabel extends JFrame
{
    public TestLabel()
    {
        setTitle( "JLabel Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new GridLayout( 2, 2 ) );
        getContentPane().add( topPanel );
        JLabel label1 = new JLabel();
        label1.setText( "Label1" );
        label1.setForeground( Color.yellow );
        topPanel.add( label1 );
        JLabel label2 = new JLabel( "Label2" );
        label2.setFont( new Font( "Helvetica", Font.BOLD, 18 ) );
        topPanel.add( label2 );
        Icon image = new ImageIcon( "src/images/myimage.gif" );
        JLabel label3 = new JLabel( "Enabled", image,SwingConstants.CENTER );
        label3.setVerticalTextPosition( SwingConstants.TOP );
        topPanel.add( label3 );
        JLabel label4 = new JLabel( "Label4",SwingConstants.RIGHT );
        topPanel.add( label4 );
    }
    public static void main( String args[] )
    {
        TestLabel mainFrame = new TestLabel();
        mainFrame.setVisible( true );
    }
} 