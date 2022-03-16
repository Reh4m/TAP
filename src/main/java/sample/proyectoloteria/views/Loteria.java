package sample.proyectoloteria.views;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.proyectoloteria.classes.Card;
import sample.proyectoloteria.models.LoteriaImages;

import java.util.Timer;
import java.util.TimerTask;

public class Loteria extends Stage {
    private VBox v_box;
    private HBox h_box1, h_box2, h_box3;
    private Button btn_prev, btn_next, btn_play;
    private Label lbl_time;
    private GridPane gdp_board, gdp_card;
    private Scene scene;
    private ImageView image_view;
    private Timeline time_line;
    private Timer timer;

    /**
     * Define el número actual de la plantilla en uso.
     **/
    private int current_board = 0;

    /**
     * Define el número actual de la carta mostrada en el mazo.
     **/
    private int current_card_image = 0;

    /**
     *  Proporciona los datos de la carta actual que se muestra en el mazo.
     **/
    private Card current_card_data;

    private final Integer START_TIME = 15;
    private final IntegerProperty time_seconds = new SimpleIntegerProperty(START_TIME);

    private final Card[] CARDS = LoteriaImages.getRandomCards();

    public Loteria() {
        createUI();
        this.setTitle("Loteria");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        // Manejar la plantilla anterior.
        btn_prev = new Button("Atrás");
        btn_prev.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                prevBoard();

                renderBoard();
            }
        });
        btn_prev.setPrefWidth(100);
        // Manejar la plantilla siguiente.
        btn_next = new Button("Siguiente");
        btn_next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nextBoard();

                renderBoard();
            }
        });
        btn_next.setPrefWidth(100);

        // Marcador de tiempo para cambiar de carta.
        lbl_time = new Label();
        lbl_time.textProperty().bind(time_seconds.asString());

        // Contenedor de botones controladores.
        h_box1 = new HBox();
        h_box1.setSpacing(5);
        h_box1.setAlignment(Pos.CENTER);
        h_box1.getChildren().addAll(btn_prev, btn_next, lbl_time);

        // Grid Pane para las plantillas.
        gdp_board = new GridPane();

        // Grid Pane para las cartas.
        gdp_card = new GridPane();

        // Muestra la primer plantilla (0).
        renderBoard();

        // Muestra la primer carta del mazo.
        renderCard();

        // Contenedor de las plantillas y las cartas.
        h_box2 = new HBox();
        h_box2.setAlignment(Pos.CENTER);
        h_box2.getChildren().addAll(gdp_board, gdp_card);

        // Botón jugar.
        // Empieza a sacar cartas del mazo y deshabilita el boton cuando este es presionado.
        btn_play = new Button("Jugar");
        btn_play.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btn_play.setDisable(true);

                changeCardTimer();
            }
        });
        btn_play.setPrefWidth(250);

        // Contenedor del botón jugar.
        h_box3 = new HBox();
        h_box3.setSpacing(5);
        h_box3.setAlignment(Pos.CENTER);
        h_box3.getChildren().addAll(btn_play);

        // Layout principal.
        // Contiene a los botones, plantillas y cartas.
        v_box = new VBox();
        v_box.getChildren().addAll(h_box1, h_box2, h_box3);

        // Vista principal.
        scene = new Scene(v_box, 800, 600);
    }

    /**
     * Muestra en pantalla la plantilla del número actual con la ayuda de un GridPane.
     *
     * Las plantillas se obtienen de la clase LoteriaImages en la cual están establecidas las plantillas con su
     * respectivo objeto carta (Card), el cual servirá para poder comparar cartas posteriormente.
     *
     * Al momento de seleccionar una carta de la plantilla se lanzará el método para comparar las cartas actuales.
     **/
    private void renderBoard() {
        int rows = 0, cols = 0;

        for (Card card : LoteriaImages.BOARDS[current_board]) {
            image_view = new ImageView(card.getImage());
            image_view.setFitWidth(70);
            image_view.setFitHeight(120);
            image_view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    handleCardClicked(card);
                }
            });

            if (rows == 4) {
                cols++;
                rows = 0;
            }

            gdp_board.add(image_view, cols, rows);

            rows++;
        }
    }

    /**
     * Llama al método validateCards y, en caso de que la igualdad sea verdadera, vuelve a cargar la plantilla
     * completa con la diferencia de que la carta seleccionada ahora queda inhabilitada. En caso contrario solamente
     * mostrará un mensaje por pantalla.
     *
     * @param card_clicked objeto Card con la información de la carta que fue seleccionada.
     **/
    private void handleCardClicked(Card card_clicked) {
        if (validateCards(card_clicked)) {
            LoteriaImages.disableSelectedCard(card_clicked, current_board);

            renderBoard();
        } else {
            System.out.println("Card not match.");
        }
    }

    /**
     * Disminuye el índice de la plantilla que será mostrada.
     *
     * Cuando el índice llega a cero se regresa a la última plantilla.
     **/
    private void prevBoard() {
        current_board--;

        if (current_board < 0) current_board = 4;
    }

    /**
     * Aumenta el índice de la plantilla que será mostrada.
     *
     * Cuando el índice llegue a cuatro se regresa a la primer plantilla.
     **/
    private void nextBoard() {
        current_board++;

        if (current_board > 4) current_board = 0;
    }

    /**
     * Muestra en pantalla las cartas del mazo.
     *
     * current_card_data se encarga de guardar los datos de la carta actual del mazo para posteriormente compararla.
     **/
    private void renderCard() {
        image_view = new ImageView((CARDS[current_card_image].getImage()));
        image_view.setFitWidth(280);
        image_view.setFitHeight(480);
        gdp_card.add(image_view, 0, 0);

        current_card_data = CARDS[current_card_image];
    }

    /**
     * Cambia a la siguiente carta del mazo.
     **/
    private void changeCard() {
        current_card_image++;

        renderCard();
    }

    /**
     *  Válida la igualdad de la carta seleccionada en la plantilla con la carta actual mostrada en el mazo.
     *
     * @param board_card carta seleccionada en la plantilla.
     *
     * @return verdadero o falso si las cartas son iguales.
     **/
    private Boolean validateCards(Card board_card) {
        return board_card.equals(current_card_data);
    }

    /**
     * Muestra una cuenta regresiva de 15 segundos, el cual indica el tiempo dado para ir marcando cartas con la carta
     * actual que aparecen el mazo.
     **/
    private void startCountDownTimer() {
        if (time_line != null) time_line.stop();

        time_seconds.set(START_TIME);

        time_line = new Timeline();
        time_line.getKeyFrames().add(
            new KeyFrame(Duration.seconds(START_TIME + 1),
            new KeyValue(time_seconds, 0))
        );
        time_line.playFromStart();
    }

    /**
     * Empieza a sacar las cartas del mazo (arreglo de cartas) cada 15 segundos. El proceso se cicla hasta que haya
     * terminado de mostrar todas las cartas y, una vez llegado ese momento, el timer se detiene y el botón jugar se
     * vuelve a habilitar.
     **/
    private void changeCardTimer() {
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (current_card_image < CARDS.length) {
                    Platform.runLater(() -> {
                        changeCard();

                        startCountDownTimer();
                    });
                } else {
                    timer.cancel();
                    btn_play.setDisable(false);
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 15000);
    }
}
