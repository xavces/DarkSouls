package characters;

import lsg.weapons.Sword;

public class Hero extends Character{

    private static int INSTANCES_COUNT = 1;

    public Hero(String name) {
        super.setName(name);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    public Hero() {
        super.setName("Ynovator_" + this.INSTANCES_COUNT);
        this.INSTANCES_COUNT++;
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

}
