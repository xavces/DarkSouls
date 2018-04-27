package lsg.armor;


/**
 *  ArmorItem est la classe représentant une pièce d'armure du héro. Il implémente la Classe Collectible pour
 *  permettre de gérer le poids des items
 *
 *  Il est caractérisé par les informations suivantes :
 *  <ul>
 *      <li>Un nom</li>
 *      <li>Un montant d'armure/de protection</li>
 *  </ul>
 */
public class ArmorItem implements lsg.bags.Collectible {

    /**
     *  Nom de la pièce d'armure
     */
    private String name;

    /**
     *  Montant de protection de la pièce d'armure
     */
    private float armorValue;

    /**
     *  Renvoie le nom de la pièce d'armure
     *
     * @return String   Nom de la pièce d'armure
     */
    public String getName() {
        return name;
    }

    /**
     *  Renvoie le montant de la protection de la pièce d'armure
     *
     * @return  float   Montant de la protection
     */
    public float getArmorValue() {
        return armorValue;
    }

    /**
     *  Renvoie le poids de la pièce d'armure
     * @return int      Poids de la pièce d'armure
     */
    public int getWeight() {
        return 4;
    }

    /**
     *  Constructeur d'une pièce d'armure
     *
     * @param name          Nom de la pièce d'armure
     * @param armorValue    Montant de la protection
     */
    public ArmorItem(String name, float armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    /**
     *  Formate les informations pour en faire un String
     *
     * @return String   La chaine de charactere
     *
     */
    public String toString() {
        String nameClass = getClass().getSimpleName();
        return String.format("%-20s", "[" + getClass().getSimpleName() + "](" + getArmorValue()+")");
    }
}
