package characters;

import consumables.Consumable;
import consumables.drinks.Drink;
import consumables.food.Food;
import consumables.repair.RepairKit;
import lsg.armor.ArmorItem;
import lsg.bags.Collectible;
import lsg.exceptions.*;
import lsg.weapons.Weapon;
import lsg.buffs.rings.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Héro est la classe représentant un héro dans le jeu. Il est hérité de la classe Character
 *
 *  Il est caractérisé par les informations suivantes :
 *  <ul>
 *      <li>Un nom</li>
 *      <li>Un montant de point de vie</li>
 *      <li>Un montant maximum de point de vie</li>
 *      <li>Un montant de stamina</li>
 *      <li>Un montant maximum de stamina</li>
 *      <li>Un petit sac hérité de Character</li>
 *  </ul>
 */
public class Hero extends Character {

    /**
     *  Variable static pour le nombre d'armure que le héro peut porter.
     *
     * @see Hero#setArmorItem(ArmorItem, int)
     */
    private static int MAX_ARMOR_PIECES = 3;

    /**
     *  Variable static pour le nom d'anneaux que le héro peut porter.
     *
     * @see Hero#setRing(Ring, int)
     */
    private static int MAX_RING_PIECES = 2;

    /**
     *  Un tableau recueillant l'armure du héro. Est automatiquement initialisé avec une valeur.
     *
     * @see Hero#setArmorItem(ArmorItem, int)
     * @see Hero#getTotalArmor()
     * @see Hero#armorToString()
     */
    private ArmorItem[] stuff = new ArmorItem[MAX_ARMOR_PIECES];

    /**
     *  Un tableau recueillant les anneaux du héro
     *
     * @see Hero#setRing(Ring, int)
     * @see Hero#getTotalRing()
     */
    private Ring[] ring = new Ring[MAX_RING_PIECES];

