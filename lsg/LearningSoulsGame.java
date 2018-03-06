package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;

import java.util.Scanner;

public class LearningSoulsGame {
    static Scanner scanner = new Scanner(System.in) ;

    static Hero hero = new Hero();
    static Monster monster = new Monster();

    static Sword mySword = new Sword("Basic Sword", 5, 10, 20, 100);
    static Sword mySword2 = new Sword("Basic Sword2", 5, 10, 20, 100);
    static ShotGun myShotGun = new ShotGun("Basic ShotGun", 6, 20, 5, 100);
    static Claw myClaw = new Claw("Bloody Claw", 50, 150, 5, 100);

    public static void main(String[] args) {
        play_v1();
    }

    private static void refresh (){
        System.out.println(hero.toString());
        System.out.println(monster.toString());
    }

    private static void fight1v1(){
        while(hero.isAlive() && monster.isAlive()) {
            refresh();
            int attackHero = hero.attack();
            monster.setLife(monster.getLife() - monster.getHitWith(attackHero));
            System.out.println("!!! " + hero.getName() + " attack " + monster.getName() + " with " + hero.getWeapon().getName() +
                    "(" + attackHero + ") !!!");
            int attackMonster = monster.attack();
            hero.setLife(hero.getLife() - hero.getHitWith(attackMonster));
            System.out.println("!!! " + monster.getName() + " attack " + hero.getName() + " with " + monster.getWeapon().getName() +
                    "(" + attackMonster + ") !!!");
            scanner.nextLine();
        }
        if(hero.isAlive())
            System.out.println(hero.getName() + " WINS !!!");
        else
            System.out.println(monster.getName() + " WINS !!!");

    }

    private static void init(){
        hero.setWeapon(mySword);
        monster.setWeapon(mySword2);
    }

    private static void play_v1(){
        init();
        fight1v1();
    }
}
