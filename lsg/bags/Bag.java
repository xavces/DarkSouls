package lsg.bags;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;

import java.util.HashSet;
import java.util.Iterator;

import static lsg.LearningSoulsGame.BULLET_POINT;

public class Bag {

    private int capacity;
    private int weight;
    private HashSet<Collectible> items = new HashSet<>();

    /**
     *
     * @return Le poid total du sac
     */
    public int getWeight() {
        return weight;
    }

    /**
     *  Défini le poid du sac
     * @param weight
     */
    private void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @return Le nombre d'item maximum dans le sac
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Défini le nombre d'item maximum dans le sac
     * @param capacity
     */
    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Constructeur global d'un sac prenant en paramètre sa capacité max
     * @param capacity
     */
    public Bag(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Ajout d'un objet(item) dans le sac
     * @param item
     */
    public void push(Collectible item){
        if (item.getWeight() <=  this.capacity - this.weight) {
            items.add(item);
            this.setWeight(this.getWeight() + item.getWeight());
        }
    }

    /**
     * Retire un objet(item) du sac
     * @param item
     * @return L'item si il était présent dans le sac, null sinon
     */
    public Collectible pop(Collectible item){
        if(items.contains(item)) {
            this.setWeight(this.getWeight() - item.getWeight());
            items.remove(item);
            return item;
        }
        return null;
    }

    /**
     * Vérifie que le sac contient un item donné
     * @param item
     * @return true or false
     */
    public boolean contains(Collectible item){
        return(items.contains(item));
    }

    /**
     *
     * @return Tableau comportant tout les items dans le sac
     */
    public Collectible[] getItems(){
        return items.toArray(new Collectible[items.size()]);
    }

    /**
     * Surcharge de la méthode toString
     * @return Chaine de caractère listant tout les objets du sac
     */
    @Override
    public String toString(){
        String string = this.getClass() + " [ " + this.items.size() + " | " +
                this.weight + "/" + this.capacity + " kg ]" + System.lineSeparator();
        if(weight == 0){
            return string + BULLET_POINT + "empty";
        }
        Iterator<Collectible> myItems = this.items.iterator();
        while(myItems.hasNext()){
            Collectible item = myItems.next();
            string += BULLET_POINT + item.toString() + " [" + item.getWeight() + " kg]" + System.lineSeparator();
        }
        return string;


    }

    /**
     * Effectue un échange d'objet entre 2 sacs
     * @param from
     * @param into
     */
    public static void transfer(Bag from, Bag into){
        for(Collectible objectFromBag : from.getItems()){
            if(objectFromBag.getWeight() > from.capacity - from.weight){
                return;
            }
            into.push(objectFromBag);
            from.pop(objectFromBag);

        }
    }

    /**
     * Main de Test des fonctions
     * @param args
     */
    public static void main(String[] args) {
        DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
        RingedKnightArmor ringedKnightArmor = new RingedKnightArmor();
        SmallBag myBag = new SmallBag();
        SmallBag myBag2 = new SmallBag();
        System.out.println("Bag 1 : " + myBag.toString());
        myBag.push(dragonSlayerLeggings);
        System.out.println("Bag 1 : " + myBag.toString());
        myBag.push(ringedKnightArmor);
        System.out.println("Bag 1 : " + myBag.toString());
        myBag.pop(dragonSlayerLeggings);
        System.out.println("Bag 1 : " + myBag.toString());
        System.out.println("Bag 2 : " + myBag2.toString());
        transfer(myBag, myBag2);
        System.out.println("After Transfer : " + System.lineSeparator());
        System.out.println("Bag 1 : " + myBag.toString());
        System.out.println("Bag 2 : " + myBag2.toString());


    }
}
