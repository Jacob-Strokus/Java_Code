package particles;

import java.awt.image.BufferedImage;
import java.util.Random;

public class FXexplotion implements Effect {
	private int update = 6;
	private static Random rnd = new Random();
	private int x,y;
	private int num;
	private int spreadx = 62;
	private int spready = 8;
	private BufferedImage[] im1;
	private BufferedImage[] im2;
	
	
	public FXexplotion(int xl, int yl, BufferedImage[] buff,BufferedImage[] buffy, int emit )
	{
		num = emit;
		im1 = buff;
		im2 = buffy;
		x = xl;
		y = yl;
	}
	
	public void done() 
	{
		im1 = null;
		im2 = null;
		
	}
	@Override
	public boolean update() 
	{
		if(update == 6)
		{
			update = 0;
			num--;
			FXsplash effect = new FXsplash(x+random(spreadx),y+random(spready),null,im1,im2);
			
		}
		else
			update++;
		if(num <=0 )
			return true;
		else 
			return false;
	}
	
	public double random( double num )
    {
		double temp = ((num * 2)  * rnd.nextDouble()) - num;
    		return temp;
  
    }
	
	

}
