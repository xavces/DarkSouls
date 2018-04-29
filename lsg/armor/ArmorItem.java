package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible {
    private String name;
    private float armorValue;

    /**
     * Constructeur d'une armure à l'aide du nom et de la valeur
     * @param name Nom de l'armure
     * @param armorValue Valeur de protection de l'armure
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

    /**
     * Méthode qui Surcharge la méthode toString
     * @return On renvoi une chaine de caractère de en donnant toutes les informations sur l'armure.
     */
    @Override
    public String toString(){
        return this.name + " (" + this.armorValue + ")";
    }

    /**
     *
     * @return Le poid que les armors prendront dans le sac.
     */
    @Override
    public int getWeight() {
        return 4;
    }
}
