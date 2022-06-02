module sample.proyectoloteria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample.proyectoloteria to javafx.fxml;
    exports sample.proyectoloteria;
}
