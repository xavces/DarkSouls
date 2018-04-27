package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

/**
 *  DragonSlayerRing est la classe représentant un anneau. Il hérite de Ring.
 *
 */
public class DragonSlayerRing extends Ring{

	/**
	 *  Constructeur d'un anneau.
	 *  Nom : "Dragon Slayer Ring",
	 *  buff : 14
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14);
	}


	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}

	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems().toArray(new ArmorItem[0]);
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ;
		}
		return false ;
	}
	
}
