import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class Fereastra extends JFrame {
    Fereastra() {
        super("Utilizare JSpinner");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SpinnerModel setari =
                new SpinnerNumberModel(0, //valoarea initiala
                        0, //valoarea minima
                        20, //valoarea maxima
                        2); //pasul de incremetare
        JSpinner spinner = new JSpinner(setari);

        JButton button = new JButton("Factorial");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long factorial = calcFact((Integer) spinner.getValue());
                JOptionPane.showMessageDialog(button.getParent(), "Factorialul numarului - " + factorial);
            }
        });

        JLabel label = new JLabel("Selecteaza un numar de la 0 pana la 20");

        add(spinner, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setVisible(true);
    }

    private long calcFact(int nr){
        long result = 1;
        for (int i = nr; i >= 2; i--){
            result *= i;
        }
        return result;
    }
}

class SpinnerExample {
    public static void main(String[] args) {
        new Fereastra();
    }
}
