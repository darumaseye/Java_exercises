/**
 * @version 1.0
 * @author Jacopo Taccucci (wonty)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameModes {
	
	public static int number_of_players;
	public static String general_input;
	public static String chosen_word;
	public static int[] result;
	public static String[] digit;
	public static long[] t;
	
	public GameModes(int numb){
		number_of_players=numb;
		t=new long[numb];
	}
	/**@since 1.0 Just Calc the best player, the deadheat must be handled in future version  */
	public static void announceWinner(long[] a){
		long min=a[0];
		int index=0;
		for(int i=1; i<a.length; i++){
			if(a[i]<=min){
				min=a[i];
				index=i;
			}
		}
		 System.out.println("The Winner is....Player "+(index+1)+"!!!!");
		 System.out.println(".......Restarting........");
	}
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
