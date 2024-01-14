package model.effects;

import model.abilities.*;
import model.world.Champion;

public class PowerUp extends Effect{
	public PowerUp(int duration)
	{
		super("PowerUp",duration,EffectType.BUFF);
	}
	public void apply(Champion c) {
		for(int i=0;i< c.getAbilities().size();i++) {
			if(c.getAbilities().get(i) instanceof DamagingAbility) 
				((DamagingAbility)c.getAbilities().get(i)).setDamageAmount((int)(((DamagingAbility)c.getAbilities().get(i)).getDamageAmount()*1.2));
			
			if(c.getAbilities().get(i) instanceof HealingAbility) 
				((HealingAbility)c.getAbilities().get(i)).setHealAmount((int)(((HealingAbility)c.getAbilities().get(i)).getHealAmount()*1.2));
			
		}
	}
	public void remove(Champion c) {
		for(int i=0;i< c.getAbilities().size();i++) {
			if(c.getAbilities().get(i) instanceof DamagingAbility) 
				((DamagingAbility)c.getAbilities().get(i)).setDamageAmount((int)(((DamagingAbility)c.getAbilities().get(i)).getDamageAmount()/1.2));
			
			if(c.getAbilities().get(i) instanceof HealingAbility) 
				((HealingAbility)c.getAbilities().get(i)).setHealAmount((int)(((HealingAbility)c.getAbilities().get(i)).getHealAmount()/1.2));
			
		}
	}

}
