package sample.proyectoloteria.classes;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Card {
    private String card_name;
    private String image_name;
    private int id;

    /**
     * Define las coordenadas donde se encuentra ubicada la carta en el tablero.
     **/
    private int axis_x;
    private int axis_y;

    /**
     * Define el índice de la carta al momento de ser añadido a una plantilla.
     *
     * Este nos ayudará a saber dónde se encuentra una carta dentro de una plantilla cualquiera.
     **/
    private int index_card_added;

    private final String IMAGES_PATH = "src/main/java/sample/proyectoloteria/assets/";

    /**
     * @param card_name nombre propio de la carta,
     * @param image_name nombre del archivo (imagen),
     * @param id número con el que se identifica una carta a las demás.
     **/
    public Card(String card_name, String image_name, int id) {
        setAll(card_name, image_name, id);
    }

    /**
     * Getters y setters.
     **/
    public void setAll(String card_name, String image_name, int id) {
        setCardName(card_name);
        setImageName(image_name);
        setId(id);
    }

    public String getCardName() {
        return card_name;
    }

    public void setCardName(String card_name) {
        this.card_name = card_name;
    }

    public String getImageName() {
        return image_name;
    }

    public void setImageName(String image_name) {
        this.image_name = image_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene un objeto Image correspondiente a la carta definida en el objeto Card.
     *
     * @return el objeto Image (carta) para ser visualizado por pantalla.
     **/
    public Image getImage() {
        FileInputStream image = null;

        try {
            image = new FileInputStream(IMAGES_PATH + this.image_name);
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file.");
            System.exit(0);
        }

        return new Image(image);
    }

    /**
     * Establece la ubicación de la carta en la plantilla.
     **/
    public void setCardCoords(int axis_x, int axis_y) {
        setAxisX(axis_x);
        setAxisY(axis_y);
    }

    public int getAxisX() {
        return axis_x;
    }

    public void setAxisX(int axis_x) {
        this.axis_x = axis_x;
    }

    public int getAxisY() {
        return axis_y;
    }

    public void setAxisY(int axis_y) {
        this.axis_y = axis_y;
    }

    public int getIndexCardAdded() {
        return index_card_added;
    }

    public void setIndexCardAdded(int index_card_added) {
        this.index_card_added = index_card_added;
    }

    @Override
    public String toString() {
        return "Carta #" + id + ": " + card_name + " (" + image_name + ").";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card that = (Card) o;
        return
            Objects.equals(card_name, that.card_name) &&
            Objects.equals(image_name, that.image_name) &&
            Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(card_name, image_name, getId());
    }
}
