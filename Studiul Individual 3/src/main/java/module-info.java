module md.ceiti.dad.exemplu.lucruindividual3_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens md.ceiti.mj.exemplu.StudiulIndividual3 to javafx.fxml;
    exports md.ceiti.mj.exemplu.StudiulIndividual3;
}