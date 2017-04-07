package net.hilaryoi.four.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.hilaryoi.four.state.GameStateManager;

public class KA extends KeyAdapter {

	GameStateManager stateManager;

	public KA(GameStateManager stateManager) {

		this.stateManager = stateManager;

	}

	@Override
	public void keyPressed(KeyEvent e) {

		stateManager.keyPressed(e.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent e) {

		stateManager.keyReleased(e.getKeyCode());

	}

}
