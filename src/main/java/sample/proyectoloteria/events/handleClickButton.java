package sample.proyectoloteria.events;

import javafx.event.Event;
import javafx.event.EventHandler;

public class handleClickButton implements EventHandler {
    public String message;

    public handleClickButton(String message) {
        this.message = message;
    }

    @Override
    public void handle(Event event) {
        System.out.println(message);
    }
}
