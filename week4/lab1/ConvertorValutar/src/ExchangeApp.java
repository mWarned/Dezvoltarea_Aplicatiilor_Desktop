import Controller.ExchangeController;
import Model.ExchangeModel;
import View.ExchangeView;

public class ExchangeApp {
    public static void main(String[] args) {
        ExchangeModel model = new ExchangeModel();
        ExchangeView view = new ExchangeView(model);
        ExchangeController controller = new ExchangeController(view, model);

        view.setVisible(true);
    }
}
