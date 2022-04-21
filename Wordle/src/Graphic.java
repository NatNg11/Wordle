import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;

public class Graphic extends JPanel implements Runnable, KeyListener
{
	private int[][] grid;	
	private char[][] letters;
	private String keys_typed;
	private char[] cur;
	private String key, word;
	private int k, index, ycor,currow;
	private ArrayList<String> words;
	private boolean flag, game;

	public Graphic() throws FileNotFoundException
	{
		Scanner f = new Scanner(new File("wordlewords.txt"));
		words = new ArrayList<String>();
		while(f.hasNext()) {
			words.add(f.nextLine());
		}
		
		key = "NO KEY PRESSED YET";
		word = words.get((int)(Math.random()*words.size()));;
		keys_typed = "";
		
		k = 0;
		flag = false;
	
		
		addKeyListener( this ); /*all keyListeners must have this in the constructor*/
		
		setFocusable( true );
		
		grid = new int[6][5];
		letters = new char[6][5];
		cur = new char[5];
		currow = 0;
		ycor = 95;
	//	letters[0][0] = 'N';
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
		window.drawString("Wordle", 250, 50);
		//window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
		
		//make all Boxes show and move
		for(int x = 250,c=0;x<grid[0].length*45+250;x+=45,c++) {
			for(int y = 75,r=0;y<grid.length*45+75;y+=45,r++) {
				switch(grid[r][c]) {
				case 0: {window.setColor(Color.GRAY); break; }
				case 1: { window.setColor(Color.BLACK); break; }
				case 2: { window.setColor(Color.YELLOW); break; }
				case 3: { window.setColor(Color.GREEN); break; }
				}
				window.fillRect(x, y, 40, 40);
				window.setColor(Color.white);
				window.drawString(Character.toString(letters[r][c]), x+20, y+20);
			}
		}
		
		
		for(int x = 250,in=0; x<cur.length*45+250;x+=45,in++) {
			if(cur[in]!=' ') {
				window.drawString(Character.toString(cur[in]), x+20, ycor);
			}
		}
		
//		if(keys_typed.length()!=0) 
//		{
//			window.setColor(Color.black);
//			window.fillRect(90, 400, keys_typed.length()*7 + 20, 30);
//			
//		}
//			
//		window.setColor(Color.green);
//		window.drawString( keys_typed, 100, 420 );
		window.setColor(Color.green);
		window.drawString(word,100,420);
		
		if(flag) {
			window.drawString("Not in word list", 100, 420);
			flag = false;
		}
	
		
	}
	/*KeyListeners must have these 3 methods:
	 * You do not have to have code in any of these, they can be empty.
	 * But they all must be in your KeyListener for it to work.
	 */
		
		/*1 */
		public void keyTyped(KeyEvent e)
		{
			keys_typed += "" + e.getKeyChar();
			
		
			
			System.out.println(Arrays.toString(cur));
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
				k = e.getKeyCode();
				System.out.println(k);
			}
			//put typed characters into array
			if(e.getKeyCode()==8) {
				if(index>0) {
				System.out.println(index);
				cur[--index]= ' ';
				}
			}
			else if(!(index>=cur.length||e.getKeyCode()==10)) {
				cur[index++] = e.getKeyChar();
			}
			
			//check if enter key pressed
			if(e.getKeyCode()==10&&currow<6) {
				if(index==5) {
				letters[currow] = cur;
				//check if word is a real word
				if(words.contains(String.valueOf(cur))) {
				//check if letters are part of the word
					for(int x =0;x<cur.length;x++) {
						if(cur[x]==word.charAt(x)) {
							grid[currow][x] = 3;
						}
						else if(word.contains(Character.toString(cur[x]))){
							grid[currow][x] = 2;
						}
						else {
							grid[currow][x] = 1;
						}
					}
					cur = new char[5];
					currow++;
					ycor+=45;
					index = 0;
				}
				else if(currow>=6){
					//"Word not in word list"
					flag = true;
					
				}
				}
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
				k = e.getKeyCode();
			}
			repaint();
			
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