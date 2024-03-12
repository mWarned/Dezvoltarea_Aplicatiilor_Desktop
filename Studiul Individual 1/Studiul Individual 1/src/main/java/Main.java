import entity.Persoane;
import entity.implimentation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main extends JFrame {

    static JPanel MainPanel;
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main frame = new Main();
                frame.setVisible(true);

            }
        });
    }

    public Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Java GUI Tutorial!");

        PanelMain mainPanel = new PanelMain();
        getContentPane().add(mainPanel);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuMain = new JMenu("File");

        JMenu menuAdd = new JMenu("Add");

        JMenuItem  menuAddPerson = new JMenuItem("Add person");

        menuAdd.add(menuAddPerson);

        menuAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdd panelAdd = new PanelAdd();
                panelAdd.setBorder(BorderFactory.createTitledBorder("Add a new person"));
                getContentPane().removeAll();
                getContentPane().add(panelAdd, BorderLayout.CENTER);
                getContentPane().doLayout();
            }
        });

        JMenu menuDelete = new JMenu("Delete");

        JMenuItem menuDeletePersonPID = new JMenuItem("Delete a person by PID");

        menuDelete.add(menuDeletePersonPID);

        menuDeletePersonPID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelDelete panelDelete = new PanelDelete();
                panelDelete.setBorder(BorderFactory.createTitledBorder("Delete a person"));
                getContentPane().removeAll();
                getContentPane().add(panelDelete, BorderLayout.CENTER);
                getContentPane().doLayout();
            }
        });

        JMenu menuShow = new JMenu("Show");

        JMenuItem menuShowOldestYoungest = new JMenuItem("Oldest/Youngest");
        JMenuItem menuShowSortAge = new JMenuItem("Age sort");
        JMenuItem menuShowDivorcePercentage = new JMenuItem("% Divorced");
        JMenuItem menuShowUnmariedMHigherEducation = new JMenuItem("M age range (HS)");
        JMenuItem menuShowMinor = new JMenuItem("M/F under 18yo");
        JMenuItem menuShowNrMarriedUnder20 = new JMenuItem("Married under 20");
        JMenuItem menuShowNrRefused = new JMenuItem("Refused to participate");

        menuShow.add(menuShowOldestYoungest);
        menuShow.add(menuShowSortAge);
        menuShow.add(menuShowDivorcePercentage);
        menuShow.add(menuShowUnmariedMHigherEducation);
        menuShow.add(menuShowMinor);
        menuShow.add(menuShowNrMarriedUnder20);
        menuShow.add(menuShowNrRefused);

        ActionListener menuShowActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impPersoane persoane = new impPersoane();
                switch (e.getActionCommand()) {
                    case "Oldest/Youngest":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        mainPanel.setOldestYoungest(persoane.findOldest().get(0), persoane.findYoungest().get(0));
                        break;
                    case "Age sort":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        mainPanel.displayList(persoane.outputAscendingByBirthday());
                        break;
                    case "% Divorced":
                        JOptionPane.showMessageDialog(getParent(), "Procentul divorturilor - " + persoane.divorcePercentage());
                        break;
                    case "M age range (HS)":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        try {
                            int age1 = Integer.parseInt(JOptionPane.showInputDialog("Introduceti varsta 1:"));
                            int age2 = Integer.parseInt(JOptionPane.showInputDialog("Introduceti varsta 2:"));
                            if (age1 > age2) {
                                JOptionPane.showMessageDialog(getParent(), "Varsta 2 nu poate fi mai mica!");
                                break;
                            }
                            mainPanel.displayList(persoane.outputPeopleInAgeRange(age1, age2));
                        } catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(getParent(), "Varsta trebuie sa fie un numar");
                        }
                        break;
                    case "M/F under 18yo":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        JComboBox<Character> genderComboBox = new JComboBox<>(new Character[]{'m', 'f'});

                        JPanel panel = new JPanel();
                        panel.add(new JLabel("Alege sexul:"));
                        panel.add(genderComboBox);

                        int result = JOptionPane.showConfirmDialog(getParent(), panel, "Alege sexul", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            Character selectedGender = (Character) genderComboBox.getSelectedItem();
                            mainPanel.displayList(persoane.peopleUnder18(selectedGender));
                            int count = persoane.peopleUnder18(selectedGender).size();
                            JOptionPane.showMessageDialog(getParent(), "Numarul persoanelor (" + selectedGender + ") - " + count);
                        }
                        break;
                    case "Married under 20":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        JOptionPane.showMessageDialog(getParent(), "Numarul persoanelor casatorite sub 20 de ani - " + persoane.marriedUnder20().size());
                        break;
                    case "Refused to participate":
                        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
                        getContentPane().removeAll();
                        getContentPane().add(mainPanel, BorderLayout.CENTER);
                        getContentPane().doLayout();

                        JOptionPane.showMessageDialog(getParent(), "Numarul persoanelor ce au refuzat sa participe - " + persoane.refusedToParticipate().size());
                        break;
                    default:
                        break;
                }
            }
        };

        menuShowOldestYoungest.addActionListener(menuShowActionListener);
        menuShowSortAge.addActionListener(menuShowActionListener);
        menuShowDivorcePercentage.addActionListener(menuShowActionListener);
        menuShowUnmariedMHigherEducation.addActionListener(menuShowActionListener);
        menuShowMinor.addActionListener(menuShowActionListener);
        menuShowNrMarriedUnder20.addActionListener(menuShowActionListener);
        menuShowNrRefused.addActionListener(menuShowActionListener);

        JMenuItem menuExport = new JMenuItem("Export people of given birth month");
        menuExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impPersoane persoane = new impPersoane();
                try {
                    int month = Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul lunii:"));

                    try (Workbook workbook = new XSSFWorkbook()) {
                        Sheet sheet = workbook.createSheet("Person Data");
                        createHeaderRow(sheet);
                        int rowNum = 1;
                        for (Persoane person : persoane.peopleBornInMonth(month)) {
                            Row row = sheet.createRow(rowNum++);
                            writePersonDataToRow(person, row);
                        }
                        FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "exportedData.xlsx");
                        workbook.write(fileOut);
                        fileOut.close();
                        JOptionPane.showMessageDialog(getParent(), "Fisierul a fost exportat (Verificati folderul Downloads)");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(getParent(), "Introduceti luna dorita sub forma de cifra");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(getParent(), ex.getMessage());
                }
            }
        });

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        menuMain.add(menuAdd);
        menuMain.add(menuDelete);
        menuMain.add(menuShow);
        menuMain.addSeparator();
        menuMain.add(menuExport);
        menuMain.add(menuExit);

        menuBar.add(menuMain);

        setJMenuBar(menuBar);

        setResizable(false);
    }

    private static void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "PID", "Nume", "Prenume", "Sex", "Nr. Telefon", "Email", "Data Nasterii", "Casatorit", "Divortat"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private static void writePersonDataToRow(Persoane person, Row row) {
        row.createCell(0).setCellValue(person.getId());
        row.createCell(1).setCellValue(person.getPid());
        row.createCell(2).setCellValue(person.getNume());
        row.createCell(3).setCellValue(person.getPrenume());
        row.createCell(4).setCellValue(String.valueOf(person.getSex()));
        row.createCell(5).setCellValue(person.getNrTelefon());
        row.createCell(6).setCellValue(person.getEmail());
        row.createCell(7).setCellValue(person.getDataNasterii().toString());
        row.createCell(8).setCellValue(person.getCasatorit() == 1 ? "casatorit" : "necasatorit");
        row.createCell(9).setCellValue(person.getDivortat() == 1 ? "divortat" : "nedivortat");
    }
}
