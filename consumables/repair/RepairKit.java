package consumables.repair;

import consumables.Consumable;
import lsg.weapons.Weapon;

import static lsg.weapons.Weapon.DURABILITY_STAT_STRING;

/**
 *  RepairKit est la classe représentant un kit de réparation dans le jeu, il est hérité de la classe Consumable
 */
public class RepairKit extends Consumable {

    /**
     *  Constructeur d'un kit de réparation ayant pour nom "Repair Kit", et une capacité de 10
     */
    public RepairKit() {
        super("Repair Kit", 10, DURABILITY_STAT_STRING);
    }

    /**
     *  Utilise le kit de réparation en faisant baisser sa capacité de 1 à chaque utilisation.
     *
     * @return int      Retourne la capacité actuelle du kit de réparation
     */
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
