import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Meniu1 extends JFrame
{
    private JPanel topPanel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuProperty;
    public Meniu1()
    {
        setTitle( "Menu Application" );
        setSize( 310, 130 );
        topPanel = new JPanel();topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza bara de meniu
        menuBar = new JMenuBar();
// Seteaza aceasta instanta ca fiind bara de meniu a aplicatiei
        setJMenuBar( menuBar );
// creeaza un submeniu "Properties"
        menuProperty = new JMenu( "Properties" );
// Creeaza un meniu "File"
        menuFile = new JMenu( "File" );
        menuBar.add( menuFile );
// Adauga submeniul "Properties" la meniul "File"
        menuFile.addSeparator();
        menuFile.add( menuProperty );
        menuFile.addSeparator();
// Creeaza meniul "Edit"
        menuEdit = new JMenu( "Edit" );
        menuBar.add( menuEdit );
    }
    public static void main( String args[] )
    {
        Meniu1 mainFrame = new Meniu1();
        mainFrame.setVisible( true );
    }
} 