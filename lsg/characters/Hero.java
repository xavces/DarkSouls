package lsg.characters;

public class Hero {
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

    public Hero(String name) {
        this.setName(name);
        this.setLife(100);
        this.setStamina(50);
    }

    public Hero() {
        this.setName("Ynovator");
        this.setLife(100);
        this.setStamina(50);
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
