package model.world;

import java.util.ArrayList;
import exceptions.*;

import exceptions.LeaderAbilityAlreadyUsedException;
import model.effects.Embrace;

public class Villain extends Champion {
	public Villain(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage)
			throws Exception {
		super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
	}

	public void useLeaderAbility(ArrayList<Champion> targets) throws LeaderAbilityAlreadyUsedException {
		for (int i = 0; i < targets.size(); i++) {
			targets.get(i).setCurrentHP(0);
			targets.get(i).setCondition(Condition.KNOCKEDOUT);
		}
	}
}
