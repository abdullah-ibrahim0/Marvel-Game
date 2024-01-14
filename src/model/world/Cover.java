package model.world;
import java.awt.*;
public class Cover implements Damageable{
	private int currentHP;
	private Point location;
	public Cover(int x,int y)
	{
		this.location = new Point(x,y);
		currentHP = (int)(Math.random()*900)+100;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int newHp) {
		if (newHp < 0) {
			currentHP = 0;
		
		} else
			currentHP = newHp;
	}
	public Point getLocation() {
		return location;
	}
}
