package Client;
/**Handles the QuickCalc game
 * @version 1.2
 * @author Jacopo Taccucci (wonty) & SquallorX (for 1.1.0)
 * @since 1.0
 * @see Nguiga class for Description
 * */

import java.util.Random;

//TODO Send evrthing to Server
public class QuickCalc{

	public static int result;
	public static long delta;

	/**Static Method for the game
	 * @since 1.0
	 * @param player Used instead of extending the class with the main class,
	 * @see IO
	 * @see Player.setPartial()
	 * @see Player.setPlartial1()
	 * @see Player.setPartial2()
	 * @see Player.setTime()*/
	public static void PlayQuickCalc(Player player){

		Random rand= new Random();

		int random[]=new int[6];
		String exp;
		int exactValue;
		System.out.println("\nWelcome to QuickCalc Mode!");

			System.out.print("\nTurn of "+player.getName()+"\nYou have to enter the solution, no mistakes allowed.\nPress 'Enter'to start immediately: ");
			IO.inputString("");

			for(int j=0; j<6; j++){
				random[j]=rand.nextInt(10);
			}
			exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
			exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);

			player.setPartial1();


			System.out.print("Calc "+exp+" = ");
			result=IO.inputInt("");
			if(result!=exactValue){
				System.out.print("Wrong Solution: Sorry Sir, you lose\n");
				player.setTime(0);
				}

			player.setPartial2();
			player.setTime(1);
			
			
			System.out.println(player.getName()+" has solved the expression in "+ player.getPartial()+" seconds");
		  }
	}


