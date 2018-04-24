package lsg.weapons;

public class Weapon {

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
        this.setDurability(this.durability--);
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
        return this.name + " (min:" + this.minDamage + " max:" + this.maxDamage +
                " stam:" + this.stamCost + " dur:" + this.durability + ")";
    }
}
