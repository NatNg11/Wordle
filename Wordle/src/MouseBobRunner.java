import java.awt.*;
import javax.swing.*;

public class MouseBobRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public MouseBobRunner()
	{
		super("MouseBob Runner");

		setSize(WIDTH,HEIGHT);
		
		
		MouseBob mb = new MouseBob( );
		       
		add( mb );	
       	
       
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		MouseBobRunner run = new MouseBobRunner();
	}
}