/**
 * @version 1.2
 * @author Jacopo Taccucci (wonty) & SquallorX (for 1.1.0)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.util.Random;

public class QuickCalc extends GameModes {

	public static int[] result;

	public static void PlayQuickCalc(){
		//defPlayers();
		Random rand= new Random();
		result= new int[number_of_players];
		int random[]=new int[6];
		String exp;
		int exactValue;
		System.out.println("\nWelcome to QuickCalc Mode!");
		for(int i=0; i<number_of_players; i++){
			System.out.print("\nTurn of "+array_of_players[i].getName()+"\nYou have to enter the solution, no mistakes allowed.\nPress 'Enter'to start immediately: ");
			IO.inputString();

			for(int j=0; j<6; j++){
				random[j]=rand.nextInt(10);
			}
			exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
			exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);
			System.err.println(exactValue);
			array_of_players[i].setPartial1();

				System.out.print("Calc "+exp+" = ");
				result[i]=IO.inputInt();
				if(result[i]!=exactValue){
					System.out.print("Wrong Solution: Sorry Sir, you lose\n");
					array_of_players[i].setTime(0);
					continue;
					}

/**TIMECALCULATION----In future Version, this must be implemented in an unique method for all classes, prob in GameModes class => As difficult as the menù option? */
			array_of_players[i].setPartial2();
			array_of_players[i].setTime(1);
			System.out.println(array_of_players[i].getName()+" has solved the expression in "+array_of_players[i].getPartial()+" seconds");
		  }
		//announceWinner("QuickCalc");
	}

}
