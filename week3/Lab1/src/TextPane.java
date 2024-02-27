import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
class TextPane extends JFrame implements ActionListener
{
    private Hashtable attributes;
    private JComboBox styleCombo;
    private DefaultStyledDocument doc;
    private JTextPane textComponent;
    public TextPane ()
    {
        setTitle( "Document Handling Application" );
        setSize( 300, 190 );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza stiluri pentru document
        StyleContext sc = new StyleContext();
        doc = new DefaultStyledDocument( sc );
        createStyles( sc );
// Creeaza un “text pane” pentru a afisa text
        textComponent = new JTextPane( doc );
        textComponent.setBackground( Color.white );
        topPanel.add( textComponent, BorderLayout.CENTER );
// Creeaza un “toolbar” pentru a manipula modificarile de stil
        topPanel.add( createToolBar(), BorderLayout.NORTH );
    }
    // Creeaza un “toolbar panel” foarte simplu
    public JPanel createToolBar()
    {
        JPanel panel = new JPanel( new FlowLayout() );
        styleCombo = new JComboBox();
        styleCombo.addActionListener( this );
        panel.add( styleCombo );
// Adauga fiecare stil la “combo box”
        for( Enumeration e = attributes.keys(); e.hasMoreElements(); )
            styleCombo.addItem( e.nextElement().toString() );
        return panel;
    }
    //Manipuleaza modificarile efectuate in “combo box”
    public void actionPerformed( ActionEvent e )
    {
        if( e.getSource() == styleCombo )
        {
            try {
// Determina noul stil
                Style s = (Style)attributes.get(
                        styleCombo.getSelectedItem() );
// Seteaza stilul
                doc.insertString( textComponent.getCaret().getDot()," ", s );
// se intoarce la fereastra editor
                textComponent.grabFocus();
            }
            catch( BadLocationException exception )
            {}
        }
    }
    // Creeaza stiluri diferite de font
    public void createStyles( StyleContext sc )
    {
        Style myStyle;
// Aloca o tabela de dispersie pentru stiluri
        attributes = new Hashtable();
// Nici un stil
        myStyle = sc.addStyle( null, null );
        attributes.put( "none", myStyle );
// Normal
        myStyle = sc.addStyle( null, null );
        StyleConstants.setLeftIndent( myStyle, 10 );
        StyleConstants.setRightIndent( myStyle, 10 );
        StyleConstants.setFontFamily( myStyle, "Helvetica" );
        StyleConstants.setFontSize( myStyle, 14 );
        StyleConstants.setSpaceAbove( myStyle, 4 );
        StyleConstants.setSpaceBelow( myStyle, 4 );
        attributes.put( "normal", myStyle );
// Big
        myStyle = sc.addStyle( null, null );
        StyleConstants.setFontFamily( myStyle, "Dialog" );
        StyleConstants.setFontSize( myStyle, 28 );
        attributes.put( "big", myStyle );
// Bold
        myStyle = sc.addStyle( null, null );
        StyleConstants.setBold( myStyle, true );
        attributes.put( "bold", myStyle );
    }
    public static void main( String args[] )
    {
        TextPane mainFrame = new TextPane ();
        mainFrame.setVisible( true );
    }
}
