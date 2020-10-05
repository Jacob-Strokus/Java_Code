package collision;

public class Vector3D {

	private float x;
	private float y;
	private float z;

	public Vector3D() {
	      x = 0.0f;
	      y = 0.0f;
	      z = 0.0f;
	   }

	// returns the (squared) distance between this 3D Vector and another
	public float distSQ(final Vector3D vec) {
		float distX = x - vec.x;
		float distY = y - vec.y;
		float disZ = z - vec.z;

		return distX * distX + distY * distY + disZ * disZ;
	}
}
