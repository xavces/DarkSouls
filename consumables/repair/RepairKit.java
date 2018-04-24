package consumables.repair;

import consumables.Consumable;
import lsg.weapons.Weapon;

import static lsg.weapons.Weapon.DURABILITY_STAT_STRING;

public class RepairKit extends Consumable {
    public RepairKit() {
        super("Repair Kit", 10, DURABILITY_STAT_STRING);
    }

    @Override
    public int use() {
        int capacity = getCapacity();
        if(capacity == 0){
            return capacity;
        }
        else{
            setCapacity(getCapacity() - 1);
            return 1;
        }
    }
}
