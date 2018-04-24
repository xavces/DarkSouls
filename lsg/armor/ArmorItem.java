package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible {
    private String name;
    private float armorValue;

    /**
     * Constructeur d'une armure à l'aide du nom et de la valeur
     * @param name
     * @param armorValue
     */
    public ArmorItem(String name, float armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    /**
     *
     * @return Nom d'une armure
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Valeur de défense d'une armure
     */
    public float getArmorValue() {
        return armorValue;
    }

    @Override
    public String toString(){
        return this.name + " (" + this.armorValue + ")";
    }

    @Override
    public int getWeight() {
        return 4;
    }
}
