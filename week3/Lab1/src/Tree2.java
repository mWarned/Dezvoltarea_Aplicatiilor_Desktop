import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Tree2 extends JFrame
{
    private JPanel topPanel;
    private JTree tree;
    private JScrollPane scrollPane;
    public Tree2()
    {
        setTitle( "Editable Tree Application" );
        setSize( 300, 100 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        tree = new JTree();
        tree.setEditable( true );
// Creeaza un ComboBox pentru editarea optiunilor
        JComboBox box = new JComboBox();
        box.addItem( "Swing" );
        box.addItem( "Java" );
        box.addItem( "neat" );
        box.addItem( "funky" );
        box.addItem( "life" );
        box.addItem( "awesome" );
        box.addItem( "cool!" );
// Adauga arborelui un „cell editor”
        tree.setCellEditor( new DefaultCellEditor( box ) );
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( tree );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    public static void main( String args[] )
    {
        Tree2 mainFrame = new Tree2();
        mainFrame.setVisible( true );
    }
}