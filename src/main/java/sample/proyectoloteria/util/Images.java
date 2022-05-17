package sample.proyectoloteria.util;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Images {
    /**
     *  Se utiliza para cargar imágenes desde una URL especificada.
     *
     * @param url para obtener los datos de la imagen cargada.
     * @return una imagen gráfica de la clase Image.
     */
    public static Image getImage(String url) {
        FileInputStream image = null;

        try {
            String images_path = "src/main/java/sample/proyectoloteria/assets/";

            image = new FileInputStream(images_path + url);
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file.");
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return new Image(image);
    }
}
