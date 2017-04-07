package net.hilaryoi.four.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import net.hilaryoi.four.state.PlayingState;
import net.hilaryoi.four.util.ImageUtil;

public class MapParser {

	ImageUtil iu = new ImageUtil();

	public Map getMap(String path) throws IOException {

		// TODO: Clean up TILE_SIZE access

		TileSet tiles = new TileSet(iu.getLRSprites(iu.fetchImage("/terrain.png"), 16, PlayingState.TILE_SIZE));

		ArrayList<TerrainTile[]> rows = new ArrayList<TerrainTile[]>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(path)));

		String line = reader.readLine();

		int count = 0;

		while (line != null) {

			System.out.println(line);

			String[] strs = line.split(",");

			TerrainTile[] row = new TerrainTile[strs.length - 1];

			for (int i = 0; i < strs.length - 1; i++) {

				row[i] = new TerrainTile(Integer.valueOf(strs[i]), tiles);

			}

			rows.add(row);

			line = reader.readLine();

			count++;

		}

		return new Map(rows.toArray(new TerrainTile[count][]));

	}

}
