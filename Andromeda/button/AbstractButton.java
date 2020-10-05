package button;

import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import gui.GuiTexture;
import renderEngine.DisplayManager;
import renderEngine.Loader;

public abstract class AbstractButton implements Button {

	private GuiTexture guiTexture;
	private Vector2f originalScale;
	private boolean isHidden = false, isHovering = false;
	private int mouseClickedCounter = 1;
	
	public AbstractButton(Loader loader, String texture, Vector2f position, Vector2f scale) {

		guiTexture = new GuiTexture(loader.loadTexture(texture), position, scale);
		originalScale = scale;
	}

	public void update() {
		if (!isHidden) {
			Vector2f location = guiTexture.getPosition();
			Vector2f scale = guiTexture.getScale();
			Vector2f mouseCoords = DisplayManager.getNormalisedMouseCoordinates();
			if (location.y + scale.y > -mouseCoords.y && location.y - scale.y < -mouseCoords.y
					&& location.x + scale.x > mouseCoords.x && location.x - scale.x < mouseCoords.x) {
				whileHovering(this);
				if (!isHovering) {
					isHovering = true;
					startHovering(this);
				}
				while (Mouse.next()) {
					if (Mouse.isButtonDown(0)) { // left mouse button
						onClick(this);
						mouseClickedCounter ++;
					}
				}
			} else {
				if (isHovering) {
					isHovering = false;
					stopHovering(this);
				}
			}
		}
	} // end update
	
	public void show(List<GuiTexture> guis) {
		if (isHidden) {
			guis.add(guiTexture);
			isHidden = false;
		}
	}
	
	public void hide(List<GuiTexture> guis) {
		if (!isHidden) {
			guis.remove(guiTexture);
			isHidden = true;
		}
	}
	
	public void resetScale() {
		guiTexture.setScale(originalScale);
	}
	
	public void playHoverAnimation(float scaleFactor) {
		guiTexture.setScale(new Vector2f(originalScale.x + scaleFactor, originalScale.y + scaleFactor));
	}

	public boolean isHidden() {
		return isHidden;
	}

	public boolean isHovering() {
		return isHovering;
	}

	public int getMouseClickedCounter() {
		return mouseClickedCounter;
	}

	public void setMouseClickedCounter(int mouseClickedCounter) {
		this.mouseClickedCounter = mouseClickedCounter;
	}
}
