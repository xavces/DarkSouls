package lsg;

import characters.Hero;
import characters.Monster;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;

import java.util.Scanner;


public class LearningSoulsGame {

    static Scanner scanner = new Scanner(System.in) ;

    static ShotGun shotGun = new ShotGun("UltraPompe", 6, 20, 5, 100);
    static Sword sword = new Sword("Basic Sword", 5, 10, 20, 100);
    static Hero hero = new Hero("Misfits");
    static Monster monstre1 = new Monster();
    static Claw claw = new Claw("Bloody Claw", 50, 150, 5, 100);


    public static void main(String[] args) {
        init();
        fight1v1();
    }

    private static void refresh() {
        System.out.println(monstre1.toString());
        System.out.println(hero.toString());

    }

    private static void fight1v1() {
        refresh();
        while (hero.isAlive() && monstre1.isAlive()) {
            int dmg = hero.attack();
            monstre1.getHitWith(dmg);
            System.out.println(hero.getName() + " attacks " + monstre1.getName() + " with " + hero.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            refresh();
            scanner.nextLine();

            if (monstre1.getLife() <= 0) {
                System.out.println("Le gagnant est : " + hero.getName());
                break;
            }
            dmg = monstre1.attack();
            hero.getHitWith(dmg);
            System.out.println(monstre1.getName() + " attacks " + hero.getName() + " with " + monstre1.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            refresh();
            scanner.nextLine();
        }

        if (hero.getLife() > 0)
            System.out.println("Le gagnant est : " + hero.getName());
        else
            System.out.println("Le gagnant est : " + monstre1.getName());
    }

    public static void init() {
        monstre1.setWeapon(claw);
        hero.setWeapon(sword);
    }
}
