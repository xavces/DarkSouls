package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class Character {
    /**
     * Définition de toutes les variables de la classe character
     *
     */
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    private Weapon weapon;
    public Dice myDice = new Dice(101);

    /**
     * Definition des getters et setters des variables hors mis myDice car il est en public
     *
     */
    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    /**
     * Méthode qui retourne une chaine de caractère qui correspond au information du personnage
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-20s", getClass().getSimpleName()) +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", " LIFE: " + this.getLife()) +
                String.format("%-20s", " STAMINA: "  + this.getStamina()) +
                String.format("%-20s", (this.isAlive()?"(ALIVE)":"(DEAD)"));

    }

    /**
     * Méthode qui retourne un boolean (si le personnage est en vie : 1 sinon 0)
     * @return
     */
    public boolean isAlive (){
        return this.getLife() > 0;
    }

    /**
     * Méthode qui permet toutes la gestion de l'attaque du cotès du personnage attaquant
     * Gestion de la durabilité de l'arme, de la stamina du personnage et de l'information sur les dommages occasionnés
     * Retourne les dommages occasionnés
     * @param weapon
     * @return
     */
    private int attackWith(Weapon weapon){
        if(weapon.isBroken())
            return 0;
        else{
            int myRoll = myDice.roll();

            // On calcule la différence entre les dommages max et min de l'arme
            int weaponDiffAttack = weapon.getMaxDamage() - weapon.getMinDamage();

            // On calcule les dommages avec la "Précision"
            int myDamage = Math.round(weapon.getMinDamage() + (weaponDiffAttack * (float)myRoll/100));

            //Vérification de la stamina restante
            // Si il est reste assez :
            if(this.stamina >= weapon.getStamCost()){
                // On met à jour la stamina du personnage
                this.stamina -= weapon.getStamCost();
                // On baisse la durabilité de l'arme
                weapon.use();
                // On retourne les dommages
                return myDamage;
            }
            // Sinon si la stamina est supérieure de 0
            else if (this.stamina > 0){
                //On calcule un ratio des dommages avec la stamina restante
                myDamage *= (float)this.stamina/weapon.getStamCost();
                // On met la stamina à 0
                this.stamina = 0;
                // On baisse la durabilité de l'arme
                weapon.use();
                return Math.round(myDamage);
            }
            else
                return 0;
        }
    }

    /**
     * Méthode qui appelle la méthode attackWith avec l'arme du personnage
     * Retourne les dommages
     * @return
     */
    public int attack(){
        return attackWith(this.weapon);
    }

    /**
     * Fonction qui retourne la valeur de l'attaque
     * La valeur par défaut si il reste assez de pv ou le nombre de PV restant si l'attaque est supérieure au nombre
     * de PV
     * @param value
     * @return
     */
    public int getHitWith(int value){
        return value<=this.getLife() ? value : this.getLife();
    }
}
