package characters;

import lsg.buffs.rings.Ring;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import lsg.buffs.talismans.*;

public class Monster extends Character {


    private static int INSTANCES_COUNT = 0;
    private static int MAX_TALISMAN_PIECES = 1;

    private float skinThickness = 0;
    private Talisman talisman = new MoonStone();

    protected float getSkinThickness() {
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    public Monster(String nameMonster) {
        super.setName(nameMonster);
        super.setLife(80);
        super.setMaxLife(80);
        super.setStamina(50);
        super.setMaxStamina(50);
        Sword basicSword = new Sword();
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

    public void setTalisman(Talisman talisman, int slot) {
        if (slot < 0 || slot > MAX_TALISMAN_PIECES) {
            return ;
        }
        else {
            this.talisman = talisman;
        }
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

    public float getTotalTalisman() {
        float total = 0;

        if (talisman != null)
            total += talisman.computeBuffValue();

        return total;
    }

    @Override
    float computeProtection() {
        return this.skinThickness;
    }

    @Override
    float computeBuff() {
        return this.getTotalTalisman();
    }

}
