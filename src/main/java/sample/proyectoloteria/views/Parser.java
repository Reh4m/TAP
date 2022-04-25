package sample.proyectoloteria.views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Parser extends Stage implements EventHandler<KeyEvent> {
    private Scene scene;
    private VBox v_box;
    private ToolBar toolbar_menu;
    private TextArea txt_input, txt_output;
    private FileChooser flc_file;
    private Button btn_open;
    private Image img_open;
    private ImageView imv_open;

    private final String IMAGES_PATH = "src/main/java/sample/proyectoloteria/assets/";

    public Parser() {
        createUI();
        this.setTitle("Traductor de código morse");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        v_box = new VBox();
        toolbar_menu = new ToolBar();
        img_open = getImage();
        imv_open = new ImageView(img_open);
        imv_open.setFitHeight(25);
        imv_open.setFitWidth(25);

        btn_open = new Button();
        btn_open.setGraphic(imv_open);
        btn_open.setOnAction(event -> {
            flc_file = new FileChooser();
            flc_file.setTitle("Buscar archivo...");
            File file = flc_file.showOpenDialog(this);
        });

        toolbar_menu.getItems().addAll(btn_open);

        txt_input = new TextArea();
        txt_input.setPromptText("Introduce el texto a parsear.");
        txt_input.setOnKeyPressed(this);

        txt_output = new TextArea();
        txt_output.setEditable(false);

        v_box.getChildren().addAll(toolbar_menu);
        v_box.setSpacing(5);
        v_box.setPadding(new Insets(5));

        scene = new Scene(v_box, 500, 300);
    }

    private Image getImage() {
        FileInputStream image = null;

        try {
            image = new FileInputStream(IMAGES_PATH + "7265_mail_open_icon.png");
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file.");
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return new Image(image);
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
    }
}
