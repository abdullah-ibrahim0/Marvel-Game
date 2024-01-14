package model.world;

import java.util.ArrayList;
import exceptions.*;

import exceptions.LeaderAbilityAlreadyUsedException;
import model.effects.*;

public class AntiHero extends Champion {
	public AntiHero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage)
			throws Exception {
		super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
	}

	public void useLeaderAbility(ArrayList<Champion> targets) throws LeaderAbilityAlreadyUsedException {
		for (Champion c: targets)
		{
			Stun s = new Stun(2);
			c.getAppliedEffects().add(s);
			s.apply(c);
		}
	}

}
