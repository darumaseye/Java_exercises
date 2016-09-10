/**
 * @version 1.2
 * @author Jacopo Taccucci (wonty) & SquallorX (for 1.1.0)
 * @since 1.0
 * @see Nguiga class for Description
 * */

public class QuickTyping extends GameModes {

	public static String chosen_word;
	public static String digit;

	public static void PlayQuickTyping(){
		//defPlayers();
		digit="";
		System.out.print("\nWelcome to QuickTyping Mode!\n");
		System.out.print("Choose the word (Remember: \"menu\" and \"exit\" are reserved keywords): ");
		chosen_word=IO.inputString();

		for(int i=0; i<number_of_players; i++){

			System.out.print("\nTurn of "+array_of_players[i].getName()+"\nYou have to enter the word until this is corrected.\nPress \"Enter\"to start immediately: ");
			IO.inputString();

			array_of_players[i].setPartial1();
			do {
				System.out.print("Input \""+chosen_word+"\": ");
				digit=IO.inputString();
			}while (!digit.equals(chosen_word));
			array_of_players[i].setPartial2();
			array_of_players[i].setTime(1);
			System.out.println(array_of_players[i].getName()+" has typed the correct word in "+array_of_players[i].getPartial()+" seconds");

		  }
		//announceWinner("QuickTyping");
	}
}
