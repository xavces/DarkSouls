package characters;

import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class Monster extends Character {


    private static int INSTANCES_COUNT = 0;

    private float skinThickness = 20;


    protected float getSkinThickness() {
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    public Monster(String nameMonster) {
        super.setName(nameMonster);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
        Sword basicSword = new Sword("Basic Sword", 5, 10, 20, 100);
        super.setWeapon(basicSword);
    }

    public Monster() {
        INSTANCES_COUNT++;
        super.setName("Monster_"+INSTANCES_COUNT);
        super.setLife(10);
        super.setMaxLife(10);
        super.setStamina(10);
        super.setMaxStamina(10);
    }


    @Override
    int attackWith(Weapon weapon) {
        if (weapon.isBroken())
            return 0;
        else {
            int diceCaract = diceCharact.roll();
            int damage = Math.round(weapon.getMinDamage() + ((weapon.getMaxDamage() - weapon.getMinDamage()) * (float)diceCaract/100));
            if (getStamina() >= weapon.getStamCost()){
                setStamina(getStamina() - weapon.getStamCost());
                weapon.use();
                return Math.round(damage);
            }
            else if (getStamina() > 0) {
                damage *= (float)getStamina()/weapon.getStamCost();
                setStamina(0);
                weapon.use();
                return Math.round(damage);
            }
            else {
                weapon.use();
                return 0;
            }

        }
    }

    @Override
    float computeProtection() {
        return this.skinThickness;
    }

}
