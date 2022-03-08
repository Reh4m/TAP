module sample.proyectoloteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.proyectoloteria to javafx.fxml;
    exports sample.proyectoloteria;
}
