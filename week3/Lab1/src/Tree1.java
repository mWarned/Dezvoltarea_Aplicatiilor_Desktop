import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
class Tree1 extends JFrame
{
    private JPanel topPanel;
    private JTree tree;
    private JScrollPane scrollPane;
    public Tree1()
    {
        setTitle( "Custom Rendered Tree Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
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
        DefaultTreeModel treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );
// informeaza arborele ca este desenat utilizand o clasa definita de
// programator
        tree.setCellRenderer( new CustomCellRender() );
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( tree );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
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
        Tree1 mainFrame = new Tree1();
        mainFrame.setVisible( true );
    }
}
class CustomCellRender extends JLabel implements TreeCellRenderer
{
    private ImageIcon deckImage;
    private ImageIcon[] suitImages;
    private ImageIcon[] cardImages;
    private boolean bSelected;
    public CustomCellRender()
    {
// Incarca imaginile
        deckImage = new ImageIcon( "deck.gif" );
        suitImages = new ImageIcon[4];
        suitImages[0] = new ImageIcon( "clubs.gif" );
        suitImages[1] = new ImageIcon( "diamonds.gif" );
        suitImages[2] = new ImageIcon( "spades.gif" );
        suitImages[3] = new ImageIcon( "hearts.gif" );
        cardImages = new ImageIcon[13];
        cardImages[0] = new ImageIcon( "ace.gif" );
        cardImages[1] = new ImageIcon( "two.gif" );
        cardImages[2] = new ImageIcon( "three.gif" );
        cardImages[3] = new ImageIcon( "four.gif" );
        cardImages[4] = new ImageIcon( "five.gif" );
        cardImages[5] = new ImageIcon( "six.gif" );
        cardImages[6] = new ImageIcon( "seven.gif" );
        cardImages[7] = new ImageIcon( "eight.gif" );
        cardImages[8] = new ImageIcon( "nine.gif" );
        cardImages[9] = new ImageIcon( "ten.gif" );
        cardImages[10] = new ImageIcon( "jack.gif" );
        cardImages[11] = new ImageIcon( "queen.gif" );
        cardImages[12] = new ImageIcon( "king.gif" );
    }
    public Component getTreeCellRendererComponent( JTree tree,
                                                   Object value, boolean bSelected, boolean bExpanded,
                                                   boolean bLeaf, int iRow, boolean bHasFocus )
    {
// Afla care nod este curent desenat si se obtine textul atasat nodului
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        String labelText = (String)node.getUserObject();
        this.bSelected = bSelected;
// Seteaza culoarea textului
        if( !bSelected )
            setForeground( Color.black );
        else
            setForeground( Color.white );
// Determina imaginea corecta
        if( labelText.equals( "Deck" ) )
            setIcon( deckImage );
        else if( labelText.equals( "Clubs" ) )
            setIcon( suitImages[0] );
        else if( labelText.equals( "Diamonds" ) )
            setIcon( suitImages[1] );
        else if( labelText.equals( "Spades" ) )
            setIcon( suitImages[2] );
        else if( labelText.equals( "Hearts" ) )
            setIcon( suitImages[3] );
        else if( labelText.equals( "Ace" ) )
            setIcon( cardImages[0] );
        else if( labelText.equals( "Two" ) )
            setIcon( cardImages[1] );
        else if( labelText.equals( "Three" ) )
            setIcon( cardImages[2] );
        else if( labelText.equals( "Four" ) )
            setIcon( cardImages[3] );
        else if( labelText.equals( "Five" ) )
            setIcon( cardImages[4] );
        else if( labelText.equals( "Six" ) )
            setIcon( cardImages[5] );
        else if( labelText.equals( "Seven" ) )
            setIcon( cardImages[6] );
        else if( labelText.equals( "Eight" ) )
            setIcon( cardImages[7] );
        else if( labelText.equals( "Nine" ) )
            setIcon( cardImages[8] );
        else if( labelText.equals( "Ten" ) )
            setIcon( cardImages[9] );
        else if( labelText.equals( "Jack" ) )
            setIcon( cardImages[10] );
        else if( labelText.equals( "Queen" ) )
            setIcon( cardImages[11] );
        else if( labelText.equals( "King" ) )
            setIcon( cardImages[12] );
// Add the text to the cell
        setText( labelText );
        return this;
    }
    public void paint( Graphics g )
    {
        Color bColor;
        Icon currentI = getIcon();
// Seteaza culoarea de fond corecta
        bColor = bSelected ? SystemColor.textHighlight : Color.white;
        g.setColor( bColor );
// Deseneaza un dreptunghi pe fundalul celulei (nodului)
        g.fillRect( 0, 0, getWidth() - 1, getHeight() - 1 );
        super.paint( g );
    }
}