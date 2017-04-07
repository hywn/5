package net.hilaryoi.four.state;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {

	int width, height;

	ArrayList<GameState> states;

	int currState;

	int statesDown;

	// TODO: add LAYERED states and multiple updates

	public GameStateManager(int width, int height) {

		states = new ArrayList<GameState>();

		this.width = width;
		this.height = height;

		// add states

		states.add(new MainMenuState(this));

		states.add(new PlayingState(this));

		states.add(new DialogueState(this));

		currState = 2;

		setStatesDown(0);

	}

	public void draw(Graphics2D g2d) {

		for (int i = statesDown; i >= 0; i--) {

			states.get(currState - i).draw(g2d);

		}

	}

	public void update() {

		for (int i = statesDown; i >= 0; i--) {

			System.out.println(i + ", " + currState);

			states.get(currState - i).update();

		}

	}

	public void mouseMovement(int mX, int mY) {

		states.get(currState).mouseMovement(mX, mY);

	}

	public void mousePressed(int mX, int mY) {

		states.get(currState).mousePressed(mX, mY);

	}

	public void mouseReleased(int mX, int mY) {

		states.get(currState).mouseReleased(mX, mY);

	}

	public void keyPressed(int keyCode) {

		states.get(currState).keyPressed(keyCode);

	}

	public void keyReleased(int keyCode) {

		System.out.println(keyCode);

		states.get(currState).keyReleased(keyCode);

	}

	public int getWidth() {
		return width;

	}

	public int getHeight() {
		return height;

	}

	public void setStatesDown(int statesDown) {
		this.statesDown = statesDown;

	}

	public void closeCurrentState() {
		states.remove(currState);
		this.currState--;

	}

}
