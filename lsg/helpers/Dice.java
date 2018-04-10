package lsg.helpers;

import java.util.Random;

public class Dice {

    private int faces;
    private Random random = new Random();


    public Random getRandom() {
        return random;
    }

    public Dice(int nbFaces) {
        this.faces = nbFaces--;
    }

    public int roll() {
        return random.nextInt(this.faces);
    }
}
