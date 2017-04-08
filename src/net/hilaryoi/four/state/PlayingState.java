package net.hilaryoi.four.state;

import java.awt.Graphics2D;
import java.io.IOException;

import net.hilaryoi.four.Player;
import net.hilaryoi.four.gui.Camera;
import net.hilaryoi.four.map.Map;
import net.hilaryoi.four.map.MapParser;
import net.hilaryoi.four.util.EntityMovementKeys;

public class PlayingState extends GameState {

	Camera camera;

	Player player;

	public static final int TILE_SIZE = 100;

	Map map;

	int mX, mY;

	// TODO: fix mouse input

	EntityMovementKeys keys;

	public PlayingState(GameStateManager stateManager) {

		super(stateManager);

		camera = new Camera();

		camera.updateDimensions(stateManager.getWidth(), stateManager.getHeight());

		MapParser mp = new MapParser();

		try {
			map = mp.getMap("/test2-level.csv");

		} catch (IOException e) {
			e.printStackTrace();

		}

		player = new Player(100, 100, 5, map, 40, 100);

		keys = new EntityMovementKeys(player);

		mX = mY = 0;

	}

	@Override
	void update() {

		keys.update();
		player.update();

	}

	public int getFactor(double num) {

		if (num == 0) {
			return 1;

		}

		return (int) (num / Math.abs(num));

	}

	public Camera getCamera() {
		return camera;

	}

	@Override
	void draw(Graphics2D g2d) {

		map.highlightTile(player.getTileX(), player.getTileY());

		map.draw(g2d, camera, player);

		player.draw(g2d, camera);

	}

	@Override
	void mouseMovement(int mX, int mY) {
		this.mX = mX;
		this.mY = mY;

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

		keys.keyPressed(keyCode);

	}

	@Override
	void keyReleased(int keyCode) {

		keys.keyReleased(keyCode);

	}

}
