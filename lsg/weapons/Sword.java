package lsg.weapons;

public class Sword extends Weapon{
    /**
     * Constructeur de l'arme Sword avec les paramètre de définition d'une arme
     * @param name
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     * @param durability
     */
    public Sword(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        super(name, minDamage, maxDamage, stamCost, durability);
    }
}
