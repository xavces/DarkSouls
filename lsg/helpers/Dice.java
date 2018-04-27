package lsg.helpers;

import java.util.Random;

/**
 * Dice est la classe qui représente un dé.
 */
public class Dice {

    /**
     *  Nombre de face du dé
     */
    private int faces;

    /**
     *  Un random
     */
    private Random random = new Random();

    /**
     *  Renvoie le random
     *
     * @return Random       random
     */
    public Random getRandom() {
        return random;
    }

    /**
     *  Constructeur d'un dé
     *
     * @param nbFaces       Nombre de faces
     */
    public Dice(int nbFaces) {
        this.faces = nbFaces--;
    }

    /**
     *  Change le random
     *
     * @return int          Le random d'après, compris entre 0 et le nombre de faces
     */
    public int roll() {
        return random.nextInt(this.faces);
    }
}
