package button;

import java.util.List;

import gui.GuiTexture;

public interface Button {
	
	 void onClick(Button button);
	 
	 int getMouseClickedCounter();
	 
	 void setMouseClickedCounter(int mouseClickedCounter);
	 
	 void startHovering(Button button);
	 
	 void stopHovering(Button button);
	 
	 void whileHovering(Button button);
	 
	 void show(List<GuiTexture> guis);
	 
	 void hide(List<GuiTexture> guis);
	 
	 void playHoverAnimation(float scaleFactor);
	 
	 void resetScale();
	 
	 void update();
}
