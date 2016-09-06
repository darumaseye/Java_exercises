/**
 * @version 1.1.0.3
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.util.Random;

public class QuickCalc extends GameModes {

	public static int[] result;

	public static void PlayQuickCalc(){
		defPlayers();
		Random rand= new Random();
		result= new int[number_of_players];
		int random[]=new int[6];
		String exp;
		int exactValue;

		for(int i=0; i<number_of_players; i++){
			System.out.print("Turn of "+array_of_players[i].getName()+"\nYou have to enter the solution, no mistakes allowed.\nPress 'Enter'to start immediately: ");
			IO.inputString();

			for(int j=0; j<6; j++){
				random[j]=rand.nextInt(10);
			}
			exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
			exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);
			System.err.println(exactValue);
			array_of_players[i].setTime(System.currentTimeMillis());

				System.out.print("Calc "+exp+" = ");
				result[i]=IO.inputInt();
				if(result[i]!=exactValue){
					System.out.print("Wrong Solution: Sorry Sir, you lose\n");
					array_of_players[i].setTime(0);
					continue;
					}

/**TIMECALCULATION----In future Version, this must be implemented in an unique method for all classes, prob in GameModes class => As difficult as the menù option? */
			array_of_players[i].setTime(System.currentTimeMillis()-array_of_players[i].getTime());
			array_of_players[i].setTime(array_of_players[i].getTime()/1000);
			System.out.println(array_of_players[i].getName()+" has solved the expression in "+array_of_players[i].getTime()+" seconds");
		  }
		announceWinner("QuickCalc");
	}

}
