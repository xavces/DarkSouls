package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import characters.Hero;

public abstract class Ring extends BuffItem {
	
	private float power ;
	private Hero hero ;
	private String name;

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
