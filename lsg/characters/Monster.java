package lsg.characters;

public class Monster extends Character{

    /**
     * Définition d'une variable permettant de compter le nombre d'instance
     */
    private static int INSTANCES_COUNT = 1;

    public Monster(String name) {
        super.setName(name);
        super.setLife(10);
        super.setStamina(10);
    }

    public Monster() {
        super.setName("YMonster_" + this.INSTANCES_COUNT);;
        this.INSTANCES_COUNT++;
        super.setLife(10);
        super.setStamina(10);
    }
}
