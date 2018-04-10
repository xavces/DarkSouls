package characters;


import lsg.weapons.ShotGun;
import lsg.weapons.Weapon;
import lsg.weapons.Sword;

public class Hero extends Character {

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
}
