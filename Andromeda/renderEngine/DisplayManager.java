package renderEngine;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.vector.Vector2f;

public class DisplayManager {

	private static final int WIDTH = 1280, HEIGHT = 720;
	private static final int FPS_CAP = 120;

	private static long lastFrameTime;
	private static float delta;

	public static void createDisplay() {

		ContextAttribs attribs = new ContextAttribs(3, 3).withForwardCompatible(true).withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat().withDepthBits(24), attribs);
			Display.setTitle("Andromeda");
			GL11.glEnable(GL13.GL_MULTISAMPLE);

		} catch (Exception e) {

			e.printStackTrace();
		}

		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		lastFrameTime = getCurrentTime();

	}

	public static void updateDisplay() {

		Display.sync(FPS_CAP);
		Display.update();
		long currentFrameTime = getCurrentTime();
		delta = (currentFrameTime - lastFrameTime) / 1000f; // seconds
		lastFrameTime = currentFrameTime;
	}

	public static float getFrameTimeSeconds() {
		return delta;
	}

	public static void closeDisplay() {

		Display.destroy();
	}

	private static long getCurrentTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution(); // milliSeconds
	}
	
	public static Vector2f getNormalisedMouseCoordinates() {
		
		float normalisedX =  -1.0f + 2.0f * (float) Mouse.getX() / (float) Display.getWidth();
		float normalisedY =  1.0f - 2.0f * (float) Mouse.getY() / (float) Display.getHeight();
		return new Vector2f(normalisedX, normalisedY);
	}

}
