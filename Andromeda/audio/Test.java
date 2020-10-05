package audio;

import java.util.Scanner;

import org.lwjgl.openal.AL10;

public class Test {

	public static void main(String[] args) {

		
		
		Scanner scan = new Scanner(System.in);
		
		
		AudioMaster.init();
		AudioMaster.setListenerData(0, 0, 0);
		int buffer = AudioMaster.loadSound("Audio/explosion1.wav"); // <-- sound file goes here
		Source source = new Source();
		AL10.alDistanceModel(AL10.AL_INVERSE_DISTANCE_CLAMPED);
		source.play(buffer);
		source.setLooping(true);
		
		while (!scan.next().equalsIgnoreCase("Q")) {
			
			
		}
		
		scan.close();
		//source.delete();
		AudioMaster.cleanUp();
		System.exit(0);
	}

}
