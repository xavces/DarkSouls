package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.buffs.rings.Ring;
import lsg.exceptions.NoBagException;

public class Hero extends Character{

    /**
     * Définition d'une constante pour le nombre d'armure équipable par un héro
     */
    private static final int MAX_ARMOR_PIECES = 3;

    private static final int MAX_RING_PIECES = 2;


    /**
     * Définition du tableau d'armure et de buffs d'un héro
     */
    private ArmorItem[] armor = new ArmorItem[MAX_ARMOR_PIECES];

    private Ring[] ring = new Ring[MAX_RING_PIECES];

    public Hero(String name) {
        super.setName(name);
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    public Hero() {
        super.setName("Ynovator");
        super.setLife(100);
        super.setMaxLife(100);
        super.setStamina(50);
        super.setMaxStamina(50);
    }

    public ArmorItem[] getArmorItems() {
        return armor;
    }

    /**
     * Méthode qui défini une pièce d'armure dans un slot
     * @param armor
     * @param slot
     */
    public void setArmorItem(ArmorItem armor, int slot) {
        if(slot > MAX_ARMOR_PIECES || slot <= 0)
            return ;
        else
            this.armor[slot-1] = armor;
    }

    /**
     * Méthode qui renvoi le total d'armure du héro
     * @return
     */
    public float getTotalArmor (){
        float sum = 0;
        for(ArmorItem armorPeace: armor){
            if(armorPeace != null)
                sum += armorPeace.getArmorValue();
        }
        return sum;
    }

    /**
     * Méthode qui renvoie une chaine de carractère qui décrit tout les slots de l'armure du héro
     * @return
     */
    public String armorToString (){
        String myString;
        myString = "ARMOR ";
        int index = 1;
        for(ArmorItem armorPeace: armor){
            if(armorPeace != null)
                myString += index + ":" + armorPeace.toString() + "   ";
            else
                myString += index + ":" +  "empty   ";
            index++;
        }
        return myString;
    }

    /**
     * Méthode qui défini un Ring dans un slot
     * @param ring
     * @param slot
     */
    public void setRing(Ring ring, int slot) {
        if( slot> MAX_RING_PIECES || slot <= 0)
            return ;
        else {
            ring.setHero(this);
            this.ring[slot - 1] = ring;
        }

    }

    /**
     * Méthode qui renvoi le total des buffs du héro
     * @return
     */
    public float getTotalBuff (){
        float sum = 0;
        for(Ring ringPeace: ring){
            if(ringPeace != null){
                sum += ringPeace.computeBuffValue();
            }
        }
        return sum;
    }

    // Main test TP3.3
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setArmorItem(new BlackWitchVeil(), 1);
        hero.setArmorItem(new BlackWitchVeil(), 3);
        System.out.println(hero.armorToString());
        System.out.println("TOTAL : "+hero.getTotalArmor());
    }

    /**
     * Méthode qui permet de sortir un item du sac et de l'équiper sur un slot précis
     * @param item
     * @param slot
     * @throws NoBagException
     */
    public void equip(ArmorItem item, int slot) throws NoBagException {
        if(pullOut(item) != null){
            this.setArmorItem(item, slot);
        }
    }

    /**
     * Méthode qui permet de sortir un Ring du sac et de l'équiper sur un slot précis
     * @param ring
     * @param slot
     * @throws NoBagException
     */
    public void equip(Ring ring, int slot) throws NoBagException {
        if(pullOut(ring) != null){
            this.setRing(ring, slot);
        }
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
        return this.getTotalBuff();
    }

}
