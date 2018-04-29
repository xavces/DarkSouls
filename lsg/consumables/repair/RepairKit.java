package lsg.consumables.repair;

import lsg.consumables.Consumable;

import static lsg.weapons.Weapon.DURABILITY_STAT_STRING;

public class RepairKit extends Consumable {
    public RepairKit() {
        super("Repair Kit", 10, DURABILITY_STAT_STRING);
    }

    /**
     * On surcharge la méthode use de Consumable, un repairKit s'utilise seulement 1 par 1 comparé aux autres consumable
     * @return
     */
    @Override
    public int use(){
        int myCapacity = this.getCapacity();
        this.setCapacity(myCapacity-1);
        return 1;
    }
}
