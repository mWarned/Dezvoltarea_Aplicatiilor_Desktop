    import entity.Persoane;
import entity.implimentation.*;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {

    static JPanel MainPanel;
    public static void main(String[] args) {

//        List<Persoane> findAll = new impPersoane().outputPeopleInAgeRange(10, 25);
//        for (Persoane x:
//                findAll) {
//            System.out.println(x);
//        }


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main frame = new Main();
                frame.setVisible(true);
            }
        });

//        System.out.println("\n");

//        List<Persoane> p = new impPersoane().outputPeopleInAgeRange(10, 25);
//        for (Persoane x:
//             p) {
//            System.out.println(x);
//        }
//
//        System.out.println("\n");

//        String rataDivortului = new impPersoane().divorcePercentage();
//        System.out.println(rataDivortului);

//        List<Persoane> over18 = new impPersoane().peopleOver18('f');
//        for (Persoane x:
//             over18) {
//            System.out.println(x);
//        }
//
//        System.out.println("\n");

//        List<Persoane> marriedUnder20 = new impPersoane().marriedUnder20();
//        for (Persoane x:
//                marriedUnder20) {
//            System.out.println(x);
//        }
//
//        System.out.println("\n");

//        long anonCount = new impPolls().countAnonymous();
//        System.out.println(anonCount);

    }

    public Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setTitle("Java GUI Tutorial");

        getContentPane().add(new PanelMain());

        JMenuBar menuBar = new JMenuBar();

        JMenu menuMain = new JMenu("File");

        JMenu menuAdd = new JMenu("Add");

        JMenuItem  menuAddPerson = new JMenuItem("Add person");

        menuAdd.add(menuAddPerson);

        menuAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFrame1 panel1 = new PanelFrame1();
                panel1.setBorder(BorderFactory.createTitledBorder("Add a new person"));
                getContentPane().removeAll();
                getContentPane().add(panel1, BorderLayout.CENTER);
                getContentPane().doLayout();
            }
        });

        JMenu menuDelete = new JMenu("Delete");

        JMenuItem menuDeletePersonPID = new JMenuItem("Delete a person by PID");

        menuDelete.add(menuDeletePersonPID);

        menuDeletePersonPID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFrame2 panel2 = new PanelFrame2();
                panel2.setBorder(BorderFactory.createTitledBorder("Delete a person"));
                getContentPane().removeAll();
                getContentPane().add(panel2, BorderLayout.CENTER);
                getContentPane().doLayout();
            }
        });

        JMenu menuShow = new JMenu("Show");

        JMenuItem menuShowOldestYoungest = new JMenuItem("Oldest/Youngest");
        JMenuItem menuShowSortAge = new JMenuItem("ASge sort");
        JMenuItem menuShowDivorcePercentage = new JMenuItem("% Divorced");
        JMenuItem menuShowUnmariedMHigherEducation = new JMenuItem("M age range (HS)");
        JMenuItem menuShowMinor = new JMenuItem("M/F under 18yo");
        JMenuItem menuShowNrMarriedUnder20 = new JMenuItem("Marriend under 20");
        JMenuItem menuShowNrRefused = new JMenuItem("Refused to participate");

        menuShow.add(menuShowOldestYoungest);
        menuShow.add(menuShowSortAge);
        menuShow.add(menuShowDivorcePercentage);
        menuShow.add(menuShowUnmariedMHigherEducation);
        menuShow.add(menuShowMinor);
        menuShow.add(menuShowNrMarriedUnder20);
        menuShow.add(menuShowNrRefused);

        menuShowOldestYoungest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                PanelFrame3 panel3 = new PanelFrame3();
//                panel3.setBorder(BorderFactory.createTitledBorder("Show data"));
//                getContentPane().removeAll();
//                getContentPane().add(panel3, BorderLayout.CENTER);
//                getContentPane().doLayout();

                // Show data in main panel
            }
        });

        JMenuItem menuExport = new JMenuItem("Export people of given birth month");
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
}
