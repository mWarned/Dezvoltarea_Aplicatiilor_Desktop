import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
class Tree3 extends JFrame implements TreeSelectionListener
{
    private JPanel topPanel;
    private JTree tree;
    private JScrollPane scrollPane;
    public Tree3()
    {
        setTitle( "TreeSelectionListener Application" );
        setSize( 300, 100 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        tree = new JTree();
// Adauga un obiect ascultator pentru selectiile nodurilor arborelui
        tree.addTreeSelectionListener( this );
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( tree );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    // Manipuleaza selectiile nodurilor
    public void valueChanged( TreeSelectionEvent event )
    {
        if( event.getSource() == tree )
        {
// Afiseaza calea completa catre nodul curent selectat
            TreePath path = tree.getSelectionPath();
            System.out.println( "Selection path="+ path.toString() );
// Obtine textul atasat ultimului nod selectat
            System.out.println( "Selection="+ path.getLastPathComponent() );
        }
    }
    public static void main( String args[] )
    {
        Tree3 mainFrame = new Tree3();
        mainFrame.setVisible( true );
    }
}
