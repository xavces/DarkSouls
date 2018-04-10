package lsg.weapons;

public class Weapon {
    private String nameWeapon;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    public String getNameWeapon() {
        return nameWeapon;
    }

    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.nameWeapon = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    public int use() {
        return this.durability--;
    }

    public boolean isBroken() {
        boolean isBroken = (this.durability <= 0) ? true : false;
        return isBroken;
    }

    public String toString() {
        return String.format("%-20s", this.nameWeapon) +
                String.format("%-20s", "min : " + this.minDamage) +
                String.format("%-20s", "max : " + this.maxDamage) +
                String.format("%-20s", "stam : " + this.stamCost) +
                String.format("%-20s", "dur : " + this.durability);
    }
}
