package sample.proyectoloteria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.proyectoloteria.views.Loteria;

import java.io.IOException;

public class Main extends Application {
    private VBox v_box;
    private MenuBar menu_bar;
    private Menu comp1, comp2;
    private MenuItem loteria_menu;

    @Override
    public void start(Stage stage) throws IOException {
        menu_bar = new MenuBar();

        // Menu correspondiente a la vista Loteria.
        comp1 = new Menu("Competencia 1");
        loteria_menu = new MenuItem("Loteria");
        // Lanza un evento el cual instancia a la clase Loteria.
        loteria_menu.setOnAction(actionEvent -> {
            new Loteria();
        });
        comp1.getItems().addAll(loteria_menu);

        // Menu correspondiente a... (pendiente).
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
    }

    public static void main(String[] args) {
        launch();
    }
}
