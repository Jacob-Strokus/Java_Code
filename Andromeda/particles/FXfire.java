package particles;

import java.awt.image.BufferedImage;

public class FXfire implements Effect{
	
	public int fire;
	public int smoke;
	public int embers;
	
	public FXfire(int x, int y, BufferedImage[] smoke1, BufferedImage[] smoke2)
	{
		
        Emitter t = new Emitter(x,y,6,true,1,1,smoke1);
        t.setFadeRate(.03);
        t.setEmitNum(4);
        t.setMaxAge(500);
        t.setSize(64);
        t.setGrowthRate(-1.9);
        t.setAngle(260,280);
        t.setVelocity(2.5, 2.5);
        
        t.setSpread(16,16);
        t.setBlink(true);
        t.setFade(0);
        t.setScale(1.2);
        fire = SystemX.addEmitter(t);
        
        t = new Emitter(x,y-26,6,true,1,25,smoke2);
        t.setFadeRate(.0041);
        t.setEmitNum(2);
        t.setMaxAge(500);
        t.setSize(32);
        t.setGrowthRate(0.9);
        t.setAngle(260,280);
        t.setVelocity(2.8,1.8f);
        t.setMaxSize(256);
        t.setSpread(8,16);
        //t.setBlink(true);
        t.setFade((Math.random()*.2) + .4);
        t.setScale(1.2);
        smoke = SystemX.addEmitter(t);
        
        
        t = new Emitter(x,y-16,6,true,1,10,smoke1);
        t.setFadeRate(.01);
        t.setEmitNum(2);
        t.setMaxAge(500);
        t.setSize(12);
        t.setGrowthRate(-.1);
        t.setAngle(250,290);
        t.setVelocity(3.5, 3.5);
        
        t.setSpread(16,16);
        t.setScale(1.2);
        embers = SystemX.addEmitter(t);
	}

	
	public void done()
	{
		SystemX.removeEmitter(smoke);
		SystemX.removeEmitter(fire);
		SystemX.removeEmitter(embers);
	}


	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	


}

