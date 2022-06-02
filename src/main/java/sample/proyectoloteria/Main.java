package sample.proyectoloteria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.proyectoloteria.util.DBConnection;
import sample.proyectoloteria.views.Loteria;
import sample.proyectoloteria.views.Parser;

import java.io.IOException;

public class Main extends Application {
    private VBox v_box;
    private MenuBar menu_bar;
    private Menu comp1, comp2;
    private MenuItem loteria_menu, parser_menu;

    @Override
    public void start(Stage stage) throws IOException {
        menu_bar = new MenuBar();

        // Sección competencia 1.
        comp1 = new Menu("Competencia 1");
        // Menu correspondiente a la vista Lotería.
        loteria_menu = new MenuItem("Lotería");
        // Lanza un evento el cual instancia a la clase Lotería.
        loteria_menu.setOnAction(actionEvent -> {
            new Loteria();
        });
        // Menu correspondiente a la vista Código morse.
        parser_menu = new MenuItem("Código morse");
        parser_menu.setOnAction(actionEvent -> {
            new Parser();
        });
        comp1.getItems().addAll(loteria_menu, parser_menu);

        // Sección competencia 2.
        comp2 = new Menu("Competencia 2");

        // Implementación de los menus (competencia 1 y 2).
        menu_bar.getMenus().addAll(comp1, comp2);

        // Contenedor del menu bar.
        v_box = new VBox();
        v_box.getChildren().addAll(menu_bar);

        // Vista principal.
        Scene scene = new Scene(v_box, 320, 240);

        stage.setTitle("Tópicos avanzados de programación");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        // Conexión a la base de datos.
        DBConnection.createConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}
