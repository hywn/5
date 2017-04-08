package net.hilaryoi.four;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import net.hilaryoi.four.gui.Camera;
import net.hilaryoi.four.map.Map;
import net.hilaryoi.four.util.ImageUtil;

public class Player extends LivingEntity {

	Image sprite;

	byte step;

	Image[] sprites;

	int walkCycle;

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

		walkCycle = 0;

	}

	public void draw(Graphics2D g2d, Camera camera) {

		System.out.println(direction);

		g2d.setColor(Color.RED);

		g2d.fillRect(camera.getX() - hWidth, camera.getY() - height, width, height);

		g2d.drawImage(sprites[direction * 3 + walkCycle], camera.getX() - hHeight, camera.getY() - height, null);

	}

	@Override
	public void updateX(double offset) {
		super.updateX(offset);

	}

}
