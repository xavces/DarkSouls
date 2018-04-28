package lsg.weapons;

public class Claw extends Weapon {
    public Claw(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        super(name, minDamage, maxDamage, stamCost, durability);
    }

    public Claw() {
        super("Claw", 10, 20, 50, 100);
    }
}
