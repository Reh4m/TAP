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


    /**
     * El arreglo será llenado con cartas de manera aleatoria y sin repetirse alguna.
     *
     * Define el mazo que será mostrado en pantalla.
     **/
    private static final Card[] random_cards = new Card[25];

    /**
     * Llena el arreglo random_cards con objetos Card que son generados automáticamente. El ciclo while sirve para
     * llenar cada campo del arreglo verificando que no se repita alguna carta ya establecida, en caso de repetirse, el
     * ciclo seguirá hasta encontrar una carta que no ha sido añadida.
     *
     * @return arreglo de cartas aleatorias que serán usadas en el mazo.
     **/
    public static Card[] getRandomCards() {
        Card random_card;

        int cards_added = 0;

        while (cards_added < random_cards.length) {
            random_card = generateRandomCard();

            if (cards_added < 1) {
                random_cards[cards_added] = random_card;

                cards_added++;
            }

            if (!checkRepeatCard(random_card, cards_added)) {
                random_cards[cards_added] = random_card;

                cards_added++;
            }
        }

        return random_cards;
    }


    /**
     * Comprueba que la carta aleatoria generada no se encuentra ya añadida en el arreglo random_cards. En caso de que
     * ambas cartas no sean iguales se podrá añadir la carta al arreglo.
     *
     * @param random_card carta generada aleatoriamente.
     * @param current_cards_added número de tarjetas añadidas hasta el momento, este servirá para recorrer el arreglo
     *                            solo hasta el índice donde se agregó la última carta.
     *
     * @return valor booleano especificando si la carta generada ya está en el arreglo.
     **/
    private static boolean checkRepeatCard(Card random_card, int current_cards_added) {
        for (int i = 0; i < current_cards_added; i++) {
            if (random_cards[i].equals(random_card)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Toma una carta de manera aleatoria procedente del arreglo CARDS para ser usada en el mazo.
     *
     * @return una carta aleatoria.
     **/
    private static Card generateRandomCard() {
        return CARDS[(int) (Math.random() * CARDS.length)];
    }
}
