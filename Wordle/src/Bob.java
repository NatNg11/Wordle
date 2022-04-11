import java.awt.*;
import javax.swing.*;

public class Bob extends JPanel
{
	private int x, y, w, h;  //these are instance variables
   
	
		//this is the constructor
	public Bob( int ex, int wy, int wd, int ht)
	{
		x = ex;
		y = wy;
		w = wd;
		h = ht;		
	}
	
	public void paintComponent( Graphics window )
	{

		//this rectangle shows you the boundaries of what you are drawing
		window.setColor( Color.RED );
		window.drawRect( x, y, w, h );
		//this allows us to put a png,jpg, or gif
		Graphics2D g2 = (Graphics2D) window;
    	Image img1 = Toolkit.getDefaultToolkit().getImage("img/bob.png"); /*the image cannot be in the SRC folder*/
    	g2.drawImage(img1, x , y , w , h , this);
			

	}
	
	/*these allow us to see the dimensions */
	public int getX() { return x; }
	public int getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }

}