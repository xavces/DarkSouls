package characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {
    private static int INSTANCES_COUNT = 0;

    private float skinThickness = 20;


    protected float getSkinThickness() {
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    public Lycanthrope(String nameMonster) {
        super.setName(nameMonster);
        super.setLife(40);
        super.setMaxLife(40);
        super.setStamina(100);
        super.setMaxStamina(100);
        Claw claw = new Claw("Bloody Claw", 10, 20, 10, 100);
        super.setWeapon(claw);
        super.setSkinThickness(0);
    }

}
