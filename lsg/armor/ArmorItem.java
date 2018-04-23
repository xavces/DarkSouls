package lsg.armor;

public class ArmorItem {
    private String name;
    private float armorValue;


    public String getName() {
        return name;
    }

    public float getArmorValue() {
        return armorValue;
    }

    public ArmorItem(String name, float armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    public String toString() {
        String nameClass = getClass().getSimpleName();
        return String.format("%-20s", "[" + getClass().getSimpleName() + "](" + getArmorValue()+")");
    }
}
