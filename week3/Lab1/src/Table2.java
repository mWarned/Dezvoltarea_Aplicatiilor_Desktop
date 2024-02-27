import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
class Table2 extends JFrame
{
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String columnNames[];
    private String dataValues[][];
    public Table2()
    {
        setTitle( "Custom Header Rendering Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza un model de date
        CustomDataModel customDataModel = new CustomDataModel();
        table = new JTable( customDataModel );
        CreateColumns();
        table.setShowHorizontalLines( false );
        table.setRowSelectionAllowed( true );
        table.setColumnSelectionAllowed( true );
        table.setSelectionForeground( Color.white );
        table.setSelectionBackground( Color.red );
        scrollPane = table.createScrollPaneForTable( table );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    public void CreateColumns()
    {
// Spunem ca vom crea manual coloanele
        table.setAutoCreateColumnsFromModel( false );
        for( int iCtr = 0; iCtr < 4; iCtr++ )
        {
// Manual cream o noua coloana
            TableColumn column = new TableColumn( iCtr );
            column.setHeaderValue( (Object)("Col:" + iCtr) );
// Adaugam un obiect care se va ocupa de desenarea unei celule header
            column.setHeaderRenderer( new CustomHeaderRenderer() );
// Adaugam coloana la tabel
            table.addColumn( column );
        }
    }
    public static void main( String args[] )
    {
        Table2 mainFrame = new Table2();
        mainFrame.setVisible( true );
    }
}
class CustomDataModel extends AbstractTableModel
{
    public Object getValueAt( int iRowIndex, int iColumnIndex )
    {
        return "" + iColumnIndex + "," + iRowIndex;
    }
    public void setValueAt( Object aValue, int iRowIndex,int iColumnIndex )
    {
    }
    public int getColumnCount()
    {
        return 0;
    }
    public int getRowCount()
    {
        return 500;
    }
}
class CustomHeaderRenderer extends JLabel implements TableCellRenderer
{
    private boolean isSelected;
    private boolean hasFocus;
    private ImageIcon[] suitImages;
    public CustomHeaderRenderer()
    {
        suitImages = new ImageIcon[4];
        suitImages[0] = new ImageIcon( "clubs.gif" );
        suitImages[1] = new ImageIcon( "diamonds.gif" );
        suitImages[2] = new ImageIcon( "spades.gif" );
        suitImages[3] = new ImageIcon( "hearts.gif" );
    }
    public Component getTableCellRendererComponent( JTable table,
                                                    Object value, boolean isSelected, boolean hasFocus,int row, int column
    )
    {
// Obtine textul care se va afisa
        String sText = (String)value;
// Seteaza optiuni de aliniament
        setVerticalAlignment( SwingConstants.CENTER );
        setHorizontalAlignment( SwingConstants.CENTER );
        setHorizontalTextPosition( SwingConstants.CENTER );
        setVerticalTextPosition( SwingConstants.BOTTOM );
// Asigneaza o margine
        setBorder( new TitledBorder( new EtchedBorder(), sText ) );
// Populeaza cu imagine si text
        setIcon( suitImages[column] );
// Set the text to the correct suit
        switch( column )
        {
            case 0:
                setText( "Clubs" );
                break;
            case 1:
                setText( "Diamonds" );
                break;
            case 2:
                setText( "Hearts" );
                break;
            case 3:
                setText( "Spades" );
                break;
        }
        return this;
    }
} 