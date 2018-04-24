package consumables;

import com.intellij.vcs.log.Hash;
import consumables.drinks.Coffee;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Iterator;

public class MenuBestOfV3 extends HashSet<Consumable> {

    public MenuBestOfV3() {

        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffee());
        this.add(new Whisky());
    }

    @Override
    public String toString() {
        String string = getClass().getSimpleName();
        int nb = 1;
        Iterator<Consumable> i = this.iterator();
        while (i.hasNext()) {
            string += "\n" + (nb) + " : " + i.next().toString();
            nb++;
        }
        return string;
    }

    public static void main(String[] args) {
        MenuBestOfV3 menu = new MenuBestOfV3();
        System.out.print(menu.toString());
    }
}
