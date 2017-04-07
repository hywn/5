package net.hilaryoi.four.gui;

import java.awt.Graphics2D;

import net.hilaryoi.four.Player;

public class Camera {

	int width, height;

	int x, y;

	public void draw(Graphics2D g2d, Player player) {

	}

	public void updateDimensions(int width, int height) {

		this.width = width;
		this.height = height;

		x = width / 2;
		y = height / 2;

	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}

	public int getWidth() {
		return width;

	}

	public int getHeight() {
		return height;

	}

	public void moveX(int amount) {
		x += amount;

	}

	public void moveY(int amount) {
		y += amount;

	}

}
