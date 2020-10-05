package projectiles;

import org.lwjgl.util.vector.Vector3f;

import entities.Entity;
import models.TexturedModels;
import particles.ParticleSystem;
import terrains.Terrain;

public class Projectile extends Entity {

	public int lifeLength = 100;
	

	public Projectile(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);

	}

	public void update(Vector3f target) {

		// 1) Calculate rotation between target (entity shooting at) and this
		// (projectile)
		float rotation = Rotation.angle(target.x, target.y, target.z, super.getPosition().x, super.getPosition().y,
				super.getPosition().z);

		// 2) The speed at which the projectiles travels
		float speed = 0.7f;

		// 3) A 3d vector which will tell how much to increment projectile's x,y
		// coordinates.
		// Rotate vector composed of [0,-speed] around point vec2.NULL( which is [0,0]
		// vector) by rotation degrees.
		Vector3f velocity = Rotation.point(new Vector3f(0, 0, 0), new Vector3f(speed, speed, speed), rotation);

		// 4) increment projectile's x,y coordinates.
		super.getPosition().x += velocity.x;
		super.getPosition().y += velocity.y;
		super.getPosition().z += velocity.z;
	}

	public boolean collesionDetection(Terrain terrain, ParticleSystem particleSys) {
		float terrainHeight = terrain.getHeightOfTerrain(super.getPosition().x, super.getPosition().z);

		if (super.getPosition().y <= terrainHeight) {

			float counter = 150;
			while(counter > 0) {
				counter --;
				particleSys.generateParticles(getPosition());
			}
			
			Projectile.this.getPosition().y -= terrainHeight;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean collesionDetection(Terrain terrain) {
		float terrainHeight = terrain.getHeightOfTerrain(super.getPosition().x, super.getPosition().z);

		if (super.getPosition().y <= terrainHeight) {
			Projectile.this.getPosition().y -= terrainHeight;
			return true;
		} else {
			return false;
		}
	}

}
