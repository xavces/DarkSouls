package consumables;

public class Consumable {

    private String name;
    protected int capacity;
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
        if (this.capacity > 1)
            return getName() + " [" + getCapacity() + " " + getStat() + " point(s)]";
        else
            return getName() + " [" + getCapacity() + " " + getStat() + " point]";
    }

    public int use() {
        int capacity = getCapacity();
        this.setCapacity(0);
        return capacity;
    }
}
