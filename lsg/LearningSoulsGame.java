package lsg;

import lsg.characters.Hero;
import lsg.characters.Monster;

public class LearningSoulsGame {

    public static void main(String[] args) {
        Hero hero1 = new Hero("Takavore");
        Hero hero2 = new Hero();

        Monster monster1 = new Monster("Bobinator");
        Monster monster2 = new Monster();
        Monster monster3 = new Monster("Rafikosor");
        Monster monster4 = new Monster();

        hero1.printStats();
        hero2.printStats();

        monster1.printStats();
        monster2.printStats();
        monster3.printStats();
        monster4.printStats();
    }
}
