import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/

// this is only to test if the keys are pressed.
public class KeyBox extends Canvas implements KeyListener
{
	private String keys_typed;
	private String key;

	
		//this is the constructor
	public KeyBox( )
	{	
		key = "NO KEY PRESSED YET";

		keys_typed = "";
		
		addKeyListener( this ); /*all keyListeners must have this in the constructor*/
		
		setFocusable( true );
	}
	

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,800,600);
		
		window.setColor(Color.red);		
		window.drawString( "Please type something!", 250, 100 );
		
		if(keys_typed.length()!=0) 
		{
			window.setColor(Color.black);
			window.fillRect(90, 130, keys_typed.length()*7 + 20, 30);
		}
			
		window.setColor(Color.green);
		window.drawString( keys_typed, 100, 150 );
		
		window.setColor(new Color( 100, 0, 100 ));		
		window.drawString( key, 250, 200 );
		
	}
	
/*KeyListeners must have these 3 methods:
 * You do not have to have code in any of these, they can be empty.
 * But they all must be in your KeyListener for it to work.
 */
	
	/*1 */
	public void keyTyped(KeyEvent e)
	{
		keys_typed += "" + e.getKeyChar();
		repaint();
	}
	
	/*2*/
	public void keyPressed(KeyEvent e)
	{
		/*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			key = ">>>>>>";
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
			key = "<<<<<<";
		}
		//add another else if to check if another key was pressed..
		else {
			key = "Key " + e.getKeyCode() + " is pressed!";
		}
		repaint();
	}
	
	/*3*/	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			key = "The right arrow key was released!";
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
			key = "The left arrow key was released!";
		}
		//add another else if to check if another key was released..
		else{
			key = "Key "+ e.getKeyCode() +" was released!";
		}
		repaint();
		
	}

}