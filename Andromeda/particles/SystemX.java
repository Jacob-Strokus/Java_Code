package particles;


import java.awt.Graphics;
import java.awt.Graphics2D;

public class SystemX {
	
	private static int maxParticles 			= 11500;
	private static int maxEmitters 			= 500;
	private static int maxEffects 			= 200;
	public static double windGlobal 		= 0;
	public static double gravityGlobal 		= 0; 
	public static double friction 			= 0;
	public static int boundBoxX1 = -25;
	public static int boundBoxX2 = 825;
	public static int boundBoxY1 = -25;
	public static int boundBoxY2 = 625;
	
	public static int currentParticles 		= 0;
	public static int currentEmitters 		= 0;
	public static int currentEffects		= 0;
	
	//---------------Arrays---------------\\
	private static Particle2[] 	particles	=	new Particle2[maxParticles];
	private static Emitter[] 	emitters 	= 	new Emitter[maxEmitters];
	private static Effect[] 	effects 	= 	new Effect[maxEffects];
	//iterator 
	private static int pIterator = 0;
	private static int eIterator = 0;
	private static int fxIterator = 0;
	
	
	public synchronized static void render( Graphics g )
	{
		
		Graphics2D g2d = (Graphics2D) g.create();

		for(int i = particles.length - 1; i >= 0;i--)
		{
			if(particles[i] != null)
			{
				particles[i].render(g2d);
			}	
		}
		g2d.dispose();
	}
	
	/**
	 * Updates the particle system
	 */
	public static void update()
	{
		updateParticles();
		updateEmitters();
		updateEffects();
	}
	
	  //----------------------------------------------------\\
	 //------------------PARTICLE METHODS--------------------\\
	//--------------------------------------------------------\\
	
	public synchronized static void addParticle(Particle2 x)
	{
		
		if(currentParticles == maxParticles)
		{
			return;
		}
		for(int i = particles.length - 1; i >= 0;i--)
		{
			if(pIterator > particles.length - 1)
				pIterator = 0;
			if(particles[pIterator] == null)
			{
				particles[pIterator] = x;
				pIterator++;
				return;
			}
			pIterator++;
		}
	}
	
	private synchronized static void updateParticles()
	{
		currentParticles = 0;
		for(int i = 0; i <= particles.length-1;i++)
		{
			if(particles[i] != null)
			{
				particles[i].update();				
				particles[i].applyForce(new Vector3D(windGlobal, gravityGlobal,0));
				
				if(particles[i].isAlive() == false)
					particles[i] = null;
				else if(particles[i].inside(boundBoxX1,boundBoxX2,boundBoxY1,boundBoxY2))
				{
					particles[i] = null;
				}
				else
					currentParticles++;
			}
		}
	}
	
	
      //----------------------------------------------------\\
	 //-------------------EMITTER METHODS--------------------\\
	//--------------------------------------------------------\\
	
	/**
	 * Removes the emitter at the given index. 
	 * @param num index of the emitter to be removed
	 */
	public static void removeEmitter( int num )
	{
		if(num >= 0)
			emitters[num] = null;
	}
	
	/**
	 * Adds the emitter to SystemX and returns its index in the backing array. 
	 * @param e the emitter being added
	 * @return the index of the emitter
	 */
	public static int addEmitter( Emitter e )
	{
		if(currentEmitters == maxEmitters)
		{
			return - 1;
		}
		for(int i = emitters.length - 1; i >= 0;i--)
		{
			if(eIterator > emitters.length - 1)
				eIterator = 0;
			if(emitters[eIterator] == null)
			{
				emitters[eIterator] = e;
				eIterator++;
				return eIterator - 1;
			}
			eIterator++;
		}
		return -1;
	}

	private static void updateEmitters()
	{
		currentEmitters = 0;
		for(int i = 0; i <= emitters.length-1;i++)
		{
			if(emitters[i] != null)
			{
				emitters[i].update();
				if(emitters[i].isAlive() == false)
				{
					emitters[i] = null;					
				}
				else
					currentEmitters++;
			}
		}
	}
	
	/**
	 * Returns the emitter at the given index. If there is no emitter it will return null. 
	 * @param i the index of the emitter
	 * @return the emitter at the given index
	 */
	public static Emitter getEmitter(int i)
	{
		if( i <= emitters.length - 1)
			return emitters[i];
		else
			return null; 
	}
	
