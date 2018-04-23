package lsg;

import characters.Character;
import characters.Hero;
import characters.Lycanthrope;
import characters.Monster;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.buffs.rings.*;

import java.util.Scanner;


public class LearningSoulsGame {

    static Scanner scanner = new Scanner(System.in) ;

    static ShotGun shotGun = new ShotGun("UltraPompe", 6, 20, 5, 100);
    static Sword sword = new Sword();
    static Hero hero = new Hero("Misfits");
    static Monster monstre1 = new Monster();
    static Claw claw = new Claw("Bloody Claw", 50, 150, 5, 100);
    static BlackWitchVeil blackWitchVeil = new BlackWitchVeil("Black Witch Veil", (float) 4.6);
    static DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings("Dragon Slayer Leggings", (float) 10);
    static Character lycanthrope = new Lycanthrope("Lycanthrope");
    static Ring ring = new RingOfDeath();


    public static void main(String[] args) {
        play_v3();
    }

    private static void refresh(Character adversaire) {
        System.out.println(adversaire.toString());
        System.out.println(hero.toString());

    }

    private static void fight1v1(Character adversaire) {
        refresh(adversaire);
        while (hero.isAlive() && adversaire.isAlive()) {
            int dmg = hero.attack();
            adversaire.getHitWith(dmg);
            System.out.println(hero.getName() + " attacks " + adversaire.getName() + " with " + hero.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            refresh(adversaire);
            scanner.nextLine();

            if (adversaire.getLife() <= 0) {
                System.out.println("Le gagnant est : " + hero.getName());
                break;
            }
            dmg = adversaire.attack();
            hero.getHitWith(dmg);
            System.out.println(adversaire.getName() + " attacks " + hero.getName() + " with " + adversaire.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            refresh(adversaire);
            scanner.nextLine();
        }

        if (hero.getLife() > 0)
            System.out.println("Le gagnant est : " + hero.getName());
        else
            System.out.println("Le gagnant est : " + adversaire.getName());
    }

    public static void init() {
        monstre1.setWeapon(claw);
        hero.setWeapon(sword);
    }

    public static void play_v1() {
        init();
        fight1v1(monstre1);
    }

    public static void play_v2() {
        monstre1.setWeapon(claw);
        hero.setWeapon(sword);
        hero.setArmorItem(blackWitchVeil, 1);
        fight1v1(monstre1);
    }

    public static void play_v3() {
        hero.setWeapon(sword);
        hero.setArmorItem(blackWitchVeil, 1);
        hero.setArmorItem(dragonSlayerLeggings, 2);
        hero.setRing(ring, 1);
        fight1v1(lycanthrope);
    }
}
