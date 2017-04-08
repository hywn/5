package net.hilaryoi.four.util;

import java.awt.event.KeyEvent;

import net.hilaryoi.four.Entity;

public class EntityMovementKeys {

	// controls any entity with keys

	private boolean left, right, up, down, jump;

	Entity target;

	public EntityMovementKeys(Entity target) {

		this.target = target;

		release();

	}

	public void keyPressed(int keyCode) {

		switch (keyCode) {

		case (KeyEvent.VK_A):
			left = true;
			target.setDirection(0);
			break;
		case (KeyEvent.VK_D):
			right = true;
			target.setDirection(1);
			break;
		case (KeyEvent.VK_W):
			up = true;
			break;
		case (KeyEvent.VK_S):
			down = true;
			break;
		case (KeyEvent.VK_SPACE):
			jump = true;

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
		case (KeyEvent.VK_SPACE):
			jump = false;

		}

	}

	int speed = 8;

	public void update() {

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

		if (jump && target.isOnGround()) {
			target.jump();

		}

	}

	public void release() {
		left = right = up = down = jump = false;

	}

}
