package lsg.characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class Character {

    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private Weapon weapon;

    public Dice myDice = new Dice(101);

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    protected void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    protected void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    protected void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void printStats() {
        System.out.println(this.toString());
    }

    /**
     * Méthode qui retourne une chaine de caractère qui correspond au information du personnage
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-20s", getClass().getSimpleName()) +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", LIFE_STAT_STRING + ": " + this.getLife()) +
                String.format("%-20s", STAM_STAT_STRING + ": "  + this.getStamina()) +
                String.format("%-20s", (this.isAlive()?"(ALIVE)":"(DEAD)"));

    }

    /**
     * Méthode qui retourne un boolean (si le personnage est en vie : 1 sinon 0)
     * @return
     */
    public boolean isAlive (){
        return this.getLife() > 0;
    }

    private int attackWith(Weapon weapon){
        if(weapon.isBroken())
            return 0;
        else{
            int myRoll = myDice.roll();
            int weaponDiffAttack = weapon.getMaxDamage() - weapon.getMinDamage();
            int myDamage = Math.round(weapon.getMinDamage() + (weaponDiffAttack * (float)myRoll/100));
            if(this.stamina >= weapon.getStamCost()){
                this.stamina -= weapon.getStamCost();
                weapon.use();
                return myDamage;
            }
            else if (this.stamina != 0){
                myDamage *= (float)this.stamina/weapon.getStamCost();
                this.setStamina(0);
                weapon.use();
                return Math.round(myDamage);
            }
            else
                return 0;
        }
    }
    public int attack(){
        return attackWith(this.weapon);
    }
    public int getHitWith(int value){
        int pvRetire =  value<=this.getLife() ? value : this.getLife();
        this.setLife(this.getLife() - pvRetire);
        return pvRetire;
    }
}
