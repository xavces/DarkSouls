package characters;

import consumables.Consumable;
import consumables.drinks.Drink;
import consumables.food.Food;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;
import consumables.repair.RepairKit;

import java.util.Locale;

public abstract class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    public Dice diceCharact = new Dice(101);
    private Weapon weapon;
    private Consumable consumable;

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

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
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
        float dmgFinal = 0;
        if (computeProtection() >= 100)
            return 0;
        dmgFinal = Math.round(value*(1-computeProtection()/100));
        if (value <= this.getLife()) {
            this.setLife(this.getLife() - Math.round(dmgFinal));
            return Math.round(dmgFinal);
        }
        else {
            this.setLife(0);
            return this.getLife();
        }
    }

    private void drink(Drink drink) {
        System.out.println(getName() + " drinks " + drink.toString());
        if ((drink.use() + this.getStamina()) >= this.getMaxStamina()) {
            this.setStamina(this.getMaxStamina());
        }
        else {
            this.setStamina(this.getStamina() + drink.use());
        }
    }

    private void eat(Food food) {
        System.out.println(getName() + " drinks " + food.toString());
        int capacity = food.use();
        int add = capacity + this.getLife();
        if (add > this.getMaxLife()) {
            this.setLife(this.getMaxLife());
        }
        else {
            this.setLife(this.getLife() + capacity);
        }
    }

    public void use(Consumable consumable) {
        if(consumable instanceof Drink){
            drink((Drink) consumable);
        }
        else if(consumable instanceof Food){
            eat((Food) consumable);
        }
        else if (consumable instanceof RepairKit) {
            repairWeaponWith((RepairKit) consumable);
        }
    }

    private void repairWeaponWith(RepairKit kit) {
        this.weapon.repairWith(kit);
        System.out.println(this.name + " repairs " + weapon.toString() + " with " + kit.toString());
    }

    public void consume() {
        use(consumable);
    }

    abstract int attackWith(Weapon weapon);
    abstract float computeProtection();
    abstract float computeBuff();


}
