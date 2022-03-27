package sample.proyectoloteria.views;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.proyectoloteria.classes.Card;
import sample.proyectoloteria.models.LoteriaImages;

import java.util.Timer;
import java.util.TimerTask;

public class Loteria extends Stage {
    private Scene scene;
    private VBox v_box_container, v_box_board, v_box_card;
    private HBox h_box_title, h_box_buttons, h_box_timer, h_box2, h_box3;
    private Button btn_prev, btn_next, btn_play;
    private Label lbl_time;
    private GridPane gdp_board, gdp_card;
    private ImageView image_view;
    private Font font;
    private Text title;
    private Timeline time_line;
    private final Timer timer = new Timer();

    /**
     * Define el número actual de la plantilla en uso.
     **/
    private int current_board = 0;

    /**
     * Define el número actual de la carta mostrada en el mazo.
     **/
    private int current_card_image = 0;

    /**
     * Proporciona los datos de la carta actual que se muestra en el mazo.
     **/
    private Card current_card_data;

    /**
     * Indica si el juego está activo o ya ha comenzado, por defecto está inactivo.
     **/
    private boolean is_active = false;

    private final Integer START_TIME = 15;
    private final IntegerProperty time_seconds = new SimpleIntegerProperty(START_TIME);

    private final Card[] CARDS = LoteriaImages.getRandomCards();

