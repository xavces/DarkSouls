package lsg.characters;

public class Hero extends Character{

    public Hero(String name) {
        super.setName(name);
        super.setLife(100);
        super.setStamina(50);
    }

    public Hero() {
        super.setName("Ynovator");
        super.setLife(100);
        super.setStamina(50);
    }

}
