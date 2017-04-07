package net.hilaryoi.four.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.hilaryoi.four.state.GameStateManager;

public class MA extends MouseAdapter {

	GameStateManager stateManager;

	public MA(GameStateManager stateManager) {

		this.stateManager = stateManager;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		stateManager.mouseMovement(e.getX(), e.getY());

	}

}
