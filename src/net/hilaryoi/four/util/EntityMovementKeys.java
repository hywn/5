package net.hilaryoi.four.util;

import java.awt.event.KeyEvent;

import net.hilaryoi.four.Entity;

public class EntityMovementKeys {

	// controls any entity with keys

	private boolean left, right, up, down;

	Entity target;

	public EntityMovementKeys(Entity target) {

		this.target = target;

		release();

	}

	public void keyPressed(int keyCode) {

		switch (keyCode) {

		case (KeyEvent.VK_A):
			left = true;
			break;
		case (KeyEvent.VK_D):
			right = true;
			break;
		case (KeyEvent.VK_W):
			up = true;
			break;
		case (KeyEvent.VK_S):
			down = true;
			break;

		}

	}

	public void keyReleased(int keyCode) {

		switch (keyCode) {

		case (KeyEvent.VK_A):
			left = false;
			break;
		case (KeyEvent.VK_D):
			right = false;
			break;
		case (KeyEvent.VK_W):
			up = false;
			break;
		case (KeyEvent.VK_S):
			down = false;
			break;

		}
	}

	public void update() {

		int speed = 5;

		if (left) {
			target.updateX(-speed);

		}

		if (right) {
			target.updateX(speed);

		}

		if (up) {
			target.updateY(-speed);

		}

		if (down) {
			target.updateY(speed);

		}

	}

	public void release() {
		left = right = up = down = false;

	}

}
