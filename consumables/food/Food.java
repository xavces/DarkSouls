package consumables.food;

import consumables.Consumable;

import static characters.Character.LIFE_STAT_STRING;

public class Food extends Consumable {
    public Food(String name, int capacity) {
        super(name, capacity, LIFE_STAT_STRING);
    }
}
