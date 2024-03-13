package view;

import entity.Persoane;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

public class PanelMain extends JPanel {
    JTable table;

    public PanelMain() {
        setLayout(null);

        table = new JTable();
        table.setBounds(20, 20, 750, 480);
        add(table);
    }

    public void setOldestYoungest(Persoane youngest, Persoane oldest){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data from the table

        String[] columnNames = {"ID", "PID", "Nume", "Prenume", "Sex", "Nr. Telefon", "Email", "Data Nasterii", "Casatorit", "Divortat"};
        model.setColumnIdentifiers(columnNames);

        Object[] rowYoungest = {
                youngest.getId(),
                youngest.getPid(),
                youngest.getNume(),
                youngest.getPrenume(),
                youngest.getSex(),
                youngest.getNrTelefon(),
                youngest.getEmail(),
                youngest.getDataNasterii(),
                youngest.getCasatorit() == 1 ? "casatorit" : "necasatorit",
                youngest.getDivortat() == 1 ? "divortat" : "nedivortat"
        };

        Object[] rowOldest = {
                oldest.getId(),
                oldest.getPid(),
                oldest.getNume(),
                oldest.getPrenume(),
                oldest.getSex(),
                oldest.getNrTelefon(),
                oldest.getEmail(),
                oldest.getDataNasterii(),
                oldest.getCasatorit() == 1 ? "casatorit" : "necastorit",
                oldest.getDivortat() == 1 ? "divortat" : "nedivortat"
        };

        model.addRow(rowYoungest);
        model.addRow(rowOldest);

        resizeTable();
    }
    public void displayList(List<Persoane> persoane){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String[] columnNames = {"ID", "PID", "Nume", "Prenume", "Sex", "Nr. Telefon", "Email", "Data Nasterii", "Casatorit", "Divortat"};
        model.setColumnIdentifiers(columnNames);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        for (Persoane person : persoane) {
            Object[] rowData = {
                    person.getId(),
                    person.getPid(),
                    person.getNume(),
                    person.getPrenume(),
                    person.getSex(),
                    person.getNrTelefon(),
                    person.getEmail(),
                    person.getDataNasterii(),
                    person.getCasatorit() == 1 ? "casatorit" : "necasatorit",
                    person.getDivortat() == 1 ? "divortat" : "nedivortat"
            };
            model.addRow(rowData);

            table.setModel(model);
            resizeTable();
        }
    }

    private void resizeTable(){
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int preferredWidth = 0;
            TableCellRenderer renderer = column.getHeaderRenderer();
            if (renderer == null) {
                renderer = table.getTableHeader().getDefaultRenderer();
            }
            Component header = renderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, 0);
            preferredWidth = header.getPreferredSize().width;

            // Adjust width based on each cell's content
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, i);
                Component c = table.prepareRenderer(cellRenderer, row, i);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }

            column.setPreferredWidth(preferredWidth + 10);
        }
    }
}
