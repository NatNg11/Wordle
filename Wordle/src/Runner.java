import javax.swing.JFrame;

public class Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Runner()
	{
		super("Wordle");

		setSize(WIDTH,HEIGHT);
		
	//	getContentPane().add( new KeyBox() ); 
		getContentPane().add(new Graphic());

		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Runner run = new Runner();
	}
}