package lsg.weapons;

import lsg.consumables.repair.RepairKit;

import static lsg.characters.Character.STAM_STAT_STRING;

public class Weapon {

    public static final String DURABILITY_STAT_STRING = "durability";
    public static final String MINI_DAMAGE_STRING = "minimal";
    public static final String MAXI_DAMAGE_STRING = "maximal";

    /**
     * Définition des différents attributs d'une arme
     */
    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    /**
     * Initialisation des getters et setters
     * @return
     */
    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public void use(){
        this.setDurability(this.durability-1);
    }

    public boolean isBroken(){
        return this.getDurability() <= 0;
    }

    /**
     * Méthode qui gère l'affichage des informations de l'arme
     * @return
     */
    @Override
    public String toString(){
        return this.name + " (" + MINI_DAMAGE_STRING +":" + this.minDamage +" "+ MAXI_DAMAGE_STRING +":" + this.maxDamage +
                " " +STAM_STAT_STRING + ":" + this.stamCost + " "+DURABILITY_STAT_STRING + ":" + this.durability + ")";
    }

    public void repairWith(RepairKit kit){
        if(kit != null && kit.getCapacity()>0) {
            this.setDurability(this.getDurability() + kit.use());
        }
    }
}
