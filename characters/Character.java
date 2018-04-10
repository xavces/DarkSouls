package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    public Dice diceCharact = new Dice(101);
    private Weapon weapon;

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
                String.format("%-20s", "Life : " + life) +
                String.format("%-20s", "Stamina : " + stamina) +
                String.format("%-20s", alive);
    }

    public int attack(){
        return attackWith(this.weapon);
    }

    public int getHitWith(int value) {
        float damage = value;
        if (damage <= this.getLife()) {
            this.setLife(this.getLife() - Math.round(damage));
            return this.getLife();
        }
        else {
            this.setLife(0);
            return this.getLife();
        }
    }

    abstract int attackWith(Weapon weapon);


}
