package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Throwable {
    private Bag fullBag;
    public BagFullException(Bag bag) {
        super();
        fullBag(bag);
    }

    public void fullBag(Bag bag) {
        fullBag = bag;
        System.out.println(fullBag + " is full!");
    }

    public Bag getFullBag() {
        return fullBag;
    }
}
