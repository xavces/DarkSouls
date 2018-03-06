package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class Character {

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

    protected void printStats() {
        System.out.println(getClass().getSimpleName() + "\t" + this.getName() + "\t LIFE: " + this.getLife() + "\t STAMINA: " + this.getStamina());
    }

    @Override
    public String toString() {
        return String.format("%-20s", getClass().getSimpleName()) +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", " LIFE: " + this.getLife()) +
                String.format("%-20s", " STAMINA: "  + this.getStamina()) +
                String.format("%-20s", (this.isAlive()?"(ALIVE)":"(DEAD)"));

    }

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
                weapon.setDurability(weapon.getDurability()-1);
                return myDamage;
            }
            else if (this.stamina != 0){
                myDamage *= (float)this.stamina/weapon.getStamCost();
                this.stamina = 0;
                weapon.setDurability(weapon.getDurability()-1);
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
        return value<=this.getLife() ? value : this.getLife();
    }
}
