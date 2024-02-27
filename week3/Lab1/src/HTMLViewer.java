import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class HTMLViewer extends JFrame implements HyperlinkListener
        {
private JEditorPane html;
private String sPath = System.getProperty( "user.dir" ) + "/";
public HTMLViewer ()
        {
        setTitle( "HTML Application" );
        setSize( 400, 300 );
        setBackground( Color.gray );
        getContentPane().setLayout( new BorderLayout() );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel, BorderLayout.CENTER );
        try {
// incarca URL pe care vrem sa-l afisam
        URL url = new URL( "file:///" + sPath + "Main.htm" );
// Creeaza un HTML viewer pentru a afisa URL-ul
        html = new JEditorPane( url );
        html.setEditable( false );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add( html, BorderLayout.CENTER );
        topPanel.add( scrollPane, BorderLayout.CENTER );
        html.addHyperlinkListener( this );
        }
        catch( MalformedURLException e )
        {
        System.out.println( "Malformed URL: " + e );
        }
        catch( IOException e )
        {
        System.out.println( "IOException: " + e );
        }
        }
public void hyperlinkUpdate( HyperlinkEvent event )
        {
        if( event.getEventType() == HyperlinkEvent.EventType.ACTIVATED )
        {
// incarca niste cursoare
        Cursor cursor = html.getCursor();
        Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR );
        html.setCursor( waitCursor );
// manipuleaza modificarile hyperlink
// ...
        }
        }
public static void main( String args[] )
        {
        HTMLViewer mainFrame = new HTMLViewer ();
        mainFrame.setVisible( true );
        }
        }
