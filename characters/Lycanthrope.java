package characters;

import lsg.weapons.Claw;

/**
 *  Lycanthrope est la classe représentant un Lycanthrope dans le jeu, il est hérité de la classe Monster
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
public class Lycanthrope extends Monster {

    /**
     *  Initialise une variable pour la protection de la peau du monstre
     *
     * @see Lycanthrope#getSkinThickness()
     * @see Lycanthrope#setSkinThickness(float)
     */
    private float skinThickness = 30;

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
     *  Constructeur du Lycanthrope. Ses statistiques sont initialisés, une arme lui est équipé.
     *  Sa protection de peau est modifié
     *
     * @param nameMonster     Nom du monstre
     */
    public Lycanthrope(String nameMonster) {
        super.setName(nameMonster);
        super.setLife(60);
        super.setMaxLife(60);
        super.setStamina(100);
        super.setMaxStamina(100);
        Claw claw = new Claw("Bloody Claw", 10, 20, 10, 100);
        super.setWeapon(claw);
        super.setSkinThickness(skinThickness);
    }

}
