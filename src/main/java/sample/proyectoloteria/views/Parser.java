package sample.proyectoloteria.views;

import javafx.application.Platform;
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
import sample.proyectoloteria.util.Images;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Parser extends Stage implements EventHandler<KeyEvent> {
    private Scene scene;
    private VBox v_box_container;
    private ToolBar toolbar_menu;
    private TextArea txt_input, txt_output;
    private FileChooser flc_file;
    private Button btn_open_file, btn_convert_text;
    private Image img_open_file;
    private ImageView imv_open_file;

    // Alfabeto Morse.
    // Guarda la letra del abecedario como la clave y su respectiva traducción a código Morse como el valor.
    private final Map<String, String> alphabet = new HashMap<>();

    Properties properties = new Properties();

    public Parser() {
        // Instancia el contenido de la ventana.
        createUI();

        // Carga el alfabeto Morse.
        loadProperties();

        this.setTitle("Traductor de código Morse");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        // Imagen o icono para el botón de apertura de archivos.
        img_open_file = Images.getImage("7265_mail_open_icon.png");
        imv_open_file = new ImageView(img_open_file);
        imv_open_file.setFitHeight(25);
        imv_open_file.setFitWidth(25);

        // Botón para seleccionar el archivo a traducir.
        btn_open_file = new Button();
        btn_open_file.setGraphic(imv_open_file);
        btn_open_file.setOnAction(event -> selectFile());

        // ToolBar contenedor del botón de apertura de archivos.
        toolbar_menu = new ToolBar();
        toolbar_menu.getItems().addAll(btn_open_file);

        // TextArea de entrada, contiene el texto a traducir.
        txt_input = new TextArea();
        txt_input.setPromptText("Introduce el texto a parsear");
        txt_input.setOnKeyPressed(this);

        // TextArea de salida, contiene el texto traducido a código Morse.
        txt_output = new TextArea();
        txt_output.setEditable(false);

        // Botón para mostrar la traducción a código Morse del texto escrito.
        btn_convert_text = new Button("Parsear");
        btn_convert_text.setPrefWidth(600);
        btn_convert_text.setOnAction(event -> writeTextToMorse());

        // Layout principal.
        // Contiene el ToolBar con su respectivo botón, los TextArea de entrada y salida, y el botón para traducir el
        // texto a código Morse.
        v_box_container = new VBox();
        v_box_container.getChildren().addAll(toolbar_menu, txt_input, txt_output, btn_convert_text);
        v_box_container.setSpacing(5);
        v_box_container.setPadding(new Insets(5));

        // Ventana principal.
        scene = new Scene(v_box_container, 500, 300);
    }

    /**
     * Muestra un diálogo de apertura de archivos, el cual será nuestro archivo fuente que se quiere traducir.
     * Permite solamente abrir archivos de texto, dicho de otra forma, sólo aquellos archivos con extensión .txt serán
     * leídos. Una vez seleccionado el archivo, se procede a obtener el texto dentro de él.
     */
    private void selectFile() {
        flc_file = new FileChooser();
        flc_file.setTitle("Seleccionar archivo");
        flc_file.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        File source = flc_file.showOpenDialog(this);

        if (source != null) onFileSelected(source);
    }

    /**
     * Acciones a ejecutar una vez que el archivo ha sido seleccionado. Primero, borra el contenido dentro del TextArea
     * de entrada para después poder insertar los caracteres recuperados desde el archivo seleccionado anteriormente.
     *
     * @param source archivo a escanear.
     */
    private void onFileSelected(File source) {
        txt_input.clear();

        txt_input.appendText(readFile(source));
    }

    /**
     * Recupera el texto (caracteres) a traducir escaneando el contenido del archivo especificado.
     *
     * @param source archivo a escanear.
     * @return cadena de texto a ser traducido.
     */
    private String readFile(File source) {
        String content = null;

        try {
            // El método useDelimiter establece el patrón de delimitación, esto al momento de coincidir con un salto de
            // línea al escanear el archivo de texto.
            content = new Scanner(source).useDelimiter("//Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return content;
    }

    /**
     * Lee la lista de propiedades (alfabeto Morse) y lo carga al objeto properties. Posteriormente, haciendo uso de la
     * interfaz Map, asigna la colección de claves (letras) y valores (código morse) recuperados desde properties y los
     * asocia a la clase HashMap alphabet.
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

    /**
     * Crea una lista en la cual se guarda el texto traducido a código Morse. Este se obtiene al buscar cada letra del
     * texto en el alfabeto Morse y devolver su respectiva traducción.
     *
     * @return una lista que contiene el texto traducido.
     */
    private ArrayList<String> convertTextToMorse() {
        ArrayList<String> words_in_morse = new ArrayList<>();

        // Convierte el texto dentro del TextArea de entrada a un arreglo de caracteres (letras).
        char[] text_letters = txt_input.getText().toCharArray();

        for (char letter : text_letters) {
            words_in_morse.add(getMorseAlphabetWord(letter) + " ");
        }

        return words_in_morse;
    }

    /**
     * Busca la clave (letra) dentro del alfabeto Morse y devuelve el valor al que está asignada dicha clave.
     *
     * @param letter letra a buscar en el alfabeto Morse.
     * @return el código Morse correspondiente a la letra.
     */
    private String getMorseAlphabetWord(char letter) {
        String morse_word = alphabet.get(String.valueOf(letter).toUpperCase());

        return morse_word != null ? morse_word : "";
    }

    /**
     * Por medio de una lista, itera las 'palabras' del código Morse y las inserta dentro del TextArea de salida.
     *
     * @param words_in_morse lista que contiene el texto a traducir.
     */
    private void writeToTextArea(List<String> words_in_morse) {
        for (String morse_word : words_in_morse) {
            txt_output.appendText(morse_word);
        }
    }

    /**
     * En términos generales, traduce el texto que contiene el TextArea de entrada y muestra su respectiva traducción a
     * código Morse en el TextArea de salida, aunque realmente cada una de estas acciones tiene su respectivo método
     * que es llamado dentro del bloque de código.
     */
    private void writeTextToMorse() {
        txt_output.clear();

        writeToTextArea(convertTextToMorse());
    }

    @Override
    public void handle(KeyEvent event) {
        // Crea un hilo de ejecución esperando a que cada sentencia asignada finalice y poder realizar futuras acciones
        // que dependen de eventos pasados.
        Platform.runLater(this::writeTextToMorse);
    }
}
