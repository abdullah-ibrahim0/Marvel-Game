package views;

import engine.Game;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Hero;
import model.world.Villain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.GameController;

public class SingleTargetFrame extends JFrame implements ActionListener {
	JPanel panel;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23,
			b24, b25;
	private ImageIcon icon,icon1,icon2;

	public SingleTargetFrame(Ability A, GameBoard frame, Game game) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setBounds(368, 160, 800, 588);
		f.setTitle(
				"                                                                                                 Please Choose Target");
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5));
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		b10 = new JButton();
		b11 = new JButton();
		b12 = new JButton();
		b13 = new JButton();
		b14 = new JButton();
		b15 = new JButton();
		b16 = new JButton();
		b17 = new JButton();
		b18 = new JButton();
		b19 = new JButton();
		b20 = new JButton();
		b21 = new JButton();
		b22 = new JButton();
		b23 = new JButton();
		b24 = new JButton();
		b25 = new JButton();
		panel.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 4;
				int y = 0;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 4;
				int y = 1;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 4;
				int y = 2;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 4;
				int y = 3;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 4;
				int y = 4;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 3;
				int y = 0;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 3;
				int y = 1;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 3;
				int y = 2;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 3;
				int y = 3;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 3;
				int y = 4;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 2;
				int y = 0;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 2;
				int y = 1;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 2;
				int y = 2;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 2;
				int y = 3;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 2;
				int y = 4;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1;
				int y = 0;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b17.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1;
				int y = 1;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b18.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1;
				int y = 2;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b19.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1;
				int y = 3;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1;
				int y = 4;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 0;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 1;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b23.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 2;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b24.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 3;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		b25.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 4;
				try {
					game.castAbility(A, x, y);
					updateGrid(frame, game);
					if (game.checkGameOver() != null) {
						// clip1.stop();
						if (game.checkGameOver().equals(game.getFirstPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player One, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
						if (game.checkGameOver().equals(game.getSecondPlayer())) {
							JOptionPane.showMessageDialog(frame,
									"Congratulations Player Two, You win ! Press Ok To End The Game ");
							frame.dispose();
						}
					}
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
				f.dispose();

			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);
		panel.add(b11);
		panel.add(b12);
		panel.add(b13);
		panel.add(b14);
		panel.add(b15);
		panel.add(b16);
		panel.add(b17);
		panel.add(b18);
		panel.add(b19);
		panel.add(b20);
		panel.add(b21);
		panel.add(b22);
		panel.add(b23);
		panel.add(b24);
		panel.add(b25);
		f.add(panel);
		f.validate();
		f.repaint();
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
				int x = j+1;
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}



	public JButton getB1() {
		return b1;
	}

	public JButton getB2() {
		return b2;
	}

	public JButton getB3() {
		return b3;
	}

	public JButton getB4() {
		return b4;
	}

	public JButton getB5() {
		return b5;
	}

	public JButton getB6() {
		return b6;
	}

	public JButton getB7() {
		return b7;
	}

	public JButton getB8() {
		return b8;
	}

	public JButton getB9() {
		return b9;
	}

	public JButton getB10() {
		return b10;
	}

	public JButton getB11() {
		return b11;
	}

	public JButton getB12() {
		return b12;
	}

	public JButton getB13() {
		return b13;
	}

	public JButton getB14() {
		return b14;
	}

	public JButton getB15() {
		return b15;
	}

	public JButton getB16() {
		return b16;
	}

	public JButton getB17() {
		return b17;
	}

	public JButton getB18() {
		return b18;
	}

	public JButton getB19() {
		return b19;
	}

	public JButton getB20() {
		return b20;
	}

	public JButton getB21() {
		return b21;
	}

	public JButton getB22() {
		return b22;
	}

	public JButton getB23() {
		return b23;
	}

	public JButton getB24() {
		return b24;
	}

	public JButton getB25() {
		return b25;
	}
}
