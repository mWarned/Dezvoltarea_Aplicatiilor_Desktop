package view;

import entity.Persoane;
import entity.implimentation.impPersoane;
import model.mainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class mainView extends JFrame {

    static JPanel MainPanel;

    private PanelMain mainPanel = new PanelMain();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuMain = new JMenu("File");
    private JMenu menuAdd = new JMenu("Add");
    private JMenuItem  menuAddPerson = new JMenuItem("Add person");
    private JMenu menuDelete = new JMenu("Delete");
    private JMenuItem menuDeletePersonPID = new JMenuItem("Delete a person by PID");

    private JMenuItem menuShowOldestYoungest = new JMenuItem("Oldest/Youngest");
    private JMenuItem menuShowSortAge = new JMenuItem("Age sort");
    private JMenuItem menuShowDivorcePercentage = new JMenuItem("% Divorced");
    private JMenuItem menuShowUnmariedMHigherEducation = new JMenuItem("M age range (HS)");
    private JMenuItem menuShowMinor = new JMenuItem("M/F under 18yo");
    private JMenuItem menuShowNrMarriedUnder20 = new JMenuItem("Married under 20");
    private JMenuItem menuShowNrRefused = new JMenuItem("Refused to participate");

    private JMenuItem menuExport = new JMenuItem("Export people of given birth month");
    private JMenuItem menuExit = new JMenuItem("Exit");

    private mainModel model;

    public mainView(mainModel model) {
        this.model = model;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Java GUI Tutorial!");
        getContentPane().add(mainPanel);

        menuAdd.add(menuAddPerson);

        menuDelete.add(menuDeletePersonPID);

        JMenu menuShow = new JMenu("Show");

        menuShow.add(menuShowOldestYoungest);
        menuShow.add(menuShowSortAge);
        menuShow.add(menuShowDivorcePercentage);
        menuShow.add(menuShowUnmariedMHigherEducation);
        menuShow.add(menuShowMinor);
        menuShow.add(menuShowNrMarriedUnder20);
        menuShow.add(menuShowNrRefused);

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

    public void addPersonAddListener(ActionListener personAddListener){
        menuAddPerson.addActionListener(personAddListener);
    }

    public void addPersonDeleteListener(ActionListener personDeleteListener){
        menuDeletePersonPID.addActionListener(personDeleteListener);
    }

    public void addShowListeners(ActionListener menuShowListener){
        menuShowOldestYoungest.addActionListener(menuShowListener);
        menuShowSortAge.addActionListener(menuShowListener);
        menuShowDivorcePercentage.addActionListener(menuShowListener);
        menuShowUnmariedMHigherEducation.addActionListener(menuShowListener);
        menuShowMinor.addActionListener(menuShowListener);
        menuShowNrMarriedUnder20.addActionListener(menuShowListener);
        menuShowNrRefused.addActionListener(menuShowListener);
    }

    public void addMenuExportListener(ActionListener menuExportListener){
        menuExport.addActionListener(menuExportListener);
    }

    public void addMenuExitListener(ActionListener menuExitListener){
        menuExit.addActionListener(menuExitListener);
    }

    public void setupMainPanel(){
        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));
        getContentPane().removeAll();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().doLayout();
    }

    public void setMainOldestYoungest(impPersoane persoane){
        mainPanel.setOldestYoungest(persoane.findOldest().get(0), persoane.findYoungest().get(0));
    }

    public void setMainDisplayList(java.util.List<Persoane> persoane){
        mainPanel.displayList(persoane);
    }
}
