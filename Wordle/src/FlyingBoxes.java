import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;

public class FlyingBoxes extends JPanel implements Runnable
{
	private List<Box> stuff;	
	
	public FlyingBoxes ()
	{
		setBackground(Color.WHITE);
		
		//Use a list to store lots of Boxes 
		//point stuff at new ArrayList
		
		
		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLACK);
		window.fillRect( 0,0, 800, 600);
		
		window.setColor(Color.WHITE);
		
		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
		
		//make all Boxes show and move
		
		
	}
	
	public void run()
	{

		try
		{
			while( true )
			{	
			   Thread.sleep(50);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}
}