package particles;

import java.awt.image.BufferedImage;

public class FXtail implements Effect {
	
	private int x,y;
	private int smoke;
	
	public FXtail(int x, int y, BufferedImage[] buffy)
	{
		Emitter t;
		t = new Emitter(x,y,0,true,1,1,buffy);
		t.setFadeRate(.0009);
        t.setEmitNum(1);
        t.setMaxAge(1000);
        t.setSize(2);
        t.setGrowthRate(3.5);
        t.setAngle(0,360);
        t.setVelocity(.2,.2);
         t.setAcc(0, -.003);
        t.setMaxSize(1024);
        // t.setRandomV(true);
        t.setSpread(16,16);
        //t.setBlink(true);
        t.setFade(.2);
        t.setScale(4);
        t.scaleSpeed(1);
        smoke = SystemX.addEmitter(t);
	}
	
	
	public boolean update()
	{
		return false;
	}
	
	public void jump(int locx, int locy)
	{
		SystemX.getEmitter(smoke).jump(locx, locy);
	}



	public void done() 
	{

		
	}

}
