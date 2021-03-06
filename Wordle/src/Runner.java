import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Runner() throws FileNotFoundException 
	{
		super("Wordle");

		setSize(WIDTH,HEIGHT);
		
		Input a = new Input();
		getContentPane().add(new Graphic());
		//getContentPane().add(a);

		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] ) throws FileNotFoundException
	{
		Runner run = new Runner();
	}
}