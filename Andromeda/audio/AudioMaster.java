package audio;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

public class AudioMaster {
	
	private static List<Integer> buffers = new ArrayList<>();

	public static void init() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * sound relative to players position in world
	 */
	public static void setListenerData( float x, float y, float z) {
		AL10.alListener3f(AL10.AL_POSITION, x, y, z);
		AL10.alListener3f(AL10.AL_VELOCITY, x, y, z);
		
	}
	
	public static int loadSound(String soundFile) {
		
		int buffer = AL10.alGenBuffers(); // create empty buffer
		buffers.add(buffer); // add buffer to list of buffers
		WaveData waveFile = WaveData.create(soundFile); // create wave file from sound file
		AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate); // store wave data in buffer
		waveFile.dispose(); // now that buffer has the data it needs, delete the wave file
		return buffer; // return the newly created buffer's ID
	}
	
	public static void cleanUp() {
		
		for (int buffer : buffers) {
			AL10.alDeleteBuffers(buffer);
		}
		AL.destroy();
	}
	
}