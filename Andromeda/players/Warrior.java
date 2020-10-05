package players;

import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import models.TexturedModels;
import renderEngine.DisplayManager;

public class Warrior extends Player {

	private double health = 1500;
	private boolean isDamaged = false;
	private double meleDamageModifier = 132.35;
	private double attackStrength = 147.50;
	private double resistance = (attackStrength / meleDamageModifier);

	public Warrior(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);

	}

	public void powerUp() {

		if (isDamaged()) {
			attackStrength += meleDamageModifier;
			health += (getHealth() + resistance * (7 * DisplayManager.getFrameTimeSeconds()));
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
