package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring{

	/**
	 * Constructeur de l'anneau DragonSlayerRing se basant sur le constructeur de la classe mère
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}

	/**
	 * Regarde si le buff est applicable au joueur (Si le joueur est équipé de l'armure DragonSlayerLeggings)
	 * @return Power de l'item si activé
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}

	/**
	 * Est que l'objet est équipé
	 * @return Boolean Oui si il a l'item
	 */
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ; 
		}
		return false ;
	}
	
}
