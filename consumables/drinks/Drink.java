package consumables.drinks;

import consumables.Consumable;

import static characters.Character.STAM_STAT_STRING;

/**
 *  Drink est la classe représentant une boisson dans le jeu, il est hérité de la classe Consumable
 */
public class Drink extends Consumable {

    /**
     *  Constructeur d'une boisson.
     *
     * @param name          Nom de la boisson
     * @param capacity      Capacité de regénération
     */
    public Drink(String name, int capacity) {
        super(name, capacity, STAM_STAT_STRING);
    }
}
