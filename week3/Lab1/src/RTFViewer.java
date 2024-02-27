import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.*;
class RTFViewer extends JFrame
{
    public RTFViewer ()
    {
        setTitle( "RTF Text Application" );
        setSize( 400, 240 );
        setBackground( Color.gray );
        getContentPane().setLayout( new BorderLayout() );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel, BorderLayout.CENTER );
// Creeaza o fereastra editor RTF
        RTFEditorKit rtf = new RTFEditorKit();
        JEditorPane editor = new JEditorPane();
        editor.setEditorKit( rtf );
        editor.setBackground( Color.white );
// textul poate fi mare, deci adaugam un “scroll pane”
        JScrollPane scroller = new JScrollPane();
        scroller.getViewport().add( editor );
        topPanel.add( scroller, BorderLayout.CENTER );
// incarca un fisier RTF in editor
        try {
            FileInputStream fi = new FileInputStream( "test.rtf" );
            rtf.read( fi, editor.getDocument(), 0 );
        }
        catch( FileNotFoundException e )
        {
            System.out.println( "File not found" );
        }
        catch( IOException e )
        {
            System.out.println( "I/O error" );
        }
        catch( BadLocationException e )
        {}
    }
    public static void main( String args[] )
    {
        RTFViewer mainFrame = new RTFViewer ();
        mainFrame.setVisible( true );
    }
} 