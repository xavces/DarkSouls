package lsg.characters;

import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.buffs.BuffItem;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.*;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

import java.nio.Buffer;
import java.util.Locale;

public abstract class Character {

    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";
    public static final String PROT_STAT_STRING = "protection";
    public static final String BUFF_STAT_STRING = "buff";

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private Weapon weapon;

    private BuffItem buff;

    private Consumable consumable;

    private Bag bag = new SmallBag();


    /**
     * Initialisation du dès à 100 faces
     */
    public Dice myDice = new Dice(101);

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    protected void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    protected void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    protected void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public BuffItem getBuff() {
        return buff;
    }

    public void setBuff(BuffItem buff){

    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public void printStats() {
        System.out.println(this);
    }

    /**
     * Méthode qui retourne une chaine de caractère qui correspond au information du personnage
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-20s", getClass().getSimpleName()) +
                String.format("%-20s", this.getName()) +
                String.format("%-20s", LIFE_STAT_STRING + ": " + this.getLife()) +
                String.format("%-20s", STAM_STAT_STRING + ": "  + this.getStamina()) +
                String.format(Locale.US , "%-20s", PROT_STAT_STRING + ": "  + this.computeProtection()) +
                String.format(Locale.US , "%-20s", BUFF_STAT_STRING + ": "  + this.computeBuff()) +
                String.format("%-20s", (this.isAlive()?"(ALIVE)":"(DEAD)"));

    }

    /**
     * Méthode qui retourne un boolean (si le personnage est en vie : 1 sinon 0)
     * @return
     */
    public boolean isAlive (){
        return this.getLife() > 0;
    }

    /**
     * Fonction qui gère l'attaque avec une arme et activant les buff
     * @param weapon
     * @return
     * @throws WeaponNullException
     * @throws WeaponBrokenException
     * @throws StaminaEmptyException
     */
    private int attackWith(Weapon weapon) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {

        if (weapon == null)
            throw new WeaponNullException();
        if(weapon.isBroken())
            throw new WeaponBrokenException(getWeapon());
        else{
            int myRoll = myDice.roll();
            // On calcule la différence entre les dommages max et min de l'arme
            int weaponDiffAttack = weapon.getMaxDamage() - weapon.getMinDamage();
            // On calcule les dommages avec la "Précision"
            int myDamage = Math.round((weapon.getMinDamage() + (weaponDiffAttack * (float)myRoll/100)) * (1+(computeBuff()/100)));
            //Vérification de la stamina restante
            // Si il est reste assez :
            if(this.stamina >= weapon.getStamCost()){
                this.stamina -= weapon.getStamCost();
                weapon.use();
                return myDamage;
            }
            // Sinon si la stamina est supérieure de 0
            else if (this.stamina != 0){
                //On calcule un ratio des dommages avec la stamina restante et on mutliplie par le buff du personnage
                myDamage *= Math.round(this.stamina/weapon.getStamCost() * (1+(computeBuff()/100)));
                this.setStamina(0);
                weapon.use();
                return myDamage;
            }
            else
                throw new StaminaEmptyException();
        }
    }

    /**
     *
     * @return
     * @throws WeaponNullException
     * @throws WeaponBrokenException
     * @throws StaminaEmptyException
     */
    public int attack() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
        return attackWith(this.weapon);
    }

    /**
     * Fonction qui retourne la valeur de l'attaque
     * La valeur par défaut si il reste assez de pv ou le nombre de PV restant si l'attaque est supérieure au nombre
     * de PV
     * La protection est activé ici
     * @param value
     * @return
     */
    public int getHitWith(int value){
        if (computeProtection() == 100)
            return 0;
        float damage = value*(1-computeProtection()/100);
        int pvRetire =  Math.round(damage)<=this.getLife() ? Math.round(damage) : this.getLife();
        this.setLife(this.getLife() - pvRetire);
        return pvRetire;
    }

    /**
     * Utilise un item pour régénérer la Stamina d'un character
     * @param drink
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     */
    private void drink(Drink drink) throws ConsumeNullException, ConsumeEmptyException {
        if (drink == null) {
            throw new ConsumeNullException();
        }
        System.out.println(this.name + " drinks " + drink.toString());
        int regenerate = drink.use();
        if(regenerate + this.getStamina()>= this.getMaxStamina())
            this.setStamina(this.getMaxStamina());
        else
            this.setStamina(this.getStamina() + regenerate);
        System.out.println("Après Utilisation : " + drink.toString());
    }

    /**
     * Utilise un item pour régénérer la vie d'un character
     * @param food
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     */
    private void eat(Food food) throws ConsumeNullException, ConsumeEmptyException {
        if (food == null) {
            throw new ConsumeNullException();
        }
        System.out.println(this.name + " eats " + food.toString());
        int regenerate = food.use();
        if(regenerate + this.getLife() >= this.getMaxLife())
            this.setLife(this.getMaxLife());
        else
            this.setLife(this.getLife() + regenerate);
        System.out.println("Après Utilisation : " + food.toString());

    }

    /**
     * Utilise un item pour réparer l'arme d'un character
     * @param kit
     * @throws WeaponNullException
     * @throws ConsumeNullException
     */
    private void repairWeaponWith(RepairKit kit) throws WeaponNullException, ConsumeNullException {
        if (this.weapon == null)
            throw new WeaponNullException();
        System.out.println(this.name + " repairs " + this.weapon.toString() + "with" + kit.toString());
        this.weapon.repairWith(kit);
        System.out.println("Après Utilisation : " + kit.toString());
    }

