package lsg.armor;

public class armorItem {
    private String name;
    private float armorValue;


    public String getName() {
        return name;
    }

    public float getArmorValue() {
        return armorValue;
    }

    public armorItem(String name, float armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    public String toString() {
        String nameClass = getClass().getSimpleName();
        return String.format("%-20s", "[" + getClass().getSimpleName() + "](" + getArmorValue()+")");
    }
}
