import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class randomWord {
	ArrayList<String> words; 

	public static void main(String[] args) throws Exception {
		
	}

	public randomWord() throws FileNotFoundException {
		//Scanner f = new Scanner(new File(".dat"));
		Scanner f = new Scanner(new File("wordlewords.txt"));
		words = new ArrayList<String>();
		while(f.hasNext()) {
			words.add(f.nextLine());
		}

		f.close();
	}
	public String word() {
		return words.get((int)(Math.random()*words.size()));
	}
}