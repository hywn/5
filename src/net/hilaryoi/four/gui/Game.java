package net.hilaryoi.four.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferStrategy;

import net.hilaryoi.four.state.GameStateManager;

public class Game extends Canvas {

	// double buffering
	Graphics dbg;
	Image dbi;

	private static final long serialVersionUID = 1L;

	MA mouse;

	KA keys;

	Thread logicThread, renderThread;

	GameStateManager stateManager;

	public Game(GameStateManager stateManager, MA mouse, KA keys) {

		this.stateManager = stateManager;

		this.setSize(stateManager.getWidth(), stateManager.getHeight());

		this.mouse = mouse;

		this.keys = keys;

		this.addMouseMotionListener(mouse);
		this.addMouseListener(mouse);
		this.addKeyListener(keys);

		setIgnoreRepaint(true);

		logicThread = new Thread(new LogicThread());
		renderThread = new Thread(new RenderThread());

		this.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				// RELEASE KEYS

			}

		});

	}

	public void start() {
		logicThread.start();
		renderThread.start();

	}

	class LogicThread implements Runnable {

		@Override
		public void run() {

			long last_update = System.nanoTime();

			final int TARGET_FPS = 60;
			final double TARGET_TIME = 1000000000 / TARGET_FPS;

			int fps = 0;
			long last_fps = 0;

			while (true) {

				// update counter every second

				long now = System.nanoTime();

				fps++;
				last_fps += now - last_update;

				last_update = now;

				if (last_fps > 1000000000) {

					System.out.println(fps);

					fps = 0;

					last_fps = 0;

				}

				update();

				try {

					Thread.sleep((long) ((System.nanoTime() - last_update + TARGET_TIME) / 1000000));

				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}

		}

	}

	class RenderThread implements Runnable {

		@Override
		public void run() {

			long last_update = System.nanoTime();

			final int TARGET_FPS = 59;
			final double TARGET_TIME = 1000000000 / TARGET_FPS;

			int fps = 0;
			long last_fps = 0;

			while (true) {

				// update counter every second

				long now = System.nanoTime();

				fps++;
				last_fps += now - last_update;

				last_update = now;

				if (last_fps > 1000000000) {

					System.out.println(fps);

					fps = 0;

					last_fps = 0;

				}

				render();

				try {

					Thread.sleep((long) ((System.nanoTime() - last_update + TARGET_TIME) / 1000000));

				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}
		}

	}

	public void update() {

		stateManager.update();

	}

	public void draw(Graphics2D g2d) {

		stateManager.draw(g2d);

	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(2);
			return;

		}

		Graphics g = bs.getDrawGraphics();

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.BLACK);

		g2d.fillRect(0, 0, getWidth(), getHeight());

		g2d.setColor(Color.BLACK);

		draw(g2d);

		g2d.dispose();

		g.dispose();

		bs.show();

	}

}
