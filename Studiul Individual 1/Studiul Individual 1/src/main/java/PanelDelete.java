import com.google.protobuf.Message;
import entity.implimentation.impPersoane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDelete extends JPanel {

    public PanelDelete() {
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

        JButton btnDeletePerson = new JButton("Delete person");
        btnDeletePerson.setBounds(250, 76, 140, 33);
        add(btnDeletePerson);

        btnDeletePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impPersoane persoane = new impPersoane();
                try{
                    int id = Integer.parseInt(txtPID.getText());
                    persoane.deleteByID(id);
                    JOptionPane.showMessageDialog(getParent(), "Persoana a fost stersa cu succes");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(getParent(), "ID-ul poate fi doar cifra");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getParent(), ex.getMessage());
                }
            }
        });
    }
}
