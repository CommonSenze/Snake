package me.commonsenze.Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import me.commonsenze.Snake.Util.UserKeyInput;
import me.commonsenze.Snake.Util.Window;

public class Main extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2197924032874913024L;

	public static final int FIELD_SIZE = 25;
	public static final int WIDTH = (int)(FIELD_SIZE * 32+(FIELD_SIZE-19)), HEIGHT = (int)(FIELD_SIZE * 32+(FIELD_SIZE+4));
	private Game game;
	private Thread thread;
	private boolean running = false;
	
	public Main() {
		this.game = new Game();
		new Window(WIDTH, HEIGHT, "Test", this);
		this.addKeyListener(new UserKeyInput());
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public synchronized void start() {
		if (thread == null) thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			System.exit(0);
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				delta--;
			}
			if (running)
				render();
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		
		game.render(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WIDTH,HEIGHT);
		
		g.setColor(Color.WHITE);
		
		

		g.dispose();
		bs.show();
	}
}
