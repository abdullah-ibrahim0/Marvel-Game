package model.world;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.*;
import model.effects.Effect;
import model.effects.EffectType;
import model.effects.Embrace;

public class Hero extends Champion {
	public Hero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage)
			throws Exception {
		super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
	}

	public void useLeaderAbility(ArrayList<Champion> targets) {
		for(int i=0;i<targets.size();i++) {
			targets.get(i).getAppliedEffects().add(new Embrace(2));
			Embrace e=new Embrace(2);
			e.apply(targets.get(i));
			ArrayList<Effect> rEffects=new ArrayList<>();
			for(int j=0;j<targets.get(i).getAppliedEffects().size();j++) {
				if(targets.get(i).getAppliedEffects().get(j).getType()==EffectType.DEBUFF) {
					rEffects.add(targets.get(i).getAppliedEffects().get(j));
				}
			}
			for(Effect effect:rEffects)
				targets.get(i).getAppliedEffects().remove(effect);	
			}	
	}

}
