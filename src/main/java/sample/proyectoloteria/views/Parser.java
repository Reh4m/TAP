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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.proyectoloteria.util.Images;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Parser extends Stage implements EventHandler<KeyEvent> {
    private Scene scene;
    private VBox v_box;
    private ToolBar toolbar_menu;
    private TextArea txt_input, txt_output;
    private FileChooser flc_file;
    private Button btn_open_file, btn_convert_text;
    private Image img_open_file;
    private ImageView imv_open_file;

    private final Map<String, String> alphabet = new HashMap<>();

    Properties properties = new Properties();

    public Parser() {
        // Instancia el contenido de la ventana.
        createUI();

        // Carga el alfabeto del Código Morse.
        loadProperties();

        this.setTitle("Traductor de Código Morse");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        v_box = new VBox();

        toolbar_menu = new ToolBar();

        img_open_file = Images.getImage("7265_mail_open_icon.png");
        imv_open_file = new ImageView(img_open_file);
        imv_open_file.setFitHeight(25);
        imv_open_file.setFitWidth(25);

        btn_open_file = new Button();
        btn_open_file.setGraphic(imv_open_file);
        btn_open_file.setOnAction(event -> selectFile());

        toolbar_menu.getItems().addAll(btn_open_file);

        txt_input = new TextArea();
        txt_input.setPromptText("Introduce el texto a parsear");
        txt_input.setOnKeyPressed(this);

        txt_output = new TextArea();
        txt_output.setEditable(false);

        btn_convert_text = new Button("Parsear");
        btn_convert_text.setPrefWidth(600);
        btn_convert_text.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("morse code");
            }
        });

        v_box.getChildren().addAll(toolbar_menu, txt_input, txt_output, btn_convert_text);
        v_box.setSpacing(5);
        v_box.setPadding(new Insets(5));

        scene = new Scene(v_box, 500, 300);
    }

    private void selectFile() {
        flc_file = new FileChooser();
        flc_file.setTitle("Seleccionar archivo");

        File source = flc_file.showOpenDialog(this);

        System.out.println(readFile(source));
    }

    /**
     * Recupera el texto (caracteres) a traducir escaneando el contenido del archivo especificado.
     * Posteriormente, inserta los caracteres recuperados al contenido del TextArea.
     *
     * @param source archivo a escanear.
     * @return cadena de texto a ser traducido.
     */
    private String readFile(File source) {
        String content = null;

        try {
            // El método useDelimiter establece el patrón de delimitación, esto al momento de coincicir con un salto de
            // línea al escanear el archivo de texto.
            content = new Scanner(source).useDelimiter("//Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Agrega el texto al contenido del TextArea de entrada.
        txt_input.appendText(content);

        return content;
    }

    /**
     * Lee la lista de propiedades (alfabeto del Código Morse) y lo carga al objeto properties.
     * Posteriormente, haciendo uso de la interfaz Map, asigna la colección de claves (letras) y valores (código morse)
     * recuperados desde properties y los asocia a la clase HashMap alphabet.
     */
    private void loadProperties() {
        try {
            File properties_file = new File("src/main/resources/alphabet.properties");

            // Carga de propiedades.
            properties.load(new FileReader(properties_file));
        }  catch (IOException e) {
            e.printStackTrace();
        }

        // Asignación de claves y valores.
        for (String letter : properties.stringPropertyNames()) {
            alphabet.put(letter, properties.getProperty(letter));
        }
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
    }
}
