package projectiles;

import org.lwjgl.util.vector.Vector3f;

public class Rotation {

	public static int angle(Vector3f pivot, Vector3f point) {

		float xdiff = pivot.x - point.x;
		float ydiff = pivot.y - point.y;
		float zdiff = pivot.z - point.z;
		
		float angle = (float) ((Math.atan2(xdiff, ydiff)) * 180 / Math.PI);

		return -(int) angle;
	}

	public static float angle(float x0, float y0, float z0, float x1, float y1, float z1) {
		return angle(new Vector3f(x0, y0, z0), new Vector3f(x1, y1, z1));
	}

	public static Vector3f point(Vector3f pivot, Vector3f point, float rotation) {

		float rot = (float) (1f / 180 * rotation * Math.PI);

		float x = point.x - pivot.x;
		float y = point.y - pivot.y;
		float z = point.z - pivot.z;

		float newx = (float) (x * Math.cos(rot) - y * Math.sin(rot));
		float newy = (float) (x * Math.sin(rot) + y * Math.cos(rot));
		float newz = (float) (x * Math.sin(rot) + y * Math.cos(rot));

		newx += pivot.x;
		newy += pivot.y;
		newz += pivot.z;

		return new Vector3f(newx, newy, newz);
	}
}
