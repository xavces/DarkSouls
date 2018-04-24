package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Iterator;

public class MenuBestOfV3 extends HashSet<Consumable>{

    private void init() {
        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffe());
        this.add(new Whisky());
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
        MenuBestOfV3 bestOf = new MenuBestOfV3();
        bestOf.init();
        System.out.println(bestOf.toString());
    }

}
