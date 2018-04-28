package lsg.weapons;

import consumables.repair.RepairKit;
import lsg.exceptions.ConsumeNullException;

/**
 * Weapon est la classe qui représente une arme. Il implémente l'interface Collectible pour gérer le poids de l'arme
 */
public class Weapon implements lsg.bags.Collectible {

    /**
     *  Nom de l'arme
     */
    private String nameWeapon;

    /**
     *  Montant des dommages minimum
     */
    private int minDamage;

    /**
     *  Montant des dommages maximum
     */
    private int maxDamage;

    /**
     *  Montant de la stamina par coup
     */
    private int stamCost;

    /**
     *  Montent de la durabilité de l'arme
     */
    private int durability;

    /**
     *  Nom de la statistique durabilité
     */
    public static final String DURABILITY_STAT_STRING = "durability";

    /**
     *  Renvoie le nom de l'arme
     *
     * @return String       Nom de l'arme
     */
    public String getNameWeapon() {
        return nameWeapon;
    }

    /**
     *  Met à jour le nom de l'arme
     *
     * @param nameWeapon    Nom de l'arme
     */
    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    /**
     *  Renvoie les dommages minimum
     *
     * @return int      Dommage minimum
     */
    public int getMinDamage() {
        return minDamage;
    }

    /**
     *  Met à jour les dommages minimum
     *
     * @param minDamage Dommage minimum
     */
    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    /**
     *  Renvoie les dommages maximum
     *
     * @return int      Dommage maximum
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     *  Met à jour les dommages maximum
     *
     * @param maxDamage Dommage maximum
     */
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    /**
     *  Renvoie le stamina d'un coup
     *
     * @return int      Coup de l'arme en stamina
     */
    public int getStamCost() {
        return stamCost;
    }

    /**
     *  Met à jour la stamina d'un coup
     *
     * @param stamCost  Coup de l'arme en stamina
     */
    public void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }

    /**
     *  Renvoie la durabilité de l'arme
     *
     * @return int      Montant de la durabilité
     */
    public int getDurability() {
        return durability;
    }

    /**
     *  Met à jour la durabilité de l'arme
     *
     * @param durability    Montant de la durabilité
     */
    private void setDurability(int durability) {
        this.durability = durability;
    }

    /**
     *  Renvoie le poids de l'objet qui est fixé à 2
     *
     * @return int      Poids de l'objet à 2
     */
    public int getWeight() {
        return 2;
    }

    /**
     *  Constructeur d'une arme
     *
     * @param name          Nom de l'arme
     * @param minDamage     Minimum des dégâts
     * @param maxDamage     Maximum des dégâts
     * @param stamCost      Coup de l'arme en stamina
     * @param durability    Duurabilité de l'arme
     */
    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.nameWeapon = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    /**
     *  Baisse de 1 la durabilité de l'arme
     *
     * @return int      Durabilité baissé de 1
     */
    public int use() {
        return this.durability--;
    }

    /**
     *  Vérifie si l'arme est cassé
     *
     * @return boolean      True si la durabilité de l'arme est inférieur ou égale à 0
     */
    public boolean isBroken() {
        boolean isBroken = (this.durability <= 0) ? true : false;
        return isBroken;
    }

    /**
     *
     */
    public String toString() {
        return String.format("%-20s", this.nameWeapon) +
                String.format("%-20s", "min : " + this.minDamage) +
                String.format("%-20s", "max : " + this.maxDamage) +
                String.format("%-20s", "stam : " + this.stamCost) +
                String.format("%-20s", "dur : " + this.durability);
    }

    /**
     *
     */
    public void repairWith(RepairKit kit) throws ConsumeNullException {
        if (kit == null)
            throw new ConsumeNullException();
        this.durability = this.durability + kit.use();
    }
}
