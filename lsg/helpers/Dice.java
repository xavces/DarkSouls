package lsg.helpers;

import java.util.Random;

public class Dice {
    /**
     * Définition des différents attributs d'un dés
     */
    private int faces;
    private Random random = new Random();

    /**
     * Constructeur du dés avec le nombre de faces
     * @param faces
     */
    public Dice(int faces) {
        this.faces = faces;
    }

    /**
     * Tirage aléatoire du dès entre 0 et this.faces
     * Retourne la valeur
     * @return
     */
    public int roll(){
        return random.nextInt(this.faces);
    }
}
