package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Exception {
    private Weapon weaponBroken;
    public WeaponBrokenException(Weapon weapon) {
        super(weapon.getName() + " is broken !");
        this.weaponBroken = weapon;
    }

    public Weapon getWeapon() {
        return weaponBroken;
    }
}
