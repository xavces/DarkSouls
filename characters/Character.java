package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

import java.util.Locale;

public abstract class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    public Dice diceCharact = new Dice(101);
    private Weapon weapon;

    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";
    public static final String PROTECTION_STAT_STRING = "protection";
    public static final String BUFF_STAT_STRING = "buff";


    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    void setLife(int life) {
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

    public boolean isAlive() {
        if (this.getLife() > 0)
            return true;
        else
            return false;
    }


    public String toString() {
        String nameClass = getClass().getSimpleName();
        String alive = isAlive() ? "(ALIVE)" : "(DEAD)";
        return String.format("%-20s", "[" + getClass().getSimpleName() + "]") +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", LIFE_STAT_STRING + " : " + life) +
                String.format("%-20s", STAM_STAT_STRING + " : " + stamina) +
                String.format(Locale.US, "%-20s", PROTECTION_STAT_STRING + " : " + computeProtection()) +
                String.format(Locale.US, "%-20s", BUFF_STAT_STRING + " : " + computeBuff()) +
                String.format("%-20s", alive);
    }

    public int attack(){
        return attackWith(this.weapon);
    }

    public int getHitWith(int value) {
        if (computeProtection() >= 100)
            return 0;
        if (value <= this.getLife()) {
            this.setLife(this.getLife() - Math.round(value*(1-computeProtection()/100)));
            return this.getLife();
        }
        else {
            this.setLife(0);
            return this.getLife();
        }
    }

    abstract int attackWith(Weapon weapon);
    abstract float computeProtection();
    abstract float computeBuff();


}
