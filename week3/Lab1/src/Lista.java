import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class Lista extends JFrame
        implements ActionListener,ListSelectionListener
{
    private JPanel topPanel;
    private JList listbox;
    private Vector listData;
    private JButton addButton;
    private JButton removeButton;
    private JTextField dataField;
    private JScrollPane scrollPane;
    public Lista()
    {
        setTitle( "Advanced List Box Application" );
        setSize( 300, 100 );
        setBackground( Color.gray );
// Creeaza un panou pentru a stoca toate celelalte componente
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza un model de date
        listData = new Vector();
// Creeaza o lista
        listbox = new JList( listData );
        listbox.addListSelectionListener( this );
// Adauga lista la un “scrolling pane”
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( listbox );
        topPanel.add( scrollPane, BorderLayout.CENTER );
        CreateDataEntryPanel();
    }
    public void CreateDataEntryPanel()
    {
// Creeaza un panou pentru a stoca celelalte componente
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout( new BorderLayout() );
        topPanel.add( dataPanel, BorderLayout.SOUTH );
// Creeaza butoane
        addButton = new JButton( "Add" );
        dataPanel.add( addButton, BorderLayout.WEST );
        addButton.addActionListener( this );
        removeButton = new JButton( "Delete" );
        dataPanel.add( removeButton, BorderLayout.EAST );
        removeButton.addActionListener( this );
// Creeaza un camp de editare
        dataField = new JTextField();
        dataPanel.add( dataField, BorderLayout.CENTER );
    }
    public void valueChanged( ListSelectionEvent event )
    {
        if( event.getSource() == listbox && !event.getValueIsAdjusting())
        {
            String stringValue = (String)listbox.getSelectedValue();
            if( stringValue != null )
                dataField.setText( stringValue );
        }
    }
    public void actionPerformed( ActionEvent event )
    {
        if( event.getSource() == addButton )
        {
            String stringValue = dataField.getText();
            dataField.setText( "" );
            if( stringValue != null )
            {
                listData.addElement( stringValue );
                listbox.setListData( listData );
                scrollPane.revalidate();
                scrollPane.repaint();
            }
        }
        if( event.getSource() == removeButton )
        {
            int selection = listbox.getSelectedIndex();
            if( selection >= 0 )
            {
                listData.removeElementAt( selection );
                listbox.setListData( listData );
                scrollPane.revalidate();
                scrollPane.repaint();
// Selecteaza urmatoarea intrare din lista
                if( selection >= listData.size() )
                    selection = listData.size() - 1;
                listbox.setSelectedIndex( selection );
            }
        }
    }
    public static void main( String args[] )
    {
        Lista mainFrame = new Lista();
        mainFrame.setVisible( true );
    }
} 