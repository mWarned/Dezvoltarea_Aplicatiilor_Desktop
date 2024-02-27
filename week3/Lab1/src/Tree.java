import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
class Tree extends JFrame
{
    private JPanel topPanel;
    private JTree tree;
    private JScrollPane scrollPane;
    public Tree()
    {
        setTitle( "More Advanced Tree Application" );
        setSize( 300, 100 );
        setBackground( Color.gray );
// Creeaza un panou pentru a stoca toate celelalte componente
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza datele pentru arbore
        DefaultMutableTreeNode root= new DefaultMutableTreeNode( "Deck" );
        DefaultMutableTreeNode itemClubs=new DefaultMutableTreeNode( "Clubs" );
        addAllCard( itemClubs );
        root.add( itemClubs );
        DefaultMutableTreeNode itemDiamonds=
                new DefaultMutableTreeNode("Diamonds");
        addAllCard( itemDiamonds );
        root.add( itemDiamonds );
        DefaultMutableTreeNode itemSpades=new DefaultMutableTreeNode("Spades");
        addAllCard( itemSpades );
        root.add( itemSpades );
        DefaultMutableTreeNode itemHearts=new DefaultMutableTreeNode("Hearts");
        addAllCard( itemHearts );
        root.add( itemHearts );
// Creeaza un model pentru arbore
        DefaultTreeModel treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );
// Add the list box to a scrolling pane
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( tree );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    // metoda care adauga intregul set de carti de joc la nodul curent
// al arborelui
    public void addAllCard( DefaultMutableTreeNode suit )
    {
        suit.add( new DefaultMutableTreeNode( "Ace" ) );
        suit.add( new DefaultMutableTreeNode( "Two" ) );
        suit.add( new DefaultMutableTreeNode( "Three" ) );
        suit.add( new DefaultMutableTreeNode( "Four" ) );
        suit.add( new DefaultMutableTreeNode( "Five" ) );
        suit.add( new DefaultMutableTreeNode( "Six" ) );
        suit.add( new DefaultMutableTreeNode( "Seven" ) );
        suit.add( new DefaultMutableTreeNode( "Eight" ) );
        suit.add( new DefaultMutableTreeNode( "Nine" ) );
        suit.add( new DefaultMutableTreeNode( "Ten" ) );
        suit.add( new DefaultMutableTreeNode( "Jack" ) );
        suit.add( new DefaultMutableTreeNode( "Queen" ) );
        suit.add( new DefaultMutableTreeNode( "King" ) );
    }
    public static void main( String args[] )
    {
        Tree mainFrame = new Tree();
        mainFrame.setVisible( true );
    }
} 