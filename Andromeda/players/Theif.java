package players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import models.TexturedModels;

public class Theif extends Player {

	public static double health = 1500;
	public static boolean isDamaged = false;
	public static int decoyTime = 50;
	

	public Theif(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	
	public static Player createTrail(Player player, TexturedModels person) {
		
		Player clone = new Theif(person, new Vector3f(player.getPosition()), 0, 250, 0, 1f);
		return clone;
	}
	
	public static List<Player> addClones(Player player, TexturedModels person) {

		List<Player> clones = new ArrayList<>();
		Random r = new Random(75);
		Player clone = new Theif(person, new Vector3f(player.getPosition().x + ( 10 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z + ( 10 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone2 = new Theif(person, new Vector3f(player.getPosition().x + ( 8 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z + ( 8 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone3 = new Theif(person, new Vector3f(player.getPosition().x - ( 10 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z + ( 10 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone4 = new Theif(person, new Vector3f(player.getPosition().x + ( 6 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z - ( 6 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone5 = new Theif(person, new Vector3f(player.getPosition().x + ( 10 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z - ( 10 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone6 = new Theif(person, new Vector3f(player.getPosition().x + ( 8 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z - ( 8 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone7 = new Theif(person, new Vector3f(player.getPosition().x - ( 10 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z - ( 10 + r.nextFloat())), 0, 250, 0, 1f);
		Player clone8 = new Theif(person, new Vector3f(player.getPosition().x - ( 8 +r.nextFloat()), player.getPosition().y,
				player.getPosition().z - ( 8 + r.nextFloat())), 0, 250, 0, 1f);

		clones.add(clone);
		clones.add(clone2);
		clones.add(clone3);
		clones.add(clone4);
		clones.add(clone5);
		clones.add(clone6);
		clones.add(clone7);
		clones.add(clone8);

		return clones;
	}
	

	public static void powerUp() {

		if (isDamaged()) {
			//something goes here
		}
		
	}

	/**
	 * 
	 * @return if damage is taken
	 */
	public static boolean isDamaged() {
		return isDamaged;
	}

	/**
	 * @return the health
	 */
	public static double getHealth() {
		return health;
	}
}
