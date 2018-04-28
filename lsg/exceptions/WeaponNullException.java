package lsg.exceptions;

public class WeaponNullException extends Throwable {
    public WeaponNullException() {
        super();
    }

    public void noWeapon() {
        System.out.println("No Weapon!");
    }
}
