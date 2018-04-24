package consumables;

import consumables.drinks.Coffee;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {
    public void MenuBestOfV4() {

        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffee());
        this.add(new Whisky());
    }

    @Override
    public String toString() {
        String string = getClass().getSimpleName();
        int nb = 0;
        Iterator<Consumable> i = this.iterator();
        while (i.hasNext()) {
            string += "\n" + (nb + 1) + " : " + i.next().toString();
            nb++;
        }
        return string;
    }

    public static void main(String[] args) {
        MenuBestOfV4 menu = new MenuBestOfV4();
        System.out.print(menu.toString());
    }
}