    public Loteria() {
        createUI();
        this.setTitle("Loteria Mexicana");
        this.setMaximized(true);
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        // Título.
        font = Font.loadFont("file:src/main/resources/fonts/Lobster-Regular.ttf", 64);
        title = new Text("Juego Loteria Mexicana");
        title.setFont(font);
        title.setFill(Color.rgb(208, 71, 100));

        // HBox contenedor del título.
        h_box_title = new HBox();
        h_box_title.setAlignment(Pos.CENTER);
        h_box_title.setPadding(new Insets(15, 0, 15, 0));
        h_box_title.getChildren().add(title);

        // Botón regresar a la plantilla anterior.
        btn_prev = new Button("Atrás");
        btn_prev.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                prevBoard();
            }
        });
        btn_prev.setPrefWidth(100);
        // Botón ir a la plantilla siguiente.
        btn_next = new Button("Siguiente");
        btn_next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nextBoard();
            }
        });
        btn_next.setPrefWidth(100);

        // Marcador de tiempo para cambiar de carta.
        lbl_time = new Label();
        lbl_time.textProperty().bind(time_seconds.asString());

        // Contenedor del contador de tiempo (label_time).
        h_box_timer = new HBox();
        h_box_timer.setAlignment(Pos.CENTER);
        h_box_timer.getChildren().add(lbl_time);

        // Contenedor de botones 'siguiente' y 'atrás'.
        h_box_buttons = new HBox();
        h_box_buttons.setSpacing(5);
        h_box_buttons.setAlignment(Pos.CENTER);
        h_box_buttons.getChildren().addAll(btn_prev, btn_next);

        // GridPane para las plantillas.
        gdp_board = new GridPane();
        gdp_board.setPadding(new Insets(15, 15, 15, 15));
        gdp_board.setHgap(15);
        gdp_board.setVgap(15);

        // Contenedor de las plantillas y los botones 'siguiente' y 'atrás'.
        v_box_board = new VBox();
        v_box_board.getChildren().addAll(h_box_buttons, gdp_board);

        // GridPane para las cartas.
        gdp_card = new GridPane();
        gdp_card.setPadding(new Insets(15, 15, 15, 15));
        gdp_card.setHgap(15);
        gdp_card.setVgap(15);

        // Contenedor del mazo y del timer para cambiar de carta.
        v_box_card = new VBox();
        v_box_card.getChildren().addAll(h_box_timer, gdp_card);

        // Muestra la primera plantilla (0).
        renderBoard();

        // Muestra la primera carta del mazo (0).
        renderCard();

        // Contenedor de las plantillas, cartas y sus controladores.
        h_box2 = new HBox();
        h_box2.setAlignment(Pos.CENTER);
        h_box2.getChildren().addAll(v_box_board, v_box_card);

        // Botón jugar.
        // Empieza a sacar cartas del mazo y deshabilita el botón cuando este es presionado.
        btn_play = new Button("Jugar");
        btn_play.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btn_play.setDisable(true);
                is_active = true;

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
        // Contiene el título, plantillas, cartas y sus respectivos botones.
        v_box_container = new VBox();
        v_box_container.getStyleClass().add("bg-3");
        v_box_container.getChildren().addAll(h_box_title, h_box2, h_box3);

        // Ventana principal.
        scene = new Scene(v_box_container, 800, 600);
        // Hoja de estilos CSS.
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("/style.css")));
    }

    /**
     * Muestra en pantalla la plantilla del número actual con la ayuda de un GridPane.
     *
     * Las plantillas se obtienen de la clase LoteriaImages previamente ya definidas las plantillas con su
     * respectivo objeto carta (Card), el cual servirá para poder comparar cartas posteriormente.
     *
     * Dentro de la clase Card se guardan datos como la posición donde se encuentra ubicada la carta en la plantilla,
     * así como el índice en el que este fue agregado a la plantilla.
     *
     * Al momento de seleccionar una carta de la plantilla se lanzará el método para comparar las cartas actuales.
     **/
    private void renderBoard() {
        // row y col establecen la posición de una carta dentro de la plantilla.
        // counter se encarga de iterar el número de cartas añadidas a la plantilla.
        int row = 0, col = 0, counter = 0;

        gdp_board.getChildren().clear();

        for (Card card : LoteriaImages.BOARDS[current_board]) {
            // Al llegar a la cuarta fila se pasa a la siguiente columna desde la fila 0 nuevamente.
            if (row == 4) {
                col++;
                row = 0;
            }

            // Se establecen los datos de la carta dentro de la plantilla.
            card.setIndexCardAdded(counter);
            card.setCardCoords(col, row);

            image_view = new ImageView(card.getImage());
            image_view.setFitWidth(70);
            image_view.setFitHeight(120);
            image_view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (is_active) handleCardClicked(card);
                }
            });

            gdp_board.add(image_view, col, row);

            // Por cada iteración las filas aumentan hasta llegar a 4.
            row++;
            // El contador de cartas aumenta.
            counter++;
        }
    }

    /**
     * Llama al método validateCards y, en caso de que la igualdad sea verdadera, reescribe el GridPane solamente en la
     * posición donde se encuentra la carta seleccionada, inhabilitando a la misma. Posteriormente verifica si la
     * plantilla actual cuenta con todas sus cartas deshabilitadas, lo cual quiere decir que la plantilla ya ha ganado
     * y el juego ha terminado, mostrando así un mensaje de victoria.
     *
     * En caso contrario, si la carta seleccionada no es igual a la carta mostrada en el mazo, solamente mostrará un
     * mensaje por pantalla.
     *
     * @param card_clicked objeto Card con la información de la carta que fue seleccionada.
     **/
    private void handleCardClicked(Card card_clicked) {
        if (validateCards(card_clicked)) {
            LoteriaImages.disableSelectedCard(card_clicked, current_board);

            image_view = new ImageView(LoteriaImages.getDisableCard().getImage());
            image_view.setFitWidth(70);
            image_view.setFitHeight(120);

            gdp_board.add(image_view, card_clicked.getAxisX(), card_clicked.getAxisY());

            if (checkIfUserWon()) {
                timer.cancel();
                time_line.stop();
                is_active = false;
                btn_play.setText("Juego terminado");
                showWinnerMessage();
            }
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

        renderBoard();
    }

    /**
     * Aumenta el índice de la plantilla que será mostrada.
     *
     * Cuando el índice llegue a cuatro se regresa a la primer plantilla.
     **/
    private void nextBoard() {
        current_board++;

        if (current_board > 4) current_board = 0;

        renderBoard();
    }

    /**
     * Muestra en pantalla las cartas del mazo.
     *
     * current_card_data se encarga de guardar los datos de la carta actual del mazo para posteriormente compararla.
     **/
    private void renderCard() {
        image_view = new ImageView((CARDS[current_card_image].getImage()));
        image_view.setFitWidth(320);
        image_view.setFitHeight(525);
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
     * Muestra una cuenta regresiva de 15 segundos, el cual indica el tiempo dado para comparar una carta de la
     * plantilla con la actual mostrada en el mazo.
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
     * terminado de mostrar todas las cartas o cuando una tabla resulte ganadora, una vez llegado ese momento el timer
     * se detiene.
     *
     * Si todas las cartas del mazo ya han sido mostradas quiere decir que ninguna tabla ganó, por lo tanto se muestra
     * un mensaje de que ninguna tabla resultó ganadora y el juego ya ha terminado.
     **/
    private void changeCardTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (current_card_image < CARDS.length - 1) {
                    Platform.runLater(() -> {
                        changeCard();

                        startCountDownTimer();
                    });
                } else {
                    Platform.runLater(() -> {
                        timer.cancel();
                        is_active = false;
                        btn_play.setText("Juego terminado");
                        showGameOverMessage();
                    });
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 15000);
    }

    /**
     * Verifica si una plantilla ya ganó comprobando el estatus de sus cartas (cartas deshabilitadas).
     *
     * @return verdadero o falso al comparar las cartas deshabilitadas con el número total de cartas en la plantilla.
     **/
    private boolean checkIfUserWon() {
        int disabled_cards = 0;

        // Recorre todas las cartas de la plantilla actual y va sumando el número de cartas deshabilitadas que tiene la
        // plantilla.
        for (Card card : LoteriaImages.BOARDS[current_board]) {
            if (card.getStatusCard()) disabled_cards++;
        }

        // Si el número de cartas deshabilitadas es igual al número de cartas de la plantilla (16), quiere decir que
        // todas las cartas de la plantilla ya fueron seleccionadas y mostradas en el mazo, obteniendo así un ganador.
        // Caso contrario, todas las cartas de la plantilla aún no son seleccionadas o mostradas en el maso, por lo
        // tanto la plantilla aún no gana.
        return disabled_cards == LoteriaImages.BOARDS[0].length;
    }

    /**
     * Muestra una ventana al momento de que una tabla resulta ganadora. Aporta un mensaje de victoria con el número de
     * tabla que ganó.
     **/
    private void showWinnerMessage() {
        String message1, message2;

        message1 = "¡Felicidades!";
        message2 = "Tabla #" + (current_board + 1) + " ha ganado la partida";

        new GameOver(message1, message2);
    }

    /**
     * Muestra una ventana al momento de que todas las cartas del mazo ya fueron mostradas y no se obtuvo una tabla
     * ganadora.
     **/
    private void showGameOverMessage() {
        String message1, message2;

        message1 = "¡Juego terminado!";
        message2 = "Ninguna tabla resultó ganadora";

        new GameOver(message1, message2);
    }
}
