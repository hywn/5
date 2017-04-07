package net.hilaryoi.four.map;

import java.awt.Image;

public class TileSet {

	Image[] tiles;

	public TileSet(Image[] tiles) {

		this.tiles = tiles;

	}

	public Image getTile(int id) {
		return tiles[id];

	}

}
