package net.hilaryoi.four.map;

import java.awt.Graphics2D;

public class TerrainTile extends Tile {

	int typeId;

	TileSet tiles;

	public TerrainTile(int typeId, TileSet tiles) {

		this.typeId = typeId;

		this.tiles = tiles;

	}

	public void draw(Graphics2D g2d, int x, int y) {

		g2d.drawImage(tiles.getTile(typeId), x, y, null);

	}

}
