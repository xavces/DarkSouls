package lsg.exceptions;

import consumables.Consumable;

public class ConsumeRepairNullWeaponException extends Throwable {
    public ConsumeRepairNullWeaponException(Consumable consumable) {
        super();
        noRepairNullWeapon();
    }

    public void noRepairNullWeapon() {
        System.out.println("Trying to repair null weapon!");
    }
}
