package lsg.consumables.repair;

import lsg.consumables.Consumable;

import static lsg.weapons.Weapon.DURABILITY_STAT_STRING;

public class RepairKit extends Consumable {
    public RepairKit() {
        super("Repair Kit", 10, DURABILITY_STAT_STRING);
    }
    @Override
    public int use(){
        int myCapacity = this.getCapacity();
        this.setCapacity(myCapacity-1);
        return 1;
    }
}
