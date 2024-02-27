import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
class Table3 extends JFrame
{
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String columnNames[];
    private String dataValues[][];
    public Table3()
    {
        setTitle( "Custom Table Data Model Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza modelul de date
        CustomDataModel1 customDataModel = new CustomDataModel1();
        table = new MyTable( customDataModel );
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
// Spunem ca vom crea coloanele manual
        table.setAutoCreateColumnsFromModel( false );
        for( int iCtr = 0; iCtr < 8; iCtr++ )
        {
// Manual cream a noua coloana
            TableColumn column = new TableColumn( iCtr );
            column.setHeaderValue( (Object)("Col:" + iCtr) );
// Adaugam coloana la tabel
            table.addColumn( column );
        }
    }
    public static void main( String args[] )
    {
        Table3 mainFrame = new Table3();
        mainFrame.setVisible( true );
    }
}
class CustomDataModel1 extends AbstractTableModel
{
    public Object getValueAt( int iRowIndex, int iColumnIndex )
    {
        return "" + iColumnIndex + "," + iRowIndex;
    }
    public void setValueAt( Object aValue, int iRowIndex,int iColumnIndex )
    { }
    public int getColumnCount()
    {
        return 0;
    }
    public int getRowCount()
    {
        return 500;
    }
}
class MyTable extends JTable implements MouseListener
{
    public MyTable( CustomDataModel1 model )
    {
        super( model );
// Configure the table
        setFont( new Font( "Helvetica", Font.PLAIN, 12 ) );
        setColumnSelectionAllowed( false );
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        setShowGrid( false );
        setIntercellSpacing( new Dimension( 0, 1 ) );
        setAutoCreateColumnsFromModel( false );
        sizeColumnsToFit( true );
// Prevent table column reordering
        JTableHeader header = getTableHeader();
        header.setUpdateTableInRealTime( false );
        header.setReorderingAllowed( false );
// Attach a mouse listener
        addMouseListener( this );
    }
    public void mouseClicked( MouseEvent e )
    {
        int iMouseX = e.getX();
        int iMouseY = e.getY();
        int iSelectedColumn = columnAtPoint(new Point( iMouseX, iMouseY ) );
        int iSelectedRow = rowAtPoint( new Point( iMouseX, iMouseY ) );
        System.out.println("S-a selectat celula de la pozitia" + iSelectedRow + ", " + iSelectedColumn);
    }
    public void mouseEntered( MouseEvent e )
    {}
    public void mouseExited( MouseEvent e )
    {}
    public void mousePressed( MouseEvent e )
    {}
    public void mouseReleased( MouseEvent e )
    {}
} 