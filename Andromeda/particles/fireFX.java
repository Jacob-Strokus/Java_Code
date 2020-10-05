package particles;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class fireFX implements Effect{
	
	public int fire;
	public int smoke;
	public int embers;
	
	public fireFX(int x, int y, BufferedImage[] smoke1, BufferedImage[] smoke2)
	{
		
        Emitter t = new Emitter(x,y,6,true,1,2,smoke1);
        t.setFadeRate(.02);
        t.setEmitNum(4);
        t.setMaxAge(500);
        t.setSize(32);
        t.setGrowthRate(-1.4);
        t.setAngle(260,280);
        t.setVelocity(2.5, 2.5);
        
        t.setSpread(16,16);
        t.setBlink(true);
        t.setFade(0);
        t.setColor(new Color(99,2,255));
        fire = SystemX.addEmitter(t);
        
        t = new Emitter(x,y-24,6,true,1,25,smoke2);
        t.setFadeRate(.004);
        t.setEmitNum(1);
        t.setMaxAge(500);
        t.setSize(64);
        t.setGrowthRate(1);
        t.setAngle(260,280);
        t.setVelocity(1.2,1.2f);
        t.setMaxSize(512);
        t.setSpread(128,128);
        t.setBlink(true);
        t.setFade(0);
        
        //smoke = SystemX.addEmitter(t);
        
        
        t = new Emitter(x,y,6,true,1,2,smoke1);
        t.setFadeRate(.02);
        t.setEmitNum(2);
        t.setMaxAge(500);
        t.setSize(4);
        t.setGrowthRate(-.05);
        t.setAngle(170,360);
        t.setVelocity(1.5, 1.5);
        t.setBlink(true);
        t.setFade(0);
        t.setColor(new Color(99,2,255));
        t.setSpread(16,16);
      
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
		return false;
	}
	


}
