package sample.proyectoloteria.classes;

import java.util.TimerTask;

public class TimerManagement extends TimerTask {
    private int i;
    private int count = 0;

    public TimerManagement(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        count++;
        System.out.println("sdf" + i);

        if (count > 10) {
            this.cancel();
        }
    }
}
