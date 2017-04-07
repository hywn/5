package net.hilaryoi.four;

public class Entity {

	public int x, y;

	public int hWidth, hHeight;

	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;

		hWidth = width / 2;
		hHeight = height / 2;

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void updateX(int offset) {
		x += offset;

	}

	public void updateY(int offset) {
		y += offset;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean intersects(Entity e) {

		int xDistance = Math.abs(e.x) - Math.abs(x);

		boolean isX = xDistance < (e.hWidth + hWidth);

		int yDistance = Math.abs(e.y) - Math.abs(y);

		boolean isY = yDistance < (e.hHeight + hHeight);

		return isX && isY;

	}

}
