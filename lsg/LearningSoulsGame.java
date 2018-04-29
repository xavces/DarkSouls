package lsg;

import lsg.armor.BlackWitchVeil;
import lsg.bags.MediumBag;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.rings.RingOfSwords;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.*;
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
        System.out.println(hero.armorToString());
        hero.printRings();
        hero.printConsumable();
        System.out.println("WEAPON : " + hero.getWeapon());
        hero.printBag();
        System.out.println();
        monster.printStats();
        System.out.println("WEAPON : " + monster.getWeapon());
    }

    private void init(){
        hero.setWeapon(new Sword());
        monster.setWeapon(new Claw());
        hero.setConsumable(new Hamburger());
    }

    private void fight1v1 (){
        while(hero.isAlive() && monster.isAlive()) {
            int flag = 0;
            int attackHero;
            while(flag == 0) {
                System.out.println("Appuyer sur 1 pour attaquer ou sur 2 pour consommer.");
                int action = scanner.nextInt();
                if (action == 1) {

                    // On fait un try catch si le monstre n'a aucune arme
                    try {
                        attackHero = hero.attack();
                    } catch (WeaponNullException weaponNullException) {
                        System.out.println("WARNING : no weapon has been equipped !!!");
                        attackHero = 0;
                    } catch (WeaponBrokenException weaponBrokenException) {
                        System.out.println("WARNING : weapon has broken");
                        attackHero = 0;
                    } catch (StaminaEmptyException staminaEmptyException) {
                        System.out.println("ACTION HAS NO EFFECT : no more stamina!!!");
                        attackHero = 0;
                    }

                // On enlève la vie au monstre
                    int damageOnMonster = monster.getHitWith(attackHero);

                    //On gère l'affichage de l'attaque
                    System.out.println("!!! " + hero.getName() + " attack " + monster.getName() + " with " + hero.getWeapon() +
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
                    try {
                        hero.use(hero.getConsumable());
                    } catch (ConsumeNullException e) {
                        System.out.println("IMPOSSIBLE ACTION : no consumable has been equiped !");
                    } catch (ConsumeEmptyException e) {
                        System.out.println("ACTION HAS NO EFFECT : " + hero.getConsumable().getName() + " is empty !");
                    } catch (ConsumeRepairNullWeaponException e) {
                        System.out.println("IMPOSSIBLE ACTION : no weapon has been equiped !");
                    }
                    refresh();
                    flag = 1;
                    scanner.nextLine();
                }
            }



            int attackMonster;
            //On repète les même opération avec le monstre
            // On fait un try catch si le monstre n'a aucune arme
            try{
                attackMonster = monster.attack();
            } catch (WeaponNullException weaponNullException) {
                System.out.println("WARNING : no weapon has been equipped !!!");
                attackMonster = 0;
            } catch (WeaponBrokenException weaponBrokenException) {
                System.out.println("WARNING : weapon has broken");
                attackMonster = 0;
            } catch (StaminaEmptyException staminaEmptyException) {
                System.out.println("ACTION HAS NO EFFECT : no more stamina!!!");
                attackMonster = 0;
            }
            int damageOnHero = hero.getHitWith(attackMonster);
            System.out.println("!!! " + monster.getName() + " attack " + hero.getName() + " with " + monster.getWeapon() +
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

    private void play_v2() {
        init();
        hero.setArmorItem(new BlackWitchVeil(), 1);
        fight1v1();
    }

    private void play_v3() {
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
        try {
            hero.attack();
        } catch (WeaponNullException weaponNullException) {
            weaponNullException.printStackTrace();
        } catch (WeaponBrokenException weaponBrokenException) {
            weaponBrokenException.printStackTrace();
        } catch (StaminaEmptyException staminaEmptyException) {
            staminaEmptyException.printStackTrace();
        }
        refresh();
    }


    private void title(){
        System.out.println("##############################" + System.lineSeparator() +
                "##   The Learning Soul Game ##" + System.lineSeparator() +
        "##############################");
    }

    private void testExceptions() {
        hero.setWeapon(null);
        fight1v1();
    }


    public static void main(String[] args) {
        LearningSoulsGame lsg = new LearningSoulsGame();
        //lsg.createExhaustedHero();
        lsg.title();
        lsg.init();
        lsg.testExceptions();
        lsg.refresh();
        //lsg.play_v3();
        //lsg.refresh();
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
