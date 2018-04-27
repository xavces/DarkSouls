package consumables;

import consumables.repair.RepairKit;

public class Consumable implements lsg.bags.Collectible {

    /**
     *  Nom du héro
     *
     * @see Consumable#getName()
     * @see Consumable#toString()
     */
    private String name;

    /**
     *  Capacité du consommable
     *
     * @see characters.Hero#fastUseFirst(Class)
     * @see Consumable#getCapacity()
     * @see Consumable#toString()
     * @see Consumable#use()
     * @see RepairKit#use()
     */
    protected int capacity;

    /**
     *  Statistique que le consommable va regénérer.
     *
     * @see Consumable#getStat()
     * @see Consumable#toString()
     */
    private String stat;

    /**
     *  Constructeur d'un Consommable
     *
     * @param name      Nom du consommable
     * @param capacity  Capacité du consommable
     * @param stat      Nom de la statistique que le consommable va regénéré.
     */
    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;
    }

    /**
     *  Renvoie le nom du consommable
     *
     * @return String   Nom du consommable
     */
    public String getName() {
        return name;
    }

    /**
     *  Renvoie la capacité du consommable
     *
     * @return int      Capacité du consommable
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *  Renvoie la statistique regénéré
     *
     * @return int      statistique regénéré
     */
    public String getStat() {
        return stat;
    }

    /**
     *  Met à jour la capacité du consommable
     *
     * @param capacity      Capacité du consommable
     */
    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *  Renvoie le poid du consommable
     *
     * @return int          Poid du consommable
     */
    public int getWeight() {
        return 1;
    }

    /**
     *  Formate les informations pour en faire un String
     *
     * @return String   La chaine de charactere
     *
     */
    @Override
    public String toString(){
        if (this.capacity > 1)
            return getName() + " [" + getCapacity() + " " + getStat() + " point(s)]";
        else
            return getName() + " [" + getCapacity() + " " + getStat() + " point]";
    }

    /**
     *  Utilise le consommable et le vide entièrement de sa capacité.
     *
     * @return int      La capacité au départ.
     */
    public int use() {
        int capacity = getCapacity();
        this.setCapacity(0);
        return capacity;
    }
}
