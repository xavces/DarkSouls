package lsg.buffs.rings;

import lsg.characters.Hero;
import lsg.weapons.Sword;

public class RingOfSwords extends Ring{

	/**
	 * Constructeur de l'anneau RingOfSwords se basant sur le constructeur de la classe mère
	 */
	public RingOfSwords() {
		super("Ring of Swords", 10) ;
	}

	/**
	 * Regarde si le buff est applicable au joueur (Le joueur est équipé d'une sword)
	 * @return Power du ring
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && (hero.getWeapon() instanceof Sword) )  return power ;
		else return 0f ;
		
	}
	
	/**
	 * Un test...
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		Hero hero = new Hero() ;
		RingOfSwords r = new RingOfSwords() ;
		hero.setRing(r, 1);
		hero.setWeapon(new Sword());
		System.out.println(r);
	}
}
