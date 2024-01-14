package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameFrame4 extends JFrame implements ActionListener {
	private JLayeredPane panel;
	JLabel label;
	JLabel label2;
	JLabel label3;
	ImageIcon img;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;

	public GameFrame4() {
		this.setBounds(350,145,800,610);
		this.setVisible(true);
		this.setTitle("Marvel Ultimate War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel = new JLayeredPane();
		/*
		 * b = new JButton("Start New Game !"); b.setBackground(Color.ORANGE);
		 * b.setBounds(375, 45, 150, 50);
		 */
		img = new ImageIcon(".\\assests\\ggg.jpg");
		label = new JLabel(img);
		label.setBounds(0, 0, 800, 600);
//		panel.add(b);
		label3 = new JLabel("First Player Leader Champion");
		label3.setBounds(253, -170, 600, 400);
		label3.setForeground(Color.MAGENTA);
		label3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
		label2 = new JLabel("Please, Choose Your Leader Champion !");
		label2.setBounds(250, -90, 600, 400);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font(Font.MONOSPACED, Font.TYPE1_FONT, 15));
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton("GO");
		b1.setBounds(111, 200, 135, 225);
		b2.setBounds(331, 200, 135, 225);
		b3.setBounds(551, 200, 135, 225);
		b4.setBounds(336, 450, 125, 70);
		b4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		b1.setBackground(Color.BLACK);
		b2.setBackground(Color.BLACK);
		b3.setBackground(Color.BLACK);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		panel.add(label);
		add(label2);
		add(label3);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		this.add(panel);
		this.revalidate();
		this.repaint();
	}

	public JButton getB4() {
		return b4;
	}

	public static void main(String[] args) {
		new GameFrame4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public JLayeredPane getPanel() {
		return panel;
	}

	public JLabel getLabel() {
		return label;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public ImageIcon getImg() {
		return img;
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

}
