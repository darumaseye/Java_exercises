/**
 * @version 1.0
 * @author Jacopo Taccucci (wonty)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.util.Random;

public class QuickCalc extends GameModes {
	
	public QuickCalc(int numb){
		super(number_of_players);
		Random rand= new Random();
		result= new int[number_of_players];
		int random[]=new int[6];
		String exp;
		int exactValue;

		for(int i=0; i<number_of_players; i++){
			System.out.print("You have to enter the solution until this is corrected.\nPress 'Enter'to start immediately: ");
			inputString();

			for(int j=0; j<6; j++){
				random[j]=rand.nextInt(10);
			}
			exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
			exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);
			System.err.println(exactValue);

			t[i] = System.currentTimeMillis();
			do {
				System.out.print("Calc "+exp+" = ");
				result[i]=inputInt(); 
			}while (result[i]!=exactValue);
/**TIMECALCULATION----In future Version, this must be implemented in an unique method for all classes, prob in GameModes class => As difficult as the menù option? */
			t[i]=System.currentTimeMillis()-t[i];
			System.out.println("Player "+(i+1)+" has solved the expression in "+(double)t[i]/1000+" seconds"+t[i]);
		  }
		announceWinner(t);
	}
	
}
