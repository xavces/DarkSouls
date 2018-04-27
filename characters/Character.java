package characters;

import consumables.Consumable;
import consumables.drinks.Drink;
import consumables.food.Food;
import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.buffs.rings.RingOfSwords;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;
import consumables.repair.RepairKit;

import java.util.Locale;

/**
 *  Character est la classe représentant un personnage du jeu.
 *
 *  Il est caractérisé par les informations suivantes :
 *  <ul>
 *      <li>Un nom</li>
 *      <li>Un montant de point de vie</li>
 *      <li>Un montant maximum de point de vie</li>
 *      <li>Un montant de stamina</li>
 *      <li>Un montant maximum de stamina</li>
 *      <li>Un petit sac</li>
 *  </ul>
 */
public abstract class Character {

    /**
     *  Le nom du héro
     *
     * @see Character#Character()
     * @see Character#getName()
     */
    private String name;

    /**
     *  La vie du héro
     *
     * @see Character#Character()
     * @see Character#getLife()
     */
    private int life;


    /**
     *    La vie maximum du héro
     *
     * @see Character#Character()
     * @see Character#getMaxLife()
     */
    private int maxLife;

    /**
     *  La stamina du héro
     *
     * @see Character#Character()
     * @see Character#getStamina() ()
     */
    private int stamina;

    /**
     *  La stamina maximum du héro
     *
     * @see Character#Character()
     * @see Character#getMaxStamina() ()
     */
    private int maxStamina;

    /**
     *  Dé à 101 faces
     *
     * @see Hero#attackWith(Weapon)
     */
    public Dice diceCharact = new Dice(101);

    /**
     *  L'arme porté du héro
     *
     * @see Character#getWeapon()
     * @see Character#attack()
     * @see RingOfSwords#computeBuffValue()
     */
    private Weapon weapon;

    /**
     *  Le consommable porté du héro
     *
     * @see Character#getConsumable()
     * @see Character#consume()
     */
    private Consumable consumable;

    /**
     *  Le sac porté du héro
     *
     * @see Character#Character()
     * @see Character#pickUp(Collectible)
     * @see Character#pullOut(Collectible)
     * @see Character#printBag()
     * @see Character#getBagCapacity()
     * @see Character#getBagItems()
     * @see Character#getBagWeight()
     * @see Character#equip(Weapon)
     * @see Character#equipe(Consumable)
     * @see Hero#fastUseFirst(Class)
     */
    protected Bag bag;

    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";
    public static final String PROTECTION_STAT_STRING = "protection";
    public static final String BUFF_STAT_STRING = "buff";

    /**
     * Renvoie le nom du héro
     *
     * @return name
     *              Le nom du héro
     */
    public String getName() {
        return name;
    }

    /**
     *  Met à jour le nom du héro
     *
     * @param name
     *              Le nom du héro
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     *  Renvoie la vie du héro
     *
     * @return life
     *              La vie du héro
     */
    public int getLife() {
        return life;
    }

    /**
     *  Met à jour la vie du héro
     *
     * @param life
     *              La vie du héro
     */
    void setLife(int life) {
        this.life = life;
    }

    /**
     *  Renvoie la vie max du héro
     *
     * @return maxLife
     *              La vie max du héro
     */
    public int getMaxLife() {
        return maxLife;
    }

    /**
     *  Met à jour la vie max du héro
     *
     * @param maxLife
     *              La vie max du héro
     */
    void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    /**
     *  Renvoie la stamina du héro
     *
     * @return stamina
     *              La stamina max du héro
     */
    public int getStamina() {
        return stamina;
    }

    /**
     *  Met à jour la stamina du héro
     *
     * @param stamina
     *              La vie stamina du héro
     */
    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     *  Renvoie la stamina max du héro
     *
     * @return maxStamina
     *              La stamina max du héro
     */
    public int getMaxStamina() {
        return maxStamina;
    }

    /**
     *  Met à jour la stamina max du héro
     *
     * @param maxStamina
     *              La stamina max du héro
     */
    void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    /**
     *  Renvoie l'arme du héro
     *
     * @return weapon
     *              L'arme du héro
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     *  Met à jour l'arme du héro
     *
     * @param weapon
     *              L'arme du héro
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     *  Renvoie le consommable du héro
     *
     * @return consumable
     *              Le consommable du héro
     */
    public Consumable getConsumable() {
        return consumable;
    }

    /**
     *  Met à jour le consommable du héro
     *
     * @param consumable
     *              le consommable du héro
     */
    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     *  Constructeur du héro.
     *  Le nom est défini à "Ynovator", avec 100 en vie et en vie maximum,
     *  et 50 en stamina et en stamina maximum.
     *  Un sac lui est attribué.
     */
    public Character() {
        this.name = "Ynovator";
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
        this.bag = new SmallBag();
    }

    /**
     *  Check si la vie est supérieur à 0.
     *
     * @return boolean  True si la vie est supérieur à 0
     *
     */
    public boolean isAlive() {
        if (this.getLife() > 0)
            return true;
        else
            return false;
    }

    /**
     *  Formate les informations pour en faire un String
     *
     * @return String   La chaine de charactere
     *
     */
    public String toString() {
        String nameClass = getClass().getSimpleName();
        String alive = isAlive() ? "(ALIVE)" : "(DEAD)";
        return String.format("%-20s", "[" + getClass().getSimpleName() + "]") +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", LIFE_STAT_STRING + " : " + life) +
                String.format("%-20s", STAM_STAT_STRING + " : " + stamina) +
                String.format(Locale.US, "%-20s", PROTECTION_STAT_STRING + " : " + computeProtection()) +
                String.format(Locale.US, "%-20s", BUFF_STAT_STRING + " : " + computeBuff()) +
                String.format("%-20s", alive);
    }

