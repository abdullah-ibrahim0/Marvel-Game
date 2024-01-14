package model.abilities;

import java.util.ArrayList;

import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;

public class DamagingAbility extends Ability {
	private int damageAmount;

	public DamagingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required,
			int damageAmount) {
		super(name, cost, baseCoolDown, castRange, area, required);
		this.damageAmount = damageAmount;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	public void execute(ArrayList<Damageable> targets) throws java.lang.CloneNotSupportedException {
		for (int i = 0; i < targets.size(); i++) {
			targets.get(i).setCurrentHP(targets.get(i).getCurrentHP() - this.damageAmount);
		}

	}

}