	      //----------------------------------------------------\\
		 //-------------------EFFECT METHODS--------------------\\
		//--------------------------------------------------------\\
	/**
	 * Same as the add emitter method but instead with the effect
	 * Warning! You can add effects and emitters that die without having to worry about managing them but
	 * if the effect has an emitter that is "continuous," it will never end until it is removed or SystemX.clearEmitters()
	 * is called.
	 * @param e the effect being added
	 * @return the index of this effect
	 */
	public static int addEffect( Effect e )
	{
		if(currentEffects == maxEffects)
			return -1;
		for(int i = effects.length - 1; i >= 0;i--)
		{
			if(fxIterator > effects.length - 1)
				fxIterator = 0;
			if(effects[fxIterator] == null)
			{
				effects[fxIterator] = e;
				fxIterator++;
				return fxIterator - 1;
			}
			fxIterator++;
		}
		return -1;
	}
	
	private static void updateEffects()
	{
		currentEffects = 0;
		for(int i = 0; i <= effects.length-1;i++)
		{
			if(effects[i] != null)
				if(effects[i].update())
					effects[i] = null;
			else
				currentEffects++;
		}

	}
	
	/**
	 * Same as the emitter version. Removeds the effect at the given index
	 * @param num
	 */
	public static void removeEffect( int num )
	{
		if(num >= 0)
			effects[num] = null;
	}
	
	/**
	 * Same as the emitter version. Returns the effect at the given index. Will return null if there is no effect.
	 * @param num the index of the effect
	 * @return the effect at the given index
	 */
	public static Effect getEffect( int num )
	{
		return effects[num];
	}
	
	
	//-------------clearing Methods------------------\\
	
	/**
	 * Clears emitters. Good for scene transitions. 
	 */
	public static void clearEmitters()
	{
		emitters = new Emitter[maxEmitters];
	}
	
	/**
	 * Is use mainly to change the number of max particles.
	 */
	public static void clearParticles()
	{
		particles = new Particle2[maxParticles];
	}
	
	/**
	 * Should be called when a scene is changed to kill and continuous emitters. 
	 */
	public static void clearEffects()
	{
		effects = new Effect[maxEffects];
	}
	
	/**
	 * Set the bounding box for particles to be update/rendered. This is useful for side scrollers as we don't
	 * want to update and draw particles/emitters/effects now on the screen. 
	 * @param x1 lowest x cord allowed 
	 * @param y1 lowest y cord allowed
	 * @param x2 largest x cord allowed
	 * @param y2 largest y cord allowed
	 */
	public static void setBoundingBox(int x1, int y1, int x2, int y2)
	{
		boundBoxX1 = x1;
		boundBoxX2 = x2;
		boundBoxY1 = y1;
		boundBoxY2 = y2;
	}
	
	/**
	 * Sets the maximum number of particles. May kill all particles on the screen if the size shrinks. 
	 * @param num
	 */
	public static void setMaxParticles(int num)
	{
		Particle2[] temp = new Particle2[num];
		if(num > maxParticles)
		{
			for(int i = 0; i <= particles.length-1;i++)
			{
				temp[i] = particles[i];
			}
		}
		else
		{
			for(int i = 0; i <= temp.length-1;i++)
			{
				temp[i] = particles[i];
			}
		}
		maxParticles = num;
		particles = temp;
	}
	
	/**
	 * Set the max emitters. Emitters may be lost if the size is decreased 
	 * @param num
	 */
	public static void setMaxEmitters(int num)
	{
		Emitter[] temp = new Emitter[num];
		if(num > maxEmitters)
		{
			for(int i = 0; i <= emitters.length-1;i++)
			{
				temp[i] = emitters[i];
			}
		}
		else
		{
			for(int i = 0; i <= temp.length-1;i++)
			{
				temp[i] = emitters[i];
			}
		}
		maxEmitters = num;
		emitters = temp;
	}
	
	/**
	 * Set the max number of Effects. May lose some effects if the size shrinks. 
	 * @param num
	 */
	public static void setMaxEffects(int num)
	{
		Effect[] temp = new Effect[num];
		if(num > maxEffects)
		{
			for(int i = 0; i <= effects.length-1;i++)
			{
				temp[i] = effects[i];
			}
		}
		else
		{
			for(int i = 0; i <= temp.length-1;i++)
			{
				temp[i] = effects[i];
			}
		}
		maxEffects = num;
		effects = temp;
	}
	


}
