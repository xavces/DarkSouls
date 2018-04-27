package lsg.bags;

import consumables.food.Hamburger;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.weapons.Sword;

import java.util.HashSet;

import static lsg.LearningSoulsGame.BULLET_POINT;

/**
 *  Bag est la classe représentant un sac.
 */
public class Bag {

    /**
     *  La capacité du sac
     */
    private int capacity;

    /**
     *  Le poids utilisé dans le sac
     */
    private int weight;

    /**
     *  Une liste nous permettant de stocké des Collectible
     */
    private HashSet<Collectible> items;

    /**
     *  Renvoie la capacité du sac
     *
     * @return int      La capacité du sac
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *  Renvoie le poids utilisé dans le sac
     *
     * @return int      Le poids utilisé dans le sac
     */
    public int getWeight() {
        return weight;
    }

    /**
     *  Constructeur du sac.
     *
     * @param capacity      Capacité du sac
     */
    public Bag(int capacity) {
        this.capacity = capacity ;
        items = new HashSet<Collectible>() ;
    }

    /**
     *  Permet de mettre un Collectible dans le sac. Ne peut pas s'il n'y a pas assez de place
     *
     * @param item      Item à mettre dans le sac
     */
    public void push(Collectible item){
        if (capacity >= (item.getWeight() + this.weight)) {
            items.add(item);
            weight += item.getWeight();
        }
    }

    /**
     *  Permet de sortir un Collectible du sac. Vérifie si le Collectible est bien dedans.
     *
     * @param item      Item à retiré du sac
     */
    public Collectible pop(Collectible item) {
        if (items.contains(item)) {
            items.remove(item);
            this.weight -= item.getWeight();
            return item;
        }
        else
            return null;
    }

    /**
     *  Vérifie si le Collectible est bien dans le sac
     *
     * @return boolean      True s'il y est
     */
    public boolean contains(Collectible item) {
        return items.contains(item);
    }

    /**
     *  Renvoie un tableau contenant tous les items du sac
     *
     * @return Collectible[]    Les items
     */
    public Collectible[] getItems() {
        return items.toArray(new Collectible[items.size()]);
    }

    /**
     *  transfert le contenu d'un sac dans un autre
     *
     * @param from      Sac initial
     * @param into      Sac déstinataire
     */
    public static void transfer(Bag from, Bag into) {
        for(Collectible item: from.getItems()) {
            if (item.getWeight() > (from.getCapacity() + from.getWeight()))
                return;
            into.push(item);
            from.pop(item);
        }
    }

    @Override
    public String toString() {
        String nameClass = getClass().getSimpleName();
        String string = nameClass;
        string += "[ " + this.items.size() + " items | " + this.weight+ "/" + getCapacity() + " kg ]\n";

        if (this.weight == 0)
            return string + BULLET_POINT + "empty\n";
        else {
            for (Collectible item: items) {
                string +=  BULLET_POINT + item.toString() + "[" + item.getWeight() + " kg]\n";
            }
        }
        return string;
    }

    public static void main (String[] args) {

        SmallBag smallBag = new SmallBag();
        MediumBag mediumBag = new MediumBag();
        BlackWitchVeil blackWitchVeil = new BlackWitchVeil();
        Hamburger hamburger = new Hamburger();
        Sword sword = new Sword();
        DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();

        smallBag.push(blackWitchVeil);
        smallBag.push(hamburger);
        smallBag.push(sword);
        smallBag.push(dragonSlayerLeggings);
        System.out.println(smallBag);

        smallBag.pop(dragonSlayerLeggings);
        System.out.println("\nPop sur " + dragonSlayerLeggings.toString() + "\n");

        System.out.println(smallBag);

        transfer(smallBag, mediumBag);
        System.out.println("\n\nTransfert Small bag -> Medium bag : \n");

        System.out.println("Small bag : \n");
        System.out.println(smallBag);
        System.out.println("Medium bag : \n");
        System.out.println(mediumBag);
    }

}
