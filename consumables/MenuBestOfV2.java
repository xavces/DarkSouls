package consumables;

import consumables.drinks.Coffee;
import consumables.drinks.Drink;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

import java.util.HashSet;

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
        for(int i = 0; i < menu.length; i++){
            string += "\n" + (i+1) + " : " + menu[i].toString();
        }
        return string;
    }

    public static void main(String[] args){
        MenuBestOfV1 menu = new MenuBestOfV1();
        System.out.print(menu.toString());
    }
