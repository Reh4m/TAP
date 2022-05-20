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
import java.util.*;

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
                writeToTextArea(convertTextToMorse());
            }
        });

        v_box.getChildren().addAll(toolbar_menu, txt_input, txt_output, btn_convert_text);
        v_box.setSpacing(5);
        v_box.setPadding(new Insets(5));

        scene = new Scene(v_box, 500, 300);
    }

    /**
     * Muestra un diálogo de apertura de archivos, el cual será nuestro archivo fuente que se quiere traducir.
     * Permite solamente abrir archivos de texto, dicho de otra forma, sólo aquellos archivos con extensión .txt serán
     * leídos.
     * Una vez seleccionado el archivo, se procede a obtener el texto dentro de él.
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
     * Acciones a ejecutar una vez que el archivo ha sido seleccionado.
     * Primero, borra el contenido dentro del TextArea de entrada para después poder insertar los caracteres recuperados
     * desde el archivo seleccionado anteriormente.
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

    /**
     * Busca la clave (letra) dentro del alfabeto del Código Morse y devuelve el valor al que está asignada dicha clave.
     *
     * @return una lista que contiene el texto traducido.
     */
    private ArrayList<String> convertTextToMorse() {
        ArrayList<String> words_in_morse = new ArrayList<>();

        // Convierte el texto dentro del TextArea de entrada a un arreglo de caracteres (letras).
        char[] text_letters = txt_input.getText().toCharArray();

        for (char letter : text_letters) {
            words_in_morse.add(alphabet.get(String.valueOf(letter).toUpperCase()) + " ");
        }

        return words_in_morse;
    }

    /**
     * Por medio de una lista, itera las 'palabras' del Código Morse y las inserta dentro del TextArea de salida.
     *
     * @param words_in_morse lista que contiene el texto a traducir.
     */
    private void writeToTextArea(List<String> words_in_morse) {
        for (String word : words_in_morse) {
            txt_output.appendText(word);
        }
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
    }
}
