package net.hilaryoi.four;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import net.hilaryoi.four.gui.Camera;
import net.hilaryoi.four.map.Map;
import net.hilaryoi.four.util.ImageUtil;

public class Player extends LivingEntity {

	Image sprite;

	// 0 left, 1 up, 2 right, 3 down
	byte direction;

	byte step;

	double angle;

	Image[] sprites;

	public Player(int x, int y, float weight, Map map, int width, int height) {
		super(x, y, weight, map, width, height);

		ImageUtil iu = new ImageUtil();

		try {
			this.sprites = iu.getSprites(iu.fetchImage("/char.png"), 16, height);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not load player sprites.");
			return;

		}

		direction = 2;

	}

	public void draw(Graphics2D g2d, Camera camera) {

		if (direction == 1) {
			g2d.drawImage(sprites[(direction * 4) + 3], camera.getX() - hHeight, camera.getY() - hHeight, null);
			g2d.drawImage(sprites[direction * 4], camera.getX() - hHeight, camera.getY() - hHeight, null);

		} else {
			g2d.drawImage(sprites[direction * 4], camera.getX() - hHeight, camera.getY() - hHeight, null);
			g2d.drawImage(sprites[(direction * 4) + 3], camera.getX() - hHeight, camera.getY() - hHeight, null);

		}

	}

	public void setAngle(double angle) {
		this.angle = angle;

		double abs = Math.abs(angle);

		if (abs <= 45) {
			direction = 1;

		} else if (abs < 135) {

			if (angle > 0) {
				direction = 2;

			} else {
				direction = 0;

			}

		} else {
			direction = 3;

		}

	}

	@Override
	public void updateX(double offset) {
		super.updateX(offset);

	}

}
