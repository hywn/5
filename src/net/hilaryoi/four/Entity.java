package net.hilaryoi.four;

import net.hilaryoi.four.map.Map;
import net.hilaryoi.four.state.PlayingState;

public class Entity {

	// TODO: update for tile scaling and varying framerates
	static float MAX_VELOCITY = 20;
	static float GRAVITY = 1.3F;

	public double x, y;

	public float weight;
	public float velocityY;

	public int hWidth, hHeight, width, height;

	boolean onGround;

	// TODO: int isnt really neccessary for one, two or possibly more
	int direction;

	Map map;

	public Entity(int x, int y, float weight, Map map, int width, int height) {

		this.x = x;
		this.y = y;

		this.weight = weight;

		this.map = map;

		this.width = width;
		this.height = height;

		hWidth = width / 2;
		hHeight = height / 2;

		velocityY = 0;

		onGround = false;

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void updateX(double offset) {
		x += offset;

	}

	public void updateY(double offset) {
		y += offset;

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setDirection(int direction) {
		this.direction = direction;

	}

	// hHeight puts it in the middle i think
	public int getTileX() {

		System.out.println(x);

		System.out.println((x / PlayingState.TILE_SIZE));

		return (int) (x / PlayingState.TILE_SIZE);

	}

	public int getTileY() {
		return (int) (y / PlayingState.TILE_SIZE);

	}

	public boolean isOnGround() {
		return onGround;

	}

	void doGravity() {

		velocityY += GRAVITY;

		y += velocityY;

	}

	// TODO: jumpheight?

	public void jump() {

		onGround = false;
		velocityY = -30;

	}

	public void update() {

		int tileY = getTileY();

		if (map.isSolid(getTileX(), tileY)) {

			if (velocityY < 0) {

				doGravity();

			}

		} else {

			doGravity();

			tileY = getTileY();

			if (map.isSolid(getTileX(), tileY)) {

				y = tileY * PlayingState.TILE_SIZE;
				velocityY = 0;
				onGround = true;

			}

		}

		System.out.println(velocityY);

	}

	public boolean intersects(Entity e) {

		double xDistance = Math.abs(e.x) - Math.abs(x);

		boolean isX = xDistance < (e.hWidth + hWidth);

		double yDistance = Math.abs(e.y) - Math.abs(y);

		boolean isY = yDistance < (e.hHeight + hHeight);

		return isX && isY;

	}

}
