package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import engine.*;

public class GameFrame3 extends JFrame implements ActionListener {
	private JLayeredPane panel;
	int picked = 0;
	JButton a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, button;
	JTextArea text, text2;
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14,
			icon15;
	private ArrayList<Integer> ChampionsIndex;
	private ArrayList<Integer> frame2Index;
	GameFrame4 fourthframe;
	JFrame fm;

	public GameFrame3() {
		fm = new JFrame();
		ChampionsIndex = new ArrayList<Integer>();
		frame2Index = new ArrayList<Integer>();
		fm.setBounds(-7, 0, 1690, 830);
		fm.setTitle("Marvel Ultimate War");
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fm.setVisible(true);
		// fm.setResizable(false);
		panel = new JLayeredPane();
		panel.setLayout(new GridLayout(5, 3));
		icon1 = new ImageIcon(".\\assests\\Captain America.png");
		Image img = icon1.getImage();
		Image newimg1 = img.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(newimg1);
		icon2 = new ImageIcon(".\\assests\\Deadpool.png");
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg2);
		icon3 = new ImageIcon(".\\assests\\Dr Strange.png");
		Image img3 = icon3.getImage();
		Image newimg3 = img3.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg3);
		icon4 = new ImageIcon(".\\assests\\Electro.png");
		Image img4 = icon4.getImage();
		Image newimg4 = img4.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon4 = new ImageIcon(newimg4);
		icon5 = new ImageIcon(".\\assests\\Ghost Rider.png");
		Image img5 = icon5.getImage();
		Image newimg5 = img5.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon5 = new ImageIcon(newimg5);
		icon6 = new ImageIcon(".\\assests\\Hela.png");
		Image img6 = icon6.getImage();
		Image newimg6 = img6.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon6 = new ImageIcon(newimg6);
		icon7 = new ImageIcon(".\\assests\\Hulk.png");
		Image img7 = icon7.getImage();
		Image newimg7 = img7.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon7 = new ImageIcon(newimg7);
		icon8 = new ImageIcon(".\\assests\\Iceman.png");
		Image img8 = icon8.getImage();
		Image newimg8 = img8.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon8 = new ImageIcon(newimg8);
		icon9 = new ImageIcon(".\\assests\\Ironman.png");
		Image img9 = icon9.getImage();
		Image newimg9 = img9.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon9 = new ImageIcon(newimg9);
		icon10 = new ImageIcon(".\\assests\\Loki.png");
		Image img10 = icon10.getImage();
		Image newimg10 = img10.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon10 = new ImageIcon(newimg10);
		icon11 = new ImageIcon(".\\assests\\Quicksilver.png");
		Image img11 = icon11.getImage();
		Image newimg11 = img11.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon11 = new ImageIcon(newimg11);
		icon12 = new ImageIcon(".\\assests\\Spiderman.png");
		Image img12 = icon12.getImage();
		Image newimg12 = img12.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon12 = new ImageIcon(newimg12);
		icon13 = new ImageIcon(".\\assests\\Thor.png");
		Image img13 = icon13.getImage();
		Image newimg13 = img13.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon13 = new ImageIcon(newimg13);
		icon14 = new ImageIcon(".\\assests\\Venom.png");
		Image img14 = icon14.getImage();
		Image newimg14 = img14.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon14 = new ImageIcon(newimg14);
		icon15 = new ImageIcon(".\\assests\\Yellow Jacket.png");
		Image img15 = icon15.getImage();
		Image newimg15 = img15.getScaledInstance(260, 137, java.awt.Image.SCALE_SMOOTH);
		icon15 = new ImageIcon(newimg15);
		a1 = new JButton(icon1);
		a1.setBackground(Color.BLACK);
		a2 = new JButton(icon2);
		a2.setBackground(Color.BLACK);
		a3 = new JButton(icon3);
		a3.setBackground(Color.BLACK);
		a4 = new JButton(icon4);
		a4.setBackground(Color.BLACK);
		a5 = new JButton(icon5);
		a5.setBackground(Color.BLACK);
		a6 = new JButton(icon6);
		a6.setBackground(Color.BLACK);
		a7 = new JButton(icon7);
		a7.setBackground(Color.BLACK);
		a8 = new JButton(icon8);
		a8.setBackground(Color.BLACK);
		a9 = new JButton(icon9);
		a9.setBackground(Color.BLACK);
		a10 = new JButton(icon10);
		a10.setBackground(Color.BLACK);
		a11 = new JButton(icon11);
		a11.setBackground(Color.BLACK);
		a12 = new JButton(icon12);
		a12.setBackground(Color.BLACK);
		a13 = new JButton(icon13);
		a13.setBackground(Color.BLACK);
		a14 = new JButton(icon14);
		a14.setBackground(Color.BLACK);
		a15 = new JButton(icon15);
		a15.setBackground(Color.BLACK);
		text = new JTextArea();
		text2 = new JTextArea();
		text.setPreferredSize(new Dimension(450, getHeight()));
		text2.setPreferredSize(new Dimension(300, getHeight()));
		text.setEditable(false);
		text2.setEditable(false);
		text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		text2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		text.setForeground(Color.BLACK);
		text2.setForeground(Color.WHITE);
		text.setBackground(Color.PINK);
		text2.setBackground(Color.BLACK);
		text2.setText("\n" + "\n" + "\n" + "\n" + "\n" + "      Picked Champions");
		text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
				+ "\n" + "\n" + "\n" + "\n" + "       Please, Pick Up Three Champions !    ");
		a1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Captain America" + "\n"
							+ "maxHP : 1500" + "\n" + "mana : 1000" + "\n" + "maxActionPoints : 6" + "\n" + "Speed : 80"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 100" + "\n"
							+ "ability1 name : Shield throw" + "\n" + "ability2 name : I can do fm all day" + "\n"
							+ "ability3 name : Shield Up");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : AntiHero" + "\n" + "Name : DeadPool" + "\n"
							+ "maxHP : 1350" + "\n" + "mana : 700" + "\n" + "maxActionPoints : 6" + "\n" + "Speed : 80"
							+ "\n" + "attackRange : 3" + "\n" + "attackDamage : 90" + "\n"
							+ "ability1 name : Try Harder" + "\n" + "ability2 name : 8 bullets left" + "\n"
							+ "ability3 name : Can't Catch Me");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Dr Strange" + "\n"
							+ "maxHP : 1100" + "\n" + "mana : 1500" + "\n" + "maxActionPoints : 6" + "\n" + "Speed : 60"
							+ "\n" + "attackRange : 2" + "\n" + "attackDamage : 60" + "\n"
							+ "ability1 name : The eye of agamotto" + "\n" + "ability2 name : Thousand Hand" + "\n"
							+ "ability3 name : Mirror Dimension");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Villain" + "\n" + "Name : Electro" + "\n"
							+ "maxHP : 1200" + "\n" + "mana : 1200" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 75"
							+ "\n" + "attackRange : 3" + "\n" + "attackDamage : 110" + "\n"
							+ "ability1 name : Fully Charged" + "\n" + "ability2 name : EMP" + "\n"
							+ "ability3 name : Lightning Strike");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : AntiHero" + "\n" + "Name : Ghost Rider" + "\n"
							+ "maxHP : 1800" + "\n" + "mana : 600" + "\n" + "maxActionPoints : 6" + "\n" + "Speed : 85"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 140" + "\n"
							+ "ability1 name : Death stare" + "\n" + "ability2 name : Fire Breath" + "\n"
							+ "ability3 name : Chain Whip");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Villain" + "\n" + "Name : Hela" + "\n"
							+ "maxHP : 1500" + "\n" + "mana : 750" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 75"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 150" + "\n"
							+ "ability1 name : Godess of Death" + "\n" + "ability2 name : Thorn Shield" + "\n"
							+ "ability3 name : Thorn Shower");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Hulk" + "\n"
							+ "maxHP : 2250" + "\n" + "mana : 550" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 55"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 200" + "\n" + "ability1 name : Rage"
							+ "\n" + "ability2 name : Hulk Smash" + "\n" + "ability3 name: Sun is getting real low");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Iceman" + "\n"
							+ "maxHP : 1000" + "\n" + "mana : 900" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 65"
							+ "\n" + "attackRange : 2" + "\n" + "attackDamage : 120" + "\n"
							+ "ability1 name : Frost bite" + "\n" + "ability2 name : SubZero" + "\n"
							+ "ability3 name : Hail Storm");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Ironman" + "\n"
							+ "maxHP : 1200" + "\n" + "mana : 800" + "\n" + "maxActionPoints : 7" + "\n" + "Speed : 85"
							+ "\n" + "attackRange : 3" + "\n" + "attackDamage : 90" + "\n"
							+ "ability1 name : I am Ironman" + "\n" + "ability2 name : Unibeam" + "\n"
							+ "ability3 name : 3000");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Villain" + "\n" + "Name : Loki" + "\n"
							+ "maxHP : 1150" + "\n" + "mana : 900" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 70"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 150" + "\n"
							+ "ability1 name : God of Mischief" + "\n" + "ability2 name : The Hidden Dagger" + "\n"
							+ "ability3 name : Fake Death");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Villain" + "\n" + "Name : Quicksilver" + "\n"
							+ "maxHP : 1200" + "\n" + "mana : 650" + "\n" + "maxActionPoints : 8" + "\n" + "Speed : 99"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 70" + "\n"
							+ "ability1 name : Time in a bottle" + "\n" + "ability2 name : Good as new" + "\n"
							+ "ability3 name : 1 sec 100 punch");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a12.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Spiderman" + "\n"
							+ "maxHP : 1400" + "\n" + "mana : 750" + "\n" + "maxActionPoints : 7" + "\n" + "Speed : 85"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 120" + "\n"
							+ "ability1 name : give me that" + "\n" + "ability2 name : web trap" + "\n"
							+ "ability3 name : Spiderverse");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a13.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Hero" + "\n" + "Name : Thor" + "\n"
							+ "maxHP : 1800" + "\n" + "mana : 800" + "\n" + "maxActionPoints : 7" + "\n" + "Speed : 90"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 130" + "\n"
							+ "ability1 name : God of Thunder" + "\n" + "ability2 name : Mjollnir Throw" + "\n"
							+ "ability3 name : Bring Me Thanos");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a14.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : AntiHero" + "\n" + "Name : Venom" + "\n"
							+ "maxHP : 1650" + "\n" + "mana : 700" + "\n" + "maxActionPoints : 5" + "\n" + "Speed : 70"
							+ "\n" + "attackRange : 1" + "\n" + "attackDamage : 140" + "\n"
							+ "ability1 name : Head Bite" + "\n" + "ability2 name : We are venom" + "\n"
							+ "ability3 name : Symbiosis");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a15.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (picked != 3)
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "Champion's Data :"
							+ "\n" + "~~~~~~~~~~~~~~~~~" + "\n" + "Type : Villain" + "\n" + "Name : Yellow Jacket"
							+ "\n" + "maxHP : 1050" + "\n" + "mana : 800" + "\n" + "maxActionPoints : 6" + "\n"
							+ "Speed : 60" + "\n" + "attackRange : 2" + "\n" + "attackDamage : 80" + "\n"
							+ "ability1 name : Laser Sting" + "\n" + "ability2 name : QuANTaMANia" + "\n"
							+ "ability3 name : Pym Particle Upsize");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (picked == 3)
					text.setText("                 You Can Go !        ");
				else
					text.setText("           Second Player Champions        " + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "      Please, Pick Up Three Champions !    ");
			}
		});
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a1)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(0)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a1.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(0);
							text2.setText(text2.getText() + "\n" + "\n" + "  Captain America");
							text.setText("                 You Can Go !        ");
							picked++;
							a1 = null;
							return;
						} else {
							ChampionsIndex.add(0);
							text2.setText(text2.getText() + "\n" + "\n" + "  Captain America");
							a1 = null;
							picked++;
						}
					}
				}
			}
		});
		a2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a2)) {
					PlaySound.playClick();
					if (frame2Index.contains(1)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a2.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(1);
							text2.setText(text2.getText() + "\n" + "\n" + "  DeadPool");
							text.setText("                 You Can Go !        ");
							picked++;
							a2 = null;
							return;
						} else {
							ChampionsIndex.add(1);
							text2.setText(text2.getText() + "\n" + "\n" + "  DeadPool");
							a2 = null;
							picked++;
						}
					}
				}
			}
		});
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a3)) {
					PlaySound.playClick();
					if (frame2Index.contains(2)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a3.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(2);
							text2.setText(text2.getText() + "\n" + "\n" + "  Dr Strange");
							text.setText("                 You Can Go !        ");
							picked++;
							a3 = null;
							return;
						} else {
							ChampionsIndex.add(2);
							text2.setText(text2.getText() + "\n" + "\n" + "  Dr Strange");
							a3 = null;
							picked++;
						}
					}
				}
			}
		});
		a4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a4)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(3)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a4.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(3);
							text2.setText(text2.getText() + "\n" + "\n" + "  Electro");
							text.setText("                 You Can Go !        ");
							picked++;
							a4 = null;
							return;
						} else {
							ChampionsIndex.add(3);
							text2.setText(text2.getText() + "\n" + "\n" + "  Electro");
							a4 = null;
							picked++;
						}
					}
				}
			}
		});
		a5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a5)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(4)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a5.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(4);
							text2.setText(text2.getText() + "\n" + "\n" + "  Ghost Rider");
							text.setText("                 You Can Go !        ");
							picked++;
							a5 = null;
							return;
						} else {
							ChampionsIndex.add(4);
							text2.setText(text2.getText() + "\n" + "\n" + "  Ghost Rider");
							a5 = null;
							picked++;
						}
					}
				}
			}
		});
		a6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a6)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(5)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a6.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(5);
							text2.setText(text2.getText() + "\n" + "\n" + "  Hela");
							text.setText("                 You Can Go !        ");
							picked++;
							a6 = null;
							return;
						} else {
							ChampionsIndex.add(5);
							text2.setText(text2.getText() + "\n" + "\n" + "  Hela");
							a6 = null;
							picked++;
						}
					}
				}
			}
		});
		a7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a7)) {
					PlaySound.playClick();
					if (frame2Index.contains(6)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a7.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(6);
							text2.setText(text2.getText() + "\n" + "\n" + "  Hulk");
							text.setText("                 You Can Go !        ");
							picked++;
							a7 = null;
							return;
						} else {
							ChampionsIndex.add(6);
							text2.setText(text2.getText() + "\n" + "\n" + "  Hulk");
							a7 = null;
							picked++;
						}
					}
				}
			}
		});
		a8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a8)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(7)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a8.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(7);
							text2.setText(text2.getText() + "\n" + "\n" + "  Iceman");
							text.setText("                 You Can Go !        ");
							picked++;
							a8 = null;
							return;
						} else {
							ChampionsIndex.add(7);
							text2.setText(text2.getText() + "\n" + "\n" + "  Iceman");
							a8 = null;
							picked++;
						}
					}
				}
			}
		});
		a9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a9)) {
					PlaySound.playClick();
					if (frame2Index.contains(8)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a9.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(8);
							text2.setText(text2.getText() + "\n" + "\n" + "  Ironman");
							text.setText("                 You Can Go !        ");
							picked++;
							a9 = null;
							return;
						} else {
							ChampionsIndex.add(8);
							text2.setText(text2.getText() + "\n" + "\n" + "  Ironman");
							a9 = null;
							picked++;
						}
					}
				}
			}
		});
		a10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a10)) {
					PlaySound.playClick();
					if (frame2Index.contains(9)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a10.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(9);
							text2.setText(text2.getText() + "\n" + "\n" + "  Loki");
							text.setText("                 You Can Go !        ");
							picked++;
							a10 = null;
							return;
						} else {
							ChampionsIndex.add(9);
							text2.setText(text2.getText() + "\n" + "\n" + "  Loki");
							a10 = null;
							picked++;
						}
					}
				}
			}
		});
		a11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a11)) {
					PlaySound.playClick();
					if (picked < 3) {
						if (frame2Index.contains(10)) {
							JOptionPane.showMessageDialog(fm,
									"This champion is Choosed by the first player, Please Choose another Champion !");
							return;
						}
						a11.setBorder(BorderFactory.createLineBorder(Color.RED,5));
						if (picked == 2) {
							ChampionsIndex.add(10);
							text2.setText(text2.getText() + "\n" + "\n" + "  Quicksilver");
							text.setText("                 You Can Go !        ");
							picked++;
							a11 = null;
							return;
						} else {
							ChampionsIndex.add(10);
							text2.setText(text2.getText() + "\n" + "\n" + "  Quicksilver");
							a11 = null;
							picked++;
						}
					}
				}
			}
		});
		a12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a12)) {
					PlaySound.playClick();
					if (frame2Index.contains(11)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a12.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(11);
							text2.setText(text2.getText() + "\n" + "\n" + "  Spiderman");
							text.setText("                 You Can Go !        ");
							picked++;
							a12 = null;
							return;
						} else {
							ChampionsIndex.add(11);
							text2.setText(text2.getText() + "\n" + "\n" + "  Spiderman");
							a12 = null;
							picked++;
						}
					}
				}
			}
		});
		a13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a13)) {
					PlaySound.playClick();
					if (frame2Index.contains(12)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a13.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(12);
							text2.setText(text2.getText() + "\n" + "\n" + "  Thor");
							text.setText("                 You Can Go !        ");
							picked++;
							a13 = null;
							return;
						} else {
							ChampionsIndex.add(12);
							text2.setText(text2.getText() + "\n" + "\n" + "  Thor");
							a13 = null;
							picked++;
						}
					}
				}
			}
		});
		a14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a14)) {
					PlaySound.playClick();
					if (frame2Index.contains(13)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a14.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(13);
							text2.setText(text2.getText() + "\n" + "\n" + "  Venom");
							text.setText("                 You Can Go !        ");
							picked++;
							a14 = null;
							return;
						} else {
							ChampionsIndex.add(13);
							text2.setText(text2.getText() + "\n" + "\n" + "  Venom");
							a14 = null;
							picked++;
						}
					}
				}
			}
		});
		a15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(a15)) {
					PlaySound.playClick();
					if (frame2Index.contains(14)) {
						JOptionPane.showMessageDialog(fm,
								"This champion is Choosed by the first player, Please Choose another Champion !");
						return;
					}
					if (picked < 3) {
						a15.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
						if (picked == 2) {
							ChampionsIndex.add(14);
							text2.setText(text2.getText() + "\n" + "\n" + "  Yellow Jacket");
							text.setText("                 You Can Go !        ");
							picked++;
							a15 = null;
							return;
						} else {
							ChampionsIndex.add(14);
							text2.setText(text2.getText() + "\n" + "\n" + "  Yellow Jacket");
							a15 = null;
							picked++;
						}
					}
				}
			}
		});
		button = new JButton("Finish");
		JLayeredPane panel2 = new JLayeredPane();
		panel2.setLayout(new GridLayout(1, 1));
		button.setPreferredSize(new Dimension(600, 100));
		panel.add(a1);
		panel.add(a2);
		panel.add(a3);
		panel.add(a4);
		panel.add(a5);
		panel.add(a6);
		panel.add(a7);
		panel.add(a8);
		panel.add(a9);
		panel.add(a10);
		panel.add(a11);
		panel.add(a12);
		panel.add(a13);
		panel.add(a14);
		panel.add(a15);
		panel2.add(button);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
		fm.add(panel, BorderLayout.CENTER);
		fm.add(panel2, BorderLayout.PAGE_END);
		fm.add(text, BorderLayout.EAST);
		fm.add(text2, BorderLayout.WEST);
		fm.revalidate();
		fm.repaint();
	}

	public int getPicked() {
		return picked;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new GameFrame3();
	}

	public JFrame getFm() {
		return fm;
	}

	public ArrayList<Integer> getChampionsIndex() {
		return ChampionsIndex;
	}

	public ArrayList<Integer> getFrame2Index() {
		return frame2Index;
	}

	public JButton getButton() {
		return button;
	}
}
