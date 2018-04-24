package lsg.buffs.rings;

import lsg.characters.Hero;

public class RingOfDeath extends Ring{
	
	private static float LIMIT = 0.5f ;

	/**
	 * Constructeur de l'anneau RingOfDeath se basant sur le constructeur de la classe mère
	 */
	public RingOfDeath() {
		super("Ring of Death", 10000) ;
	}

	/**
	 * Regarde si le buff est applicable au joueur (Le joueur à moins de XX% de vie, dépend de la constant LIMIT)
	 * @return Power du ring
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null){
			float gauge = (float)hero.getLife() / hero.getMaxLife() ;
			if(gauge <= LIMIT) return power ;
			else return 0f ;
		}else return 0f ;
	}
	
	/**
	 * Un test...
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		Hero hero = new Hero() ;
		Ring r = new RingOfDeath() ;
		hero.setRing(r, 1);
		hero.getHitWith(60) ; // pour abaisser les PV du hero
		System.out.println(r);
	}
	
}
