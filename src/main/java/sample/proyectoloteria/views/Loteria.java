package sample.proyectoloteria.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.proyectoloteria.events.ButtonPlayClicked;

import java.io.File;

public class Loteria extends Stage {
    private VBox v_box;
    private HBox h_box1, h_box2;
    private Button btn_back, btn_next, btn_play;
    private Label lbl_time;
    private GridPane gdp_template;
    private Image img_card;
    private Scene scene;
    private Image img_card_template;
    private ImageView image_view;

    private final String[] IMAGES = {
        "barril.jpeg",
        "botella.jpeg",
        "catrin.jpeg",
        "chavorruco.jpeg",
        "concha.jpeg",
        "luchador.jpeg",
        "botella.jpeg",
        "tacos.jpeg",
    };
    private final Button[][] BUTTONS = new Button[4][2];

    public Loteria() {
        createUI();
        this.setTitle("Loteria");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        // Área de selección de plantilla (botones).
        btn_back = new Button("Atrás");
        btn_back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("back event");
            }
        });
        btn_back.setPrefWidth(100);
        btn_next = new Button("Siguiente");
        btn_next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("next event");
            }
        });
        btn_next.setPrefWidth(100);

        // Marcador de tiempo para cambiar de carta.
        lbl_time = new Label("00:00");

        // Contenedor de botones.
        h_box1 = new HBox();
        h_box1.setSpacing(5);
        h_box1.getChildren().addAll(btn_back, btn_next, lbl_time);

        // Grid Pane.
        gdp_template = new GridPane();

        // Mostrar la carta actual.
        createTemplate();

//        img_card = new Image("");

        // Contenedor.
        h_box2 = new HBox();
        h_box2.getChildren().addAll(gdp_template);

        // Botón jugar.
        btn_play = new Button("Jugar");
        btn_play.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Play event");
            }
        });
        btn_play.setPrefWidth(250);

        // Vertical box contenedor de botones y cartas.
        v_box = new VBox();
        v_box.getChildren().addAll(h_box1, h_box2, btn_play);

        // Vista principal.
        scene = new Scene(v_box, 350, 580);
    }

    private void createTemplate() {
        int current_images = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                BUTTONS[j][i] = new Button();
                File file = new File("src/main/java/sample/proyectoloteria/assets/" + IMAGES[current_images]);
                img_card_template = new Image(file.toURI().toString());
                image_view = new ImageView(img_card_template);
                image_view.setFitWidth(70);
                image_view.setFitHeight(120);
                BUTTONS[j][i].setGraphic(image_view);
                gdp_template.add(BUTTONS[j][i], i, j);

                current_images++;
            }
        }
    }
}
