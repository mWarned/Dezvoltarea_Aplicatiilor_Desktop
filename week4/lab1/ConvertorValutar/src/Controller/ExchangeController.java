package Controller;

import Model.ExchangeModel;
import View.ExchangeView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExchangeController {
    private ExchangeModel m_model;
    private ExchangeView  m_view;

    //========================================================== constructor
    /** Constructor */
    public ExchangeController(ExchangeView view, ExchangeModel model){
        m_model = model;
        m_view = view;

        view.addCurrencyChange(new CurrencyChanged());
        view.addSwapCurrency(new SwapCurrency());
        view.addConvertion(new Convertion());
    }

    class CurrencyChanged implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index1 = m_view.getM_currency1().getSelectedIndex();
            int index2 = m_view.getM_currency2().getSelectedIndex();

            m_view.setRate(index1, index2);

            //... Refresh input
            KeyEvent keyEvent = new KeyEvent(m_view.getM_inCurrency(), KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, KeyEvent.CHAR_UNDEFINED);
            m_view.getM_inCurrency().dispatchEvent(keyEvent);
        }
    }

    class SwapCurrency implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int val = m_view.getM_currency1().getSelectedIndex();
            m_view.setM_currency1(m_view.getM_currency2().getSelectedIndex());
            m_view.setM_currency2(val);

            //... Refresh input
            KeyEvent keyEvent = new KeyEvent(m_view.getM_inCurrency(), KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, KeyEvent.CHAR_UNDEFINED);
            m_view.getM_inCurrency().dispatchEvent(keyEvent);
        }
    }

    class Convertion implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // Not used
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // Not used
        }

        @Override
        public void keyReleased(KeyEvent e) {
            textChanged();
        }

        public void textChanged(){
            try {
                m_view.setM_outCurrency(String.valueOf(m_model.df.format(Double.parseDouble(m_view.getM_inCurrency().getText()) * m_model.currentRate)));
            } catch (NumberFormatException ex) {
                m_view.setM_outCurrency("ERR");
            }
        }
    }
}
