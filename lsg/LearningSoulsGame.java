package lsg;

import lsg.armor.BlackWitchVeil;
import lsg.bags.MediumBag;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.rings.RingOfSwords;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Hamburger;
import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

import java.util.Iterator;
import java.util.Scanner;

public class LearningSoulsGame {

    /**
     * Méthode main pour test des dès
     * @param args
     */

/*    public static void main(String[] args) {
        Dice dice = new Dice(50);
        int min = 50, max=0;
        for(int i=0; i<500; i++){
            int roll = dice.roll();
            if(roll < min)
                min = roll;
            if (roll > max)
                max = roll;
        }
        System.out.println("max :" + max + " min : " + min);
    }*/



    /**
     * Fin TP2
     */

    Hero hero = new Hero("Takavore");
    Monster monster = new Monster("Bobinator");

    Scanner scanner = new Scanner(System.in);

    public static final String BULLET_POINT = "\u2219";

    /**
     * Fonction qui affiche l'affichage des 2 personnages
     */
    private void refresh (){
        hero.printStats();
        System.out.println(BULLET_POINT + hero.getWeapon().toString());
        System.out.println(BULLET_POINT + hero.getConsumable());
        monster.printStats();
    }

    private void init(){
        hero.setWeapon(new Sword());
        monster.setWeapon(new Claw());
        hero.setConsumable(new Hamburger());
    }

    private void fight1v1 (){
        while(hero.isAlive() && monster.isAlive()) {
            int flag = 0;

            while(flag == 0) {
                System.out.println("Appuyer sur 1 pour attaquer ou sur 2 pour consommer.");
                int action = scanner.nextInt();
                if (action == 1) {
                    int attackHero = hero.attack();

                    // On enlève la vie au monstre
                    int damageOnMonster = monster.getHitWith(attackHero);

                    //On gère l'affichage de l'attaque
                    System.out.println("!!! " + hero.getName() + " attack " + monster.getName() + " with " + hero.getWeapon().getName() +
                            "(Attack:" + attackHero + " Damage : " + damageOnMonster + ") !!!");

                    if (!monster.isAlive()) {
                        refresh();
                        System.out.println(hero.getName() + " WINS !!!");
                        break;
                    }
                    refresh();
                    flag = 1;
                    scanner.nextLine();
                }
                if (action == 2) {
                    hero.use(hero.getConsumable());
                    refresh();
                    flag = 1;
                    scanner.nextLine();
                }
            }




            //On repète les même opération avec le monstre
            int attackMonster = monster.attack();
            int damageOnHero = hero.getHitWith(attackMonster);
            System.out.println("!!! " + monster.getName() + " attack " + hero.getName() + " with " + monster.getWeapon().getName() +
                    "(Attack:" + attackMonster + " Damage:" + damageOnHero  + ") !!!");
            if (!hero.isAlive()) {
                refresh();
                System.out.println(monster.getName() + " WINS !!!");
                break;
            }
            refresh();


        }
    }
    private void play_v1() {
        init();
        fight1v1();
    }

    private void play_v2(){
        init();
        hero.setArmorItem(new BlackWitchVeil(), 1);
        fight1v1();
    }

    private void play_v3(){
        init();
        hero.setArmorItem(new BlackWitchVeil(), 1);
        monster = new Lycanthrope();
        hero.setRing(new RingOfDeath(), 1);
        hero.setRing(new RingOfSwords(), 2);
        fight1v1();
    }

    /**
     * TP4
     *
     */

    private void createExhaustedHero(){
        hero = new Hero();
        hero.getHitWith(99);
        hero.setWeapon(new Weapon("Grosse Arme", 0, 0, 1000, 100));
        hero.attack();
        refresh();
    }

    private void aTable(){
        MenuBestOfV4 menu = new MenuBestOfV4();
        menu.init();
        Iterator<Consumable> myMenu = menu.iterator();
        while(myMenu.hasNext()) {
            Consumable element = myMenu.next();
            hero.use(element);
            refresh();
        }
        System.out.println(hero.getWeapon().toString());
    }

    private void title(){
        System.out.println("##############################" + System.lineSeparator() +
                "##   The Learning Soul Game ##" + System.lineSeparator() +
        "##############################");
    }

    public void testBag() {
        createExhaustedHero();
        Sword sword = new Sword();
        BlackWitchVeil blackWitchVeil = new BlackWitchVeil();
        RingOfDeath ringOfDeath = new RingOfDeath();
        Whisky whisky = new Whisky();
        Hamburger hamburger = new Hamburger();
        Wine wine = new Wine();
        MediumBag mediumBag = new MediumBag();


        hero.pickUp(sword);
        hero.pickUp(blackWitchVeil);
        hero.pickUp(ringOfDeath);
        System.out.println("----- INVENTAIRE -----");
        hero.printBag();
        hero.setBag(mediumBag);
        hero.printBag();
        hero.equip(ringOfDeath, 1);
        hero.equip(blackWitchVeil, 1);
        hero.pickUp(whisky);
        hero.pickUp(wine);
        hero.pickUp(hamburger);
        hero.printBag();
        refresh();
        hero.fastEat();
    }

    public static void main(String[] args) {
        LearningSoulsGame lsg = new LearningSoulsGame();
        //lsg.createExhaustedHero();
        //lsg.aTable();
        lsg.title();
        //lsg.play_v3();
        lsg.testBag();
        lsg.refresh();
    }



//    public static void main(String[] args) {
//        Hero hero1 = new Hero("Takavore");
//        Hero hero2 = new Hero();
//
//        Monster monster1 = new Monster("Bobinator");
//        Monster monster2 = new Monster();
//        Monster monster3 = new Monster("Rafikosor");
//        Monster monster4 = new Monster();
//
//        hero1.printStats();
//        hero2.printStats();
//
//        monster1.printStats();
//        monster2.printStats();
//        monster3.printStats();
//        monster4.printStats();
//    }
}
