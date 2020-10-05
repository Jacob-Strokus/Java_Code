package collision;

import org.lwjgl.util.vector.Vector3f;

public class AABB {

	private Vector3f center, radius;

	public AABB(Vector3f center, Vector3f radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	

	public Vector3f getCenter() {
		return center;
	}

	public Vector3f getRadius() {
		return radius;
	}

}
