package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Iterator;

public class MenuBestOfV2 {
    private HashSet<Consumable> menu = new HashSet<Consumable>();

    private void init() {
        this.menu.add(new Hamburger());
        this.menu.add(new Wine());
        this.menu.add(new Americain());
        this.menu.add(new Coffe());
        this.menu.add(new Whisky());
    }

    public String toString() {
        int number = 1;
        String string = this.getClass()+" :" + System.lineSeparator();
        Iterator<Consumable> myMenu = menu.iterator();
        while(myMenu.hasNext()){
            string += number + " : " + myMenu.next() + System.lineSeparator();
            number++;
        }
        return string;
    }

    public static void main (String[] args) {
        MenuBestOfV2 bestOf = new MenuBestOfV2();
        bestOf.init();
        System.out.println(bestOf.toString());
    }

}
