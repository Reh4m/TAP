package sample.proyectoloteria.events;

import javafx.event.Event;
import javafx.event.EventHandler;

public class ButtonPlayClicked implements EventHandler {
    public String message;

    public ButtonPlayClicked(String message) {
        this.message = message;
    }

    @Override
    public void handle(Event event) {
        System.out.println(message);
    }
}