    /**
     *  Constructeur du héro. Les statistiques du héro sont initialisés à 100 pour la vie et son maximum,
     *  et à 50 pour sa stamina et son maximum.
     *
     * @param nameHero      Le nom du héro
     */
    public Hero(String nameHero) {
        super.setName(nameHero);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    /**
     *  Un autre constructeur du héro. Son nom est initialisé à "Ynovator",
     *  Ses statistiques sont initialisés à 100 pour la vie et son maximum,
     *  et à 50 pour sa stamina et son maximum.
     */
    public Hero() {
        super.setName("Ynovator");
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }



    /**
     *  Permet d'équiper un item au héro.
     *
     * @param ArmorItem     L'item que le héro veut équiper
     * @param slot          Le slot dans l'équipement du héro.
     */
    public void setArmorItem(ArmorItem ArmorItem, int slot) {
        if (slot < 0 || slot > MAX_ARMOR_PIECES) {
            return ;
        }
        else {
            this.stuff[slot - 1] = ArmorItem;
        }
    }

    /**
     *  Permet d'équiper un anneau au héro.
     *
     * @param ring     L'anneau que le héro veut équiper
     * @param slot     Le slot dans l'équipement du héro.
     */
    public void setRing(Ring ring, int slot) {
        if (slot < 0 || slot > MAX_RING_PIECES) {
            return ;
        }
        else {
            this.ring[slot - 1] = ring;
        }
    }

    /**
     *  Renvoie le total de protection de l'armure
     *
     * @return float    Le total de protection
     */
    public float getTotalArmor() {
        float total = 0;
        for (ArmorItem item: stuff) {
            if (item != null)
                total += item.getArmorValue();
        }
        return Math.round(total);
    }

    /**
     *  Renvoie le total de buff des anneaux
     *
     * @return float    Le total de buff
     */
    public float getTotalRing() {
        float total = 0;
        for (Ring rings: ring) {
            if (rings != null)
                total += rings.computeBuffValue();
        }
        return total;
    }

    /**
     *  Formate les informations pour en faire un String
     *
     * @return String   La chaine de charactere
     *
     */
    public String armorToString() {
        String string = "ARMOR  ";
        int i = 1;

        for (ArmorItem item: stuff) {
            if (item != null) {
                string += i + ":" + item.toString() + "    ";
            } else {
                string += i + ":empty    " ;
            }
            i++;
        }
        return string;
    }

    /**
     *  Renvoie une liste des items que le héro porte
     *
     * @return List     Les items d'armure.
     */
    public List<ArmorItem> getArmorItems() {
        List<ArmorItem> armor = new ArrayList<ArmorItem>();
        for (ArmorItem armorItems: armor) {
            if (armorItems != null) {
                armor.add(armorItems);
            }
        }
        return armor;
    }

    /**
     *  Permet d'équiper le héro avec un item du sac
     *
     * @param item      Armure à équiper
     * @param slot      Slot à utiliser pour placer l'item
     */
    public void equip(ArmorItem item, int slot) throws NoBagException {
        if (bag == null)
            throw new NoBagException();
        if(pullOut(item) != null) {
            this.setArmorItem(item, slot);
            System.out.println(this.getName() + " équipe " + item.toString() + " de son sac");
        }
        else
            System.out.println("Rien n'a été équipé!");
    }

    /**
     *  Permet d'équiper le héro avec un anneau du sac
     *
     * @param ring      Anneau à équiper
     * @param slot      Slot à utiliser pour placer l'anneau
     */
    public void equip(Ring ring, int slot) throws NoBagException {
        if (bag == null)
            throw new NoBagException();
        if(pullOut(ring) != null) {
            this.setRing(ring, slot);
            System.out.println(this.getName() + " équipe " + ring.toString() + " de son sac");
        }
        else
            System.out.println("Rien n'a été équipé!");
    }

    /**
     *  Permet d'utiliser un consommable contenu dans le sac du héro, prend le premier consommable
     *  de la même instance que celui passé en paramètre. Si la capacité du consommable est inférieur ou égale
     *  à 0, il est retiré du sac.
     *
     * @param consumable      Class du consommable à chercher dans le sac.
     */
    private Consumable fastUseFirst(Class<? extends Consumable> consumable) throws WeaponNullException, ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
        for (Collectible collectible: bag.getItems()) {
            if (consumable.isInstance(collectible)) {
                use((Consumable) collectible);
                if (((Consumable) collectible).getCapacity() <= 0){
                    pullOut(collectible);
                }
                return (Consumable) collectible;
            }

        }
        return null;
    }

    /**
     * Renvoie le consommable utilisé par la méthode fastUseFirst()
     *
     * @return Consumable       Le consommable Drink utilisé
     */
    public Drink fastDrink() throws WeaponNullException, ConsumeNullException, ConsumeEmptyException, NoBagException {
        System.out.println(getName() + " drinks FAST : " );
        try {
            return (Drink)fastUseFirst(Drink.class);
        } catch (ConsumeRepairNullWeaponException consumeRepairNullWeaponException) {
            return null;
        }
    }

    /**
     * Renvoie le consommable utilisé par la méthode fastUseFirst()
     *
     * @return Food       Le consommable Food utilisé
     */
    public Food fastEat() throws WeaponNullException, ConsumeNullException, ConsumeEmptyException, NoBagException {
        System.out.println(getName() + " eats FAST : " );
        try {
            return (Food)fastUseFirst(Food.class);
        } catch (ConsumeRepairNullWeaponException consumeRepairNullWeaponException) {
            return null;
        }

    }

    /**
     * Renvoie le consommable utilisé par la méthode fastUseFirst()
     *
     * @return Consumable       Le consommable Repair utilisé
     */
    public RepairKit fastRepair() throws WeaponNullException, ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
        System.out.println(getName() + " repairs FAST : " );
        return (RepairKit) fastUseFirst(RepairKit.class);
    }

    public void printRings() {
        System.out.println("RINGS   1:" + ring[0] + "           2:" + ring[1]);
    }

    @Override
    float computeProtection() {
        return this.getTotalArmor();
    }

    @Override
    float computeBuff() {
        return this.getTotalRing();
    }
}
