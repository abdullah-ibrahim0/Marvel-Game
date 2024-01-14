package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Root extends Effect{
	public Root(int duration)
	{
		super("Root",duration,EffectType.DEBUFF);
	}
	
	public void apply(Champion c) {
		if(c.getCondition().equals(Condition.INACTIVE))
			return;
		else
			c.setCondition(Condition.ROOTED);
	}
	
	public void remove(Champion c) {
		
		if(c.getCondition().equals(Condition.INACTIVE))
			return;
		for(Effect eff: c.getAppliedEffects())
			if(eff instanceof Root)
				return;
		c.setCondition(Condition.ACTIVE);
	}
}
