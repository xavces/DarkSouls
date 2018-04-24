package lsg.armor;

public class DragonSlayerLeggings extends ArmorItem {
    /**
     * Constructeur de l'armure DragonSlayerLeggings qui utilise le constructeur de la classe mère
     */
    public DragonSlayerLeggings() {
        super("Dragon Slayer Leggings", 10.2f);
    }

    @Override
    public int getWeight() {
        return 3;
    }
}