import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ImgLista extends JFrame
{
    private JPanel topPanel;
    private JList listbox;
    public ImgLista()
    {
        setTitle( "Rendered ListBox Application" );
        setSize( 300, 160 );
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
// Creeaza datele ce vor fi adaugate in lista
        String listData[] ={"Smile","Naughty","Amazed","Angry"};
        listbox = new JList( listData );
        listbox.setCellRenderer( new CustomCellRenderer() );
        topPanel.add( listbox, BorderLayout.CENTER );
    }
    public static void main( String args[] )
    {
        ImgLista mainFrame = new ImgLista ();
        mainFrame.setVisible( true );
    }
}
class CustomCellRenderer extends JLabel implements ListCellRenderer
{
    private ImageIcon image[];
    public CustomCellRenderer()
    {
        setOpaque(true);
// Se pre-incarca imaginile pentru a economisi timp
        image = new ImageIcon[4];
        image[0] = new ImageIcon( " pic1.gif" );
        image[1] = new ImageIcon( " pic2.gif" );
        image[2] = new ImageIcon( " pic3.gif" );
        image[3] = new ImageIcon( " pic4.gif" );
    }
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index,boolean isSelected, boolean cellHasFocus)
    {
// afiseaza textul pentru aceasta intrare a listei
        setText(value.toString());
// Seteaza imaginea corecta
        setIcon( image[index] );
// Deseneaza fontul si culorile corecte
        if( isSelected )
        {
// Seteaza culoarea si fontul pentru o optiune selectata
            setBackground( Color.red );
            setForeground( Color.white );
            setFont( new Font( "Roman", Font.BOLD, 24 ) );
        }
        else
        {
// Seteaza culoarea si fontul pentru o optiune neselectata
            setBackground( Color.white );
            setForeground( Color.black );
            setFont( new Font( "Roman", Font.PLAIN, 12 ) );
        }
        return this;
    }
} 