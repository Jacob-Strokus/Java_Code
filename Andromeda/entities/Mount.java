package entities;

import org.lwjgl.util.vector.Vector3f;
import models.TexturedModels;

public class Mount extends Player {

	public Mount(TexturedModels model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}

}
