package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

public class Consumable implements Collectible {

    private String name;
    private int capacity;
    private String stat;


    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStat() {
        return stat;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString(){
        return this.name + " [" + this.capacity + " " + this.stat + " point(s)]";
    }

    /**
     * Méthode qui utilise un consumable et met sa capacité à 0
     * @return
     * @throws ConsumeEmptyException
     */
    public int use() throws ConsumeEmptyException {
        if(getCapacity() == 0){
            throw new ConsumeEmptyException(this);
        }
        int myCapacity = this.capacity;
        this.setCapacity(0);
        return myCapacity;
    }

    @Override
    public int getWeight() {
        return 1;
    }
}