package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;

import java.util.Scanner;

public class LearningSoulsGame {
    /**
     * Définition de tout les objets qu'on aura besoin dans la classe
     * On les déclare en static car on va vouloir les appeller sans instance
     */
    static Scanner scanner = new Scanner(System.in) ;

    static Hero hero = new Hero();
    static Monster monster = new Monster();

    static Sword mySword = new Sword("Basic Sword", 5, 10, 20, 100);
    static Sword mySword2 = new Sword("Basic Sword2", 5, 10, 20, 100);
    static ShotGun myShotGun = new ShotGun("Basic ShotGun", 6, 20, 5, 100);
    static Claw myClaw = new Claw("Bloody Claw", 50, 150, 5, 100);

    /**
     * Méthode main Rien à dire
     * @param args
     */
    public static void main(String[] args) {
        play_v1();
    }

    /**
     * Fonction qui affiche l'affichage des 2 personnages
     */
    private static void refresh (){
        System.out.println(hero.toString());
        System.out.println(monster.toString());
    }

    /**
     * Fonction du combat
     * gère le tour des héros, leur attaque et la victoire
     */
    private static void fight1v1(){
        // On vérifie que le héro et le monstre sont encore en vie
        while(hero.isAlive() && monster.isAlive()) {
            refresh();

            // Tour du héro, on génère son attaque
            int attackHero = hero.attack();

            // On enlève la vie au monstre
            monster.setLife(monster.getLife() - monster.getHitWith(attackHero));

            //On gère l'affichage de l'attaque
            System.out.println("!!! " + hero.getName() + " attack " + monster.getName() + " with " + hero.getWeapon().getName() +
                    "(" + attackHero + ") !!!");

            //On repète les même opération avec le monstre
            int attackMonster = monster.attack();
            hero.setLife(hero.getLife() - hero.getHitWith(attackMonster));
            System.out.println("!!! " + monster.getName() + " attack " + hero.getName() + " with " + monster.getWeapon().getName() +
                    "(" + attackMonster + ") !!!");

            // On attend que l'utilisateur appuie sur Entrée
            scanner.nextLine();
        }

        // On affiche qui a gagné
        if(hero.isAlive())
            System.out.println(hero.getName() + " WINS !!!");
        else
            System.out.println(monster.getName() + " WINS !!!");

    }

    /**
     * Initialisation de l'arme des héros
     */
    private static void init(){
        hero.setWeapon(mySword);
        monster.setWeapon(mySword2);
    }

    /**
     * Fonction qui gère le jeu
     */
    private static void play_v1(){
        init();
        fight1v1();
    }
}
