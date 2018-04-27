package lsg.buffs;

import java.util.Locale;

/**
 *	BuffItem est la classe qui représente un anneau ou un talisman. Il implémente l'instance Collectible
 *	pour gérer le poids des items
 */
public abstract class BuffItem implements lsg.bags.Collectible {

	/**
	 *	Nom de l'item
	 */
	protected String name ;

	/**
	 *	Constructeur d'un item.
	 *
	 * @param name	Nom de l'item
	 */
	public BuffItem(String name) {
		this.name = name;
	}

	protected BuffItem() {
	}

	/**
	 *	Renvoie le nom de l'item
	 *
	 * @return String		Nom de l'item
	 */
	public String getName() {
		return name;
	}

	/**
	 *	Renvoie le poids de l'item, fixé à 1
	 *
	 * @return	int			Poids de l'item
	 */
	public int getWeight() {
		return 1;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}

	public abstract float computeBuffValue();
}
