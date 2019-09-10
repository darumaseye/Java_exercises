package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.awt.Desktop;
import java.io.File;

/**
 * @author Jacopo Taccucci (wonty)
 * @since 1.1
 * @ToUpdate
 * @see  The class Session and Server for further descriptions
 * 
 * */

/*TODO _________________:Reorganize the class, leaving the essential
 * 						:HOW TO SAVE PROGRESS IN A FILE? WHEN? the piece of code below has been taken from the class GameModes */

public class IO{

	/**Input method managing streams
	 * @since 1.0
	 * @return String*/
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
			//TODO Nguiga_Client.play();
		}
		return s;
	}
	
	/**Input method managing streams
	 * @since 1.0
	 * @return Integer*/
	public static int inputInt(){
		return Integer.parseInt(inputString());
	}
	
	/**Output method managing streams for files
	 * @since 1.1.0.2
	 * @param p Player array
	 * @param t 
	 * @param q
	 * @deprecated*/
	public static void output(Player[] p, String t,String q){
		try{
			Formatter f= new Formatter(t);
			f.format("%s","Players list for "+q+" game\r\n");
			f.format("%s %s","Name    ","      Time\r\n\r\n");
			for(int i=0; i<p.length; i++){
				f.format("%s %s",p[i].getHost(),"    "+p[i].getTime()+" seconds\r\n");
			}
			f.close();
			System.out.println("Done! File Created; you'll it find at \""+t+"\"\n");
			File x=new File(t);
			Desktop.getDesktop().open(x);
		}catch(Exception e){
			System.err.println("Error");
		}

	}
	
	public static void output(String s){
		System.out.println(s);
		
	}

	/*do{
			System.out.println("Do you want to save progress in a file? [y/n]");
		 	s=IO.inputString();
		 	}
		 while(!s.equals("y")&&!s.equals("n"));
		 if(s.equals("y")){
			 System.out.println("Oh! Thank You!\nYou are a good man Sir\nPlease insert the path of the file, or just the name(with the correct extension):");
			 IO.output(this.players,IO.inputString(),q);
		}else if(s.equals("n"))
			System.out.print("ok :( ....");

		 System.out.println(".......Restarting........\n");*/
}