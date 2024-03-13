package controller;

import entity.Persoane;
import entity.implimentation.impPersoane;
import model.mainModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.PanelAdd;
import view.PanelDelete;
import view.mainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class mainController {
    private static mainModel model;
    private static mainView view;

    public mainController(mainModel model, mainView view) {
        mainController.model = model;
        mainController.view = view;

        view.addPersonAddListener(new PersonAddListener());
        view.addPersonDeleteListener(new PersonDeleteListener());
        view.addShowListeners(new MenuShowListener());
        view.addMenuExportListener(new MenuExportListener());
        view.addMenuExitListener(new MenuExitListener());
    }

    static class PersonAddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PanelAdd panelAdd = new PanelAdd();
            panelAdd.setBorder(BorderFactory.createTitledBorder("Add a new person"));
            view.getContentPane().removeAll();
            view.getContentPane().add(panelAdd, BorderLayout.CENTER);
            view.getContentPane().doLayout();
        }
    };

    static class PersonDeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PanelDelete panelDelete = new PanelDelete();
            panelDelete.setBorder(BorderFactory.createTitledBorder("Delete a person"));
            view.getContentPane().removeAll();
            view.getContentPane().add(panelDelete, BorderLayout.CENTER);
            view.getContentPane().doLayout();
        }
    };

    static class MenuShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            impPersoane persoane = new impPersoane();
            switch (e.getActionCommand()) {
                case "Oldest/Youngest":
                    view.setupMainPanel();
                    view.setMainOldestYoungest(persoane);
                    break;
                case "Age sort":
                    view.setupMainPanel();
                    view.setMainDisplayList(persoane.outputAscendingByBirthday());
                    break;
                case "% Divorced":
                    JOptionPane.showMessageDialog(view.getParent(), "Procentul divorturilor - " + persoane.divorcePercentage());
                    break;
                case "M age range (HS)":
                    view.setupMainPanel();

                    try {
                        int age1 = Integer.parseInt(JOptionPane.showInputDialog("Introduceti varsta 1:"));
                        int age2 = Integer.parseInt(JOptionPane.showInputDialog("Introduceti varsta 2:"));
                        if (age1 > age2) {
                            JOptionPane.showMessageDialog(view.getParent(), "Varsta 2 nu poate fi mai mica!");
                            break;
                        }
                        view.setMainDisplayList(persoane.outputPeopleInAgeRange(age1, age2));
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(view.getParent(), "Varsta trebuie sa fie un numar");
                    }
                    break;
                case "M/F under 18yo":
                    view.setupMainPanel();

                    JComboBox<Character> genderComboBox = new JComboBox<>(new Character[]{'m', 'f'});

                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Alege sexul:"));
                    panel.add(genderComboBox);

                    int result = JOptionPane.showConfirmDialog(view.getParent(), panel, "Alege sexul", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        Character selectedGender = (Character) genderComboBox.getSelectedItem();
                        view.setMainDisplayList(persoane.peopleUnder18(selectedGender));
                        int count = persoane.peopleUnder18(selectedGender).size();
                        JOptionPane.showMessageDialog(view.getParent(), "Numarul persoanelor (" + selectedGender + ") - " + count);
                    }
                    break;
                case "Married under 20":
                    view.setupMainPanel();

                    JOptionPane.showMessageDialog(view.getParent(), "Numarul persoanelor casatorite sub 20 de ani - " + persoane.marriedUnder20().size());
                    break;
                case "Refused to participate":
                    view.setupMainPanel();

                    JOptionPane.showMessageDialog(view.getParent(), "Numarul persoanelor ce au refuzat sa participe - " + persoane.refusedToParticipate().size());
                    break;
                default:
                    break;
            }
        }
    };

    static class MenuExportListener implements ActionListener {
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
                    JOptionPane.showMessageDialog(view.getParent(), "Fisierul a fost exportat (Verificati folderul Downloads)");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(view.getParent(), "Introduceti luna dorita sub forma de cifra");
            } catch (Exception ex){
                JOptionPane.showMessageDialog(view.getParent(), ex.getMessage());
            }
        }
    };

    static class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

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
