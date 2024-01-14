package engine;

import java.util.*;

import exceptions.*;
import model.abilities.*;
import model.world.*;
import model.effects.*;
import java.awt.Point;
import java.io.*;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;
	private boolean firstLeaderAbilityUsed;
	private boolean secondLeaderAbilityUsed;
	private Object[][] board;
	private static ArrayList<Champion> availableChampions = new ArrayList<Champion>();
	private static ArrayList<Ability> availableAbilities = new ArrayList<Ability>();
	private PriorityQueue turnOrder;
	private final static int BOARDHEIGHT = 5;
	private final static int BOARDWIDTH = 5;

	public Game(Player firstPlayer, Player secondPlayer) throws Exception {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.board = new Object[5][5];
		// availableChampions = new ArrayList<Champion>();
		// availableAbilities = new ArrayList<Ability>();
		firstLeaderAbilityUsed = false;
		secondLeaderAbilityUsed = false;
		turnOrder = new PriorityQueue(6);
		placeCovers();
		placeChampions();
		prepareChampionTurns();
	}

	private void placeChampions() {
		if (firstPlayer.getTeam().size() == 3) {
			board[0][1] = firstPlayer.getTeam().get(0);
			firstPlayer.getTeam().get(0).setLocation(new Point(0, 1));
			board[0][2] = firstPlayer.getTeam().get(1);
			firstPlayer.getTeam().get(1).setLocation(new Point(0, 2));
			board[0][3] = firstPlayer.getTeam().get(2);
			firstPlayer.getTeam().get(2).setLocation(new Point(0, 3));
		}
		if (secondPlayer.getTeam().size() == 3) {
			board[4][1] = secondPlayer.getTeam().get(0);
			secondPlayer.getTeam().get(0).setLocation(new Point(4, 1));
			board[4][2] = secondPlayer.getTeam().get(1);
			secondPlayer.getTeam().get(1).setLocation(new Point(4, 2));
			board[4][3] = secondPlayer.getTeam().get(2);
			secondPlayer.getTeam().get(2).setLocation(new Point(4, 3));
		}
	}

	private void placeCovers() {
		Point[] arr = new Point[5];
		int i = 0;
		while (i < 5) {
			int x = (int) (Math.random() * 5);
			int y = (int) (Math.random() * 3) + 1;
			boolean f = false;
			for (int j = 0; j < i; j++) {
				if (x == arr[j].x && y == arr[j].y) {
					f = true;
					break;
				}
			}
			if (!f) {
				arr[i] = new Point(x, y);
				i++;
			}
		}
		for (int c = 0; c < 5; c++) {
			board[arr[c].y][arr[c].x] = new Cover(arr[c].y, arr[c].x);
		}
	}

	public static void loadAbilities(String filePath) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String[] x;
		while (br.ready()) {
			x = br.readLine().split(",");
			String a1 = x[0]; // Type
			String a2 = x[1]; // Name
			int a3 = Integer.parseInt(x[2]); // manaCost
			int a4 = Integer.parseInt(x[3]); // castRange
			int a5 = Integer.parseInt(x[4]); // baseCooldown
			AreaOfEffect a6 = AreaOfEffect.valueOf(x[5]); // AreaOfEffect
			int a7 = Integer.parseInt(x[6]); // requiredActionsPerTurn
			int a8 = 0;
			String A8 = null;
			if (x[7].matches("[0-9]+")) // check if the data in the array string contains a numbers or (else) String
				a8 = Integer.parseInt(x[7]); // damageAmount/healAmount
			else
				A8 = x[7]; // effect name
			if (a1.equals("CC")) {
				int a9 = Integer.parseInt(x[8]); // effect duration
				switch (A8) {
				case "Shield":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Shield(a9)));
					break;
				case "Stun":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Stun(a9)));
					break;
				case "Root":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Root(a9)));
					break;
				case "Disarm":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Disarm(a9)));
					break;
				case "Embrace":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Embrace(a9)));
					break;
				case "SpeedUp":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new SpeedUp(a9)));
					break;
				case "Dodge":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Dodge(a9)));
					break;
				case "PowerUp":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new PowerUp(a9)));
					break;
				case "Silence":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Silence(a9)));
					break;
				case "Shock":
					availableAbilities.add(new CrowdControlAbility(a2, a3, a5, a4, a6, a7, new Shock(a9)));
					break;
				}
			}
			if (a1.equals("DMG")) {
				availableAbilities.add(new DamagingAbility(a2, a3, a5, a4, a6, a7, a8));
			}
			if (a1.equals("HEL")) {
				availableAbilities.add(new HealingAbility(a2, a3, a5, a4, a6, a7, a8));
			}
		}
		br.close();
	}

	public static void loadChampions(String filePath) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String[] x;
		while (br.ready()) {
			x = br.readLine().split(",");
			String a1 = x[0]; // Type
			String a2 = x[1]; // Name
			int a3 = Integer.parseInt(x[2]); // maxHp
			int a4 = Integer.parseInt(x[3]); // mana
			int a5 = Integer.parseInt(x[4]); // actions
			int a6 = Integer.parseInt(x[5]); // speed
			int a7 = Integer.parseInt(x[6]); // attackRange
			int a8 = Integer.parseInt(x[7]); // attackDamage
			if (a1.equals("A")) {
				AntiHero C = new AntiHero(a2, a3, a4, a5, a6, a7, a8);
				int i;
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[8]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[9]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[10]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				availableChampions.add(C);
			}
			if (a1.equals("H")) {
				Hero C = new Hero(a2, a3, a4, a5, a6, a7, a8);
				int i;
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[8]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[9]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[10]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				availableChampions.add(C);

			}
			if (a1.equals("V")) {
				Villain C = new Villain(a2, a3, a4, a5, a6, a7, a8);
				int i;
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[8]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[9]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				for (i = 0; i < availableAbilities.size(); i++) {
					if (availableAbilities.get(i).getName().equals(x[10]))
						break;
				}
				if (availableAbilities.size() != 0)
					C.getAbilities().add(availableAbilities.get(i));
				availableChampions.add(C);
			}

		}
		br.close();
	}

	public Champion getCurrentChampion() {
		return (Champion) turnOrder.peekMin();
	}

	public Player checkGameOver() {
		if (this.firstPlayer.getTeam().size() == 0)
			return secondPlayer;
		if (this.secondPlayer.getTeam().size() == 0)
			return firstPlayer;
		return null;
	}

	public void move(Direction d) throws UnallowedMovementException, NotEnoughResourcesException {
		Champion x = this.getCurrentChampion();
		Point a = x.getLocation();
		int X = a.x;
		int Y = a.y;
		if (x.getCondition().equals(Condition.ROOTED))
			throw new UnallowedMovementException("You can not move while being rooted");
		if (d.equals(Direction.LEFT)) {
			if (a.y == 0)
				throw new UnallowedMovementException("Can not move out of the board");
			else if (x.getCurrentActionPoints() == 0)
				throw new NotEnoughResourcesException("You need at least one action point to move");
			else if (board[X][Y - 1] != null)
				throw new UnallowedMovementException("target cell is not empty");
			else {
				Point z = new Point(X, Y - 1);
				x.setLocation(z);
				board[X][Y] = null;
				board[X][Y - 1] = x;
				x.setCurrentActionPoints(x.getCurrentActionPoints() - 1);
			}
		}
		if (d.equals(Direction.RIGHT)) {
			if (a.y == 4)
				throw new UnallowedMovementException("Can not move out of the board");
			else if (x.getCurrentActionPoints() == 0)
				throw new NotEnoughResourcesException("You need at least one action point to move");
			else if (board[X][Y + 1] != null)
				throw new UnallowedMovementException("target cell is not empty");
			else {
				Point z = new Point(X, Y + 1);
				x.setLocation(z);
				board[X][Y] = null;
				board[X][Y + 1] = x;
				x.setCurrentActionPoints(x.getCurrentActionPoints() - 1);
			}
		}
		if (d.equals(Direction.UP)) {
			if (a.x == 4)
				throw new UnallowedMovementException("Can not move out of the board");
			else if (x.getCurrentActionPoints() == 0)
				throw new NotEnoughResourcesException("You need at least one action point to move");
			else if (board[X + 1][Y] != null)
				throw new UnallowedMovementException("target cell is not empty");
			else {
				Point z = new Point(X + 1, Y);
				x.setLocation(z);
				board[X][Y] = null;
				board[X + 1][Y] = x;
				x.setCurrentActionPoints(x.getCurrentActionPoints() - 1);
			}
		}
		if (d.equals(Direction.DOWN)) {
			if (a.x == 0)
				throw new UnallowedMovementException("Can not move out of the board");
			else if (x.getCurrentActionPoints() == 0)
				throw new NotEnoughResourcesException("You need at least one action point to move");
			else if (board[X - 1][Y] != null)
				throw new UnallowedMovementException("target cell is not empty");
			else {
				Point z = new Point(X - 1, Y);
				x.setLocation(z);
				board[X][Y] = null;
				board[X - 1][Y] = x;
				x.setCurrentActionPoints(x.getCurrentActionPoints() - 1);
			}
		}
	}

	public boolean withMe(Champion a, Champion c) {
		if (this.firstPlayer.getTeam().contains(a) && this.firstPlayer.getTeam().contains(c))
			return true;
		else if (this.secondPlayer.getTeam().contains(a) && this.secondPlayer.getTeam().contains(c))
			return true;
		else
			return false;
	}

	public void attackH(Damageable target) throws InvalidTargetException {
		Champion c = this.getCurrentChampion();
		int attackDamage = c.getAttackDamage();
		if (target instanceof Cover) {
			target.setCurrentHP(target.getCurrentHP() - c.getAttackDamage());
			if (target.getCurrentHP() <= 0)
				board[target.getLocation().x][target.getLocation().y] = null;
		} else {
			Champion a = (Champion) target;
			if (this.withMe(a, c))
				throw new InvalidTargetException("You can not attack your team");
			for (Effect eff : a.getAppliedEffects()) {
				if (eff instanceof Shield) {
					a.getAppliedEffects().remove(eff);
					eff.remove(a);
					return;
				}
				if (eff instanceof Dodge && (int) Math.round(Math.random()) == 0) {
					return;
				}
			}
			if (c instanceof Hero) {
				if (a instanceof Villain || a instanceof AntiHero)
					attackDamage = (int) (attackDamage * 1.5);
			}
			if (c instanceof Villain) {
				if (a instanceof Hero || a instanceof AntiHero)
					attackDamage = (int) (attackDamage * 1.5);
			}
			if (c instanceof AntiHero) {
				if (a instanceof Hero || a instanceof Villain)
					attackDamage = (int) (attackDamage * 1.5);
			}
			a.setCurrentHP(a.getCurrentHP() - attackDamage);

			if (a.getCurrentHP() <= 0) {
				removeChampion(a);
				if (firstPlayer.getTeam().contains(a))
					firstPlayer.getTeam().remove(a);
				else
					secondPlayer.getTeam().remove(a);
			}
		}
	}

	public void attack(Direction d)
			throws NotEnoughResourcesException, InvalidTargetException, ChampionDisarmedException {
		Champion c = this.getCurrentChampion();
		int x = (int) c.getLocation().getX();
		int y = (int) c.getLocation().getY();
		int range = c.getAttackRange();
		for (int i = 0; i < c.getAppliedEffects().size(); i++) {
			if (c.getAppliedEffects().get(i) instanceof Disarm)
				throw new ChampionDisarmedException("Can not attack while being disarmed");
		}
		if (c.getCurrentActionPoints() < 2)
			throw new NotEnoughResourcesException("You need at least two action point to perform a normal attack");
		switch (d) {
		case LEFT:
			int range3 = y - range < 0 ? 0 : y - range;
			for (int y1 = y - 1; y1 >= range3; y1--)
				if (board[x][y1] != null) {
					attackH((Damageable) board[x][y1]);
					break;
				}
			;
			break;
		case RIGHT:
			int range4 = y + range > 4 ? 4 : y + range;
			for (int y1 = y + 1; y1 <= range4; y1++)
				if (board[x][y1] != null) {
					attackH((Damageable) board[x][y1]);
					break;
				}
			;
			break;
		case UP:
			int range1 = x + range > 4 ? 4 : x + range;
			for (int x1 = x + 1; x1 <= range1; x1++)
				if (board[x1][y] != null) {
					attackH((Damageable) board[x1][y]);
					break;
				}
			;
			break;
		case DOWN:
			int range2 = x - range < 0 ? 0 : x - range;
			for (int x1 = x - 1; x1 >= range2; x1--)
				if (board[x1][y] != null) {
					attackH((Damageable) board[x1][y]);
					break;
				}
			;
			break;
		}
		c.setCurrentActionPoints(c.getCurrentActionPoints() - 2);
	}

	public void removeChampion(Champion c) {
		c.setCondition(Condition.KNOCKEDOUT);
		board[c.getLocation().x][c.getLocation().y] = null;
		if (this.firstPlayer.getTeam().contains(c))
			this.firstPlayer.getTeam().remove(c);
		if (this.secondPlayer.getTeam().contains(c))
			this.secondPlayer.getTeam().contains(c);
		PriorityQueue new1 = new PriorityQueue(6);
		while (!turnOrder.isEmpty()) {
			Champion a = (Champion) turnOrder.remove();
			if (a != c)
				new1.insert(a);
		}
		turnOrder = new1;
	}

	public void castAbility(Ability a) throws AbilityUseException, InvalidTargetException, NotEnoughResourcesException,
			CloneNotSupportedException {
		Champion c = getCurrentChampion();
		if (a.getCurrentCooldown() > 0)
			throw new AbilityUseException("You can not use an ability while it is in cooldown");

		for (Effect eff : c.getAppliedEffects())
			if (eff instanceof Silence)
				throw new AbilityUseException("You can not cast an ability while being silenced");

		if (c.getMana() < a.getManaCost())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getManaCost() + " mana to cast this ability");
		if (c.getCurrentActionPoints() < a.getRequiredActionPoints())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getRequiredActionPoints() + " action points to cast this ability");
		int x = c.getLocation().x;
		int y = c.getLocation().y;
		ArrayList<Damageable> targets = new ArrayList<>();
		switch (a.getCastArea()) {
		case SURROUND:
			int xDown = x == 0 ? 0 : x - 1;
			int xUp = x == 4 ? 4 : x + 1;
			int yLeft = y == 0 ? 0 : y - 1;
			int yRight = y == 4 ? 4 : y + 1;

			for (int x1 = xDown; x1 <= xUp; x1++)
				for (int y1 = yLeft; y1 <= yRight; y1++)
					if ((x == x1 && y == y1) || board[x1][y1] == null)
						continue;
					else
						try {
							validTarget(a, (Damageable) board[x1][y1], targets);
						} catch (InvalidTargetException e) {
						}
			a.execute(targets);
			for (Damageable target : targets) {
				if (target.getCurrentHP() == 0)
					for (int j = 0; j < targets.size(); j++) {
						if (targets.get(j).getCurrentHP() <= 0) {
							if (targets.get(j) instanceof Cover)
								board[targets.get(j).getLocation().x][targets.get(j).getLocation().y] = null;
							else {
								removeChampion((Champion) targets.get(j));
								if (firstPlayer.getTeam().contains(targets.get(j)))
									firstPlayer.getTeam().remove(targets.get(j));
								else
									secondPlayer.getTeam().remove(targets.get(j));
							}

						}
					}
			}
			break;

		case SELFTARGET:

			targets.add(c);
			a.execute(targets);
			for (Damageable target : targets) {
				if (target.getCurrentHP() == 0)
					for (int j = 0; j < targets.size(); j++) {
						if (targets.get(j).getCurrentHP() <= 0) {
							if (targets.get(j) instanceof Cover)
								board[targets.get(j).getLocation().x][targets.get(j).getLocation().y] = null;
							else
								removeChampion((Champion) targets.get(j));

						}
					}
			}
			break;

		case TEAMTARGET:

			for (Champion champ : firstPlayer.getTeam())
				if (Math.abs(y - champ.getLocation().y) + Math.abs(x - champ.getLocation().x) <= a.getCastRange())
					try {
						validTarget(a, champ, targets);
					} catch (InvalidTargetException e) {
					}
			for (Champion champ : secondPlayer.getTeam())
				if (Math.abs(y - champ.getLocation().y) + Math.abs(x - champ.getLocation().x) <= a.getCastRange())
					try {
						validTarget(a, champ, targets);
					} catch (InvalidTargetException e) {
					}

			a.execute(targets);
			for (Damageable target : targets) {
				if (target.getCurrentHP() == 0)
					for (int j = 0; j < targets.size(); j++) {
						if (targets.get(j).getCurrentHP() <= 0) {
							if (targets.get(j) instanceof Cover)
								board[targets.get(j).getLocation().x][targets.get(j).getLocation().y] = null;
							else {
								removeChampion((Champion) targets.get(j));
								if (firstPlayer.getTeam().contains(targets.get(j)))
									firstPlayer.getTeam().remove(targets.get(j));
								else
									secondPlayer.getTeam().remove(targets.get(j));
							}

						}
					}
			}
		}
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		c.setMana(c.getMana() - a.getManaCost());
		a.setCurrentCooldown(a.getBaseCooldown());
	}

	public void castAbility(Ability a, Direction d) throws InvalidTargetException, NotEnoughResourcesException,
			AbilityUseException, CloneNotSupportedException {
		Champion c = this.getCurrentChampion();
		int x = (int) c.getLocation().getX();
		int y = (int) c.getLocation().getY();
		if (a.getCurrentCooldown() > 0)
			throw new AbilityUseException("You can not use an ability while it is in cooldown");

		for (Effect eff : c.getAppliedEffects())
			if (eff instanceof Silence)
				throw new AbilityUseException("You can not cast an ability while being silenced");

		if (c.getMana() < a.getManaCost())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getManaCost() + " mana to cast this ability");
		if (c.getCurrentActionPoints() < a.getRequiredActionPoints())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getRequiredActionPoints() + " action points to cast this ability");
		ArrayList<Damageable> Objects = new ArrayList<Damageable>();
		ArrayList<Damageable> targets = new ArrayList<Damageable>();
		switch (d) {
		case LEFT:
			for (int i = 1; y - i >= 0 && i <= a.getCastRange(); i++) {
				if (board[x][y - i] != null) {
					Objects.add((Damageable) board[x][y - i]);
				}
			}
			;
			break;
		case RIGHT:
			for (int i = 1; y + i < 5 && i <= a.getCastRange(); i++) {
				if (board[x][y + i] != null) {

					Objects.add((Damageable) board[x][y + i]);
				}
			}
			;
			break;
		case UP:
			for (int i = 1; x + i < 5 && i <= a.getCastRange(); i++) {
				if (board[x + i][y] != null) {
					Objects.add((Damageable) board[x + i][y]);
				}
			}
			;
			break;
		case DOWN:
			for (int i = 1; x - i >= 0 && i <= a.getCastRange(); i++) {
				if (board[x - i][y] != null) {
					Objects.add((Damageable) board[x - i][y]);
				}
			}
			;
			break;
		}
		if (a instanceof DamagingAbility) {
			for (int i = 0; i < Objects.size(); i++) {
				if (Objects.get(i) instanceof Cover) {
					targets.add(Objects.get(i));
				} else if (Objects.get(i) instanceof Champion) {
					if (!withMe((Champion) Objects.get(i), c) && !shieldExist((Champion) Objects.get(i))) {
						targets.add((Champion) Objects.get(i));
					}
				}
			}
		}
		if (a instanceof HealingAbility) {
			for (int i = 0; i < Objects.size(); i++) {
				if (Objects.get(i) instanceof Champion) {
					if (withMe((Champion) Objects.get(i), c)) {
						targets.add((Champion) Objects.get(i));
					}
				}
			}
		}
		if (a instanceof CrowdControlAbility) {
			CrowdControlAbility cc = (CrowdControlAbility) a;
			for (int i = 0; i < Objects.size(); i++) {
				if (Objects.get(i) instanceof Champion) {
					if (withMe((Champion) Objects.get(i), c) && cc.getEffect().getType().equals(EffectType.BUFF))
						targets.add((Champion) Objects.get(i));
					else if (!withMe((Champion) Objects.get(i), c)
							&& cc.getEffect().getType().equals(EffectType.DEBUFF))
						targets.add((Champion) Objects.get(i));
				}
			}
		}
		a.execute(targets);
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i).getCurrentHP() <= 0) {
				if (targets.get(i) instanceof Cover) {
					board[targets.get(i).getLocation().x][targets.get(i).getLocation().y] = null;
				}
				if (targets.get(i) instanceof Champion) {

					board[targets.get(i).getLocation().x][targets.get(i).getLocation().y] = null;
					((Champion) targets.get(i)).setCondition(Condition.KNOCKEDOUT);
					if (firstPlayer.getTeam().contains((Champion) targets.get(i)))
						firstPlayer.getTeam().remove((Champion) targets.get(i));
					else
						secondPlayer.getTeam().remove((Champion) targets.get(i));
				}
			}
		}
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		c.setMana(c.getMana() - a.getManaCost());
		a.setCurrentCooldown(a.getBaseCooldown());
	}

	public void castAbility(Ability a, int x, int y) throws InvalidTargetException, NotEnoughResourcesException,
			AbilityUseException, CloneNotSupportedException {
		Champion c = this.getCurrentChampion();
		if (a.getCurrentCooldown() > 0)
			throw new AbilityUseException("You can not use an ability while it is in cooldown");
		for (int i = 0; i < c.getAppliedEffects().size(); i++)
			if (c.getAppliedEffects().get(i).getName().equals("Silence"))
				throw new AbilityUseException("You can not cast an ability while being silenced");
		if (c.getMana() < a.getManaCost())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getManaCost() + " mana to cast this ability");
		if (c.getCurrentActionPoints() < a.getRequiredActionPoints())
			throw new NotEnoughResourcesException(
					"you need at least " + a.getRequiredActionPoints() + " action points to cast this ability");
		if (board[x][y] instanceof Cover && !(a instanceof DamagingAbility))
			throw new InvalidTargetException("Covers can only be damaged");
		if (board[x][y] == null)
			throw new InvalidTargetException("You can not cast an ability on an empty cell");
		if (Math.abs(x - c.getLocation().x) + Math.abs(y - c.getLocation().y) > a.getCastRange())
			throw new AbilityUseException("Target out of the ability's cast range");
		ArrayList<Damageable> targets = new ArrayList<Damageable>();
		if (a instanceof DamagingAbility) {
			if (board[x][y] instanceof Cover) {
				Cover z = (Cover) board[x][y];
				targets.add(z);
				a.execute(targets);
				if (z.getCurrentHP() <= 0)
					board[x][y] = null;
			} else {
				Champion z = (Champion) board[x][y];
				if (this.withMe(z, c)) {
					throw new InvalidTargetException("Can not cast damaging ability on friendly targets");
				} else {
					for (Effect eff : z.getAppliedEffects()) {
						if (eff instanceof Dodge && (int) Math.round(Math.random()) == 0) {
							return;
						}
						if (eff instanceof Shield) {
							eff.remove(z);
							c.setMana(c.getMana() - a.getManaCost());
							c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
							a.setCurrentCooldown(a.getBaseCooldown());
							return;
						}
					}
					targets.add(z);
					a.execute(targets);
					if (z.getCurrentHP() <= 0) {
						this.removeChampion(z);
						if (firstPlayer.getTeam().contains(z))
							firstPlayer.getTeam().remove(z);
						else
							secondPlayer.getTeam().remove(z);
					}

				}
			}
		} else if (a instanceof HealingAbility) {
			if (board[x][y] instanceof Cover)
				throw new InvalidTargetException("Covers can only be damaged");
			else {
				Champion z = (Champion) board[x][y];
				if (!this.withMe(z, c))
					throw new InvalidTargetException("Can not cast healing ability on enemy targets");
				else {
					targets.add(z);
					a.execute(targets);
				}
			}
		} else {
			CrowdControlAbility CC = (CrowdControlAbility) a;
			if (board[x][y] instanceof Cover)
				throw new InvalidTargetException("Covers can only be damaged");
			else {
				Champion z = (Champion) board[x][y];
				if (this.withMe(z, c))
					if (CC.getEffect().getType().equals(EffectType.BUFF))
						targets.add(z);
					else
						throw new InvalidTargetException("Can not debuff friendly targets");
				else if (CC.getEffect().getType().equals(EffectType.DEBUFF))
					targets.add(z);
				else
					throw new InvalidTargetException("Can not buff enemy targets");
				CC.execute(targets);
				if (z.getCurrentHP() <= 0) {
					this.removeChampion(z);
					if (firstPlayer.getTeam().contains(z))
						firstPlayer.getTeam().remove(z);
					else
						secondPlayer.getTeam().remove(z);
				}
			}
		}
		c.setMana(c.getMana() - a.getManaCost());
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		a.setCurrentCooldown(a.getBaseCooldown());
	}

	public boolean shieldExist(Champion c) {
		int f = 0;
		for (int i = 0; i < c.getAppliedEffects().size(); i++)
			if (c.getAppliedEffects().get(i) instanceof Shield)
				f++;
		if (f == 0)
			return false;
		else
			return true;
	}

	public void validTarget(Ability a, Damageable z, ArrayList<Damageable> targets) throws InvalidTargetException {
		Champion c = getCurrentChampion();
		if (a instanceof HealingAbility) {
			if (z instanceof Cover)
				throw new InvalidTargetException();

			Champion target = (Champion) z;
			if (withMe(c, target))
				targets.add(target);
			else
				throw new InvalidTargetException();
		}
		if (a instanceof DamagingAbility) {
			if (z instanceof Champion) {
				Champion target = (Champion) z;
				if (withMe(c, target))
					throw new InvalidTargetException();
				else {
					for (Effect eff : target.getAppliedEffects()) {
						if (eff instanceof Dodge && (int) Math.round(Math.random()) == 0) {
							return;
						}
						if (eff instanceof Shield) {
							eff.remove(target);
							return;
						}
					}
					targets.add(target);
				}
			} else
				targets.add((Cover) z);
		}
		if (a instanceof CrowdControlAbility) {

			if (z instanceof Cover)
				throw new InvalidTargetException();
			else {
				Champion target = (Champion) z;
				Effect cc = ((CrowdControlAbility) a).getEffect();
				if (withMe(c, target))
					if (cc.getType() == EffectType.DEBUFF)
						throw new InvalidTargetException();
					else
						targets.add(target);
				if (!(withMe(c, target)))
					if (cc.getType() == EffectType.BUFF)
						throw new InvalidTargetException();
					else
						targets.add(target);
			}
		}
	}

	public void useLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
		if (getCurrentChampion() != firstPlayer.getLeader() && getCurrentChampion() != secondPlayer.getLeader())
			throw new LeaderNotCurrentException("The current champion is not a leader");
		if (getCurrentChampion() == firstPlayer.getLeader() && firstLeaderAbilityUsed)
			throw new LeaderAbilityAlreadyUsedException("This leader already used his ability");
		if (getCurrentChampion() == secondPlayer.getLeader() && secondLeaderAbilityUsed)
			throw new LeaderAbilityAlreadyUsedException("This leader already used his ability");
		ArrayList<Champion> targets = new ArrayList<Champion>();
		if (getCurrentChampion() instanceof Hero) {
			ArrayList<Champion> team = getCurrentChampion() == firstPlayer.getLeader() ? firstPlayer.getTeam()
					: secondPlayer.getTeam();
			targets.add(getCurrentChampion());
			for (Champion c : team)
				targets.add(c);
		} else if (getCurrentChampion() instanceof AntiHero) {
			for (Champion c : firstPlayer.getTeam()) {
				if (c != firstPlayer.getLeader())
					targets.add(c);
			}
			for (Champion c : secondPlayer.getTeam()) {
				if (c != secondPlayer.getLeader())
					targets.add(c);
			}
		} else if (getCurrentChampion() instanceof Villain) {
			ArrayList<Champion> enemies = getCurrentChampion() == firstPlayer.getLeader() ? secondPlayer.getTeam()
					: firstPlayer.getTeam();
			for (Champion c : enemies) {
				if (c.getCurrentHP() < (0.3 * c.getMaxHP()))
					targets.add(c);
			}
		}
		getCurrentChampion().useLeaderAbility(targets);
		if (getCurrentChampion() == firstPlayer.getLeader())
			firstLeaderAbilityUsed = true;
		else if (getCurrentChampion() == secondPlayer.getLeader())
			secondLeaderAbilityUsed = true;
	}

	public void endTurn() {
		turnOrder.remove();
		if (turnOrder.isEmpty())
			prepareChampionTurns();
		while (!turnOrder.isEmpty() && hasEffect((Champion) turnOrder.peekMin(), "Stun")) {
			Champion current = (Champion) turnOrder.peekMin();
			updateTimers(current);
			turnOrder.remove();
		}
		Champion current = (Champion) turnOrder.peekMin();
		updateTimers(current);
		current.setCurrentActionPoints(current.getMaxActionPointsPerTurn());
	}

	private boolean hasEffect(Champion currentChampion, String s) {
		for (Effect e : currentChampion.getAppliedEffects()) {
			if (e.getName().equals(s))
				return true;
		}
		return false;
	}

	private void updateTimers(Champion current) {
		int i = 0;
		while (i < current.getAppliedEffects().size()) {
			Effect e = current.getAppliedEffects().get(i);
			e.setDuration(e.getDuration() - 1);
			if (e.getDuration() == 0) {
				current.getAppliedEffects().remove(e);
				e.remove(current);

			} else
				i++;
		}
		for (Ability a : current.getAbilities()) {
			if (a.getCurrentCooldown() > 0)
				a.setCurrentCooldown(a.getCurrentCooldown() - 1);
		}
	}

	// helper for updates turns of effects and abbilites

	public void UpEandA(Champion s) {
		int i = 0;
		ArrayList<Effect> removed = new ArrayList<Effect>();
		while (i < s.getAppliedEffects().size()) {
			Effect z = s.getAppliedEffects().get(i);
			z.setDuration(z.getDuration() - 1);
			if (z.getDuration() == 0) {
				removed.add(z);
				z.remove(s);
			}
			i++;
		}
		for (Effect eff : removed)
			s.getAppliedEffects().remove(eff);

		i = 0;
		while (i < s.getAbilities().size()) {
			Ability a = s.getAbilities().get(i);
			a.setCurrentCooldown(a.getCurrentCooldown() - 1);
			i++;
		}
	}

	private void prepareChampionTurns() {
		for (Champion x : firstPlayer.getTeam())
			if (x.getCondition() != Condition.KNOCKEDOUT)
				turnOrder.insert(x);

		for (Champion x : secondPlayer.getTeam())
			if (x.getCondition() != Condition.KNOCKEDOUT)
				turnOrder.insert(x);
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

	public Object[][] getBoard() {
		return board;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static int getBoardheight() {
		return BOARDHEIGHT;
	}

	public static int getBoardwidth() {
		return BOARDWIDTH;
	}
}
