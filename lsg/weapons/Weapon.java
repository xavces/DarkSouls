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

    /**
     * Constructeur d'arme
     * @param name
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     * @param durability
     */
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

    public void setDurability(int durability) {
        this.durability = durability;
    }


    /**
     * Méthode qui enlève un de durabilité
     */
    public void use(){
        this.durability--;
    }

    /**
     * Méthode qui renvoi 1 si l'arme est cassé, 0 sinon
     * @return
     */
    public boolean isBroken(){
        return this.durability <= 0;
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
