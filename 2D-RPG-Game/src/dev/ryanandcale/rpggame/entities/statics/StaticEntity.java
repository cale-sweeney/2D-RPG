package dev.ryanandcale.rpggame.entities.statics;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
