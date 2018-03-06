package lsg.weapons;

public class Claw extends Weapon {
    /**
     * Constructeur de l'arme Claw avec les paramètre de définition d'une arme
     * @param name
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     * @param durability
     */
    public Claw(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        super(name, minDamage, maxDamage, stamCost, durability);
    }
}
