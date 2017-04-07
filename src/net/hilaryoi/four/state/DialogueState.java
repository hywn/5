package net.hilaryoi.four.state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import net.hilaryoi.four.util.TextUtil;

public class DialogueState extends GameState {

	TextUtil textU;

	int y;

	int textScale;

	int textSpeed;

	int timer;

	String buffer;

	String string;

	public DialogueState(GameStateManager stateManager) {

		super(stateManager);

		string = buffer = new String();
		// string = new String();

		y = 400;

		textScale = 3;

		textSpeed = 10;

		try {
			textU = new TextUtil("alphabet-05.png", 5, textScale, 2);

		} catch (IOException e) {
			e.printStackTrace();

		}

		printString("hello world");

	}

	@Override
	void draw(Graphics2D g2d) {

		g2d.fillRect(0, y, stateManager.getWidth(), stateManager.getHeight() - y);

		textU.drawString(g2d, buffer, 10, y + 10);

	}

	public void printString(String newString) {

		string = string.concat(newString);

	}

	@Override
	void update() {

		if (string.isEmpty()) {
			return;

		}

		timer++;

		System.out.println(buffer);

		if (timer % textSpeed == 0) {

			printCharacter();

		}

		if (string.isEmpty()) {
			timer = 0;

		}

	}

	public void printCharacter() {

		String c = String.valueOf(string.charAt(0));

		buffer = buffer.concat(c);

		string = string.replaceFirst(c, "");

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
