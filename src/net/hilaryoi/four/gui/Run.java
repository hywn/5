package net.hilaryoi.four.gui;

import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import net.hilaryoi.four.state.GameStateManager;

public class Run {

	public static void main(String[] args) {

		Frame f = new Frame();

		GameStateManager stateManager = new GameStateManager(800, 500);

		KA keys = new KA(stateManager);

		MA mouse = new MA(stateManager);

		// f.addKeyListener(keys);

		// f.addMouseMotionListener(mouse);

		// f.addMouseListener(mouse);

		Game g = new Game(stateManager, mouse, keys);

		f.add(g);

		f.setSize(800, 500);

		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}

		});

		f.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				// TODO: g.getCamera().updateDimensions(f.getWidth(),
				// f.getHeight());
				System.out.println(f.getWidth() + ", " + f.getHeight());

			}

		});

		f.setVisible(true);

		g.start();

	}

}
