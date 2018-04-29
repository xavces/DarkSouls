package lsg.buffs;

import lsg.bags.Collectible;

import java.util.Locale;

public abstract class BuffItem implements Collectible {
	
	private String name ; 
	
	public BuffItem(String name) {
		this.name = name ;
	}
	
	public abstract float computeBuffValue() ;
	
	public String getName() {
		return name;
	}

	/**
	 * Surcharge de la méthode toString
	 * @return Une chaine de caractère avec le nom et le total des buff d'un objet
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}

	/**
	 * Surcharge de la méthode getWeight de collectible qui renvoie 1
	 * @return
	 */
	@Override
	public int getWeight() {
		return 1;
	}
	
}
