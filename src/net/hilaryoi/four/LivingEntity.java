package net.hilaryoi.four;

import net.hilaryoi.four.map.Map;

public class LivingEntity extends Entity {

	int health;

	public LivingEntity(int x, int y, float weight, Map map, int width, int height) {
		super(x, y, weight, map, width, height);

	}

	public int getHealth() {
		return health;

	}

}
