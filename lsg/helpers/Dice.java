package lsg.helpers;

import java.util.Random;

public class Dice {
    private int faces;
    private Random random = new Random();


    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll(){
        return random.nextInt(this.faces);
    }

}
