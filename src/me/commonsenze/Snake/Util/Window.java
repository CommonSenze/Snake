package me.commonsenze.Snake.Util;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import me.commonsenze.Snake.Main;

public class Window extends Canvas {

	private static final long serialVersionUID = -7350994056018897085L;
	private JFrame frame;
	
	public Window(int width, int height, String title, Main main) {
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(main);
		frame.setVisible(true);
		frame.pack();
		main.start();
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
