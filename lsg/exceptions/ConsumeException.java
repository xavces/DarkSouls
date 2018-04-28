package lsg.exceptions;

import consumables.Consumable;

public abstract class ConsumeException extends Exception{
    private Consumable consumable;
    private String message;
    public ConsumeException(String message, Consumable consumable) {
        this.message = message;
        this.consumable = consumable;
    }

    public Consumable getConsumable() {
        return consumable;
    }
}
