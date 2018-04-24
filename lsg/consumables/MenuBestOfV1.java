package lsg.consumables;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.lang.reflect.Array;

public class MenuBestOfV1 {
    private Consumable menu[] = new Consumable[5];

    private void init() {
        this.menu[0] = new Hamburger();
        this.menu[1] = new Wine();
        this.menu[2] = new Americain();
        this.menu[3] = new Coffe();
        this.menu[4] = new Whisky();
    }

    public String toString() {
        String string = this.getClass()+" :" + System.lineSeparator();
        for (int i = 0; i < this.menu.length; i++) {
            string += i+1 + " : " + this.menu[i] + System.lineSeparator();
        }
        return string;
    }

    public static void main (String[] args) {
        MenuBestOfV1 bestOf = new MenuBestOfV1();
        bestOf.init();
        System.out.println(bestOf.toString());
    }

}
