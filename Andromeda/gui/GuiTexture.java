package gui;

import org.lwjgl.util.vector.Vector2f;

public class GuiTexture {

	private int guiTexture;
	private Vector2f position;
	private Vector2f scale;
	
	public GuiTexture(int guiTexture, Vector2f position, Vector2f scale) {
		super();
		this.guiTexture = guiTexture;
		this.position = position;
		this.scale = scale;
	}

	public int getGuiTexture() {
		return guiTexture;
	}

	public Vector2f getPosition() {
		return position;
	}

	public Vector2f getScale() {
		return scale;
	}

	public void setScale(Vector2f scale) {
		this.scale = scale;
	}
	
	
	
	
	
}
