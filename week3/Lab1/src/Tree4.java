import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
class Tree4 extends JFrame implements TreeExpansionListener
{
    private JPanel topPanel;
    private JTree tree;
    private JScrollPane scrollPane;
    public Tree4()
    {
        setTitle( "TreeExpansionListener Application" );
        setSize( 300, 300 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        tree = new JTree();
// Adauga un obiect ascultator
        tree.addTreeExpansionListener( this );
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( tree );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    // Manipuleaza expansiunea nodurilor arborelui
    public void treeExpanded( TreeExpansionEvent event)
    {
        if( event.getSource() == tree )
        {
// Afiseaza calea completa catre nodul expandat
            TreePath path = event.getPath();
            System.out.println( "Node Expanded=" + path.toString() );
        }
    }
    // Manipuleaza comprimarea nodurilor arborelui
    public void treeCollapsed( TreeExpansionEvent event )
    {
        if( event.getSource() == tree )
        {
            TreePath path = event.getPath();
            System.out.println( "Node Collapsed=" + path.toString() );
        }
    }
    public static void main( String args[] )
    {
        Tree4 mainFrame = new Tree4();
        mainFrame.setVisible( true );
    }
} 