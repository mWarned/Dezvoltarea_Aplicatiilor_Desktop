import entity.Persoane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelFrame2 extends JPanel {

    public PanelFrame2() {
        setLayout(null);

        JLabel lblPID = new JLabel("PID");
        lblPID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPID.setBounds(20, 33, 150, 33);
        add(lblPID);

        JTextField txtPID = new JTextField();
        txtPID.setHorizontalAlignment(SwingConstants.LEFT);
        txtPID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPID.setBounds(190, 33, 200, 33);
        add(txtPID);

        JButton button = new JButton("Delete person");
        button.setBounds(250, 76, 140, 33);
        add(button);
    }
}
