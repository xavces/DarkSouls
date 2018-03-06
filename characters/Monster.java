package characters;

import lsg.weapons.Sword;

public class Monster extends Character{

    private static int INSTANCES_COUNT = 1;

    public Monster(String name) {
        super.setName(name);
        super.setLife(10);
        super.setMaxLife(100);
        super.setStamina(10);
        super.setMaxStamina(50);
    }

    public Monster() {
        super.setName("YMonster_" + this.INSTANCES_COUNT);
        this.INSTANCES_COUNT++;
        super.setLife(10);
        super.setMaxLife(100);
        super.setStamina(10);
        super.setMaxStamina(50);
    }

}
