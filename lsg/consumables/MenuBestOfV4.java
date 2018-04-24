package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {

    public void init() {
        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffe());
        this.add(new Whisky());
        this.add(new RepairKit());
    }

    public String toString() {
        int number = 1;
        String string = this.getClass()+" :" + System.lineSeparator();
        Iterator<Consumable> myMenu = this.iterator();
        while(myMenu.hasNext()){
            string += number + " : " + myMenu.next() + System.lineSeparator();
            number++;
        }
        return string;
    }

    public static void main (String[] args) {
        MenuBestOfV4 bestOf = new MenuBestOfV4();
        bestOf.init();
        System.out.println(bestOf.toString());
    }

}
