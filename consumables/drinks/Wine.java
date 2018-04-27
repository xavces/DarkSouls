package consumables.drinks;

/**
 *  Wine est la classe représentant un vin dans le jeu, il est hérité de la classe Drink
 */
public class Wine extends Drink {

    /**
     *  Constructeur d'un Vin ayant pour nom "Pomerol 2008", et une capacité de 30
     */
    public Wine() {
        super("Pomerol 2008", 30);
    }
}
