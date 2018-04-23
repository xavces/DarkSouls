package characters;

import lsg.armor.ArmorItem;
import lsg.weapons.Weapon;
import lsg.buffs.rings.*;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Character {

    private static int MAX_ARMOR_PIECES = 3;
    private static int MAX_RING_PIECES = 2;


    private ArmorItem[] stuff = new ArmorItem[MAX_ARMOR_PIECES];
    private Ring[] ring = new Ring[MAX_RING_PIECES];


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
            float test = this.computeBuff();
            damage += Math.round(damage * (1+(computeBuff()/100)));
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

    public void setArmorItem(ArmorItem ArmorItem, int slot) {
        if (slot < 0 || slot > MAX_ARMOR_PIECES) {
            return ;
        }
        else {
            this.stuff[slot - 1] = ArmorItem;
        }
    }

    public void setRing(Ring ring, int slot) {
        if (slot < 0 || slot > MAX_RING_PIECES) {
            return ;
        }
        else {
            this.ring[slot - 1] = ring;
        }
    }

    public float getTotalArmor() {
        float total = 0;
        for (ArmorItem item: stuff) {
            if (item != null)
                total += item.getArmorValue();
        }
        return total;
    }

    public float getTotalRing() {
        float total = 0;
        for (Ring rings: ring) {
            if (rings != null)
                total += rings.computeBuffValue();
        }
        return total;
    }

    public String armorToString() {
        String string = "ARMOR  ";
        int i = 1;

        for (ArmorItem item: stuff) {
            if (item != null) {
                string += i + ":" + item.toString() + "    ";
            } else {
                string += i + ":empty    " ;
            }
            i++;
        }
        return string;
    }



    public List<ArmorItem> getArmorItems() {
        List<ArmorItem> armor = new ArrayList<ArmorItem>();
        for (ArmorItem armorItems: armor) {
            if (armorItems != null) {
                armor.add(armorItems);
            }
        }
        return armor;
    }

    @Override
    float computeProtection() {
        return this.getTotalArmor();
    }

    @Override
    float computeBuff() {
        return this.getTotalRing();
    }
}
