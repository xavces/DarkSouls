package characters;

import lsg.buffs.rings.Ring;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import lsg.buffs.talismans.*;

/**
 *  Monster est la classe représentant un monstre dans le jeu. Il est hérité de la classe Character
 *
 *  Il est caractérisé par les informations suivantes :
 *  <ul>
 *      <li>Un nom</li>
 *      <li>Un montant de point de vie</li>
 *      <li>Un montant maximum de point de vie</li>
 *      <li>Un montant de stamina</li>
 *      <li>Un montant maximum de stamina</li>
 *      <li>Un petit sac hérité de Character</li>
 *  </ul>
 */
public class Monster extends Character {

    /**
     *  Variable static pour l'itération du nom du monstre
     *
     * @see Monster#Monster()
     */
    private static int INSTANCES_COUNT = 0;

    /**
     *  Variable static pour le nombre de talisman que le monstre peut porter.
     *
     * @see Monster#setTalisman(Talisman, int)
     */
    private static int MAX_TALISMAN_PIECES = 1;

    /**
     *  Initialise une variable pour la protection de la peau du monstre
     *
     * @see Monster#getSkinThickness()
     * @see Monster#computeProtection()
     */
    private float skinThickness = 0;

    /**
     *  Instancie un talisman
     *
     * @see Monster#getTotalTalisman()
     */
    private Talisman talisman = new MoonStone();

    /**
     *  Renvoie le montant de protection du monstre
     *
     * @return float            Montant de l'épaisseur de la peau du monstre
     */
    protected float getSkinThickness() {
        return skinThickness;
    }

    /**
     *  Met à jour le montant de protection du monstre
     *
     * @param skinThickness     Montant de l'épaisseur de la peau du monstre
     */
    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    /**
     *  Constructeur du monstre. Ses statistiques sont initialisés, une arme lui est équipé.
     *
     * @param nameMonster     Nom du monstre
     */
    public Monster(String nameMonster) {
        super.setName(nameMonster);
        super.setLife(80);
        super.setMaxLife(80);
        super.setStamina(50);
        super.setMaxStamina(50);
        Sword basicSword = new Sword();
        super.setWeapon(basicSword);
    }

    /**
     *  Constructeur du monstre. Ses statistiques sont initialisés, sont nom est composé de
     *  "Monster_" et d'une variable itinéré,
     */
    public Monster() {
        INSTANCES_COUNT++;
        super.setName("Monster_"+INSTANCES_COUNT);
        super.setLife(10);
        super.setMaxLife(10);
        super.setStamina(10);
        super.setMaxStamina(10);
    }

    /**
     *  Equipe le monstre du talisman, dans le slot choisi.
     *
     * @param talisman      Le talisman à équipé.
     * @param slot          Le slot choisi.
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
     *  Renvoie le nombre de dégât que l'arme inflige. Utilise le dé de 101 faces pour générer un
     *  montant de dégâts aléatoire. Réduit la stamina du héro qui l'utilise.
     *  Baisse de 1 la durabilité du l'arme
     *
     * @param weapon    Instance de l'arme utilisé.
     * @return int      Montant de dégât aléatoire en fonction des dégâts de l'arme.
     */
    @Override
    int attackWith(Weapon weapon) {
        if (weapon.isBroken())
            return 0;
        else {
            int diceCaract = diceCharact.roll();
            int damage = Math.round(weapon.getMinDamage() + ((weapon.getMaxDamage() - weapon.getMinDamage()) * (float)diceCaract/100));
            if (getStamina() >= weapon.getStamCost()){
                setStamina(getStamina() - weapon.getStamCost());
                weapon.use();
                return Math.round(damage);
            }
            else if (getStamina() > 0) {
                damage *= (float)getStamina()/weapon.getStamCost();
                setStamina(0);
                weapon.use();
                return Math.round(damage);
            }
            else {
                weapon.use();
                return 0;
            }

        }
    }

    /**
     *  Renvoie le total de buff du talisman
     *
     * @return float    Le total de buff
     */
    public float getTotalTalisman() {
        float total = 0;

        if (talisman != null)
            total += talisman.computeBuffValue();

        return total;
    }

    @Override
    float computeProtection() {
        return this.skinThickness;
    }

    @Override
    float computeBuff() {
        return this.getTotalTalisman();
    }

}
