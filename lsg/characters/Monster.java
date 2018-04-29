package lsg.characters;

import lsg.buffs.talismans.MoonStone;
import lsg.buffs.talismans.NoonGift;
import lsg.buffs.talismans.Talisman;

public class Monster extends Character{

    /**
     * Définition d'une variable permettant de compter le nombre d'instance
     */
    private static int INSTANCES_COUNT = 1;

    /**
     * Définition d'une variable qui a l'armure d'un monstre
     */
    private float skinThickness = 20;


    private float MAX_TALISMAN_PIECES = 1;

    private Talisman talisman = new NoonGift();


    public Monster(String name) {
        super.setName(name);
        super.setLife(10);
        super.setStamina(10);
    }

    public Monster() {
        super.setName("YMonster_" + INSTANCES_COUNT);
        INSTANCES_COUNT++;
        super.setLife(10);
        super.setStamina(10);
    }

    /**
     *
     * @return L'armure du monstre
     */
    public float getSkinThickness() {
        return skinThickness;
    }

    /**
     * Initialise l'armure du monstre à l'aide du paramètre
     * @param skinThickness
     */
    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    /**
     * Méthode qui défini un talisman pour un monstre
     * @param talisman
     * @param slot
     */
    public void setTalisman(Talisman talisman, int slot) {
        if (slot < 0 || slot > MAX_TALISMAN_PIECES) {
            return ;
        }
        else {
            this.talisman = talisman;
        }
    }

    /**
     * Méthode qui renvoi le total des buffs du monstre
     * @return
     */
    public float getTotalTalisman() {
        float total = 0;

        if (talisman != null)
            total += talisman.computeBuffValue();

        return total;
    }

    @Override
    float computeProtection() {
        return this.getSkinThickness();
    }

    @Override
    float computeBuff() {
        return this.getTotalTalisman();
    }

}
