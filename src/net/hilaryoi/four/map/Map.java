package net.hilaryoi.four.map;

import java.awt.Graphics2D;

import net.hilaryoi.four.Entity;
import net.hilaryoi.four.gui.Camera;
import net.hilaryoi.four.state.PlayingState;

public class Map {

	int padding = 2;

	TerrainTile[][] terrain;

	int xMax, yMax;

	public Map(TerrainTile[][] terrain) {

		this.terrain = terrain;

		yMax = terrain.length - 1;
		xMax = terrain[0].length - 1;

		System.out.println(yMax + ", " + xMax);

	}

	// TODO: Clean up static access to TILE_SIZE

	public void draw(Graphics2D g2d, Camera camera, Entity focus) {

		// camera is the center

		int cameraUpperX = (camera.getWidth() / 2) - focus.getX();
		int cameraUpperY = (camera.getHeight() / 2) - focus.getY();

		int cameraXTile = focus.getX() / PlayingState.TILE_SIZE;
		int cameraYTile = focus.getY() / PlayingState.TILE_SIZE;

		int cameraTileHWidth = (camera.getWidth() / PlayingState.TILE_SIZE) / 2;
		int cameraTileHHeight = (camera.getHeight() / PlayingState.TILE_SIZE) / 2;

		int tileOffsetX = cameraXTile - cameraTileHWidth;
		int tileOffsetY = cameraYTile - cameraTileHHeight;

		// int renderedTiles = 0;

		for (int xTile = tileOffsetX - padding; xTile < Math.min(xMax,
				cameraXTile + cameraTileHWidth + padding); xTile++) {

			for (int yTile = tileOffsetY - padding; yTile < Math.min(yMax,
					cameraYTile + cameraTileHHeight + padding); yTile++) {

				if (xTile < 0 || yTile < 0) {
					continue;

				}

				terrain[yTile][xTile].draw(g2d, cameraUpperX + (xTile * PlayingState.TILE_SIZE),
						cameraUpperY + (yTile * PlayingState.TILE_SIZE));

				// renderedTiles++;

			}

		}

		// System.out.println("Rendered Tiles: " + renderedTiles);

	}

}
