package sample.proyectoloteria.classes;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Card {
    private String card_name;
    private String image_name;
    private int id;

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
