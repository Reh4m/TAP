package sample.proyectoloteria.models;

import sample.proyectoloteria.classes.Card;

public class LoteriaImages {
    /**
     * Número de cartas totales que se tienen en el mazo.
     **/
    private static final int TOTAL_NUMBER_CARDS = 55;

    /**
     * Total de plantillas que serán usadas por el jugador.
     *
     * Se guardan en la clase Card para obtener información de la misma cuando sea requerido.
     **/
    public static Card[][] BOARDS = {
        {
            new Card("bota", "22.PNG", 22),
            new Card("luna", "23.PNG", 23),
            new Card("cotorro", "24.PNG", 24),
            new Card("borracho", "25.PNG", 25),
            new Card("corazon", "27.PNG", 27),
            new Card("sandia", "28.PNG", 28),
            new Card("tambor", "29.PNG", 29),
            new Card("camaron", "30.PNG", 30),
            new Card("musico", "32.PNG", 32),
            new Card("arana", "33.PNG", 33),
            new Card("soldado", "34.PNG", 34),
            new Card("estrella", "35.PNG", 35),
            new Card("mundo", "37.PNG", 37),
            new Card("apache", "38.PNG", 38),
            new Card("nopal", "39.PNG", 39),
            new Card("alacran", "40.PNG", 40)
        }, {
            new Card("nopal", "39.PNG", 39),
            new Card("alacran", "40.PNG", 40),
            new Card("garza", "19.PNG", 19),
            new Card("pajaro", "20.PNG", 20),
            new Card("chalupa", "48.PNG", 48),
            new Card("pino", "49.PNG", 49),
            new Card("sandia", "28.PNG", 28),
            new Card("tambor", "29.PNG", 29),
            new Card("dama", "3.PNG", 3),
            new Card("catrin", "4.PNG", 4),
            new Card("mundo", "37.PNG", 37),
            new Card("apache", "38.PNG", 38),
            new Card("valiente", "12.PNG", 12),
            new Card("gorrito", "13.PNG", 13),
            new Card("sol", "46.PNG", 46),
            new Card("corona", "47.PNG", 47)
        }, {
            new Card("campana", "43.PNG", 43),
            new Card("cantarito", "44.PNG", 44),
            new Card("venado", "45.PNG", 45),
            new Card("mano", "21.PNG", 21),
            new Card("maceta", "52.PNG", 52),
            new Card("arpa", "53.PNG", 53),
            new Card("rana", "54.PNG", 54),
            new Card("negrito", "26.PNG", 26),
            new Card("escalera", "7.PNG", 7),
            new Card("botella", "8.PNG", 8),
            new Card("barril", "9.PNG", 9),
            new Card("jaras", "31.PNG", 31),
            new Card("bandera", "16.PNG", 16),
            new Card("bandolon", "17.PNG", 17),
            new Card("violoncello", "18.PNG", 18),
            new Card("cazo", "36.PNG", 36)
        }, {
            new Card("gallo", "1.PNG", 1),
            new Card("diablo", "2.PNG", 2),
            new Card("dama", "3.PNG", 3),
            new Card("catrin", "4.PNG", 4),
            new Card("arbol", "10.PNG", 10),
            new Card("melon", "11.PNG", 11),
            new Card("valiente", "12.PNG", 12),
            new Card("gorrito", "13.PNG", 13),
            new Card("garza", "19.PNG", 19),
            new Card("pajaro", "20.PNG", 20),
            new Card("mano", "21.PNG", 21),
            new Card("bota", "22.PNG", 22),
            new Card("sandia", "28.PNG", 28),
            new Card("tambor", "29.PNG", 29),
            new Card("camaron", "30.PNG", 30),
            new Card("jaras", "31.PNG", 31),
        }, {
            new Card("mano", "21.PNG", 21),
            new Card("bota", "22.PNG", 22),
            new Card("luna", "23.PNG", 23),
            new Card("cotorro", "24.PNG", 24),
            new Card("camaron", "30.PNG", 30),
            new Card("jaras", "31.PNG", 31),
            new Card("musico", "32.PNG", 32),
            new Card("arana", "33.PNG", 33),
            new Card("nopal", "39.PNG", 39),
            new Card("alacran", "40.PNG", 40),
            new Card("rosa", "41.PNG", 41),
            new Card("calavera", "42.PNG", 42),
            new Card("chalupa", "48.PNG", 48),
            new Card("pino", "49.PNG", 49),
            new Card("pescado", "50.PNG", 50),
            new Card("palma", "51.PNG", 51)
        }
    };

