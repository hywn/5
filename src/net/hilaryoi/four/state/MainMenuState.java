package net.hilaryoi.four.state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import net.hilaryoi.four.util.TextUtil;

public class MainMenuState extends GameState {

	TextUtil textU;

	public MainMenuState(GameStateManager stateManager) {

		super(stateManager);

		try {
			textU = new TextUtil("alphabet-04.png", 5, 8, 4);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	void draw(Graphics2D g2d) {

		textU.drawLines(g2d, "tes\nabcdefg\nhijklmnop\nqrstuv\nwxyz!\nbob went to the store\ncoffee\nshorts\nsunday\nexclamation!\n?\n...\nalright?", 40, 40);

	}

	@Override
	void update() {
		// TODO Auto-generated method stub

	}

	@Override
	void mouseMovement(int mX, int mY) {
		// TODO Auto-generated method stub

	}

	@Override
	void mousePressed(int mX, int mY) {
		// TODO Auto-generated method stub

	}

	@Override
	void mouseReleased(int mX, int mY) {
		// TODO Auto-generated method stub

	}

	@Override
	void keyPressed(int keyCode) {

		if (keyCode == KeyEvent.VK_ENTER) {

			stateManager.setStatesDown(0);

			stateManager.closeCurrentState();

		}

	}

	@Override
	void keyReleased(int keyCode) {
		// TODO Auto-generated method stub

	}

}
