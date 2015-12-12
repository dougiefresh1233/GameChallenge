package com.monochromatic.god_of_fire.mechanics;

import com.monochromatic.god_of_fire.enums.RangeType;
import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.ElementalType;

public class Damage {
	private boolean hasElement;
	int damageAmount;
	private DamageType damageType;
	private RangeType rangeType;
	private ElementalType elementalType;

	public Damage(int amount, DamageType dType, RangeType range, ElementalType eType) {
		hasElement = true;
		damageAmount = amount;
		damageType = dType;
		this.rangeType = range;
		elementalType = eType;
	}

	public Damage(int amount, DamageType dType, RangeType range) {
		hasElement = false;
		damageAmount = amount;
		damageType = dType;
		this.rangeType = range;
	}

	public boolean hasElement() {
		return hasElement;
	}

	public int getDamageValue() {
		return damageAmount;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public RangeType getRangeType() {
		return rangeType;
	}

	public ElementalType getElementalType() {
		return elementalType;
	}

	public void setDamageValue(int amount) {
		damageAmount = amount;
	}

	public void setDamageType(DamageType dType) {
		damageType = dType;
	}

	public void setRangeType(RangeType rType) {
		rangeType = rType;
	}

	public void setElementalType(ElementalType eType) {
		elementalType = eType;
	}
}
