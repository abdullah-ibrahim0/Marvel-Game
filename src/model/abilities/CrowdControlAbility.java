package model.abilities;

import java.util.ArrayList;

import model.effects.Effect;
import model.world.Champion;
import model.world.Damageable;

public class CrowdControlAbility extends Ability {
	private Effect effect;

	public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required,
			Effect effect) {
		super(name, cost, baseCoolDown, castRange, area, required);
		this.effect = effect;
	}

	public Effect getEffect() {
		return effect;
	}

	public void execute(ArrayList<Damageable> targets) throws java.lang.CloneNotSupportedException {
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i) instanceof Champion) {
				Champion x = (Champion) targets.get(i);
				effect.apply(x);
				Effect y = (Effect) effect.clone();
				x.getAppliedEffects().add(y);
			}
		}
	}
}
