/**
 * @version 1.1.0.3
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.1
 * @see Nguiga class for Description
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.awt.Desktop;
import java.io.File;

public class IO{

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
		return Integer.parseInt(inputString());
	}
	/**@since 1.1.0.2*/
	public static void output(Player[] p, String t,String q){
		try{
			Formatter f= new Formatter(t);
			f.format("%s","Players list for "+q+" game\r\n");
			f.format("%s %s","Name    ","      Time\r\n\r\n");
			for(int i=0; i<p.length; i++){
				f.format("%s %s",p[i].getName(),"    "+p[i].getTime()+" seconds\r\n");
			}
			f.close();
			System.out.println("Done! File Created; you'll find at \""+t+"\"\n");
			File x=new File(t);
			Desktop.getDesktop().open(x);
		}catch(Exception e){
			System.err.println("Error");
		}

	}


}