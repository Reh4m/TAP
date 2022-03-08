package sample.proyectoloteria.events;

import javafx.event.Event;
import javafx.event.EventHandler;

public class ButtonPlayClicked implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println("Play event");
    }
}