    /**
     * Cartas que serán utilizadas en el mazo.
     **/
    public final static Card[] CARDS = {
        new Card("reverso", "reverso.png", 0),
        new Card("gallo", "1.PNG", 1),
        new Card("diablo", "2.PNG", 2),
        new Card("dama", "3.PNG", 3),
        new Card("catrin", "4.PNG", 4),
        new Card("paraguas", "5.PNG", 5),
        new Card("sirena", "6.PNG", 6),
        new Card("escalera", "7.PNG", 7),
        new Card("botella", "8.PNG", 8),
        new Card("barril", "9.PNG", 9),
        new Card("arbol", "10.PNG", 10),
        new Card("melon", "11.PNG", 11),
        new Card("valiente", "12.PNG", 12),
        new Card("gorrito", "13.PNG", 13),
        new Card("muerte", "14.PNG", 14),
        new Card("pera", "15.PNG", 15),
        new Card("bandera", "16.PNG", 16),
        new Card("bandolon", "17.PNG", 17),
        new Card("violoncello", "18.PNG", 18),
        new Card("garza", "19.PNG", 19),
        new Card("pajaro", "20.PNG", 20),
        new Card("mano", "21.PNG", 21),
        new Card("bota", "22.PNG", 22),
        new Card("luna", "23.PNG", 23),
        new Card("cotorro", "24.PNG", 24),
        new Card("borracho", "25.PNG", 25),
        new Card("negrito", "26.PNG", 26),
        new Card("corazon", "27.PNG", 27),
        new Card("sandia", "28.PNG", 28),
        new Card("tambor", "29.PNG", 29),
        new Card("camaron", "30.PNG", 30),
        new Card("jaras", "31.PNG", 31),
        new Card("musico", "32.PNG", 32),
        new Card("arana", "33.PNG", 33),
        new Card("soldado", "34.PNG", 34),
        new Card("estrella", "35.PNG", 35),
        new Card("cazo", "36.PNG", 36),
        new Card("mundo", "37.PNG", 37),
        new Card("apache", "38.PNG", 38),
        new Card("nopal", "39.PNG", 39),
        new Card("alacran", "40.PNG", 40),
        new Card("rosa", "41.PNG", 41),
        new Card("calavera", "42.PNG", 42),
        new Card("campana", "43.PNG", 43),
        new Card("cantarito", "44.PNG", 44),
        new Card("venado", "45.PNG", 45),
        new Card("sol", "46.PNG", 46),
        new Card("corona", "47.PNG", 47),
        new Card("chalupa", "48.PNG", 48),
        new Card("pino", "49.PNG", 49),
        new Card("pescado", "50.PNG", 50),
        new Card("palma", "51.PNG", 51),
        new Card("maceta", "52.PNG", 52),
        new Card("arpa", "53.PNG", 53),
        new Card("rana", "54.PNG", 54),
    };

    /**
     * Modifica la carta seleccionada obteniendo la misma carta pero ahora deshabilitada. En otras palabras, actualiza
     * el estado de la carta seleccionada, la cual se encuentra en el número de plantilla usada.
     *
     * @param old_card objeto Card que será inhabilitado.
     * @param board_number número de plantilla donde se encuentra la carta.
     **/
    public static void disableSelectedCard(Card old_card, int board_number) {
        BOARDS[board_number][old_card.getIndexCardAdded()] = getDisableCard(old_card);
    }

    /**
     * Cambia el estado y la imagen de la carta seleccionada, obteniendo de esa forma la misma carta pero ahora
     * deshabilitada.
     *
     * @param old_card objeto Card que será inhabilitado.
     * @return objeto Card con la carta inhabilitada.
     **/
    public static Card getDisableCard(Card old_card) {
        old_card.disableCard();

        old_card.setImageName("match.png");

        return old_card;
    }

    /**
     * El arreglo será llenado con cartas de manera aleatoria y sin repetirse alguna.
     *
     * Define el mazo que será mostrado en pantalla.
     **/
    private static final Card[] random_cards = new Card[TOTAL_NUMBER_CARDS];

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

            // La primer carta del arreglo siempre será la 'carta volteada', esto para indicar que las cartas aún no
            // empiezan a mostrarse.
            if (cards_added < 1) {
                random_cards[0] = CARDS[0];

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
