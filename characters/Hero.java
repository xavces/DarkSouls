package characters;

import lsg.weapons.Sword;

public class Hero extends Character{
    /**
     * Définition d'une variable permettant de compter le nombre d'instance
     */
    private static int INSTANCES_COUNT = 1;

    /**
     * Constructeur d'un héro avec en paramètre son nom
     * @param name
     */
    public Hero(String name) {
        super.setName(name);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    /**
     * Constructeur d'un montre sans paramètre
     * On gère le nombre d'instance pour pas que 2 héros est le même nom
     */
    public Hero() {
        super.setName("Ynovator_" + this.INSTANCES_COUNT);
        this.INSTANCES_COUNT++;
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

}
