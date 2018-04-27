package lsg;

import characters.Character;
import characters.Hero;
import characters.Lycanthrope;
import characters.Monster;
import consumables.Consumable;
import consumables.MenuBestOfV4;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.bags.MediumBag;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.buffs.rings.*;
import lsg.weapons.Weapon;
import lsg.buffs.talismans.MoonStone;
import lsg.buffs.talismans.Talisman;
import consumables.food.Hamburger;

import java.util.Scanner;
import java.util.Iterator;


public class LearningSoulsGame {

    private Scanner scanner = new Scanner(System.in) ;
    static public final String BULLET_POINT = "∙";
    static public final String TITLE = "###########################\n# THE LEARNING SOULS GAME #\n###########################";

    private ShotGun shotGun = new ShotGun("UltraPompe", 6, 20, 5, 100);
    private Sword sword = new Sword();
    private Hero hero = new Hero("Misfits");
    static Monster monstre1 = new Lycanthrope("Lycan");
    static Claw claw = new Claw("Bloody Claw", 20, 30, 5, 100);
    private BlackWitchVeil blackWitchVeil = new BlackWitchVeil();
    private DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
    static Monster lycanthrope = new Lycanthrope("Lycanthrope");
    static Ring ring = new DragonSlayerRing();
    static Consumable burger = new Hamburger();
    static Talisman moonStone = new MoonStone();


    public static void main(String[] args) {
        LearningSoulsGame game = new LearningSoulsGame();
        game.title();
        game.testBag();
    }

    public void title(){
        System.out.println(TITLE);
    }

    private void refresh(Character adversaire) {
        System.out.println(hero.toString());
        System.out.println(BULLET_POINT + hero.getWeapon().toString());
        System.out.println(BULLET_POINT + hero.getConsumable());
        System.out.println();
        System.out.println(adversaire.toString());
    }

    private void fight1v1(Character adversaire) {

        while (hero.isAlive() && adversaire.isAlive()) {

            refresh(adversaire);

            int dmg = 0;
            int dmgFinal = 0;
            int action = 0;
            while (action != 1 && action != 2) {
                System.out.println(hero.getName() + "'s action for next move : (1) attack | (2) consume");
                action = scanner.nextInt();
            }

            if (action == 1) {
                dmg = hero.attack();
                dmgFinal = adversaire.getHitWith(dmg);
                adversaire.getHitWith(dmgFinal);

                System.out.println(hero.getName() + " attacks " + adversaire.getName() + " with " + hero.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmgFinal);
                refresh(adversaire);
            }
            else if (action == 2) {
                hero.consume();
            }

            if (adversaire.getLife() <= 0) {
                System.out.println("Le gagnant est : " + hero.getName());
                break;
            }

            System.out.println("Tour du : " + adversaire.getName());
            scanner.nextLine();

            dmg = adversaire.attack();
            hero.getHitWith(dmg);
            System.out.println(adversaire.getName() + " attacks " + hero.getName() + " with " + adversaire.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            scanner.nextLine();
        }

        if (hero.getLife() > 0)
            System.out.println("Le gagnant est : " + hero.getName());
        else
            System.out.println("Le gagnant est : " + adversaire.getName());
    }

    public void init() {
        lycanthrope.setWeapon(claw);
        lycanthrope.setTalisman(moonStone, 1);
        monstre1.setWeapon(claw);
        hero.setWeapon(sword);
        hero.setArmorItem(blackWitchVeil, 1);
        hero.setArmorItem(dragonSlayerLeggings, 2);
        //hero.setRing(ring, 1);
        hero.setConsumable(burger);
        fight1v1(lycanthrope);
    }

    public void play_v1() {
        init();
        fight1v1(monstre1);
    }

    public void play_v2() {
        monstre1.setWeapon(claw);
        hero.setWeapon(sword);
        hero.setArmorItem(blackWitchVeil, 1);
        fight1v1(monstre1);
    }

    public void play_v3() {
        hero.setWeapon(sword);
        hero.setArmorItem(blackWitchVeil, 1);
        hero.setArmorItem(dragonSlayerLeggings, 2);
        hero.setRing(ring, 1);
        fight1v1(lycanthrope);
    }

    public void createExhaustedHero() {
        hero = new Hero("Misfits épuisé");
        hero.getHitWith(99);
        Weapon GrosseArme = new Weapon("Grosse arme", 0, 0, 1000, 100);
        hero.setWeapon(GrosseArme);
        hero.attack();
        System.out.println(hero.toString());
    }

    public void aTable() {
        MenuBestOfV4 menuBestOfV4 = new MenuBestOfV4();
        menuBestOfV4.MenuBestOfV4();
        Iterator<Consumable> i = menuBestOfV4.iterator();
        while (i.hasNext()) {
            scanner.nextLine();
            Consumable consumable = i.next();
            hero.use(consumable);
            System.out.println(hero.toString());
            System.out.println("Après utilisation : " + consumable.toString());
        }
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
        hero.fastEat();
    }


}
