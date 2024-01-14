package Controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import engine.*;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import views.*;
 

public class GameController implements ActionListener,KeyListener {
	private Game game;
	private Player player1;
	private Player player2;
	private VideoClass frame;
	private StartFrame frame0;
	private GameFrame frame1;
	private GameFrame2 frame2;
	private GameFrame3 frame3;
	private GameFrame4 frame4;
	private GameFrame5 frame5;
	private GameBoard frame6;
	private ImageIcon icon,icon1,icon2;
	private boolean bability=false;
	private int x = 0;
	private int y = 0;
	private PriorityQueue pq;
	public GameController() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		File base = new File("startSound.wav");
		Clip clip1 = AudioSystem.getClip();
		clip1.open(AudioSystem.getAudioInputStream(base));
		File war = new File("warTime.wav");
		Clip clip2 = AudioSystem.getClip();
		clip2.open(AudioSystem.getAudioInputStream(war));
		try {
			game.loadChampions("Champions.csv");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			game.loadAbilities("Abilities.csv");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new VideoClass();
		frame.getB().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(frame.getB())){
		                frame.getClip1().stop();
						frame0 = new StartFrame();
						 clip1.start();
				         clip1.loop(5555);
				         frame.dispose();
		            frame0.getbutton().addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
				         if (e.getSource().equals(frame0.getbutton())) {
					           PlaySound.playClick();
					          
					           frame0.dispose();
					           frame1 = new GameFrame();
					           frame1.getbutton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getSource().equals(frame1.getbutton())) {
								PlaySound.playClick();
								String name1 = frame1.getField1().getText();
								String name2 = frame1.getField2().getText();
								if (name1.equals("") || name2.equals("")) {
									JOptionPane.showMessageDialog(frame1, "Please, Fill your name to start the game !");
									return;
								}
								if (name1.equals(name2)) {
									JOptionPane.showMessageDialog(frame1,
											"Please, type different names to start the game !");
									return;
								}
							
								player1 = new Player(frame1.getField1().getText());
								player2 = new Player(frame1.getField2().getText());
								frame1.dispose();
								frame2 = new GameFrame2();
								frame2.getButton().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (e.getSource().equals(frame2.getButton())) {
											PlaySound.playClick();
											if (frame2.getPicked() < 3) {
												JOptionPane.showMessageDialog(frame2,
														"Please, Pick Up 3 Champions to start the game !");
												return;
											} else {
												frame2.dispose();
												frame3=new GameFrame3();
												frame3.getFrame2Index().add(frame2.getChampionsIndex().get(0));
												frame3.getFrame2Index().add(frame2.getChampionsIndex().get(1));
												frame3.getFrame2Index().add(frame2.getChampionsIndex().get(2));
												frame3.getButton().addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														if (e.getSource().equals(frame3.getButton())) {
															PlaySound.playClick();
															if (frame3.getPicked() < 3) {
																JOptionPane.showMessageDialog(frame3,
																		"Please, Pick Up 3 Champions to start the game !");
																return;
															}else {
																frame3.getFm().dispose();
																for (int i = 0; i < 3; i++) {
																	player1.getTeam().add(Game.getAvailableChampions()
																			.get(frame2.getChampionsIndex().get(i)));
																	player2.getTeam().add(Game.getAvailableChampions()
																			.get(frame3.getChampionsIndex().get(i)));
																}
																for(int i=0;i<3;i++) {
																	switch (player1.getTeam().get(i).getName()) {
																	    case "Captain America" :
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(0));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(1));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(2));
																		    ;
																		    break;
																	    case "Deadpool" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(3));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(4));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(5));
																			;
																			break;
																	    case "Dr Strange" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(6));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(7));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(8));
																			;
																			break;
																	    case "Electro" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(9));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(10));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(11));
																			;
																			break;
																	    case "Ghost Rider" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(12));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(13));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(14));
																			;
																			break;
																	    case "Hela" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(15));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(16));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(17));

																			;
																			break;
																	    case "Hulk" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(18));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(19));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(20));
																			;
																			break;
																	    case "Iceman" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(21));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(22));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(23));
																			;
																			break;
																	    case "Ironman" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(24));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(25));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(26));
																			;
																			break;
																	    case "Loki" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(27));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(28));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(29));
																			;
																			break;
																	    case "Quicksilver" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(30));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(31));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(32));
																			;
																			break;
																	    case "Spiderman" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(33));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(34));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(35));
																			;
																			break;
																	    case "Thor" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(36));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(37));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(38));
																			;
																			break;
																	    case "Venom" :
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(39));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(40));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(41));
																			;
																			break;
																	    case "Yellow Jacket" : 
																	    	player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(42));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(43));
																			player1.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(44));
																			;
																			break;
																	}
																}
																for(int i=0;i<3;i++) {
																	switch (player2.getTeam().get(i).getName()) {
																	    case "Captain America" :
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(0));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(1));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(2));
																		    ;
																		    break;
																	    case "Deadpool" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(3));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(4));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(5));
																			;
																			break;
																	    case "Dr Strange" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(6));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(7));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(8));
																			;
																			break;
																	    case "Electro" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(9));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(10));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(11));
																			;
																			break;
																	    case "Ghost Rider" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(12));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(13));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(14));
																			;
																			break;
																	    case "Hela" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(15));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(16));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(17));

																			;
																			break;
																	    case "Hulk" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(18));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(19));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(20));
																			;
																			break;
																	    case "Iceman" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(21));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(22));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(23));
																			;
																			break;
																	    case "Ironman" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(24));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(25));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(26));
																			;
																			break;
																	    case "Loki" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(27));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(28));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(29));
																			;
																			break;
																	    case "Quicksilver" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(30));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(31));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(32));
																			;
																			break;
																	    case "Spiderman" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(33));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(34));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(35));
																			;
																			break;
																	    case "Thor" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(36));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(37));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(38));
																			;
																			break;
																	    case "Venom" :
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(39));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(40));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(41));
																			;
																			break;
																	    case "Yellow Jacket" : 
																	    	player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(42));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(43));
																			player2.getTeam().get(i).getAbilities().add(game.getAvailableAbilities().get(44));
																			;
																			break;
																	}
																}
																frame4= new GameFrame4();
																frame4.setVisible(false);
																try {
																	game = new Game(player1, player2);
																} catch (Exception e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
																pq = new PriorityQueue(6);
																
																while(!game.getTurnOrder().isEmpty())
																	pq.insert(game.getTurnOrder().remove());
																while(!pq.isEmpty())
																	game.getTurnOrder().insert(pq.remove());
																for (int i = 0; i < 3; i++) {
																	switch (frame2.getChampionsIndex().get(i)) {
																	case 0:
																		icon = new ImageIcon(".\\assests\\Captain America.png");
																		Image img = icon.getImage();
																		Image newimg1 = img.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg1);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 1:
																		icon = new ImageIcon(".\\assests\\Deadpool.png");
																		Image img2 = icon.getImage();
																		Image newimg2 = img2.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg2);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 2:
																		icon = new ImageIcon(".\\assests\\Dr Strange.png");
																		Image img3 = icon.getImage();
																		Image newimg3 = img3.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg3);
																		if (i == 0) {

																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 3:
																		icon = new ImageIcon(".\\assests\\Electro.png");
																		Image img4 = icon.getImage();
																		Image newimg4 = img4.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg4);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 4:
																		icon = new ImageIcon(".\\assests\\Ghost Rider.png");
																		Image img5 = icon.getImage();
																		Image newimg5 = img5.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg5);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 5:
																		icon = new ImageIcon(".\\assests\\Hela.png");
																		Image img6 = icon.getImage();
																		Image newimg6 = img6.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg6);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 6:
																		icon = new ImageIcon(".\\assests\\Hulk.png");
																		Image img7 = icon.getImage();
																		Image newimg7 = img7.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg7);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 7:
																		icon = new ImageIcon(".\\assests\\Iceman.png");
																		Image img8 = icon.getImage();
																		Image newimg8 = img8.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg8);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 8:
																		icon = new ImageIcon(".\\assests\\Ironman.png");
																		Image img9 = icon.getImage();
																		Image newimg9 = img9.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg9);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 9:
																		icon = new ImageIcon(".\\assests\\Loki.png");
																		Image img10 = icon.getImage();
																		Image newimg10 = img10.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg10);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 10:
																		icon = new ImageIcon(".\\assests\\Quicksilver.png");
																		Image img11 = icon.getImage();
																		Image newimg11 = img11.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg11);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 11:
																		icon = new ImageIcon(".\\assests\\Spiderman.png");
																		Image img12 = icon.getImage();
																		Image newimg12 = img12.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg12);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 12:
																		icon = new ImageIcon(".\\assests\\Thor.png");
																		Image img13 = icon.getImage();
																		Image newimg13 = img13.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg13);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 13:
																		icon = new ImageIcon(".\\assests\\Venom.png");
																		Image img14 = icon.getImage();
																		Image newimg14 = img14.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg14);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	case 14:
																		icon = new ImageIcon(".\\assests\\Yellow Jacket.png");
																		Image img15 = icon.getImage();
																		Image newimg15 = img15.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																		icon = new ImageIcon(newimg15);
																		if (i == 0) {
																			frame4.getB1().setIcon(icon);
																		} else if (i == 1) {
																			frame4.getB2().setIcon(icon);
																		} else {
																			frame4.getB3().setIcon(icon);
																		}
																		;
																		break;
																	}
																}
																frame4.setVisible(true);
																frame4.getB1().addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		if (e.getSource().equals(frame4.getB1())){
																			PlaySound.playClick();
																			if(x==0) {
																			player1.setLeader(player1.getTeam().get(0));
																			frame4.getB1().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																			x++;
																			return;
																			}
																		}
																	}
																});
																frame4.getB2().addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		if (e.getSource().equals(frame4.getB2())) {
																			PlaySound.playClick();
																			if(x==0) {
																			player1.setLeader(player1.getTeam().get(1));
																			frame4.getB2().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																			x++;
																			return;
																			}
																		}
																	}
																});
																frame4.getB3().addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		if (e.getSource().equals(frame4.getB3())) {
																			PlaySound.playClick();
																			if(x==0) {
																			player1.setLeader(player1.getTeam().get(2));
																			frame4.getB3().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																			x++;
																			return;
																			}
																		}
																	}
																});
																frame4.getB4().addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e) {
																		if (e.getSource().equals(frame4.getB4())) {
																			PlaySound.playClick();
																			if(player1.getLeader()==null) {
																				JOptionPane.showMessageDialog(frame4,
																						"Please, Choose Your Leader Champion to start the game !");
																			}
																			else {
																				frame4.dispose();
																				frame5 = new GameFrame5();
																				frame5.setVisible(false);
																				for (int i = 0; i < 3; i++) {
																					switch (frame3.getChampionsIndex().get(i)) {
																					case 0:
																						icon = new ImageIcon(".\\assests\\Captain America.png");
																						Image img = icon.getImage();
																						Image newimg1 = img.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg1);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 1:
																						icon = new ImageIcon(".\\assests\\Deadpool.png");
																						Image img2 = icon.getImage();
																						Image newimg2 = img2.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg2);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 2:
																						icon = new ImageIcon(".\\assests\\Dr Strange.png");
																						Image img3 = icon.getImage();
																						Image newimg3 = img3.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg3);
																						if (i == 0) {

																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 3:
																						icon = new ImageIcon(".\\assests\\Electro.png");
																						Image img4 = icon.getImage();
																						Image newimg4 = img4.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg4);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 4:
																						icon = new ImageIcon(".\\assests\\Ghost Rider.png");
																						Image img5 = icon.getImage();
																						Image newimg5 = img5.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg5);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 5:
																						icon = new ImageIcon(".\\assests\\Hela.png");
																						Image img6 = icon.getImage();
																						Image newimg6 = img6.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg6);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 6:
																						icon = new ImageIcon(".\\assests\\Hulk.png");
																						Image img7 = icon.getImage();
																						Image newimg7 = img7.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg7);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 7:
																						icon = new ImageIcon(".\\assests\\Iceman.png");
																						Image img8 = icon.getImage();
																						Image newimg8 = img8.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg8);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 8:
																						icon = new ImageIcon(".\\assests\\Ironman.png");
																						Image img9 = icon.getImage();
																						Image newimg9 = img9.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg9);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 9:
																						icon = new ImageIcon(".\\assests\\Loki.png");
																						Image img10 = icon.getImage();
																						Image newimg10 = img10.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg10);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 10:
																						icon = new ImageIcon(".\\assests\\Quicksilver.png");
																						Image img11 = icon.getImage();
																						Image newimg11 = img11.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg11);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 11:
																						icon = new ImageIcon(".\\assests\\Spiderman.png");
																						Image img12 = icon.getImage();
																						Image newimg12 = img12.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg12);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 12:
																						icon = new ImageIcon(".\\assests\\Thor.png");
																						Image img13 = icon.getImage();
																						Image newimg13 = img13.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg13);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 13:
																						icon = new ImageIcon(".\\assests\\Venom.png");
																						Image img14 = icon.getImage();
																						Image newimg14 = img14.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg14);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					case 14:
																						icon = new ImageIcon(".\\assests\\Yellow Jacket.png");
																						Image img15 = icon.getImage();
																						Image newimg15 = img15.getScaledInstance(130, 220, java.awt.Image.SCALE_SMOOTH);
																						icon = new ImageIcon(newimg15);
																						if (i == 0) {
																							frame5.getB1().setIcon(icon);
																						} else if (i == 1) {
																							frame5.getB2().setIcon(icon);
																						} else {
																							frame5.getB3().setIcon(icon);
																						}
																						;
																						break;
																					}
																				}
																				frame5.setVisible(true);
																				frame5.getB1().addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						if (e.getSource().equals(frame5.getB1())) {
																							PlaySound.playClick();
																							if(y==0) {
																							player2.setLeader(player2.getTeam().get(0));
																							frame5.getB1().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																							y++;
																							return;
																							}
																						}
																					}
																				});
																				frame5.getB2().addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						if (e.getSource().equals(frame5.getB2())) {
																							PlaySound.playClick();
																							if(y==0) {
																							player2.setLeader(player2.getTeam().get(1));
																							frame5.getB2().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																							y++;
																							return;
																							}
																						}
																					}
																				});
																				frame5.getB3().addActionListener(new ActionListener(){
																					public void actionPerformed(ActionEvent e) {
																						if (e.getSource().equals(frame5.getB3())) {
																							PlaySound.playClick();
																							if(y==0) {
																							player2.setLeader(player2.getTeam().get(2));
																							frame5.getB3().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,5));
																							y++;
																							return;
																							}
																						}
																					}
																				});
																				frame5.getB4().addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						if (e.getSource().equals(frame5.getB4())) {
																							PlaySound.playClick();
																							if(player2.getLeader()==null) {
																								JOptionPane.showMessageDialog(frame5,
																										"Please, Choose Your Leader Champion to start the game !");
																							}
																							else {
																								try {
																									Clip clip = AudioSystem.getClip();
																									clip.close();
																								} catch (Exception e2) {
																									e2.printStackTrace();
																								}
																								clip1.stop();
																								clip1.close();
																								
																								clip2.start();
																								clip2.loop(5555);
																								frame5.dispose();
																								frame6 = new GameBoard();
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.getI().setFocusable(false);
																								frame6.getI().addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(e.getSource().equals(frame6.getI())) {
																											PlaySound.playClick();
																											JOptionPane.showMessageDialog(frame6,"       "+
																										"                          Playing Rules :"+"\n"+"\n"+"you can move by keyBoard Arrows"+"\n"+
																											"you can Attack by Keys Characters : (W) for Up Attack "+"\n"+
																											"                                                                (S) for Down Attack"+"\n"+
																											"                                                                (A) for Left Attack"+"\n"+
																											"                                                                (D) for Right Attack"+
																											"\n"+"you can End Champion Turn by Clicking on (Z)");
																										}
																										
																									}
																								});
																								frame6.getI().setFocusable(false);
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								clip1.start();
																								frame6.getNorth().setText("\n"+"    Player One Name : "+name1+"\n"+"\n"+
																								"    Player Two Name : "+name2);
																								updateGrid(frame6,game);
																								frame6.getEast().setText(printDetails(game.getCurrentChampion()));
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.getB1().setFocusable(false);
																								frame6.getB1().addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(e.getSource().equals(frame6.getB1())){
																											PlaySound.playClick();
																											String x = game.getCurrentChampion().getAbilities().get(0).getCastArea()+"";
																											switch (x) {
																											case "SELFTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SELFTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(0));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}break;
																											case "SINGLETARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SINGLETARGET, Please Choose the Target Cell by Mouse to cast The "+
																												         "Ability on it");
																												SingleTargetFrame f = new SingleTargetFrame(game.getCurrentChampion().getAbilities().get(0), frame6, game);
																												doSingleTargetframe(f, game);
																												;break;
																											case "TEAMTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is TEAMTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(0));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											case "DIRECTIONAL":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is DIRECTIONAL ability,Choose a Direction "+
																												"by Clicking on keyboard arrows to Cast it");
																												bability=true;
																												frame6.getB1().setFocusable(true);
																												frame6.getB1().requestFocus();
																												frame6.getB1().addKeyListener(new KeyListener() {
																													public void keyTyped(KeyEvent e) {
																													}
																													public void keyReleased(KeyEvent e) {
																													}
																													public void keyPressed(KeyEvent e) {
																														int keyCode = e.getKeyCode();
																													    switch( keyCode ) { 
																													    case 38:
																															try {if(bability) {
																																frame6.setFocusable(true);
																																game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.UP);
																																updateGrid(frame6, game);
																																frame6.getB1().setFocusable(false);
																																bability=false;
																															
																																if(game.checkGameOver()!=null) {
																																	clip2.stop();
																																	clip2.close();
																																	if(game.checkGameOver().equals(player1)){
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player One, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																																	if(game.checkGameOver().equals(player2)) {
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																															}
																															}
																															} catch (AbilityUseException e1) {
																																bability =false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (InvalidTargetException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (NotEnoughResourcesException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (CloneNotSupportedException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															}
																															frame6.getB1().setFocusable(false);
																															frame6.setFocusable(true);
																															frame6.requestFocus();
																															break;
																													        case 40:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.DOWN);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        	}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 37:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.LEFT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 39:
																													        	try {
																													        		if(bability) {
																													        			
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.RIGHT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													    }
																													}
																												})
																												;break;
																											case "SURROUND":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SURROUND ability, Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(0));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											}
																											
																										}
																									}
																								});
																								frame6.getB1().setFocusable(false);
																								frame6.getB2().setFocusable(false);
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.getB2().addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(e.getSource().equals(frame6.getB2())){
																											PlaySound.playClick();
																											String x = game.getCurrentChampion().getAbilities().get(1).getCastArea()+"";
																											switch (x) {
																											case "SELFTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SELFTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(1));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}break;
																											case "SINGLETARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SINGLETARGET, Please Choose the Target Cell by Mouse to cast The "+
																												         "Ability on it");
																												SingleTargetFrame f = new SingleTargetFrame(game.getCurrentChampion().getAbilities().get(1), frame6, game);
																												f.dispose();
																												doSingleTargetframe(f, game);
																												break;
																											case "TEAMTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is TEAMTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(1));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											case "DIRECTIONAL":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is DIRECTIONAL ability,Choose a Direction "+
																												"by Clicking on keyboard arrows to Cast it");
																												bability=true;
																												frame6.getB2().setFocusable(true);
																												frame6.getB2().requestFocus();
																												frame6.getB2().addKeyListener(new KeyListener() {
																													public void keyTyped(KeyEvent e) {
																													}
																													public void keyReleased(KeyEvent e) {
																													}
																													public void keyPressed(KeyEvent e) {
																														int keyCode = e.getKeyCode();
																													    switch( keyCode ) { 
																													    case 38:
																															try {if(bability) {
																																frame6.setFocusable(true);
																																game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.UP);
																																updateGrid(frame6, game);
																																frame6.getB1().setFocusable(false);
																																bability=false;
																															
																																if(game.checkGameOver()!=null) {
																																	clip2.stop();
																																	clip2.close();
																																	if(game.checkGameOver().equals(player1)){
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player One, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																																	if(game.checkGameOver().equals(player2)) {
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																															}
																															}
																															} catch (AbilityUseException e1) {
																																bability =false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (InvalidTargetException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (NotEnoughResourcesException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (CloneNotSupportedException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															}
																															frame6.getB1().setFocusable(false);
																															frame6.setFocusable(true);
																															frame6.requestFocus();
																															break;
																													        case 40:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.DOWN);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        	}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 37:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.LEFT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 39:
																													        	try {
																													        		if(bability) {
																													        			
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.RIGHT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													    }
																													}
																												})
																												;break;
																											case "SURROUND":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SURROUND ability, Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(1));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											}
																											
																										}
																									}
																								});
																								frame6.getB2().setFocusable(false);
																								frame6.getB3().setFocusable(false);
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.getB3().addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(e.getSource().equals(frame6.getB3())){
																											PlaySound.playClick();
																											String x = game.getCurrentChampion().getAbilities().get(2).getCastArea()+"";
																											switch (x) {
																											case "SELFTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SELFTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(2));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}break;
																											case "SINGLETARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SINGLETARGET, Please Choose the Target Cell by Mouse to cast The "+
																												         "Ability on it");
																												SingleTargetFrame f = new SingleTargetFrame(game.getCurrentChampion().getAbilities().get(2), frame6, game);
																												doSingleTargetframe(f, game);
																												;break;
																											case "TEAMTARGET":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is TEAMTARGET ability,Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(2));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											case "DIRECTIONAL":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is DIRECTIONAL ability,Choose a Direction "+
																												"by Clicking on keyboard arrows to Cast it");
																												bability=true;
																												frame6.getB3().setFocusable(true);
																												frame6.getB3().requestFocus();
																												frame6.getB3().addKeyListener(new KeyListener() {
																													public void keyTyped(KeyEvent e) {
																													}
																													public void keyReleased(KeyEvent e) {
																													}
																													public void keyPressed(KeyEvent e) {
																														int keyCode = e.getKeyCode();
																													    switch( keyCode ) { 
																													    case 38:
																															try {if(bability) {
																																frame6.setFocusable(true);
																																game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.UP);
																																updateGrid(frame6, game);
																																frame6.getB1().setFocusable(false);
																																bability=false;
																															
																																if(game.checkGameOver()!=null) {
																																	clip2.stop();
																																	clip2.close();
																																	if(game.checkGameOver().equals(player1)){
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player One, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																																	if(game.checkGameOver().equals(player2)) {
																																		JOptionPane.showMessageDialog(frame6,
																																				"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																		frame6.dispose();
																																	}
																															}
																															}
																															} catch (AbilityUseException e1) {
																																bability =false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (InvalidTargetException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (NotEnoughResourcesException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															} catch (CloneNotSupportedException e1) {
																																bability=false;
																																JOptionPane.showMessageDialog(frame6,
																																		e1.getLocalizedMessage());
																															}
																															frame6.getB1().setFocusable(false);
																															frame6.setFocusable(true);
																															frame6.requestFocus();
																															break;
																													        case 40:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.DOWN);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        	}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 37:
																													        	try {
																													        		if(bability) {
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.LEFT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													        case 39:
																													        	try {
																													        		if(bability) {
																													        			
																													        		frame6.setFocusable(false);
																																	game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.RIGHT);
																																	updateGrid(frame6, game);
																																	frame6.getB1().setFocusable(false);
																																	bability=false;
																													        		
																																	if(game.checkGameOver()!=null) {
																																		clip2.stop();
																																		clip2.close();
																																		if(game.checkGameOver().equals(player1)){
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player One, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																		if(game.checkGameOver().equals(player2)) {
																																			JOptionPane.showMessageDialog(frame6,
																																					"Congratulations Player Two, You win ! Press Ok To End The Game ");
																																			frame6.dispose();
																																		}
																																}
																													        		}
																																} catch (AbilityUseException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (InvalidTargetException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (NotEnoughResourcesException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																} catch (CloneNotSupportedException e1) {
																																	bability=false;
																																	JOptionPane.showMessageDialog(frame6,
																																			e1.getLocalizedMessage());
																																}
																													        	frame6.getB1().setFocusable(false);
																													        	frame6.setFocusable(true);
																													        	frame6.requestFocus();break;
																													    }
																													}
																												})
																												;break;
																											case "SURROUND":
																												JOptionPane.showMessageDialog(frame6,
																														"This Ability is SURROUND ability, Press Ok to Cast it");
																												try {
																													game.castAbility(game.getCurrentChampion().getAbilities().get(2));
																													updateGrid(frame6, game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (AbilityUseException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (CloneNotSupportedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																												;break;
																											}
																											
																										}
																									}
																								});
																								frame6.getB3().setFocusable(false);
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.getButton().addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(e.getSource().equals(frame6.getButton())){
																											PlaySound.playClick();
																											try {
																												game.useLeaderAbility();
																												updateGrid(frame6,game);
																												if(game.checkGameOver()!=null) {
																													clip2.stop();
																													clip2.close();
																													if(game.checkGameOver().equals(player1)){
																														JOptionPane.showMessageDialog(frame6,
																																"Congratulations Player One, You win ! Press Ok To End The Game ");
																														frame6.dispose();
																													}
																													if(game.checkGameOver().equals(player2)) {
																														JOptionPane.showMessageDialog(frame6,
																																"Congratulations Player Two, You win ! Press Ok To End The Game ");
																														frame6.dispose();
																													}
																												}
																											} catch (LeaderAbilityAlreadyUsedException e1) {
																												JOptionPane.showMessageDialog(frame6,
																														e1.getLocalizedMessage());
																											} catch (LeaderNotCurrentException e1) {
																												JOptionPane.showMessageDialog(frame6,
																														e1.getLocalizedMessage());
																											}
																										}
																										
																									}
																								});
																								frame6.getButton().setFocusable(false);
																								frame6.getB1().setFocusable(false);
																								frame6.setFocusable(true);
																								frame6.requestFocus();
																								frame6.addKeyListener(new KeyListener() {
																									public void keyTyped(KeyEvent e) {
																									}
																									
																									public void keyReleased(KeyEvent e) {
																									}
																									@Override
																									public void keyPressed(KeyEvent e) {
																										 int keyCode = e.getKeyCode();
																										    switch( keyCode ) { 
																										        case 38:
																												try {
																													if(!bability) {
																													game.move(Direction.UP);
																													updateGrid(frame6,game);
																													}
																												} catch (UnallowedMovementException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																										            break;
																										        case 40:
																										        	try {
																										        		if(!bability) {
																														game.move(Direction.DOWN);
																														updateGrid(frame6,game);
																										        		}
																													} catch (UnallowedMovementException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													} catch (NotEnoughResourcesException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													} 
																										            break;
																										        case 37:
																										        	try {
																										        		if(!bability) {
																														game.move(Direction.LEFT);
																											     		updateGrid(frame6,game);
																										        		}
																													} catch (UnallowedMovementException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													} catch (NotEnoughResourcesException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													}
																										            break;
																										        case 39:
																										        	try {
																										        		if(!bability) {
																														game.move(Direction.RIGHT);
																														updateGrid(frame6,game);
																										        		}
																													} catch (UnallowedMovementException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													} catch (NotEnoughResourcesException e1) {
																														JOptionPane.showMessageDialog(frame6,
																																e1.getLocalizedMessage());
																													}
																										            break;
																										        case 87:
																												try {
																													game.attack(Direction.UP);
																													updateGrid(frame6,game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																													}
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (ChampionDisarmedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																										            break;
																										        case 83:
																												try {
																													game.attack(Direction.DOWN);
																													updateGrid(frame6,game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																													}
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (ChampionDisarmedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																										            break;
																										        case 65:
																												try {
																													game.attack(Direction.LEFT);
																													updateGrid(frame6,game);
																													if(game.checkGameOver()!=null){
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																													}
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (ChampionDisarmedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																										            break;
																										        case 68:
																												try {
																													game.attack(Direction.RIGHT);
																													updateGrid(frame6,game);
																													if(game.checkGameOver()!=null) {
																														clip2.stop();
																														clip2.close();
																														if(game.checkGameOver().equals(player1)){
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player One, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																														if(game.checkGameOver().equals(player2)) {
																															JOptionPane.showMessageDialog(frame6,
																																	"Congratulations Player Two, You win ! Press Ok To End The Game ");
																															frame6.dispose();
																														}
																												}
																												} catch (NotEnoughResourcesException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (InvalidTargetException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												} catch (ChampionDisarmedException e1) {
																													JOptionPane.showMessageDialog(frame6,
																															e1.getLocalizedMessage());
																												}
																										            break;
																										        case 90:
																										        	System.out
																															.println(game.getTurnOrder().size());
																										        	game.endTurn();
																										        	updateGrid(frame6,game);
																										  }
																										    frame6.setFocusable(true);
																											frame6.requestFocus();
																									}
																								});
																								
																							}
																						}
																					}
																				});
																			}
																		}
																	}
																});	
															}
														}
													}
												});
											}
										}
									}
								});
							}
						}
					});
				}
			}
		});
}
				
			}
		});
	}
	public void updateGrid(GameBoard frame,Game game){
		frame.getB1().setFocusable(false);
		frame.setFocusable(true);
		frame.requestFocus();
		frame.getPanel().removeAll();
		if (game.isFirstLeaderAbilityUsed()){
			frame.getT11().setText("Used");
			frame.getT11().setForeground(Color.RED);
		}
		if (game.isSecondLeaderAbilityUsed()){
			frame.getT22().setText("Used");
			frame.getT22().setForeground(Color.RED);
		}
		String w = game.getCurrentChampion().getName();
		icon1 = new ImageIcon(".\\assests\\"+w+".png");
		Image img1 = icon1.getImage();
		Image newimg1 = img1.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(newimg1);
		frame.getB4().setIcon(icon1);
		Champion s = null;
		PriorityQueue pq = new PriorityQueue(2);
		if(game.getTurnOrder().size()>=2){
			pq.insert(game.getTurnOrder().remove());
			s=(Champion) game.getTurnOrder().peekMin();
			game.getTurnOrder().insert(pq.remove());
			String d=s.getName();
			icon2 = new ImageIcon(".\\assests\\"+d+".png");
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(newimg2);
			frame.getB5().setIcon(icon2);
		}
		if(game.getTurnOrder().size()<2){
			int v = game.getFirstPlayer().getTeam().size()+game.getSecondPlayer().getTeam().size();
			PriorityQueue q = new PriorityQueue(v);
			for(int i=0 ;i<game.getFirstPlayer().getTeam().size();i++) {
				q.insert(game.getFirstPlayer().getTeam().get(i));
			}
            for(int i=0 ;i<game.getSecondPlayer().getTeam().size();i++) {
            	q.insert(game.getSecondPlayer().getTeam().get(i));
			}
			s=(Champion) q.peekMin();
			String d=s.getName();
			icon2 = new ImageIcon(".\\assests\\"+d+".png");
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(newimg2);
			frame.getB5().setIcon(icon2);
		}
		for(int i=4;i>=0;i--){
			for(int j=0;j<5;j++){
				if(game.getBoard()[i][j]==null){
					JButton b = new JButton();
					icon = new ImageIcon(".\\assests\\ground.jpg");
					Image img = icon.getImage();
					Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					b.setIcon(icon);
				//	b.setBackground(Color.BLACK);
					frame.getPanel().add(b);
				}
				else if(game.getBoard()[i][j] instanceof Cover){
					Cover x = (Cover)game.getBoard()[i][j];
					JButton b = new JButton();
					icon = new ImageIcon(".\\assests\\Cover.png");
					Image img = icon.getImage();
					Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					b.setText("HP :"+x.getCurrentHP());
					b.setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
				//	b.setToolTipText("HP :"+x.getCurrentHP());
					b.setIcon(icon);
					b.setForeground(Color.BLACK);
					b.setBackground(Color.WHITE);
					frame.getPanel().add(b);
				}
				else{
                	Champion x = (Champion) game.getBoard()[i][j];
                	JButton b = new JButton();
                	String a = x.getName();
                	icon = new ImageIcon(".\\assests\\"+a+".png");
					Image img = icon.getImage();
					Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
                	b.setIcon(icon);
                	if(game.getFirstPlayer().getTeam().contains(x))
                	    b.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
                	else
                    	b.setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
                	b.setForeground(Color.BLACK);
					b.setBackground(Color.WHITE);
                	frame.getPanel().add(b);
				}
			}
		}
		frame.getEast().setText(printDetails(game.getCurrentChampion()));
		frame.getWest().setText(printDetails2(game));
		frame.add(frame.getPanel());
		frame.validate();
		frame.repaint();
	}
	
	public String printDetails(Champion c){
		String a ="";
		String t = "";
		if(c instanceof Hero)
			t = "Hero";
		else if(c instanceof AntiHero)
			t = "AntiHero";
		else if(c instanceof Villain)
			t = "Villain";
		a ="              Current Champion Details"+"\n"+"             ~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+
	    "Name :"+ c.getName()+"\n"+"Type :"+t+"\n"+"CurrentHP :"+c.getCurrentHP()+"\n"+"mana :"+c.getMana()
		+"\n"+"currentActionPoints :"+c.getCurrentActionPoints()+"\n"
		+"attackRange :"+c.getAttackRange()+"\n"+"attackDamage :"+c.getAttackDamage()+"\n"
		+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
		for(int i=0;i<c.getAbilities().size();i++){
			if(c.getAbilities().get(i) instanceof DamagingAbility) {
				DamagingAbility d = (DamagingAbility) c.getAbilities().get(i);
				int x =i+1;
			a = a + "Ability "+x+":"+"\n"+"Name:"+d.getName()+" || "+"Type:DamagingAbility"+
			"\n"+"AreaOfEffect :"+d.getCastArea()+"  ||  "+"CastRange :"+d.getCastRange()+
			"\n"+"ManaCost:"+d.getManaCost()+"  ||  "+"requiredActionPoints :"+d.getRequiredActionPoints()+
			"\n"+"currentCooldown :"+d.getCurrentCooldown()+"  ||  "+"baseCooldown :"+d.getBaseCooldown()+
			"\n"+"DamageAmount :"+d.getDamageAmount()+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
			}
			if(c.getAbilities().get(i) instanceof HealingAbility) {
				HealingAbility d = (HealingAbility) c.getAbilities().get(i);
				int x =i+1;
				a = a+"Ability "+x+":"+"\n"+"Name:"+d.getName()+" || "+"Type:HealingAbility"+
				"\n"+"AreaOfEffect :"+d.getCastArea()+"  ||  "+"CastRange :"+d.getCastRange()+
				"\n"+"ManaCost:"+d.getManaCost()+"  ||  "+"requiredActionPoints :"+d.getRequiredActionPoints()+
				"\n"+"currentCooldown :"+d.getCurrentCooldown()+"  ||  "+"baseCooldown :"+d.getBaseCooldown()+
				"\n"+"HealAmount :"+d.getHealAmount()+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
			}
				
			if(c.getAbilities().get(i) instanceof CrowdControlAbility) {
				CrowdControlAbility d = (CrowdControlAbility) c.getAbilities().get(i);
				int x =i+1;
				a = a+"Ability "+x+":"+"\n"+"Name:"+d.getName()+"||"+"Type:CrowdControlAbility"+
				"\n"+"AreaOfEffect :"+d.getCastArea()+"  ||  "+"CastRange :"+d.getCastRange()+
				"\n"+"ManaCost:"+d.getManaCost()+"  ||  "+"requiredActionPoints :"+d.getRequiredActionPoints()+
				"\n"+"currentCooldown :"+d.getCurrentCooldown()+"  ||  "+"baseCooldown :"+d.getBaseCooldown()+
				"\n"+"EffectName:"+d.getEffect().getName()+"  ||  "+"EffectDuration :"+d.getEffect().getDuration()+"\n"
				+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
			}
		}
		return a;
	}
	public String printDetails2(Game game){
		String a ="            Remaining Champions Details"+"\n"+"            ~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
		String t = "";
		String L = "";
		String E = "";
		for(int i=0;i<game.getFirstPlayer().getTeam().size();i++) {
			Champion c = game.getFirstPlayer().getTeam().get(i);
			if(c!=game.getCurrentChampion()) {
			if(c instanceof Hero)
				t = "Hero";
			else if(c instanceof AntiHero)
				t = "AntiHero";
			else if(c instanceof Villain)
				t = "Villain";
			if (game.getFirstPlayer().getLeader() != c && game.getSecondPlayer().getLeader() != (c))
				L = "Not Leader";
			else 
				L = "Leader";
			for(int j=0;j<c.getAppliedEffects().size();j++){
				if(c.getAppliedEffects().size()==1)
					E = "Name :"+c.getAppliedEffects().get(j).getName()
							+" || "+"Duration :"+c.getAppliedEffects().get(j).getDuration();
			}
			a += "Name :"+ c.getName()+"||"+"Type :"+t+"||"+"CurrentHP :"+c.getCurrentHP()+"\n"+"mana :"+c.getMana()
			+"||"+"MaxActionsPerTurn :"+c.getMaxActionPointsPerTurn()+"\n"
			+"attackRange :"+c.getAttackRange()+"||"+"attackDamage :"+c.getAttackDamage()+"\n"+"This Champion is "+L
			+"\n"+"Applied Effects :"+E+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
			}
		}
		for(int i=0;i<game.getSecondPlayer().getTeam().size();i++) {
			Champion c = game.getSecondPlayer().getTeam().get(i);
			if(c!=game.getCurrentChampion()) {
			if(c instanceof Hero)
				t = "Hero";
			else if(c instanceof AntiHero)
				t = "AntiHero";
			else if(c instanceof Villain)
				t = "Villain";
			if (game.getFirstPlayer().getLeader() != c && game.getSecondPlayer().getLeader() != (c))
				L = "Not Leader";
			else 
				L = "Leader";
			for(int j=0;j<c.getAppliedEffects().size();j++){
				if(c.getAppliedEffects().size()==1)
				E = "Name :"+c.getAppliedEffects().get(j).getName()
						+" || "+"Duration :"+c.getAppliedEffects().get(j).getDuration();
			}
			a +="Name :"+ c.getName()+"||"+"Type :"+t+"||"+"CurrentHP :"+c.getCurrentHP()+"\n"+"mana :"+c.getMana()
			+"||"+"MaxActionsPerTurn :"+c.getMaxActionPointsPerTurn()+"\n"
			+"attackRange :"+c.getAttackRange()+"||"+"attackDamage :"+c.getAttackDamage()+"\n"+"This Champion is "+L
			+"\n"+"Applied Effects :"+E+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~"+"\n";
			}
		}
		return a;
	}
	public void doSingleTargetframe(SingleTargetFrame frame,Game game){
		if(game.getBoard()[4][0]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB1().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[4][0] instanceof Cover){
			Cover x = (Cover)game.getBoard()[4][0];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB1().setText("HP :"+x.getCurrentHP());
			frame.getB1().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB1().setIcon(icon);
			frame.getB1().setForeground(Color.BLACK);
			frame.getB1().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[4][0];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB1().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB1().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB1().setIcon(icon);
		}
		if(game.getBoard()[4][1]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB2().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[4][1] instanceof Cover){
			Cover x = (Cover)game.getBoard()[4][1];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB2().setText("HP :"+x.getCurrentHP());
			frame.getB2().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB2().setIcon(icon);
			frame.getB2().setForeground(Color.BLACK);
			frame.getB2().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[4][1];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB2().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB2().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB2().setIcon(icon);
		}
		if(game.getBoard()[4][2]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB3().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[4][2] instanceof Cover){
			Cover x = (Cover)game.getBoard()[4][2];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB3().setText("HP :"+x.getCurrentHP());
			frame.getB3().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB3().setIcon(icon);
			frame.getB3().setForeground(Color.BLACK);
			frame.getB3().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[4][2];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB3().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB3().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB3().setIcon(icon);
		}
		
		if(game.getBoard()[4][3]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB4().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[4][3] instanceof Cover){
			Cover x = (Cover)game.getBoard()[4][3];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB4().setText("HP :"+x.getCurrentHP());
			frame.getB4().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB4().setIcon(icon);
			frame.getB4().setForeground(Color.BLACK);
			frame.getB4().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[4][3];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB4().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB4().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB4().setIcon(icon);
		}
		
		if(game.getBoard()[4][4]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB5().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[4][4] instanceof Cover){
			Cover x = (Cover)game.getBoard()[4][4];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB5().setText("HP :"+x.getCurrentHP());
			frame.getB5().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB5().setIcon(icon);
			frame.getB5().setForeground(Color.BLACK);
			frame.getB5().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[4][4];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB5().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB5().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB5().setIcon(icon);
		}
		if(game.getBoard()[3][0]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB6().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[3][0] instanceof Cover){
			Cover x = (Cover)game.getBoard()[3][0];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB6().setText("HP :"+x.getCurrentHP());
			frame.getB6().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB6().setIcon(icon);
			frame.getB6().setForeground(Color.BLACK);
			frame.getB6().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[3][0];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB6().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB6().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB6().setIcon(icon);
		}
		if(game.getBoard()[3][1]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB7().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[3][1] instanceof Cover){
			Cover x = (Cover)game.getBoard()[3][1];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB7().setText("HP :"+x.getCurrentHP());
			frame.getB7().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB7().setIcon(icon);
			frame.getB7().setForeground(Color.BLACK);
			frame.getB7().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[3][1];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB7().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB7().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB7().setIcon(icon);
		}
		if(game.getBoard()[3][2]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB8().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[3][2] instanceof Cover){
			Cover x = (Cover)game.getBoard()[3][2];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB8().setText("HP :"+x.getCurrentHP());
			frame.getB8().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB8().setIcon(icon);
			frame.getB8().setForeground(Color.BLACK);
			frame.getB8().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[3][2];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB8().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB8().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB8().setIcon(icon);
		}
		
		if(game.getBoard()[3][3]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB9().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[3][3] instanceof Cover){
			Cover x = (Cover)game.getBoard()[3][3];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB9().setText("HP :"+x.getCurrentHP());
			frame.getB9().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB9().setIcon(icon);
			frame.getB9().setForeground(Color.BLACK);
			frame.getB9().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[3][3];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB9().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB9().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB9().setIcon(icon);
		}
		
		if(game.getBoard()[3][4]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB10().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[3][4] instanceof Cover){
			Cover x = (Cover)game.getBoard()[3][4];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB10().setText("HP :"+x.getCurrentHP());
			frame.getB10().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB10().setIcon(icon);
			frame.getB10().setForeground(Color.BLACK);
			frame.getB10().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[3][4];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB10().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB10().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB10().setIcon(icon);
		}
		if(game.getBoard()[2][0]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB11().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[2][0] instanceof Cover){
			Cover x = (Cover)game.getBoard()[2][0];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB11().setText("HP :"+x.getCurrentHP());
			frame.getB11().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB11().setIcon(icon);
			frame.getB11().setForeground(Color.BLACK);
			frame.getB11().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[2][0];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB11().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB11().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB11().setIcon(icon);
		}
		if(game.getBoard()[2][1]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB12().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[2][1] instanceof Cover){
			Cover x = (Cover)game.getBoard()[2][1];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB12().setText("HP :"+x.getCurrentHP());
			frame.getB12().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB12().setIcon(icon);
			frame.getB12().setForeground(Color.BLACK);
			frame.getB12().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[2][1];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB12().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB12().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB12().setIcon(icon);
		}
		if(game.getBoard()[2][2]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB13().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[2][2] instanceof Cover){
			Cover x = (Cover)game.getBoard()[2][2];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB13().setText("HP :"+x.getCurrentHP());
			frame.getB13().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB13().setIcon(icon);
			frame.getB13().setForeground(Color.BLACK);
			frame.getB13().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[2][2];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB13().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB13().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB13().setIcon(icon);
		}
		
		if(game.getBoard()[2][3]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB14().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[2][3] instanceof Cover){
			Cover x = (Cover)game.getBoard()[2][3];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB14().setText("HP :"+x.getCurrentHP());
			frame.getB14().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB14().setIcon(icon);
			frame.getB14().setForeground(Color.BLACK);
			frame.getB14().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[2][3];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB14().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB14().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB14().setIcon(icon);
		}
		
		if(game.getBoard()[2][4]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB15().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[2][4] instanceof Cover){
			Cover x = (Cover)game.getBoard()[2][4];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB15().setText("HP :"+x.getCurrentHP());
			frame.getB15().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB15().setIcon(icon);
			frame.getB15().setForeground(Color.BLACK);
			frame.getB15().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[2][4];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB15().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB5().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB15().setIcon(icon);
		}
		if(game.getBoard()[1][0]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB16().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[1][0] instanceof Cover){
			Cover x = (Cover)game.getBoard()[1][0];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB16().setText("HP :"+x.getCurrentHP());
			frame.getB16().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB16().setIcon(icon);
			frame.getB16().setForeground(Color.BLACK);
			frame.getB16().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[1][0];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB16().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB16().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB16().setIcon(icon);
		}
		if(game.getBoard()[1][1]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB17().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[1][1] instanceof Cover){
			Cover x = (Cover)game.getBoard()[1][1];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB17().setText("HP :"+x.getCurrentHP());
			frame.getB17().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB17().setIcon(icon);
			frame.getB17().setForeground(Color.BLACK);
			frame.getB17().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[1][1];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB17().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB17().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB17().setIcon(icon);
		}
		if(game.getBoard()[1][2]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB18().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[1][2] instanceof Cover){
			Cover x = (Cover)game.getBoard()[1][2];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB18().setText("HP :"+x.getCurrentHP());
			frame.getB18().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB18().setIcon(icon);
			frame.getB18().setForeground(Color.BLACK);
			frame.getB18().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[1][2];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB18().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB18().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB18().setIcon(icon);
		}
		
		if(game.getBoard()[1][3]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB19().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[1][3] instanceof Cover){
			Cover x = (Cover)game.getBoard()[1][3];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB19().setText("HP :"+x.getCurrentHP());
			frame.getB19().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB19().setIcon(icon);
			frame.getB19().setForeground(Color.BLACK);
			frame.getB19().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[1][3];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB19().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB19().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB19().setIcon(icon);
		}
		
		if(game.getBoard()[1][4]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB20().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[1][4] instanceof Cover){
			Cover x = (Cover)game.getBoard()[1][4];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB20().setText("HP :"+x.getCurrentHP());
			frame.getB20().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB20().setIcon(icon);
			frame.getB20().setForeground(Color.BLACK);
			frame.getB20().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[1][4];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB20().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB20().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB20().setIcon(icon);
		}
		if(game.getBoard()[0][0]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB21().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[0][0] instanceof Cover){
			Cover x = (Cover)game.getBoard()[0][0];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB21().setText("HP :"+x.getCurrentHP());
			frame.getB21().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB21().setIcon(icon);
			frame.getB21().setForeground(Color.BLACK);
			frame.getB21().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[0][0];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB21().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB21().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB21().setIcon(icon);
		}
		if(game.getBoard()[0][1]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB22().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[0][1] instanceof Cover){
			Cover x = (Cover)game.getBoard()[0][1];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB22().setText("HP :"+x.getCurrentHP());
			frame.getB22().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB22().setIcon(icon);
			frame.getB22().setForeground(Color.BLACK);
			frame.getB22().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[0][1];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB22().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB22().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB22().setIcon(icon);
		}
		if(game.getBoard()[0][2]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB23().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[0][2] instanceof Cover){
			Cover x = (Cover)game.getBoard()[0][2];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB23().setText("HP :"+x.getCurrentHP());
			frame.getB23().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB23().setIcon(icon);
			frame.getB23().setForeground(Color.BLACK);
			frame.getB23().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[0][2];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB23().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB23().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB23().setIcon(icon);
		}
		
		if(game.getBoard()[0][3]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB24().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[0][3] instanceof Cover){
			Cover x = (Cover)game.getBoard()[0][3];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB24().setText("HP :"+x.getCurrentHP());
			frame.getB24().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB24().setIcon(icon);
			frame.getB24().setForeground(Color.BLACK);
			frame.getB24().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[0][3];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB24().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB24().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB24().setIcon(icon);
		}
		
		if(game.getBoard()[0][4]==null){
			icon = new ImageIcon(".\\assests\\ground.jpg");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB25().setIcon(icon);
		//	frame.getB1().setBackground(Color.BLACK);
		}
		else if(game.getBoard()[0][4] instanceof Cover){
			Cover x = (Cover)game.getBoard()[0][4];
			icon = new ImageIcon(".\\assests\\Cover.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			frame.getB25().setText("HP :"+x.getCurrentHP());
			frame.getB25().setBorder(BorderFactory.createTitledBorder("Current HP : "+x.getCurrentHP()));
			frame.getB25().setIcon(icon);
			frame.getB25().setForeground(Color.BLACK);
			frame.getB25().setBackground(Color.WHITE);
		}
		else {
        	Champion x = (Champion) game.getBoard()[0][4];
        	String a = x.getName();
        	icon = new ImageIcon(".\\assests\\"+a+".png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(167, 115, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			if(game.getFirstPlayer().getTeam().contains(x))
				frame.getB25().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,4));
        	else
        		frame.getB25().setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			frame.getB25().setIcon(icon);
		}
	}
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		new GameController();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
