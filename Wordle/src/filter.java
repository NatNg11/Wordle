import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class filter {

	public static void main(String[] args) throws Exception {
		new filter().run();
	}

	public void run() throws Exception {
		//Scanner f = new Scanner(new File(".dat"));
		Scanner f = new Scanner(new File("dictionary.txt"));
		PrintWriter out = new PrintWriter(new File("wordlewords.txt"));
		while(f.hasNext()) {
			String n = f.nextLine();
			if(n.length()==5) {
				out.println(n);
			}
		}

		f.close();
	}
}