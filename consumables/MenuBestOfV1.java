package consumables;

import consumables.drinks.Coffee;
import consumables.drinks.Drink;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

public class MenuBestOfV1 {

    public Consumable[] menu;

    public MenuBestOfV1() {
        menu = new Consumable[]{
                new Hamburger(),
                new Wine(),
                new Americain(),
                new Coffee(),
                new Whisky()
        };
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
}
