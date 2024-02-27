import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
class CompText extends JFrame
        implements DocumentListener,ActionListener
{
    private JTextField field1;
    private JTextField field2;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField password;
    public CompText()
    {
        setTitle( "TextHandling Application" );
        setSize( 300, 300 );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null );
        getContentPane().add( topPanel );
        field1 = new JTextField();
        field1.setBounds( 20, 40, 260, 25 );
        field1.setFocusAccelerator( 'v' );
        topPanel.add( field1 );
        label1 = new JLabel( "Value 1:");
        label1.setBounds( 20, 15, 260, 20 );
        label1.setLabelFor(field1 );
        label1.setDisplayedMnemonic( 'V' );
        topPanel.add( label1 );
        field2 = new JTextField();
        field2.setBounds( 20, 90, 260, 25 );
        field2.setFocusAccelerator( 'a' );
        topPanel.add( field2 );
        label2 = new JLabel( "Value 2:" );
        label2.setDisplayedMnemonic( 'a' );
        label2.setBounds( 20, 65, 260, 20 );
        label2.setLabelFor(field2 );
        topPanel.add( label2 );
        password=new JPasswordField();
        password.setBounds( 20, 140, 260, 25 );
        password.setFocusAccelerator( 'p' );
        topPanel.add(password);
        label3 = new JLabel( "Password:" );
        label3.setDisplayedMnemonic( 'P' );
        label3.setBounds( 20, 115, 260, 20 );
        label3.setLabelFor(password );
        topPanel.add( label3 );
        button1 = new JButton( "OK" );
        button1.setBounds( 100, 180, 100, 25 );
        button1.setEnabled(false );
        topPanel.add( button1 );
// adauga un document listener la primul camp de editare
        Document document = field1.getDocument();
        document.addDocumentListener( this );
    }
    // manipuleaza acceleratorii
    public void actionPerformed( ActionEvent e )
    {
// obtine sursa care a generat evenimentul
        JLabel label = (JLabel)e.getSource();
// ofera componentei associate focus-ul
        Component fieldComponent = label.getLabelFor();
        fieldComponent.requestFocus();
    }
    // manipuleaza inserarile in campul de editare
    public void insertUpdate( DocumentEvent event )
    {
        String sString = field1.getText();
        try {
            int iValue = Integer.parseInt( sString );
            button1.setEnabled( true );
        }
        catch( NumberFormatException e )
        {
            button1.setEnabled( false );
        }
    }
    // manipuleaza stergerile din campul de editare
    public void removeUpdate( DocumentEvent event )
    {
// nu permite utilizatorului sa introduca un camp vid
        if( field1.getText().length() == 0 )
            button1.setEnabled( false );
        else
        {
// efectueaza aceeasi verificare a erorilor ca si insertUpdate()
            insertUpdate( event );
        }
    }
    // manipuleaza modificarile in campul de editare
    public void changedUpdate( DocumentEvent event )
    {}
    public static void main( String args[] )
    {
        CompText mainFrame = new CompText();
        mainFrame.setVisible( true );
    }
} 