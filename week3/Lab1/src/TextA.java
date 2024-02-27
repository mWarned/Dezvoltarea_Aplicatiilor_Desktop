import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TextA extends JFrame
{
    public TextA()
    {
        setTitle( "Text Area Application" );
        setSize( 310, 230 );
        setBackground( Color.gray );
        getContentPane().setLayout( new BorderLayout() );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel, BorderLayout.CENTER );
        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add( area );
        topPanel.add( scrollPane, BorderLayout.CENTER );
// Incarca un fisier in TextArea, trateaza eventualele exceptii
        try {
            FileReader fileStream = new FileReader("TextA.java" );
            area.read( fileStream, "TextA.java" );
        }
        catch( FileNotFoundException e )
        {
            System.out.println( "File not found" );
        }
        catch( IOException e )
        {
            System.out.println( "IOException occurred" );
        }
    }
    public static void main( String args[] )
    {
        TextA mainFrame = new TextA();
        mainFrame.setVisible( true );
    }
} 