    /**
     * Fait appel au fonction de consommation selon le type de consommable
     * @param consumable
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws ConsumeRepairNullWeaponException
     */
    public void use(Consumable consumable) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
        if (consumable == null) {
            throw new ConsumeNullException();
        }
        if(consumable instanceof Food)
            eat((Food)consumable);
        else if(consumable instanceof Drink)
            drink((Drink)consumable);
        else if(consumable instanceof RepairKit)
            try {
                repairWeaponWith((RepairKit) consumable);
            } catch (WeaponNullException weaponNullException) {
                throw new ConsumeRepairNullWeaponException(consumable);
            }

    }

    /**
     *
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws ConsumeRepairNullWeaponException
     */
    public void consume() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
        this.use(this.getConsumable());
    }

    /**
     * Méthode qui ramasse un objet et le met dans le sac du character
     * @param item
     * @throws NoBagException
     * @throws BagFullException
     */
    public void pickUp(Collectible item) throws NoBagException, BagFullException {
        if (this.bag == null) {
            throw new NoBagException();
        }
        bag.push(item);
        System.out.println(this.name + " picks up " + item.toString());
    }

    /**
     * Méthode qui enleve un item du sac d'un character
     * @param item
     * @return
     * @throws NoBagException
     */
    public Collectible pullOut(Collectible item) throws NoBagException {
        if (this.bag == null) {
            throw new NoBagException();
        }
        Collectible result = bag.pop(item);
        if( result != null)
            System.out.println(this.name + " pulls out " + item.toString());
        else
            System.out.println("Item not found");
        return result;
    }

    public void printBag(){
        System.out.println(bag.toString());
    }

    /**
     * On récupère la capacité du sac du character
     * @return
     * @throws NoBagException
     */
    public int getBagCapacity() throws NoBagException {
        if (this.bag == null) {
            throw new NoBagException();
        }
        return bag.getCapacity();
    }

    /**
     * On récupère le poid contenu dans le sac du character
     * @return
     * @throws NoBagException
     */
    public int getBagWeight() throws NoBagException {
        if (this.bag == null) {
            throw new NoBagException();
        }
        return bag.getWeight();
    }

    /**
     * On récupère la liste des objets contenu dans le sac du character
     * @return
     * @throws NoBagException
     */
    public Collectible[] getBagItems() throws NoBagException {
        if (this.bag == null) {
            throw new NoBagException();
        }
        return bag.getItems();
    }

    /**
     * On défini un sac pour le character
     * @param bag
     * @return
     */
    public Bag setBag(Bag bag){
        Bag bagToReturn = this.bag;
        String newBagName = getClass().getSimpleName();
        String oldBagName = bagToReturn.getClass().getSimpleName();
        if (bag == null){
            newBagName = null;
        }
        if (bagToReturn == null)
            oldBagName = null;
        Bag.transfer(this.bag, bag);
        this.bag = bag;
        System.out.println(this.getName() + " changes " + oldBagName + " for " + newBagName);
        return bagToReturn;
    }

    /**
     * Equipe une arme présente dans le sac
     * @param weapon
     * @throws NoBagException
     */
    public void equip(Weapon weapon) throws NoBagException {
        if(pullOut(weapon) != null) {
            this.setWeapon(weapon);
        }
    }

    /**
     * Equipe un consommable présent dans le sac
     * @param consumable
     * @throws NoBagException
     */
    public void equip(Consumable consumable) throws NoBagException {
        if(pullOut(consumable) != null){
            this.setConsumable(consumable);
        }
    }

    /**
     * Méthode qui permet d'utiliser le premier consommable dans le sac du character d'un type précis
     * @param type
     * @return
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws ConsumeRepairNullWeaponException
     * @throws NoBagException
     */
    private Consumable fastUseFirst(Class<? extends Consumable> type) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
        for (Collectible collectible: bag.getItems()) {
            if (type.isInstance(collectible)) {
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
     * Méthode public qui utilise fastUseFirst avec une consommable de type Drink
     * @return
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws NoBagException
     */
    public Drink fastDrink() throws ConsumeNullException, ConsumeEmptyException, NoBagException {

        try {
            System.out.println(getName() + " drinks FAST : " );
            return (Drink)fastUseFirst(Drink.class);
        } catch (ConsumeRepairNullWeaponException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Méthode public qui utilise fastUseFirst avec une consommable de type Food
     * @return
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws NoBagException
     */
    public Food fastEat() throws ConsumeNullException, ConsumeEmptyException, NoBagException {

        try {
            System.out.println(getName() + " eats FAST : " );
            return (Food)fastUseFirst(Food.class);
        } catch (ConsumeRepairNullWeaponException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Méthode public qui utilise fastUseFirst avec une consommable de type RepairKit
     * @return
     * @throws ConsumeNullException
     * @throws ConsumeEmptyException
     * @throws ConsumeRepairNullWeaponException
     * @throws NoBagException
     */
    public RepairKit fastRepair() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
        System.out.println(getName() + " repairs FAST : " );
        return (RepairKit) fastUseFirst(RepairKit.class);
    }

    public void printConsumable() {
        System.out.println("CONSUMABLE : " + consumable);
    }


    abstract float computeProtection();
    abstract float computeBuff();
}
