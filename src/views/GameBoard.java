package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameBoard extends JFrame implements KeyListener {

	JLayeredPane panel;
	JLayeredPane panel1;
	JLayeredPane panel2;
	JLayeredPane panel3;
	JLayeredPane panel4;
	JButton button, b1, b2, b3, b4, b5,i;
	JLabel northLabel, southLabel, eastLabel, westLabel;
	JLabel curr, next, t1, t11, t2, t22;
	ImageIcon icon1, icon2, icon3, icon4,icon,icon0;
	JLabel currentlabel;
	JTextArea East, West, north, south;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
			btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25;
	JFrame f;

	public GameBoard() {
		f = new JFrame();
		icon0 = new ImageIcon(".\\assests\\logoo.jpg");
		Image img00 = icon0.getImage();
		Image newimg00 = img00.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		setIconImage(newimg00);
		
		setBounds(-6, 0, 1549, 830);
		setVisible(true);
		setTitle("Marvel Ultimate War");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JLayeredPane();
		panel.setLayout(new GridLayout(5, 5));
		East = new JTextArea();
		West = new JTextArea();
		north = new JTextArea();
		south = new JTextArea();
		t1 = new JLabel("1st Player Leader Ability :");
		t2 = new JLabel("2nd Player Leader Ability :");
		t11 = new JLabel("Not Used");
		t22 = new JLabel("Not Used");
		curr = new JLabel("Champion Who is Currently Playing");
		curr.setForeground(Color.GREEN);
		next = new JLabel("Champion Whose turns Will be Next");
		next.setForeground(Color.RED);
		t1.setForeground(Color.WHITE);
		t2.setForeground(Color.WHITE);
		t11.setForeground(Color.GREEN);
		t22.setForeground(Color.GREEN);
		curr.setBounds(518, -25, 500, 90);
		next.setBounds(827, -25, 500, 90);
		t1.setBounds(31, 0, 500, 60);
		t2.setBounds(29, 30, 500, 60);
		t11.setBounds(200, 0, 500, 60);
		t22.setBounds(200, 30, 500, 60);
		// icon1 = new ImageIcon(".\\assests\\East.jpg");
		// Image img = icon1.getImage();
		// Image newimg1 = img.getScaledInstance(375, 580, java.awt.Image.SCALE_SMOOTH);
		// icon1 = new ImageIcon(newimg1);
		// icon2 = new ImageIcon(".\\assests\\West.jpg");
		// Image img2 = icon2.getImage();
		// Image newimg2 = img2.getScaledInstance(375, 580,
		// java.awt.Image.SCALE_SMOOTH);
		// icon2 = new ImageIcon(newimg2);
		icon3 = new ImageIcon(".\\assests\\North.jpg");
		Image img3 = icon3.getImage();
		Image newimg3 = img3.getScaledInstance(1535, 135, java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg3);
		icon4 = new ImageIcon(".\\assests\\South.jpg");
		Image img4 = icon4.getImage();
		Image newimg4 = img4.getScaledInstance(1535, 82, java.awt.Image.SCALE_SMOOTH);
		icon4 = new ImageIcon(newimg4);
		northLabel = new JLabel(icon3);
		southLabel = new JLabel(icon4);
		eastLabel = new JLabel(icon1);
		westLabel = new JLabel(icon2);
		currentlabel = new JLabel();
		currentlabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		currentlabel.setForeground(Color.WHITE);
		currentlabel.setBounds(3, 3, 230, 450);
		eastLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		westLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		eastLabel.setForeground(Color.BLACK);
		westLabel.setForeground(Color.WHITE);
		eastLabel.setBackground(Color.BLACK);
		westLabel.setBackground(Color.BLACK);
		southLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		northLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		southLabel.setForeground(Color.BLACK);
		northLabel.setForeground(Color.WHITE);
		southLabel.setBackground(Color.BLUE);
		northLabel.setBackground(Color.BLACK);
		b1 = new JButton("Cast Ability 1");
		b2 = new JButton("Cast Ability 2");
		b3 = new JButton("Cast Ability 3");
		button = new JButton("use Leader Ability");
		icon = new ImageIcon(".\\assests\\rules.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(128, 80, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		i = new JButton(icon);
		i.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		i.setBounds(1350, 22, 128, 85);
		i.setBackground(Color.WHITE);
		b1.setBackground(Color.RED);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		b1.setBounds(593, 22, 160, 40);
		b2.setBackground(Color.RED);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		b2.setBounds(803, 22, 160, 40);
		b3.setBackground(Color.RED);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		b3.setBounds(1003, 22, 160, 40);
		button.setBackground(Color.RED);
		button.setForeground(Color.BLACK);
		button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		button.setBounds(375, 13, 180, 60);
		b4 = new JButton();
		b5 = new JButton();
		// b4.setEnabled(false);
		// b5.setEnabled(false);
		// b4.setBackground(Color.RED);
		// b4.setForeground(Color.BLACK);
		// b4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		b4.setBounds(536, 37, 150, 80);
		// b5.setBackground(Color.RED);
		// b5.setForeground(Color.BLACK);
		// b5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		b5.setBounds(846, 37, 150, 80);
		northLabel.setPreferredSize(new Dimension(getWidth(), 132));
		southLabel.setPreferredSize(new Dimension(getWidth(), 82));
		eastLabel.setPreferredSize(new Dimension(375, getHeight()));
		westLabel.setPreferredSize(new Dimension(375, getHeight()));
		East.setPreferredSize(new Dimension(375, getHeight()));
		West.setPreferredSize(new Dimension(375, getHeight()));
		East.setBackground(new Color(464441));
		West.setBackground(new Color(464441));
		East.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		East.setForeground(Color.WHITE);
		West.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		West.setForeground(Color.WHITE);
		East.setEditable(false);
		West.setEditable(false);
		north.setPreferredSize(new Dimension(getWidth(), 132));
		south.setPreferredSize(new Dimension(getWidth(), 82));
		north.setBackground(new Color(464441));
		south.setBackground(new Color(464441));
		north.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
		north.setForeground(Color.RED);
		south.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
		south.setForeground(Color.RED);
		north.setEditable(false);
		south.setEditable(false);
		south.add(button);
		south.add(b1);
		south.add(b2);
		south.add(b3);
		south.add(t1);
		south.add(t2);
		south.add(t11);
		south.add(t22);
		north.add(b4);
		north.add(b5);
		north.add(curr);
		north.add(next);
		north.add(i);
		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btn4 = new JButton();
		btn5 = new JButton();
		btn6 = new JButton();
		btn7 = new JButton();
		btn8 = new JButton();
		btn9 = new JButton();
		btn10 = new JButton();
		btn11 = new JButton();
		btn12 = new JButton();
		btn13 = new JButton();
		btn14 = new JButton();
		btn15 = new JButton();
		btn16 = new JButton();
		btn17 = new JButton();
		btn18 = new JButton();
		btn19 = new JButton();
		btn20 = new JButton();
		btn21 = new JButton();
		btn22 = new JButton();
		btn23 = new JButton();
		btn24 = new JButton();
		btn25 = new JButton();
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btn10);
		panel.add(btn11);
		panel.add(btn12);
		panel.add(btn13);
		panel.add(btn14);
		panel.add(btn15);
		panel.add(btn16);
		panel.add(btn17);
		panel.add(btn18);
		panel.add(btn19);
		panel.add(btn20);
		panel.add(btn21);
		panel.add(btn22);
		panel.add(btn23);
		panel.add(btn24);
		panel.add(btn25);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED,5));
