/**
 * @version 1.1.0.3
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

public class QuickTyping extends GameModes {

	public static String chosen_word;
	public static String digit;

	public static void PlayQuickTyping(){
		defPlayers();
		digit="";
		System.out.print("Choose the word (Remember: \"menu\" and \"exit\" are reserved keywords): ");
		chosen_word=IO.inputString();

		for(int i=0; i<number_of_players; i++){

			System.out.print("\nTurn of "+array_of_players[i].getName()+"\nYou have to enter the word until this is corrected.\nPress \"Enter\"to start immediately: ");
			IO.inputString();

			array_of_players[i].setTime(System.currentTimeMillis());
			do {
				System.out.print("Input \""+chosen_word+"\": ");
				digit=IO.inputString();
			}while (!digit.equals(chosen_word));
			array_of_players[i].setTime(System.currentTimeMillis()-array_of_players[i].getTime());
			array_of_players[i].setTime(array_of_players[i].getTime()/1000);
			System.out.println(array_of_players[i].getName()+" has typed the correct word in "+array_of_players[i].getTime()+" seconds");

		  }
		announceWinner("QuickTyping");
	}
}
