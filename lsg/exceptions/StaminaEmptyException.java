package lsg.exceptions;

public class StaminaEmptyException extends Throwable {
    public StaminaEmptyException() {
        super();
        noStamina();
    }

    public void noStamina() {
        System.out.println("No Stamina!");
    }
}
