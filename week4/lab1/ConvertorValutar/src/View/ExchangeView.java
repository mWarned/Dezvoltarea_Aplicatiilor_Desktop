package View;

import Model.ExchangeModel;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class ExchangeView extends JFrame {

    //... Constants
    private static final String[] CURRENCY_LIST = {"RON", "EURO", "MDL", "USD", "UAH"};
    private static final Double[] RATE_LIST = {4.9731, 1.0, 19.3959, 1.0848, 41.6508};

    //... Components
    private JLabel            m_rate           = new JLabel(String.format("1 " + CURRENCY_LIST[1] + " = " + RATE_LIST[0] + " " + CURRENCY_LIST[0]));
    private JComboBox<String> m_currency1      = new JComboBox<>(CURRENCY_LIST);
    private JButton           m_btnSwap        = new JButton("Swap");
    private JComboBox<String> m_currency2      = new JComboBox<>(CURRENCY_LIST);
    private JTextField        m_inCurrency     = new JTextField("", 10);
    private JLabel            m_lblInCurrency  = new JLabel("EURO");
    private JTextField        m_outCurrency    = new JTextField("", 10);
    private JLabel            m_lblOutCurrency = new JLabel("RON");
    private ExchangeModel     m_model;

    //====================================================================== Constructor
    /** Constructor */
    public ExchangeView(ExchangeModel model){
        // Initialize model
        m_model = model;

        // Setup components
        m_currency1.setSelectedIndex(1);
        m_currency2.setSelectedIndex(0);

        // Add components to the frame
        JPanel content = new JPanel();
        content.add(m_rate);
        content.add(m_currency1);
        content.add(m_btnSwap);
        content.add(m_currency2);
        content.add(m_inCurrency);
        content.add(m_lblInCurrency);
        content.add(m_outCurrency);
        content.add(m_lblOutCurrency);

        // Setup the frame
        this.setContentPane(content);
        this.pack();
        this.setBounds(250, 250, 800, 80);

        this.setTitle("Currency exchange");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void setRate(int index1, int index2) {
        m_model.currentRate = Double.parseDouble(m_model.df.format(RATE_LIST[index2] / RATE_LIST[index1]));
        m_rate.setText("1 " + CURRENCY_LIST[index1] + " = " + m_model.currentRate + " " + CURRENCY_LIST[index2]);
        m_lblInCurrency.setText(CURRENCY_LIST[index1]);
        m_lblOutCurrency.setText(CURRENCY_LIST[index2]);
    }

    public void addCurrencyChange(ActionListener curr){
        m_currency1.addActionListener(curr);
        m_currency2.addActionListener(curr);
    }

    public void addSwapCurrency(ActionListener swap){
        m_btnSwap.addActionListener(swap);
    }

    public void addConvertion(KeyListener convert){
        m_inCurrency.addKeyListener(convert);
    }

    public JLabel getM_rate() {
        return m_rate;
    }

    public void setM_rate(JLabel m_rate) {
        this.m_rate = m_rate;
    }

    public JComboBox<String> getM_currency1() {
        return m_currency1;
    }

    public void setM_currency1(int index) {
        m_currency1.setSelectedIndex(index);
    }

    public JButton getM_btnSwap() {
        return m_btnSwap;
    }

    public void setM_btnSwap(JButton m_btnSwap) {
        this.m_btnSwap = m_btnSwap;
    }

    public JComboBox<String> getM_currency2() {
        return m_currency2;
    }

    public void setM_currency2(int index) {
        m_currency2.setSelectedIndex(index);
    }

    public JTextField getM_inCurrency() {
        return m_inCurrency;
    }

    public void setM_inCurrency(JTextField m_inCurrency) {
        this.m_inCurrency = m_inCurrency;
    }

    public JLabel getM_lblInCurrency() {
        return m_lblInCurrency;
    }

    public void setM_lblInCurrency(JLabel m_lblInCurrency) {
        this.m_lblInCurrency = m_lblInCurrency;
    }

    public JTextField getM_outCurrency() {
        return m_outCurrency;
    }

    public void setM_outCurrency(String text) {
        m_outCurrency.setText(text);
    }

    public JLabel getM_lblOutCurrency() {
        return m_lblOutCurrency;
    }

    public void setM_lblOutCurrency(String text) {
        m_lblOutCurrency.setText(text);
    }
}
