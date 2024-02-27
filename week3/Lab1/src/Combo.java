import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class Combo extends JFrame implements ItemListener
{
    private JComboBox combo;
    final String[] sList ={"Canada","USA","Australia","Bolivia",
            "Denmark","Japan"};
    public Combo()
    {
        setTitle( "ComboBox Application" );
        setSize( 300, 80 );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( null );
        getContentPane().add( topPanel );
        combo = new JComboBox();
        combo.setBounds( 20, 15, 260, 20 );
        topPanel.add( combo );
// Populeaza lista ComboBox
        for( int iCtr = 0; iCtr < sList.length; iCtr++ )
            combo.addItem( sList[iCtr] );
// Permite editarea
        combo.setEditable( true );
        combo.addItemListener( this );
    }
    public void itemStateChanged( ItemEvent event )
    {
        if( event.getSource() == combo &&
                event.getStateChange() == ItemEvent.SELECTED )
        {
            System.out.println( "Change:"+ combo.getSelectedItem() );
        }
    }
    public static void main( String args[] )
    {
        Combo mainFrame = new Combo();
        mainFrame.setVisible( true );
    }
} 