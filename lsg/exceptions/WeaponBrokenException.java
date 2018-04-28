package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Throwable{
    private Weapon weaponBroken;
    public WeaponBrokenException(Weapon weapon) {
        super();
        brokenWeapon(weapon);
    }

    public void brokenWeapon(Weapon weapon) {
        weaponBroken = weapon;
        System.out.println(weaponBroken.getNameWeapon() + " is broken!");
    }

    public Weapon getWeapon() {
        return weaponBroken;
    }
}
