package lsg.exceptions;

public class ConsumeNullException extends Throwable{
    public ConsumeNullException() {
        super();
        noConsumable();
    }

    public void noConsumable() {
        System.out.println("Consumable is null!");
    }
}
