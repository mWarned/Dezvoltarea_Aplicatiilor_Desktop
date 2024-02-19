import javax.swing.*;
import java.awt.*;

public class PanelMain extends JPanel {

    public PanelMain() {
        setLayout(null);

        JTable table = new JTable();
        table.setBounds(20, 20, 550, 450);
        add(table);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(470, 490, 100, 33);
        add(btnRefresh);

    }
}
