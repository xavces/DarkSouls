package lsg.characters;

public class Monster {

    /**
     * Définition d'une variable permettant de compter le nombre d'instance
     */
    private static int INSTANCES_COUNT = 1;

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    private void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    private void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    private void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    private void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Monster(String name) {
        this.setName(name);
        this.setLife(10);
        this.setStamina(10);
    }

    public Monster() {
        this.setName("YMonster_" + this.INSTANCES_COUNT);;
        this.INSTANCES_COUNT++;
        this.setLife(10);
        this.setStamina(10);
    }

    public void printStats() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("%-20s", getClass().getSimpleName()) +
            String.format("%-20s", this.getName()) +
            String.format("%-20s", " LIFE: " + this.getLife()) +
            String.format("%-20s", " STAMINA: "  + this.getStamina()) +
            String.format("%-20s", (this.isAlive()?"(ALIVE)":"(DEAD)"));
    }

    /**
     * Méthode qui retourne un boolean (si le personnage est en vie : 1 sinon 0)
     * @return
     */
    private boolean isAlive (){
        return this.getLife() > 0;
    }
}
