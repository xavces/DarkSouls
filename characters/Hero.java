package characters;

import lsg.armor.armorItem;
import lsg.weapons.ShotGun;
import lsg.weapons.Weapon;
import lsg.weapons.Sword;

public class Hero extends Character {

    private static int MAX_ARMOR_PIECES = 3;

    private armorItem[] stuff = new armorItem[MAX_ARMOR_PIECES];

    public Hero(String nameHero) {
        super.setName(nameHero);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    public Hero() {
        super.setName("Ynovator");
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    @Override
    int attackWith(Weapon weapon) {
        if (weapon.isBroken())
            return 0;
        else {
            int diceCaract = diceCharact.roll();
            int damage = Math.round(weapon.getMinDamage() + ((weapon.getMaxDamage() - weapon.getMinDamage()) * (float)diceCaract/100));
            if (super.getStamina() >= weapon.getStamCost()){
                super.setStamina(super.getStamina() - weapon.getStamCost());
                weapon.use();
                return Math.round(damage);
            }
            else if (super.getStamina() > 0) {
                damage *= (float)super.getStamina()/weapon.getStamCost();
                super.setStamina(0);
                weapon.use();
                return Math.round(damage);
            }
            else {
                weapon.use();
                return 0;
            }

        }
    }

    public void setArmorItem(armorItem armorItem, int slot) {
        if (slot < 0 || slot > MAX_ARMOR_PIECES) {
            return ;
        }
        else {
            this.stuff[slot - 1] = armorItem;
        }
    }

    public float getTotalArmor() {
        float total = 0;
        for (armorItem item: stuff) {
            if (item != null)
                total += item.getArmorValue();
        }
        return total;
    }

    public String armorToString() {
        String string = "ARMOR  ";
        int i = 1;

        for (armorItem item: stuff) {
            if (item != null) {
                string += i + ":" + item.toString() + "    ";
            } else {
                string += i + ":empty    " ;
            }
            i++;
        }
        return string;
    }
}
