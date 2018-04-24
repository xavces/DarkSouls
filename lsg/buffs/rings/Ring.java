package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import lsg.characters.Hero;

public abstract class Ring extends BuffItem {
	
	protected int power ; 
	protected Hero hero ;

	/**
	 * Constructeur de base de tout les Ring
	 * @param name
	 * @param power
	 */
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}

	/**
	 * Défini le héros à qui appartient l'anneau
	 * @param hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * Récupère le héros à qui appartient l'anneau
	 * @return
	 */
	public Hero getHero() {
		return hero;
	}
	
}