    /**
     *  Attaque un adversaire
     *
     * @return int      Les dégâts provoqués.
     *
     */
    public int attack(){
        return attackWith(this.weapon);
    }

    /**
     *  Occasionne les dommages à la cible, prend en compte la protection.
     *
     * @param value     Les dégâts à occasionner
     * @return int      Les dégâts finaux, ou le nombre de vie qu'il avait avant de tomber à 0
     */
    public int getHitWith(int value) {
        float dmgFinal = 0;
        int vieTemp = 0;
        if (computeProtection() >= 100)
            return 0;
        dmgFinal = Math.round(value*(1-computeProtection()/100));
        if (value <= this.getLife()) {
            this.setLife(this.getLife() - Math.round(dmgFinal));
            return Math.round(dmgFinal);
        }
        else {
            vieTemp = this.getLife();
            this.setLife(0);
            return vieTemp;
        }
    }

    /**
     *  Remonte la stamina avec un objet Drink
     *
     * @param drink     Objet Drink
     *
     */
    private void drink(Drink drink) {
        System.out.println(getName() + " drinks " + drink.toString());
        if ((drink.use() + this.getStamina()) >= this.getMaxStamina()) {
            this.setStamina(this.getMaxStamina());
        }
        else {
            this.setStamina(this.getStamina() + drink.use());
        }
    }

    /**
     *  Remonte la vie avec un objet Food
     *
     * @param food     Objet Food
     *
     */
    private void eat(Food food) {
        System.out.println(getName() + " eats " + food.toString());
        int capacity = food.use();
        int add = capacity + this.getLife();
        if (add > this.getMaxLife()) {
            this.setLife(this.getMaxLife());
        }
        else {
            this.setLife(this.getLife() + capacity);
        }
    }

    /**
     *  Détecte l'instance passé en paramètre et utilise la bonne méthode
     *
     * @param consumable     Peut être une instance de Drink, de Food ou de RepairKit.
     *
     */
    public void use(Consumable consumable) {
        if(consumable instanceof Drink){
            drink((Drink) consumable);
        }
        else if(consumable instanceof Food){
            eat((Food) consumable);
        }
        else if (consumable instanceof RepairKit) {
            repairWeaponWith((RepairKit) consumable);
        }
    }

    /**
     *  Permet de réparer l'arme du héro
     *
     * @param kit
     *
     */
    private void repairWeaponWith(RepairKit kit) {
        this.weapon.repairWith(kit);
        System.out.println(this.name + " repairs " + weapon.toString() + " with " + kit.toString());
    }

    /**
     *  Utilise la méthode use()
     */
    public void consume() {
        use(consumable);
    }

    /**
     *  Ajoute un item dans le sac
     *
     * @param item
     */
    public void pickUp(Collectible item) {
        if (this.bag.getCapacity() >= (item.getWeight() + this.bag.getWeight())){
            this.bag.push(item);
            System.out.println(this.getName() + " up " + item.toString());
        }

    }

    /**
     *  Retire un item du sac
     *
     * @param item
     */
    public Collectible pullOut(Collectible item) {
        if (!this.bag.contains(item)) {
            return null;
        }

        Collectible popItem = this.bag.pop(item);
        System.out.println(this.getName() + " out " + popItem);
        return popItem;

    }

    /**
     *  Affiche le contenu du sac.
     */
    public void printBag() {
        System.out.println(bag.toString());
    }

    /**
     *  Renvoie la capacité du sac
     *
     * @return int      La capacité du sac
     */
    public int getBagCapacity() {
        return bag.getCapacity();
    }

    /**
     *  Renvoie la place utilisé du sac.
     *
     * @return int      La place utilisé du sac
     */
    public int getBagWeight() {
        return bag.getWeight();
    }

    /**
     *  Renvoie le contenu du sac
     *
     * @return Collectible[]    Les items dans un tableau
     */
    public Collectible[] getBagItems() {
        return bag.getItems();
    }

    /**
     *  Echange le sac du héro avec un autre sac. Transfert le contenu par la même occasion.
     *
     * @param bag           Le sac à échanger avec celui du héro
     * @return transfert    Le sac avec les items qui n'ont pas pu être transferés
     */
    public Bag setBag(Bag bag) {
        Bag transfert;

        Bag.transfer(this.bag, bag);
        transfert = this.bag;

        this.bag = bag;
        System.out.println(this.getName() + " changes " + this.bag.getClass().getSimpleName() + " for " + bag.getClass().getSimpleName());
        return transfert;
    }

    /**
     *  Permet d'équiper le héro de l'arme présente dans son sac
     *
     * @param weapon    l'arme se trouvant dans son sac
     */
    public void equip(Weapon weapon) {
        if(bag.contains(weapon)) {
            this.setWeapon(weapon);
            bag.pop(weapon);
            System.out.println(this.getName() + " pulls out " + weapon.toString() + " and equips it!");
        }
        else
            System.out.println("Rien n'a été équipé!");
    }

    /**
     *  Permet d'équiper le héro du consommable présent dans son sac
     *
     * @param consumable    le consommable se trouvant dans son sac
     */
    public void equipe(Consumable consumable) {
        if(bag.contains(consumable)) {
            this.setConsumable(consumable);
            bag.pop(consumable);
            System.out.println(this.getName() + " pulls out " + consumable.toString() + " and equips it!");
        }
        else
            System.out.println("Rien n'a été équipé!");
    }

    abstract int attackWith(Weapon weapon);
    abstract float computeProtection();
    abstract float computeBuff();


}
