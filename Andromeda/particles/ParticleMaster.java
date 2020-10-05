package particles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import renderEngine.Loader;

public class ParticleMaster {

	private static Map<ParticleTexture, List<Particle>> particles = new HashMap<>();
	private static ParticleRenderer renderer;

	public static void init(Loader loader, Matrix4f projectionMatrix) {
		renderer = new ParticleRenderer(loader, projectionMatrix);
	}

	public static void update(Camera camera) {

		Iterator<Entry<ParticleTexture, List<Particle>>> mapIterator = particles.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<ParticleTexture, List<Particle>> entry = mapIterator.next();
			List<Particle> list = entry.getValue();
			Iterator<Particle> it = list.iterator();
			while (it.hasNext()) {
				Particle p = it.next();
				boolean stillAlive = p.update(camera);
				if (!stillAlive) {
					it.remove();
					if(list.isEmpty()) {
						mapIterator.remove();
					}
				}
			}
			if (!entry.getKey().isAdditiveBlending()) {
				InsertionSort.sortHighToLow(list);
			}
		}

	}

	public static void renderParticles(Camera camera) {
		renderer.render(particles, camera);
	}

	public static void cleanup() {
		renderer.cleanUp();
	}

	public static void addParticles(Particle p) {
		List<Particle> list = particles.get(p.getTexture());
		if (list == null) {
			list = new ArrayList<Particle>();
			particles.put(p.getTexture(), list);
		}
		list.add(p);
	}

}
