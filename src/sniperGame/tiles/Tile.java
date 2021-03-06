package sniperGame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author Arafin
 *
 */

public class Tile {
	
	//Static Stuff Here
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(2);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile roadTile = new RoadTile(0);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	//Class

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getID() {
		return id;
	}
}
