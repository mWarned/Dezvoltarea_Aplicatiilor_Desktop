import entity.Persoane;
import entity.implimentation.impPersoane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class PanelAdd extends JPanel {

    public PanelAdd() {
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

        JLabel lblNume = new JLabel("Nume");
        lblNume.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNume.setBounds(20, 76, 150, 33);
        add(lblNume);

        JTextField txtNume = new JTextField();
        txtNume.setHorizontalAlignment(SwingConstants.LEFT);
        txtNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtNume.setBounds(190, 76, 200, 33);
        add(txtNume);

        JLabel lblPrenume = new JLabel("Prenume");
        lblPrenume.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrenume.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrenume.setBounds(20, 119, 150, 33);
        add(lblPrenume);

        JTextField txtPrenume = new JTextField();
        txtPrenume.setHorizontalAlignment(SwingConstants.LEFT);
        txtPrenume.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPrenume.setBounds(190, 119, 200, 33);
        add(txtPrenume);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSex.setBounds(20, 162, 150, 33);
        add(lblSex);

        JComboBox<String> txtSex = new JComboBox<>(new String[] {"m", "f"});
        txtSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSex.setBounds(190, 162, 66, 33);
        add(txtSex);

        JLabel lblTelefon = new JLabel("NrTelefon");
        lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTelefon.setBounds(20, 205, 150, 33);
        add(lblTelefon);

        JTextField txtTelefon = new JTextField();
        txtTelefon.setHorizontalAlignment(SwingConstants.LEFT);
        txtTelefon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTelefon.setBounds(190, 205, 200, 33);
        add(txtTelefon);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmail.setBounds(20, 248, 150, 33);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtEmail.setBounds(190, 248, 200, 33);
        add(txtEmail);

        JLabel lblDataNasterii = new JLabel("Data Nasterii");
        lblDataNasterii.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDataNasterii.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDataNasterii.setBounds(20, 291, 150, 33);
        add(lblDataNasterii);

        Calendar calendar = Calendar.getInstance();
        Date initialDate = new java.sql.Date(calendar.getTimeInMillis());
        SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH);
        JSpinner txtDataNasterii = new JSpinner(dateModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(txtDataNasterii, "yyyy-MM-dd");
        txtDataNasterii.setEditor(editor);
        txtDataNasterii.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDataNasterii.setBounds(190, 291, 200, 33);
        add(txtDataNasterii);

        JLabel lblCasatorit = new JLabel("Casatorit");
        lblCasatorit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCasatorit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCasatorit.setBounds(20, 334, 150, 33);
        add(lblCasatorit);

        JCheckBox txtCasatorit = new JCheckBox();
        txtCasatorit.setHorizontalAlignment(SwingConstants.LEFT);
        txtCasatorit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtCasatorit.setBounds(190, 334, 33, 33);
        add(txtCasatorit);

        JLabel lblDivortat = new JLabel("Divortat");
        lblDivortat.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDivortat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDivortat.setBounds(20, 377, 150, 33);
        add(lblDivortat);

        JCheckBox txtDivortat = new JCheckBox();
        txtDivortat.setBounds(190, 377, 33, 33);
        add(txtDivortat);

        JButton btnAddPerson = new JButton("Add new person");
        btnAddPerson.setBounds(250, 420, 140, 33);
        add(btnAddPerson);

        btnAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impPersoane persoane = new impPersoane();
                try {
                    Persoane person = new Persoane();
                    try {
                        person.setPid(Integer.parseInt(txtPID.getText()));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(getParent(), "PID trebuie sa fie un numar!");
                    }
                    person.setNume(txtNume.getText());
                    person.setPrenume(txtPrenume.getText());
                    person.setSex(txtSex.getSelectedIndex() == 0 ? 'm' : 'f');
                    person.setNrTelefon(txtTelefon.getText());
                    person.setEmail(txtEmail.getText());
                    person.setDataNasterii(new java.sql.Date(((java.util.Date) txtDataNasterii.getValue()).getTime()));
                    person.setCasatorit((byte) (txtCasatorit.isSelected() ? 1 : 0));
                    person.setDivortat((byte) (txtDivortat.isSelected() ? 1 : 0));

                    persoane.insert(person);
                    JOptionPane.showMessageDialog(getParent(), "Persoana a fost introdusa cu succes");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getParent(), ex.getMessage());
                }
            }
        });
    }
}
