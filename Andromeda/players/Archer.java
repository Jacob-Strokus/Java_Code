package players;

import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import models.TexturedModels;

public class Archer extends Player {

	private double health = 1500;
	private boolean isDamaged = false;

	public Archer(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}

	public void powerUp() {

		if (isDamaged()) {

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
