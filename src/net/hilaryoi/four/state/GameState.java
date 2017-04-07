package net.hilaryoi.four.state;

import java.awt.Graphics2D;

public abstract class GameState {

	GameStateManager stateManager;

	public GameState(GameStateManager stateManager) {

		this.stateManager = stateManager;

	}

	abstract void draw(Graphics2D g2d);

	abstract void update();

	abstract void mouseMovement(int mX, int mY);

	abstract void mousePressed(int mX, int mY);

	abstract void mouseReleased(int mX, int mY);

	abstract void keyPressed(int keyCode);

	abstract void keyReleased(int keyCode);

}
