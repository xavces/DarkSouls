package lsg;

import characters.Character;
import characters.Hero;
import characters.Lycanthrope;
import characters.Monster;
import consumables.Consumable;
import consumables.MenuBestOfV4;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.repair.RepairKit;
import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.bags.MediumBag;
import lsg.exceptions.*;
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

    private Hero hero;
    private Monster monster;
    private ShotGun shotGun = new ShotGun("UltraPompe", 6, 20, 5, 0);
//    private Sword sword = new Sword();
//    private Hero hero = new Hero("Misfits");
//    static Monster monstre1 = new Lycanthrope("Lycan");
//    static Claw claw = new Claw("Bloody Claw", 20, 30, 5, 100);
//    private BlackWitchVeil blackWitchVeil = new BlackWitchVeil();
//    private DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
//    static Monster lycanthrope = new Lycanthrope("Lycanthrope");
//    static Ring ring = new DragonSlayerRing();
//    static Consumable burger = new Hamburger();
//    static Talisman moonStone = new MoonStone();


    public static void main(String[] args) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, NoBagException, BagFullException {
        LearningSoulsGame game = new LearningSoulsGame();
        game.title();
        game.init();
        game.testExceptions();
    }

    public void title(){
        System.out.println(TITLE);
    }

    private void refresh() throws NoBagException {
        //System.out.println(hero.toString());
        System.out.println(hero.armorToString());
        hero.printRings();
        hero.printConsumable();
        System.out.println(hero.getWeapon());
        hero.printBag();
        System.out.println();
        System.out.println(monster.toString());
        System.out.println(monster.getWeapon().toString());
    }

    private void fight1v1(Character adversaire) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, NoBagException {

        while (hero.isAlive() && adversaire.isAlive()) {

            refresh();

            int dmg = 0;
            int dmgFinal = 0;
            int action = 0;
            while (action != 1 && action != 2) {
                System.out.println(hero.getName() + "'s action for next move : (1) attack | (2) consume");
                action = scanner.nextInt();
            }

            if (action == 1) {
                try {
                    dmg = hero.attack();
                } catch (WeaponNullException weaponNullException) {
                    System.out.println("WARNING : no weapon has been equipped !!!");
                    dmg = 0;
                } catch (WeaponBrokenException weaponBrokenException) {
                    dmg = 0;
                } catch (StaminaEmptyException staminaEmptyException) {
                    dmg = 0;
                }
                dmgFinal = adversaire.getHitWith(dmg);
                adversaire.getHitWith(dmgFinal);

                System.out.println(hero.getName() + " attacks " + adversaire.getName() + " with " + hero.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmgFinal + ")");
                //refresh();
            }
            else if (action == 2) {
                try {
                    hero.consume();
                } catch (ConsumeNullException consumeNullException) {

                } catch (ConsumeEmptyException consumeEmptyException) {

                } catch (ConsumeRepairNullWeaponException e) {
                    System.out.println("IMPOSSIBLE ACTION : no weapon has been equipped !!!");
                }
            }

            if (adversaire.getLife() <= 0) {
                System.out.println("Le gagnant est : " + hero.getName());
                break;
            }

            System.out.println("Tour du : " + adversaire.getName());
            scanner.nextLine();

            try {
                dmg = adversaire.attack();
            } catch (StaminaEmptyException staminaEmptyException) {
                dmg = 0;
            }
            hero.getHitWith(dmg);
            System.out.println(adversaire.getName() + " attacks " + hero.getName() + " with " + adversaire.getWeapon() + "(ATTACK:" + dmg + " | DMG:" + dmg);
            scanner.nextLine();
        }

        if (hero.getLife() > 0)
            System.out.println("Le gagnant est : " + hero.getName());
        else
            System.out.println("Le gagnant est : " + adversaire.getName());
    }

    public void init() throws WeaponNullException {
        hero = createExhaustedHero();
        monster = new Monster();
        monster.setWeapon(new Claw());
        monster.setTalisman(new MoonStone(), 1);
        hero.setWeapon(new Sword());
    }


    public void testExceptions() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, BagFullException, NoBagException {
        hero.setWeapon(null);
        hero.setConsumable(new RepairKit());
        hero.setBag(new MediumBag());
        fight1v1(monster);
    }

    public void play_v1() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, NoBagException {
        init();
        fight1v1(monster);
    }

    public void play_v2() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, NoBagException {
        monster.setWeapon(new Claw());
        hero.setWeapon(new Sword());
        hero.setArmorItem(new BlackWitchVeil(), 1);
        fight1v1(monster);
    }

    public void play_v3() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException, NoBagException {
        hero.setWeapon(new Claw());
        hero.setArmorItem(new BlackWitchVeil(), 1);
        hero.setArmorItem(new DragonSlayerLeggings(), 2);
        hero.setRing(new DragonSlayerRing(), 1);
        fight1v1(monster);
    }

    public Hero createExhaustedHero() throws WeaponNullException {
        hero = new Hero("Misfits épuisé");
        hero.getHitWith(99);
        Weapon GrosseArme = new Weapon("Grosse arme", 0, 0, 1000, 100);
        hero.setWeapon(GrosseArme);
        try {
            hero.attack();
        } catch (WeaponNullException weaponNullException) {
            weaponNullException.printStackTrace();
        } catch (WeaponBrokenException e) {
            e.printStackTrace();
        } catch (StaminaEmptyException e) {
            e.printStackTrace();
        }
        System.out.println(hero.toString());
        return  hero;
    }

}
