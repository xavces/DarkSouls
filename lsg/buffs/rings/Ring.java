package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import characters.Hero;

/**
 *  Ring est la classe représentant un anneau. Il hérite de BuffItem
 */
public abstract class Ring extends BuffItem {

	/**
	 *	Le montant du buff de l'anneau
	 */
	protected float power ;

	/**
	 *	Le hero qui porte l'anneau
	 */
	protected Hero hero ;

	/**
	 *	Le nom de l'anneau
	 */
	private String name;

	/**
	 *  Constructeur de l'anneau.
	 *
	 * @param name      Nom de l'anneau
	 * @param power		Montant du buff de l'anneau
	 */
	public Ring(String name, float power) {
		this.name = name ;
		this.power = power ;
	}

	@Override
	public String toString(){
		return this.name + "(" + this.power + ")";
	}

	@Override
	public float computeBuffValue() {
		return power;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero() {
		return hero;
	}
	
}
