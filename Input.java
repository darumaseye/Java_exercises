/**
 * @version 1.1
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.1
 * @see Nguiga class for Description
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input{

	/**@since 1.0*/
	public static String inputString(){
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader myInput = new BufferedReader(reader);
		String s=new String();
		try{
			   s=myInput.readLine();
			}catch (IOException e){System.exit(-1);}
		if(s.equals("exit")){
			System.out.println("Thanks for trying Nguiga, Best Regards Sir");
			System.exit(0);
		}
		else if(s.equals("menu")){
			Nguiga.play();
		}
		return s;
	}
	/**@since 1.0*/
	public static int inputInt(){
		int n=0;
		String s=inputString();
		n=Integer.parseInt(s);
		return n;
	}


}