package sample.proyectoloteria.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver extends Stage {
    private Scene scene;
    VBox v_box_container;
    Text text1, text2;

    /**
     * La ventana mostrará un mensaje al momento de terminar el juego. El juego termina una vez que resulta una tabla
     * ganadora, así mismo, el juego puede terminar cuando las cartas del mazo se han acabado y ninguna tabla resultó
     * ganadora.
     *
     * @param message1 o texto principal, es el mensaje que indica la forma en que terminó el juego.
     * @param message2 es el texto por debajo del principal, aporta información extra al mensaje principal.
     **/
    public GameOver(String message1, String message2) {
        createUI(message1, message2);
        this.setTitle("Juego terminado");
        this.setScene(scene);
        this.show();
    }

    private void createUI(String message1, String message2) {
        text1 = new Text();
        text1.setText(message1);
        text1.setFont(Font.font("Malgun Gothic", FontWeight.BOLD, FontPosture.REGULAR, 46));
        text1.setFill(Color.rgb(254, 249, 239));

        text2 = new Text();
        text2.setText(message2);
        text2.setFont(Font.font("Malgun Gothic", FontWeight.BOLD, FontPosture.REGULAR, 24));
        text2.setFill(Color.rgb(254, 249, 239));

        // Layout principal.
        v_box_container = new VBox();
        v_box_container.setAlignment(Pos.CENTER);
        v_box_container.getStyleClass().add("bg-6");
        v_box_container.getChildren().addAll(text1, text2);

        // Vista principal.
        scene = new Scene(v_box_container, 450, 300);
        // Hoja de estilos CSS.
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("/style.css")));
    }
}
