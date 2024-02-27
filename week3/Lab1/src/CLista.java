import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class CLista extends JFrame
{
    private JPanel topPanel;
    private JList listbox;
    private CustomListModel listData;
    private JScrollPane scrollPane;
    public CLista()
    {
        setTitle( "Custom Data Model List Application" );
        setSize( 300, 100 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        listData = new CustomListModel();// creeaza modelul de date
        listbox = new JList( listData );
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( listbox );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    public static void main( String args[] )
    {
        CLista mainFrame = new CLista();
        mainFrame.setVisible( true );
    }
}
class CustomListModel extends AbstractListModel
{
    public int getSize()
    {
        return 300;
    }
    public Object getElementAt( int index )
    {
        return "Item " + index;
    }
} 