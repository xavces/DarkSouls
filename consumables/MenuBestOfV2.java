package consumables;

import consumables.drinks.Coffee;
import consumables.drinks.Drink;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Iterator;

public class MenuBestOfV2 {

    private HashSet<Consumable> menu;

    public MenuBestOfV2() {

        menu = new HashSet<>();
        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffee());
        menu.add(new Whisky());
    }

    @Override
    public String toString() {
        String string = getClass().getSimpleName();
        int nb = 0;
        Iterator<Consumable> i = menu.iterator();
        while (i.hasNext()) {
            string += "\n" + (nb + 1) + " : " + i.next().toString();
        }
        return string;
    }

    public static void main(String[] args) {
        MenuBestOfV2 menu = new MenuBestOfV2();
        System.out.print(menu.toString());
    }
}
