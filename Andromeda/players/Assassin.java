package players;

import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import models.TexturedModels;

public class Assassin extends Player {

	private double health = 1500;
	private boolean isDamaged = false;

	public Assassin(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}

	public void powerUp() {

		if (isDamaged()) {
			Assassin.RUN_SPEED = 100;
		}
	}

	/**
	 * 
	 * @return if damage is taken
	 */
	public boolean isDamaged() {
		return isDamaged;
	}

	/**
	 * @return the health
	 */
	public double getHealth() {
		return health;
	}

}
