package lsg.weapons;

public class ShotGun extends Weapon{
    /**
     * Constructeur de l'arme ShotGun avec les paramètre de définition d'une arme
     * @param name
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     * @param durability
     */
    public ShotGun(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        super(name, minDamage, maxDamage, stamCost, durability);
    }
}
