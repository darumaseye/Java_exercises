/**
 * @version 1.1
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.util.Random;

public class QuickCalc extends GameModes {

	public static int[] result;

	public static void PlayQuickCalc(){
		defNPlayers();
		Random rand= new Random();
		result= new int[number_of_players];
		int random[]=new int[6];
		String exp;
		int exactValue;

		for(int i=0; i<number_of_players; i++){
			System.out.print("Turn of Player "+(i+1)+"\nYou have to enter the solution, no mistakes allowed.\nPress 'Enter'to start immediately: ");
			Input.inputString();

			for(int j=0; j<6; j++){
				random[j]=rand.nextInt(10);
			}
			exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
			exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);
			System.err.println(exactValue);
			t[i] = System.currentTimeMillis();
			/*do {
				System.out.print("Calc "+exp+" = ");
				result[i]=Input.inputInt();
			}while (result[i]!=exactValue);*/
				System.out.print("Calc "+exp+" = ");
				result[i]=Input.inputInt();
				if(result[i]!=exactValue){
					System.out.print("Wrong Solution: Sorry Sir, you lose\n");
					t[i]=0;
					continue;
					}

/**TIMECALCULATION----In future Version, this must be implemented in an unique method for all classes, prob in GameModes class => As difficult as the menù option? */
			t[i]=System.currentTimeMillis()-t[i];
			System.out.println("Player "+(i+1)+" has solved the expression in "+(double)t[i]/1000+" seconds"+t[i]);
		  }
		announceWinner(t);
	}

}
