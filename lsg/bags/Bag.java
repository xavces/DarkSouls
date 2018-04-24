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

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public void push(Collectible item){
        if (item.getWeight() <=  this.capacity - this.weight) {
            items.add(item);
            this.setWeight(this.getWeight() + item.getWeight());
        }
    }

    public Collectible pop(Collectible item){
        if(items.contains(item)) {
            this.setWeight(this.getWeight() - item.getWeight());
            items.remove(item);
            return item;
        }
        return null;
    }

    public boolean contains(Collectible item){
        return(items.contains(item));
    }

    public Collectible[] getItems(){
        return items.toArray(new Collectible[items.size()]);
    }

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

    public static void transfer(Bag from, Bag into){
        for(Collectible objectFromBag : from.getItems()){
            if(objectFromBag.getWeight() > from.capacity - from.weight){
                return;
            }
            into.push(objectFromBag);
            from.pop(objectFromBag);

        }
    }

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
