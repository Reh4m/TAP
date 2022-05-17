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

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser extends Stage implements EventHandler<KeyEvent> {
    private Scene scene;
    private VBox v_box;
    private ToolBar toolbar_menu;
    private TextArea txt_input, txt_output;
    private FileChooser flc_file;
    private Button btn_open_file;
    private Image img_open_file;
    private ImageView imv_open_file;

    private final Map<String, String> ALPHABET = new HashMap<>();

    private final String IMAGES_PATH = "src/main/java/sample/proyectoloteria/assets/";

    public Parser() {
        createUI();
        this.setTitle("Traductor de Código Morse");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        v_box = new VBox();

        toolbar_menu = new ToolBar();

        img_open_file = getImage();
        imv_open_file = new ImageView(img_open_file);
        imv_open_file.setFitHeight(25);
        imv_open_file.setFitWidth(25);

        btn_open_file = new Button();
        btn_open_file.setGraphic(imv_open_file);
        btn_open_file.setOnAction(event -> {
            selectFile();
        });

        toolbar_menu.getItems().addAll(btn_open_file);

        txt_input = new TextArea();
        txt_input.setPromptText("Introduce el texto a parsear");
        txt_input.setOnKeyPressed(this);

        txt_output = new TextArea();
        txt_output.setEditable(false);

        v_box.getChildren().addAll(toolbar_menu, txt_input, txt_output);
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

    private void selectFile() {
        flc_file = new FileChooser();
        flc_file.setTitle("Seleccionar archivo");

        File source = flc_file.showOpenDialog(this);

        System.out.println(readFile(source));
    }

    /**
     * Obtiene el texto (caracteres) a traducir del archivo especificado.
     *
     * El método useDelimiter establece el patrón de delimitación, esto al momento de coincicir con un salto de línea.
     *
     * Por último, añadimos los caracteres recuperados al contenido del TextArea.
     *
     * @param source archivo a escanear.
     * @return cadena de texto a ser traducido.
     */
    private String readFile(File source) {
        String content = null;

        try {
            content = new Scanner(source).useDelimiter("//Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        txt_input.appendText(content);

        return content;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
    }
}