//		panel1.add(eastLabel);
		// panel2.add(westLabel);
		// panel3.add(northLabel);
		// panel4.add(southLabel);
		add(panel);
		add(East, BorderLayout.EAST);
		add(West, BorderLayout.WEST);
		// add(eastLabel,BorderLayout.EAST);
		// add(westLabel,BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		validate();
		repaint();
	}

	public JButton getI() {
		return i;
	}

	public JFrame getF() {
		return f;
	}

	public JLayeredPane getPanel1() {
		return panel1;
	}

	public JLayeredPane getPanel2() {
		return panel2;
	}

	public JLayeredPane getPanel3() {
		return panel3;
	}

	public JLayeredPane getPanel4() {
		return panel4;
	}

	public JLabel getCurr() {
		return curr;
	}

	public JLabel getNext() {
		return next;
	}

	public JLabel getT1() {
		return t1;
	}

	public JLabel getT2() {
		return t2;
	}

	public ImageIcon getIcon1() {
		return icon1;
	}

	public ImageIcon getIcon2() {
		return icon2;
	}

	public ImageIcon getIcon3() {
		return icon3;
	}

	public ImageIcon getIcon4() {
		return icon4;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public JButton getBtn9() {
		return btn9;
	}

	public JButton getBtn10() {
		return btn10;
	}

	public JButton getBtn11() {
		return btn11;
	}

	public JButton getBtn12() {
		return btn12;
	}

	public JButton getBtn13() {
		return btn13;
	}

	public JButton getBtn14() {
		return btn14;
	}

	public JButton getBtn15() {
		return btn15;
	}

	public JButton getBtn16() {
		return btn16;
	}

	public JButton getBtn17() {
		return btn17;
	}

	public JButton getBtn18() {
		return btn18;
	}

	public JButton getBtn19() {
		return btn19;
	}

	public JButton getBtn20() {
		return btn20;
	}

	public JButton getBtn21() {
		return btn21;
	}

	public JButton getBtn22() {
		return btn22;
	}

	public JButton getBtn23() {
		return btn23;
	}

	public JButton getBtn24() {
		return btn24;
	}

	public JButton getBtn25() {
		return btn25;
	}

	public JLabel getT11() {
		return t11;
	}

	public JLabel getT22() {
		return t22;
	}

	public JTextArea getNorth() {
		return north;
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

	public JTextArea getSouth() {
		return south;
	}

	public JButton getButton() {
		return button;
	}

	public JTextArea getEast() {
		return East;
	}

	public JTextArea getWest() {
		return West;
	}

	public JLabel getCurrentlabel() {
		return currentlabel;
	}

	public JLayeredPane getPanel() {
		return panel;
	}

	public JLabel getNorthLabel() {
		return northLabel;
	}

	public JLabel getSouthLabel() {
		return southLabel;
	}

	public JLabel getEastLabel() {
		return eastLabel;
	}

	public JLabel getWestLabel() {
		return westLabel;
	}

	public static void main(String[] args) {
		new GameBoard();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
