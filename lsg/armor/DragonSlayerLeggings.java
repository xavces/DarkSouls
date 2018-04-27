package lsg.armor;

/**
 *  DragonSlayerLeggings est la classe représentant la pièce d'armure "DragonSlayerLeggings". Il hérite de ArmorItem.
 *
 */
public class DragonSlayerLeggings extends ArmorItem {

    /**
     *  Renvoie le poids de la pièce d'armure
     * @return int      Poids de la pièce d'armure
     */
    public int getWeight() {
        return 3;
    }

    /**
     *  Constructeur d'une pièce d'armure avec comme nom : "DragonSlayerLeggings" et d'un montant d'armure de 10.2
     */
    public DragonSlayerLeggings() {
        super("DragonSlayerLeggings", (float) 10.2);
    }
}
