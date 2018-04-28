package lsg.exceptions;

import consumables.Consumable;

public class ConsumeEmptyException extends Throwable{

    private Consumable consumableEmpty;

    public ConsumeEmptyException(Consumable consumable) {
        super();
        emptyConsumable(consumable);
    }

    public void emptyConsumable(Consumable consumable) {
        consumableEmpty = consumable;
        System.out.println(consumableEmpty.getName() + " is empty!");
    }
}
