package lsg.exceptions;

public class NoBagException extends Throwable {
    public NoBagException() {
        super();
        noBag();
    }

    public void noBag() {
        System.out.println("No Bag!");
    }
}
