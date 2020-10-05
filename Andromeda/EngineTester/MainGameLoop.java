package EngineTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import audio.AudioMaster;
import audio.Source;
import button.AbstractButton;
import button.Button;
import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import gui.GuiRenderer;
import gui.GuiTexture;
import models.RawModel;
import models.TexturedModels;
import normalMappingObjConverter.NormalMappingObjLoader;
import objConverter.OBJFileLoader2;
import particles.ParticleMaster;
import particles.ParticleSystem;
import particles.ParticleTexture;
import postProcessing.Fbo;
import postProcessing.PostProcessing;
import projectiles.Projectile;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import skyBox.SkyboxRenderer;
import terrains.Terrain;
import terrains.TerrainTexture;
import terrains.TerrainTexturePack;
import textures.ModelTexture;
import toolbox.MousePicker;
import water.WaterFrameBuffers;
import water.WaterRenderer;
import water.WaterShader;
import water.WaterTile;

public class MainGameLoop {
	
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		
		// default
		TexturedModels person = new TexturedModels(OBJFileLoader2.loadOBJ("person", loader),
				new ModelTexture(loader.loadTexture("White")));
		Player player = new Player(person, new Vector3f(390, 1, -285), 0, 250, 0, 1f);
		player.getModel().getTexture().setHasTransparency(true);

		List<Entity> entities = new ArrayList<Entity>();
		// entities.add(mount1);
		entities.add(player);

