import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
class Table1 extends JFrame
{
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String columnNames[];
    private String dataValues[][];
    public Table1()
    {
        setTitle( "Advanced Table Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza coloane
        CreateColumns();
        CreateData();
// Creeaza o instanta tabel
        table = new JTable( dataValues, columnNames );
// Configureaza cativa din parametrii JTable
        table.setShowHorizontalLines( false );
        table.setRowSelectionAllowed( true );
        table.setColumnSelectionAllowed( true );
// Modifica culoarea de selectie
        table.setSelectionForeground( Color.white );
        table.setSelectionBackground( Color.red );
// Adauga tabelul la un "scrolling pane"
        scrollPane = table.createScrollPaneForTable( table );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }
    public void CreateColumns()
    {
// Creeaza etichetele coloanelor
        columnNames = new String[8];
        for( int iCtr = 0; iCtr < 8; iCtr++ )
            columnNames[iCtr] = "Col:" + iCtr;
    }
    public void CreateData()
    {
// Creeaza fiecare element
        dataValues = new String[100][8];
        for( int iY = 0; iY < 100; iY++ )
        {
            for( int iX = 0; iX < 8; iX++ )
            {
                dataValues[iY][iX] = "" + iX + "," + iY;
            }
        }
    }
    public static void main( String args[] )
    {
        Table1 mainFrame = new Table1();
        mainFrame.setVisible( true );
    }
} 