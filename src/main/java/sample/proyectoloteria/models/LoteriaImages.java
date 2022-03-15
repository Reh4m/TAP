package sample.proyectoloteria.models;

import sample.proyectoloteria.classes.Card;

public class LoteriaImages {
    /**
     * Total de plantillas que serán usadas por el jugador.
     *
     * Se guardan en la clase Card para obtener información de la misma cuando sea requerido.
     **/
    public static Card[][] BOARDS = {
        {
            new Card("bandolon", "bandolon.jpg", 1),
            new Card("barril", "barril.jpeg", 2),
            new Card("botella", "botella.jpeg", 3),
            new Card("campana", "campana.jpg", 4),
            new Card("catrin", "catrin.jpeg", 5),
            new Card("chalupa", "chalupa.jpg", 6),
            new Card("chavorruco", "chavorruco.jpeg", 7),
            new Card("concha", "concha.jpeg", 8),
            new Card("corazon", "corazon.jpg", 9),
            new Card("corona", "corona.jpg", 10),
            new Card("cotorro", "cotorro.jpg", 11),
            new Card("estrella", "estrella.jpg", 12),
            new Card("graduada", "graduada.jpeg", 13),
            new Card("luchador", "luchador.jpeg", 14),
            new Card("maceta", "maceta.jpeg", 15),
            new Card("negro", "negro.jpg", 16),
        }, {
            new Card("venado", "venado.jpeg", 25),
            new Card("valiente", "valiente.jpg", 24),
            new Card("tambor", "tambor.jpg", 23),
            new Card("tacos", "tacos.jpeg", 22),
            new Card("soldado", "soldado.jpg", 21),
            new Card("sandia", "sandia.jpg", 20),
            new Card("rosa", "rosa.jpeg", 19),
            new Card("rana", "rana.jpg", 18),
            new Card("pescado", "pescado.jpg", 17),
            new Card("negro", "negro.jpg", 16),
            new Card("maceta", "maceta.jpeg", 15),
            new Card("luchador", "luchador.jpeg", 14),
            new Card("graduada", "graduada.jpeg", 13),
            new Card("estrella", "estrella.jpg", 12),
            new Card("cotorro", "cotorro.jpg", 11),
            new Card("corona", "corona.jpg", 10),
    }, {
            new Card("corazon", "corazon.jpg", 9),
            new Card("concha", "concha.jpeg", 8),
            new Card("chavorruco", "chavorruco.jpeg", 7),
            new Card("chalupa", "chalupa.jpg", 6),
            new Card("catrin", "catrin.jpeg", 5),
            new Card("campana", "campana.jpg", 4),
            new Card("botella", "botella.jpeg", 3),
            new Card("barril", "barril.jpeg", 2),
            new Card("bandolon", "bandolon.jpg", 1),
            new Card("venado", "venado.jpeg", 25),
            new Card("valiente", "valiente.jpg", 24),
            new Card("tambor", "tambor.jpg", 23),
            new Card("tacos", "tacos.jpeg", 22),
            new Card("soldado", "soldado.jpg", 21),
            new Card("sandia", "sandia.jpg", 20),
            new Card("rosa", "rosa.jpeg", 19),
    }, {
            new Card("rana", "rana.jpg", 18),
            new Card("pescado", "pescado.jpg", 17),
            new Card("negro", "negro.jpg", 16),
            new Card("maceta", "maceta.jpeg", 15),
            new Card("luchador", "luchador.jpeg", 14),
            new Card("graduada", "graduada.jpeg", 13),
            new Card("estrella", "estrella.jpg", 12),
            new Card("cotorro", "cotorro.jpg", 11),
            new Card("corona", "corona.jpg", 10),
            new Card("corazon", "corazon.jpg", 9),
            new Card("concha", "concha.jpeg", 8),
            new Card("chavorruco", "chavorruco.jpeg", 7),
            new Card("chalupa", "chalupa.jpg", 6),
            new Card("catrin", "catrin.jpeg", 5),
            new Card("campana", "campana.jpg", 4),
            new Card("botella", "botella.jpeg", 3),
    }, {
            new Card("barril", "barril.jpeg", 2),
            new Card("bandolon", "bandolon.jpg", 1),
            new Card("venado", "venado.jpeg", 25),
            new Card("valiente", "valiente.jpg", 24),
            new Card("tambor", "tambor.jpg", 23),
            new Card("tacos", "tacos.jpeg", 22),
            new Card("soldado", "soldado.jpg", 21),
            new Card("sandia", "sandia.jpg", 20),
            new Card("rosa", "rosa.jpeg", 19),
            new Card("rana", "rana.jpg", 18),
            new Card("pescado", "pescado.jpg", 17),
            new Card("negro", "negro.jpg", 16),
            new Card("maceta", "maceta.jpeg", 15),
            new Card("luchador", "luchador.jpeg", 14),
            new Card("graduada", "graduada.jpeg", 13),
            new Card("estrella", "estrella.jpg", 12),
        }
    };

    /**
     * Cartas que serán utilizadas en el mazo.
     **/
    public final static Card[] CARDS = {
            new Card("bandolon", "bandolon.jpg", 1),
            new Card("barril", "barril.jpeg", 2),
            new Card("botella", "botella.jpeg", 3),
            new Card("campana", "campana.jpg", 4),
            new Card("catrin", "catrin.jpeg", 5),
            new Card("chalupa", "chalupa.jpg", 6),
            new Card("chavorruco", "chavorruco.jpeg", 7),
            new Card("concha", "concha.jpeg", 8),
            new Card("corazon", "corazon.jpg", 9),
            new Card("corona", "corona.jpg", 10),
            new Card("cotorro", "cotorro.jpg", 11),
            new Card("estrella", "estrella.jpg", 12),
            new Card("graduada", "graduada.jpeg", 13),
            new Card("luchador", "luchador.jpeg", 14),
            new Card("maceta", "maceta.jpeg", 15),
            new Card("negro", "negro.jpg", 16),
            new Card("pescado", "pescado.jpg", 17),
            new Card("rana", "rana.jpg", 18),
            new Card("rosa", "rosa.jpeg", 19),
            new Card("sandia", "sandia.jpg", 20),
            new Card("soldado", "soldado.jpg", 21),
            new Card("tacos", "tacos.jpeg", 22),
            new Card("tambor", "tambor.jpg", 23),
            new Card("valiente", "valiente.jpg", 24),
            new Card("venado", "venado.jpeg", 25)
    };

    /**
     * Deshabilita la carta de la plantilla previamente seleccionada y verificada su igualdad con la carta actual del
     * mazo.
     *
     * @param old_card objeto Card que será inhabilitada.
     * @param row índice o fila donde se encuentra la carta dentro de la matriz de plantillas.
     **/
    public static void disableSelectedCard(Card old_card, int row) {
        for (int cols = 0; cols < BOARDS[row].length; cols++) {
            if (BOARDS[row][cols].equals(old_card)) {
                BOARDS[row][cols] = getDisableCard();

                break;
            }
        }
    }

    /**
     * Crea un objeto Card con la imagen de un frijol simulando que la carta ya se encuentra inhabilitada.
     *
     * @return un objeto Card con una nueva imagen.
     **/
    public static Card getDisableCard() {
        return new Card("frijol", "frijol.jpg", 0);
    }
}
