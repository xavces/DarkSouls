package consumables.food;

import consumables.Consumable;

import static characters.Character.LIFE_STAT_STRING;

/**
 *  Food est la classe représentant une nourriture dans le jeu, il est hérité de la classe Consumable
 */
public class Food extends Consumable {

    /**
     *  Constructeur d'une boisson.
     *
     * @param name          Nom de la boisson
     * @param capacity      Capacité de regénération
     */
    public Food(String name, int capacity) {
        super(name, capacity, LIFE_STAT_STRING);
    }
}
