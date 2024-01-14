package model.world;

import java.util.ArrayList;

import exceptions.*;

import java.awt.*;
import model.abilities.*;
import model.effects.*;

public abstract class Champion implements Damageable, Comparable {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;

	public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage)
			throws Exception {
		this.name = name;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.mana = mana;
		this.maxActionPointsPerTurn = maxActions;
		this.currentActionPoints = maxActions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
	}

	abstract public void useLeaderAbility(ArrayList<Champion> targets)throws LeaderAbilityAlreadyUsedException;

	public int compareTo(Object o){
		Champion x = (Champion)o;
		if(this.speed==x.speed)  
		      return this.name.compareTo(x.name);  
		   else if(this.speed>x.speed)  
		      return -1;  
		   else  
		      return 1;  
    }

	public String getName() {
		return name;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		if (currentHP < 0)
			this.currentHP = 0;
		else if (currentHP > maxHP)
			this.currentHP = maxHP;
		else
			this.currentHP = currentHP;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if (currentActionPoints > maxActionPointsPerTurn)
			currentActionPoints = maxActionPointsPerTurn;
		else if (currentActionPoints < 0)
			currentActionPoints = 0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
