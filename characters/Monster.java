package characters;

import lsg.weapons.Sword;

public class Monster extends Character{

    /**
     * Définition d'une variable permettant de compter le nombre d'instance
     */
    private static int INSTANCES_COUNT = 1;

    /**
     * Constructeur d'un monstre avec en paramètre son nom
     * @param name
     */
    public Monster(String name) {
        super.setName(name);
        super.setLife(10);
        super.setMaxLife(100);
        super.setStamina(10);
        super.setMaxStamina(50);
    }

    /**
     * Constructeur d'un montre sans paramètre
     * On gère le nombre d'instance pour pas que 2 monstres est le même nom
     */
    public Monster() {
        super.setName("YMonster_" + this.INSTANCES_COUNT);
        this.INSTANCES_COUNT++;
        super.setLife(10);
        super.setMaxLife(100);
        super.setStamina(10);
        super.setMaxStamina(50);
    }

}