		// ********************* TERRAIN TEXTURE ************************************************************
		TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy3"));
		TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("grassFlowers"));
		TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("dirt3"));
		TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("pathway"));

		TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap4"));
		
		//procedural terrain generation
		Terrain terrain2 = new Terrain(0, -1, loader, texturePack, blendMap);
		
		//Terrain.SIZE = 150;
		
		//terrain generation with heightMap
		//Terrain terrain = new Terrain(0, 1, loader, texturePack, blendMap, "pond");
	
		List<Terrain> terrains = new ArrayList<>();
		terrains.add(terrain2);
		//terrains.add(terrain);
		// ********************* TERRAIN TEXTURE ************************************************************
		

		Camera camera = new Camera(player);
		MasterRenderer renderer = new MasterRenderer(loader, camera);
		ParticleMaster.init(loader, renderer.getProjectionMatrix());
		MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix(), terrain2);
		
		
		
		/********************  MOUNTS  ****************************************************************
		TexturedModels alien_mount = new TexturedModels(OBJFileLoader2.loadOBJ("Alien Animal", loader),
				new ModelTexture(loader.loadTexture("alien_creep")));
		
		float mountX =380;
		float mountZ = -280;
		float mountY = terrain.getHeightOfTerrain(mountX, mountZ);
		Mount mount1 = new Mount(alien_mount, new Vector3f(mountX, mountY + (float) 0.5, mountZ), 0, 100, 0, 0.6f);
		//********************  MOUNTS  ****************************************************************/
		
		
		
		
		
		
		
		
		//***********************  MODELS  **************************************************************
		 TexturedModels projectileModel = new TexturedModels(OBJFileLoader2.loadOBJ("projectile", loader),
	                new ModelTexture(loader.loadTexture("darkBlue")));
		 
		 TexturedModels houseModel = new TexturedModels(OBJFileLoader2.loadOBJ("FantasyHouse", loader),
	                new ModelTexture(loader.loadTexture("FantasyHouseTexture")));
		 
	/*	 TexturedModels arrowModel = new TexturedModels(OBJFileLoader2.loadOBJ("arrow", loader),
	                new ModelTexture(loader.loadTexture("light_blue")));*/
		
        TexturedModels bobble = new TexturedModels(OBJFileLoader2.loadOBJ("pine", loader),
                new ModelTexture(loader.loadTexture("pine")));
        bobble.getTexture().setHasTransparency(true);
        
        TexturedModels flower = new TexturedModels(OBJFileLoader2.loadOBJ("singleFlowerModel", loader),
                new ModelTexture(loader.loadTexture("flower")));
        flower.getTexture().setHasTransparency(true);
        flower.getTexture().setUseFakeLighting(true);
        
        TexturedModels flower2 = new TexturedModels(OBJFileLoader2.loadOBJ("singleFlowerModel", loader),
                new ModelTexture(loader.loadTexture("flower2")));
        flower2.getTexture().setHasTransparency(true);
        flower2.getTexture().setUseFakeLighting(true);

        ModelTexture fernTextureAtlas = new ModelTexture(loader.loadTexture("fernTextureAtlas"));
        fernTextureAtlas.setNumberOfRows(2);
 
        TexturedModels fern = new TexturedModels(OBJFileLoader2.loadOBJ("fern", loader),
                fernTextureAtlas);
        fern.getTexture().setHasTransparency(true);
        
        RawModel lampModel =  OBJFileLoader2.loadOBJ("lamp", loader);
		
		TexturedModels lamp = new TexturedModels(lampModel, new ModelTexture(loader.loadTexture("lamp2")));
		lamp.getTexture().setUseFakeLighting(true);
		//***********************  MODELS  **************************************************************
		
		
		
		
        
        
        
		
        //******************NORMAL MAP MODELS************************
        
        TexturedModels barrelModel = new TexturedModels(NormalMappingObjLoader.loadOBJ("barrel", loader),
                new ModelTexture(loader.loadTexture("barrel")));
        barrelModel.getTexture().setNormalMap(loader.loadTexture("barrelNormal"));
        barrelModel.getTexture().setShineDamper(10);
        barrelModel.getTexture().setReflectivity(0.5f);
        

        TexturedModels boulderModel = new TexturedModels(NormalMappingObjLoader.loadOBJ("boulder", loader),
                new ModelTexture(loader.loadTexture("boulder")));
        boulderModel.getTexture().setNormalMap(loader.loadTexture("boulderNormal"));
        boulderModel.getTexture().setShineDamper(5);
        boulderModel.getTexture().setReflectivity(0.2f);
        //************ NORMAL ENTITIES*******************
        List<Entity> normalMapEntities = new ArrayList<>();
       
        //************ NORMAL ENTITIES*******************
        
        
        
 
        
       
		
		
        //****************************  CAMERA & LIGHTING  ********************************************
		List<Light> lights = new ArrayList<>();
		Light sun = new Light(new Vector3f(10000, 10000, 10000), new Vector3f(1.8f, 1.8f, 1.8f));
		lights.add(sun);
		boolean night = SkyboxRenderer.isNightTime();
		boolean transition = SkyboxRenderer.isTransition();
		//****************************  CAMERA & LIGHTING  ********************************************
		
		
		
		
		
	
        
        
        
		
		
		//******************************  LOAD ENTITIES  ************************************************
		Random random = new Random(5666778);

		entities.add(new Entity(houseModel, new Vector3f(350, 1, -250), 0, 0, 0, 50f));
		
		for (int i = 0; i < 500; i++) {

			/*
			 * if(i % 50 == 0) { float x = random.nextFloat() * 599; float z =
			 * random.nextFloat() * -599; if ((x > 50 && x < 100) || (z < -50 && z > -100))
			 * { } else { float y = terrain.getHeightOfTerrain(x, z);
			 * normalMapEntities.add(new Entity(barrelModel, new Vector3f(x, y + 3, z), 0,
			 * 0, 0, 0.5f)); } }
			 */

			/*
			 * if (i % 139 == 0) { float x = random.nextFloat() * 599; float z =
			 * random.nextFloat() * -599; float y = terrain2.getHeightOfTerrain(x, z);
			 * 
			 * lights.add(new Light(new Vector3f(x, y + 15, z), new Vector3f(2, (float) 0.7,
			 * (float) 0.1), new Vector3f(1, 0.01f, 0.002f))); entities.add(new Entity(lamp,
			 * new Vector3f(x, y, z), 0, 0, 0, 1)); }
			 */

			if (i % 13 == 0) {
				float x = random.nextFloat() * 1200;
				float z = random.nextFloat() * -1200;
				float y = terrain2.getHeightOfTerrain(x, z);
				Entity rocks = new Entity(boulderModel, new Vector3f(x, y, z), 0, 0, 0, 2f);
				normalMapEntities.add(rocks);
			}

			if (i % 3 == 0) {
				float x = random.nextFloat() * 1200;
				float z = random.nextFloat() * -1200;
				float y = terrain2.getHeightOfTerrain(x, z);

				entities.add(new Entity(fern, random.nextInt(4), new Vector3f(x, y, z), 0, random.nextFloat() * 360, 0,
						1.2f));

			}
			if (i % 2 == 0) {
				float x = random.nextFloat() * 1200;
				float z = random.nextFloat() * -1200;
				float y = terrain2.getHeightOfTerrain(x, z);

				entities.add(new Entity(flower2, random.nextInt(9), new Vector3f(x, y, z), 0, random.nextFloat() * 360,
						0, 4.2f));

				x = random.nextFloat() * 1200;
				z = random.nextFloat() * -1200;
				y = terrain2.getHeightOfTerrain(x, z);

				entities.add(new Entity(flower, new Vector3f(x, y, z), 0, random.nextFloat() * 360, 0, 4.2f));

			}
			if (i % 3 == 0) {

				float x = random.nextFloat() * 1200;
				float z = random.nextFloat() * -1200;
				float y = terrain2.getHeightOfTerrain(x, z);

				entities.add(new Entity(bobble, new Vector3f(x, y, z), 0, random.nextFloat() * 360, 0,
						random.nextFloat() * 0.8f + 1.8f));

			}
		}
		//******************************  LOAD ENTITIES  ************************************************
		
		
		 
        
		
		
		
		//******************************  LOAD GUI  ******************************************************
		List<GuiTexture> guis = new ArrayList<>();	
		List<GuiTexture> inventoryList = new ArrayList<>();
		GuiTexture gui = new GuiTexture(loader.loadTexture("Andromeda2"), new Vector2f(0.8f, 0.8f), new Vector2f(0.15f, 0.15f));
		GuiTexture sideBar = new GuiTexture(loader.loadTexture("button2"), new Vector2f(0.9f, 0.01f),  new Vector2f(0.065f, 0.55f));
		GuiTexture inventory = new GuiTexture(loader.loadTexture("button2"), new Vector2f(0.67f, 0.01f),  new Vector2f(0.15f, 0.55f));
		guis.add(gui);
		GuiRenderer guiRenderer = new GuiRenderer(loader);
		
		AbstractButton button1 = new AbstractButton(loader, "backpack", new Vector2f(0.9f, 0.4f),  new Vector2f(0.035f, 0.065f)) {
			
			@Override
			public void onClick(Button button) {
				
				if (button.getMouseClickedCounter() == 1)
					guis.add(inventory);
				
				if (button.getMouseClickedCounter() > 1) {
					guis.remove(inventory);
					button.setMouseClickedCounter(0);
				}
				
			}
			
			@Override
			public void startHovering(Button button) {
				button.playHoverAnimation(0.01f);
			}

			@Override
			public void stopHovering(Button button) {
				button.resetScale();
			}

			@Override
			public void whileHovering(Button button) {
				
			}

			
		};
		
		AbstractButton button2 = new AbstractButton(loader, "crafting", new Vector2f(0.9f, 0.28f),  new Vector2f(0.035f, 0.065f)) {
			
			@Override
			public void onClick(Button button) {
				
				if (button.getMouseClickedCounter() == 1)
					guis.add(inventory);
				
				if (button.getMouseClickedCounter() > 1) {
					guis.remove(inventory);
					button.setMouseClickedCounter(0);
				}
				
			}
			
			@Override
			public void startHovering(Button button) {
				button.playHoverAnimation(0.01f);
			}

			@Override
			public void stopHovering(Button button) {
				button.resetScale();
			}

			@Override
			public void whileHovering(Button button) {
				
			}

			
		};
		
		AbstractButton button3 = new AbstractButton(loader, "spellBook", new Vector2f(0.9f, 0.1f),  new Vector2f(0.035f, 0.065f)) {
			
			@Override
			public void onClick(Button button) {
				
				if (button.getMouseClickedCounter() == 1)
					guis.add(inventory);
				
				if (button.getMouseClickedCounter() > 1) {
					guis.remove(inventory);
					button.setMouseClickedCounter(0);
				}
				
			}
			
			@Override
			public void startHovering(Button button) {
				button.playHoverAnimation(0.01f);
			}

			@Override
			public void stopHovering(Button button) {
				button.resetScale();
			}

			@Override
			public void whileHovering(Button button) {
				
			}

			
		};
		//******************************  LOAD GUI  ******************************************************
		
		
		
		
		
		
		//******************************  PARTICLE SYSTEM  ************************************************
      
        // boolean to use additive blending (true) or alpha blending (false)
        ParticleTexture particleTexture = new ParticleTexture(true, loader.loadTexture("cosmic2"), 4);
        ParticleTexture particleTexture2 = new ParticleTexture(true, loader.loadTexture("particleAtlas4"), 6);
        ParticleTexture particleTexture3 = new ParticleTexture(true, loader.loadTexture("particleAtlas5"), 5);
        ParticleTexture explosion = new ParticleTexture(true, loader.loadTexture("particleAtlas"), 6);
        ParticleTexture particleTexture4 = new ParticleTexture(true, loader.loadTexture("fire3"), 8);
    
        ParticleTexture particleTexture6 = new ParticleTexture(true, loader.loadTexture("smoke"), 4);
        /*  particles per second
         * 	speed
         *  gravity effect in particle
         *  lifeLength
         *  scale
         */ 
        ParticleSystem system1 = new ParticleSystem(particleTexture, 65, 5, -0.1f, (float) 0.8, 10.6f);
        system1.setLifeError(0.1f);
        system1.setSpeedError(0.25f);
        system1.setScaleError(0.5f);
        system1.randomizeRotation();
        
     
        ParticleSystem system2 = new ParticleSystem(particleTexture2, 105, 5, -0.1f, (float) 0.8, 5.6f);
        system2.setLifeError(0.1f);
        system2.setSpeedError(0.25f);
        system2.setScaleError(0.5f);
        system2.randomizeRotation();
        
        ParticleSystem system3 = new ParticleSystem(particleTexture3, 105, 5, -0.1f, (float) 0.8, 15.6f);
        system3.setLifeError(0.1f);
        system3.setSpeedError(0.25f);
        system3.setScaleError(0.5f);
        system3.randomizeRotation();
        
        ParticleSystem system4 = new ParticleSystem(particleTexture4, 25, 5, -0.001f, (float) 1.6, 100.6f); 
        system3.setLifeError(0.1f);
        system3.setSpeedError(0.25f);
        system3.setScaleError(0.5f);
        system3.randomizeRotation();
        
        ParticleSystem system6 = new ParticleSystem(particleTexture6, 105, 5, -0.01f, (float) 1.0, 100.6f);
        system3.setLifeError(0.1f);
        system3.setSpeedError(0.25f);
        system3.setScaleError(0.5f);
        system3.randomizeRotation();
        
        ParticleSystem system7 = new ParticleSystem(explosion, 105, 5, -0.01f, (float) 1.0, 100.6f);
        system3.setLifeError(0.1f);
        system3.setSpeedError(0.25f);
        system3.setScaleError(0.5f);
        system3.randomizeRotation();
    
    
        /**
         * 3D particle effects!
         */
    	//ParticleVao vao = ParticleVao.create(loader);
        //ParticleSystemDemo particles = new ParticleSystemDemo();
        
        /**
         * new particle system!!! **********   SystemX   **********
         */
     
      
        /*	FXfire fire = new FXfire((int) projectile.getPosition().x, (int) projectile.getPosition().y, null, null);
		
		Particle2 p = new Particle2(projectile.getPosition().x, projectile.getPosition().y, projectile.getPosition().z,
				2.0, 2.0, 2.0, null);
		Emitter e = new Emitter();
		SystemX.addParticle(p);
		SystemX.addEmitter(e);
	   */

    	//******************************  PARTICLE SYSTEM  ************************************************
        
        
        
        

        
        
    	//******************************   FBOS  **********************************************************
        Fbo multisampledFbo = new Fbo(Display.getWidth(), Display.getHeight());
        Fbo outputFbo = new Fbo(Display.getWidth(), Display.getHeight(), Fbo.DEPTH_TEXTURE);
        PostProcessing.init(loader);
    	//******************************   FBOS  **********************************************************
        
        
        
        
        
        
        //******************************* PROJECTILES *****************************************************
        Projectile projectile = new Projectile(projectileModel,
				new Vector3f(player.getPosition().x, player.getPosition().y +10, player.getPosition().z), 0, 0, 0,
				0.2f);
    /*    Projectile arrow = new Projectile(arrowModel,
				new Vector3f(player.getPosition().x, player.getPosition().y +5, player.getPosition().z), 0.4f, 0, 0,
				25.2f);*/
      
       boolean fire = false;
       boolean p1 = false;
       boolean p2 = false;
       boolean p3 = false;
       boolean p4 = false;
      // float counter = 50;
       //******************************* PROJECTILES *****************************************************
        
        
       
       
       
       
       
       
   	   //********************* WATER SHADING & RENDERER SEUP **********************************************
	   WaterFrameBuffers buffers = new WaterFrameBuffers();
       WaterShader waterShader = new WaterShader();
       WaterRenderer waterRenderer = new WaterRenderer(loader, waterShader, renderer.getProjectionMatrix(), buffers);
       List<WaterTile> waters = new ArrayList<WaterTile>();
       //centerX, centerZ, height
       WaterTile water = new WaterTile(505, -505, -15); 
       waters.add(water);
       //********************* WATER SHADING & RENDERER SEUP ***********************************************
       
       
       
       
       
       
       
       
        //******************************   AUDIO  **********************************************************
        List<Source> sources = new ArrayList<>();
        AudioMaster.init();
        AudioMaster.setListenerData(player.getPosition().x, player.getPosition().y, player.getPosition().z);
        int buffer = AudioMaster.loadSound("Audio/explosion1.wav"); // <-- sound file goes here
        int buffer2 = AudioMaster.loadSound("Audio/birds.wav"); // <-- sound file goes here
        int buffer3 = AudioMaster.loadSound("Audio/water.wav"); // <-- sound file goes here
		Source source = new Source();
		Source source2 = new Source();
		Source source3 = new Source();
		source2.setPosition(water.getX(), water.getHeight(), water.getZ());
		AL10.alDistanceModel(AL10.AL_INVERSE_DISTANCE_CLAMPED);
		sources.add(source);
		sources.add(source2);
		sources.add(source3);
		
		source3.setPosition(305, water.getHeight(), -305);
		source3.play(buffer3);
		source3.setVolume(0.01f);
		
		source2.setVolume(0.025f);
		source2.play(buffer2);
		source2.setLooping(true);
		//******************************   AUDIO  **********************************************************
        
        
        
       
       
    
       
       List<Player> clones = new ArrayList<>();
       
       
       
       
       
       
       
        
        
       //******************************* RUN GAME *****************************************************
		while (!Display.isCloseRequested()) {
			// mount1.move(terrain);
			player.move(terrain2);
			camera.move();
			picker.update(entities, normalMapEntities);
			night = SkyboxRenderer.isNightTime();
			transition = SkyboxRenderer.isTransition();
			skyColor(night, transition, sun, lights);
			//camera.rotate();
			
			button1.update();
			button2.update();			
			button3.update();			
			inventory(button1, button2, button3, inventoryList, guis, sideBar, inventory);
		
			Vector3f terrainPoint = picker.getCurrentTerrainPoint();
			boolean launch = input(entities, projectile, terrainPoint);
			boolean one = launchSequence();
			boolean two = launchSequence2();
			boolean three = launchSequence3();
			boolean four = launchSequence4();
			
			if (one) {
				p1 = true;
			} else if (two) {
				p2 = true;
			} else if (three) {
				p3 = true;
			} else if (four) {
				p4 = true;
			}

			system4.generateParticles(
					new Vector3f(player.getPosition().x, player.getPosition().y + 8, player.getPosition().z));
			if (launch) {
				fire = true;
			}
			if (fire) {
				if (terrainPoint != null) {
					if (p1) {
						for (int i = 0; i < 4; i++) {
							system1.generateParticles(projectile.getPosition());
							Vector3f trajectory = calculateVectorAngle(projectile, terrainPoint);
							if (trajectory != null) {
								projectile.setPosition(trajectory);
								boolean collision = projectile.collesionDetection(terrain2, system1);
								if (collision) {
									fire = false;
									p1 = false;
									p2 = false;
									p3 = false;
									p4 = false;
								}
							}
						}
					} else if (p2) {
						for (int i = 0; i < 4; i++) {
							system2.generateParticles(projectile.getPosition());
							Vector3f trajectory = calculateVectorAngle(projectile, terrainPoint);
							if (trajectory != null) {
								projectile.setPosition(trajectory);
								boolean collision = projectile.collesionDetection(terrain2, system2);
								if (collision) {
									fire = false;
									p1 = false;
									p2 = false;
									p3 = false;
									p4 = false;
								}
							}
						}
					} else if (p3) {
						for (int i = 0; i < 4; i++) {
							system3.generateParticles(projectile.getPosition());
							Vector3f trajectory = calculateVectorAngle(projectile, terrainPoint);
							if (trajectory != null) {
								projectile.setPosition(trajectory);
								boolean collision = projectile.collesionDetection(terrain2, system7);
								if (collision) {
									source.setVolume(0.25f);
									source.play(buffer);
									entities.remove(projectile);
									fire = false;
									p1 = false;
									p2 = false;
									p3 = false;
									p4 = false;
								}
							}
						}
					} else if (p4) {
						for (int i = 0; i < 4; i++) {
							system6.generateParticles(projectile.getPosition());
							Vector3f trajectory = calculateVectorAngle(projectile, terrainPoint);
							if (trajectory != null) {
								projectile.setPosition(trajectory);
								boolean collision = projectile.collesionDetection(terrain2, system6);
								if (collision) {
									entities.remove(projectile);
									fire = false;
									p1 = false;
									p2 = false;
									p3 = false;
									p4 = false;
								}
							}
						}
					}
				} // end fire
			} else {
				entities.remove(projectile);
				entities.remove(projectile);
				projectile = new Projectile(projectileModel,
						new Vector3f(player.getPosition().x, player.getPosition().y + 15, player.getPosition().z), 0, 0,
						0, 10.2f);
			}

			/* if (iconic.theif) {

				

				if (!p1) {
					system5.generateParticles(
							new Vector3f(player.getPosition().x, player.getPosition().y + 8, player.getPosition().z));
				}

				if (p1 && !p2 && !p3) {
					if (counter > 0) {

						counter--;
						player.setModel(new TexturedModels(OBJFileLoader2.loadOBJ("theif_cloak", loader),
								new ModelTexture(loader.loadTexture("theif_cloak"))));
					} else {
						p1 = false;
						player.setModel(new TexturedModels(OBJFileLoader2.loadOBJ("person", loader),
								new ModelTexture(loader.loadTexture("Theif"))));
						counter = 50;
					}
				} // end p1

				else if (p2 && !p1 && !p3) {

					if (counter > 0) {

						counter--;

						clones.add(Theif.createTrail(player, person));

						Player.RUN_SPEED = 125;
					} else {
						clones.clear();
						p2 = false;
						Player.RUN_SPEED = 50;
						counter = 50;
					}
				} // end p2

				else if (p3 && !p1 && !p2) {

					boolean addClone = p3;

					if (addClone) {
						clones = Theif.addClones(player, person);
						addClone = false;
					}

					for (Player clone : clones) {
						clone.move(terrain2);
					}

					Theif.decoyTime--;
					if (Theif.decoyTime <= 0) {

						clones.clear();
						Theif.decoyTime = 100;
						p3 = false;

					}
				} // end p3

			} // end thief
*/
			ParticleMaster.update(camera);

			projectile.increaseRotation(0.5f, 0.5f, 0.5f);

			renderer.renderShadowMap(entities, normalMapEntities, sun);

			GL11.glEnable(GL30.GL_CLIP_DISTANCE0);

			// render reflection texture
			buffers.bindReflectionFrameBuffer();
			float distance = 2 * (camera.getPosition().y - water.getHeight());
			camera.getPosition().y -= distance;
			camera.invertPitch();
			renderer.renderScene(clones, entities, normalMapEntities, terrains, lights, camera,
					new Vector4f(0, 1, 0, -water.getHeight() + 1));
			camera.getPosition().y += distance;
			camera.invertPitch();

			// render refraction texture
			buffers.bindRefractionFrameBuffer();
			renderer.renderScene(clones, entities, normalMapEntities, terrains, lights, camera,
					new Vector4f(0, -1, 0, water.getHeight()));

			// render to screen
			GL11.glDisable(GL30.GL_CLIP_DISTANCE0);
			buffers.unbindCurrentFrameBuffer();

			// post processing
			multisampledFbo.bindFrameBuffer();
			renderer.renderScene(clones, entities, normalMapEntities, terrains, lights, camera,
					new Vector4f(0, -1, 0, 100000));
			waterRenderer.render(waters, camera, sun);
			ParticleMaster.renderParticles(camera);
			multisampledFbo.unbindFrameBuffer();
			multisampledFbo.resolveToFbo(outputFbo);
			PostProcessing.doPostProcessing(outputFbo.getColourTexture());

			guiRenderer.render(guis);
			guiRenderer.render(inventoryList);

			DisplayManager.updateDisplay();
		}

		//******************************* CLEAN UP *****************************************************
		multisampledFbo.cleanUp();
		outputFbo.cleanUp();
		PostProcessing.cleanUp();
		buffers.cleanUp();
		waterShader.cleanUp();
		guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		ParticleMaster.cleanup();
		source.delete(sources);
		AudioMaster.cleanUp();
		DisplayManager.closeDisplay();
		//******************************* CLEAN UP *****************************************************
	}

	public static boolean launchSequence() {

		if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
			return true;
		}
		return false;
	} // end launchSequence2

	public static boolean launchSequence2() {

		if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
			return true;
		}
		return false;
	} // end launchSequence2

	public static boolean launchSequence3() {

		if (Keyboard.isKeyDown(Keyboard.KEY_3)) {
			return true;
		}
		return false;
	} // end launchSequence3

	public static boolean launchSequence4() {

		if (Keyboard.isKeyDown(Keyboard.KEY_4)) {
			return true;
		}
		return false;
	} // end launchSequence4

	private static void skyColor(boolean night, boolean transition, Light sun ,List<Light> lights) {
		if (night) {
			MasterRenderer.BLUE = 0;
			MasterRenderer.GREEN = 0;
			MasterRenderer.RED = 0;
			sun = new Light(new Vector3f(10000, 10000, 10000), new Vector3f(0f,0f,0f));
			lights.remove(0);
			lights.add(0, sun);
		} if (transition){
			MasterRenderer.RED = 0.52f;
			MasterRenderer.GREEN = 0.34f;
			MasterRenderer.BLUE = 0.34f;
			sun = new Light(new Vector3f(10000, 10000, 10000), new Vector3f(0.9f, 0.9f, 0.9f));
			lights.remove(0);
			lights.add(0, sun);
		
		} else if (!transition && !night) {
			MasterRenderer.RED = 0.43f;
			MasterRenderer.GREEN = 0.52f;
			MasterRenderer.BLUE = 0.6f;
			sun = new Light(new Vector3f(10000, 10000, 10000), new Vector3f(1.8f, 1.8f, 1.8f));
			lights.remove(0);
			lights.add(0, sun);
		}
	}

	public static Vector3f calculateVectorAngle(Entity projectile, Vector3f terrainPoint) {

		float speed = 2f;

		float dx = terrainPoint.x - projectile.getPosition().x;
		float dy = terrainPoint.y - projectile.getPosition().y;
		float dz = terrainPoint.z - projectile.getPosition().z;
		
		

		double angle = Math.atan2(dy, dx);
		double angleZ = Math.atan(dz);
	

		float x = projectile.getPosition().x += speed * Math.cos(angle);
		float y = projectile.getPosition().y += speed * Math.sin(angle);
		float z = projectile.getPosition().z += speed * Math.sin(angleZ);

		return new Vector3f (x,y,z);
	}
	
	public static void inventory(AbstractButton button, AbstractButton button2, AbstractButton button3,
			List<GuiTexture> inventoryList, List<GuiTexture> guis, GuiTexture sideBar, GuiTexture inventory) {

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					if (button.isHidden()) {
						guis.add(sideBar);
						button.show(inventoryList);

					} else {
						button.hide(inventoryList);
						guis.remove(sideBar);
						guis.remove(inventory);
					}

					if (button2.isHidden()) {

						button2.show(inventoryList);

					} else {
						button2.hide(inventoryList);

					}

					if (button3.isHidden()) {

						button3.show(inventoryList);

					} else {
						button3.hide(inventoryList);

					}
				}
			}
		}

	}
	
	public static boolean input(List<Entity> entities, Projectile projectile, Vector3f terrainPoint) {
		
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_1 && terrainPoint != null) {
					
					entities.add(projectile);
					return true;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_2 && terrainPoint != null) {
					
					
					entities.add(projectile);
					return true;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_3 && terrainPoint != null) {
				
					entities.add(projectile);
					return true;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_4 && terrainPoint != null) {
				
					entities.add(projectile);
					return true;
				}
			}
		}
		return false;
	} //end input

}