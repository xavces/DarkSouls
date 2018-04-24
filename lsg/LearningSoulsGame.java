package lsg;

import lsg.characters.Hero;
import lsg.characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.Sword;

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

    /**
     * Fonction qui affiche l'affichage des 2 personnages
     */
    private void refresh (){
        hero.printStats();
        monster.printStats();
    }

    private void init(){
        hero.setWeapon(new Sword());
        monster.setWeapon(new Claw());
    }

    private void fight1v1 (){
        while(hero.isAlive() && monster.isAlive()) {


            // Tour du héro, on génère son attaque
            int attackHero = hero.attack();

            // On enlève la vie au monstre
            monster.getHitWith(attackHero);

            //On gère l'affichage de l'attaque
            System.out.println("!!! " + hero.getName() + " attack " + monster.getName() + " with " + hero.getWeapon().getName() +
                    "(" + attackHero + ") !!!");

            if (!monster.isAlive()) {
                refresh();
                System.out.println(hero.getName() + " WINS !!!");
                break;
            }
            refresh();
            scanner.nextLine();


            //On repète les même opération avec le monstre
            int attackMonster = monster.attack();
            hero.getHitWith(attackMonster);
            System.out.println("!!! " + monster.getName() + " attack " + hero.getName() + " with " + monster.getWeapon().getName() +
                    "(" + attackMonster + ") !!!");
            if (!hero.isAlive()) {
                refresh();
                System.out.println(monster.getName() + " WINS !!!");
                break;
            }
            refresh();
            // On attend que l'utilisateur appuie sur Entrée
            scanner.nextLine();

        }
    }
    private void play_v1() {
        init();
        fight1v1();
    }

    public static void main(String[] args) {
        LearningSoulsGame lsg = new LearningSoulsGame();
        lsg.play_v1();

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
