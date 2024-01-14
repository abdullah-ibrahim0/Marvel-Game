package model.abilities;

import java.util.ArrayList;

import model.world.*;

public class HealingAbility extends Ability {
	private int healAmount;

	public HealingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required,
			int healAmount) {
		super(name, cost, baseCoolDown, castRange, area, required);
		this.healAmount = healAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	public void execute(ArrayList<Damageable> targets) throws java.lang.CloneNotSupportedException {
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i) instanceof Champion)
				targets.get(i).setCurrentHP(targets.get(i).getCurrentHP() + this.healAmount);
		}
	}

}
