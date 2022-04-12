import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;

public class Graphic extends JPanel implements Runnable
{
	private int[][] grid;	
	private char[][] letters;
	
	public Graphic()
	{
		grid = new int[6][5];
		letters = new char[6][5];
		setBackground(Color.WHITE);
		System.out.println(Arrays.deepToString(grid));
		//Use a list to store lots of Boxes 
		//point stuff at new ArrayList
		
		
		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.white);
		window.fillRect(0, 0, 800, 600);
		
		window.setColor(Color.BLACK);
		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
		
		//make all Boxes show and move
		for(int x = 250,c=0;x<grid[0].length*40+250;x+=40,c++) {
			for(int y = 100,r=0;y<grid.length*40+100;y+=40,r++) {
				switch(grid[r][c]) {
				case 0: {window.setColor(Color.blue); break; }
				case 1: { window.setColor(Color.GRAY); break; }
				case 2: { window.setColor(Color.YELLOW); break; }
				case 3: { window.setColor(Color.GREEN); break; }
				}
				window.fillRect(x, y, 30, 30);
			}
		}
		
		
		
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