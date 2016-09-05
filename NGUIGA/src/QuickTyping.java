/**
 * @version 1.1
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

public class QuickTyping extends GameModes {

	public static String chosen_word;
	public static String[] digit;

	public static void PlayQuickTyping(){
		defNPlayers();
		digit= new String[number_of_players];
		System.out.print("Choose the word (Remember: \"menu\" and \"exit\" are reserved keywords): ");
		chosen_word="";
		/** @deprecated but still here, for possible future use. Input was implemented in a different way and no more "blocks" are needed */
		do{
			chosen_word=Input.inputString();
			if(chosen_word.equals("calc")||chosen_word.equals("typing")||chosen_word.equals("menù"))
				System.out.println("Cannot use this,try another:");
		}while(chosen_word.equals("calc")||chosen_word.equals("typing")||chosen_word.equals("menù"));// this loop, is deprecated, is here just for possibile future use

		for(int i=0; i<number_of_players; i++){

			System.out.print("Turn of Player "+(i+1)+"\nYou have to enter the word until this is corrected.\nPress \"Enter\"to start immediately: ");
			Input.inputString();

			t[i] = System.currentTimeMillis();
			do {
				System.out.print("Input \""+chosen_word+"\": ");
				digit[i]=Input.inputString();
			}while (!digit[i].equals(chosen_word));
/**TIMECALCULATION----In future Version, this must be implemented in an unique method for all classes, prob in GameModes class => As difficult as the menù option?*/
			t[i]=System.currentTimeMillis()-t[i];
			System.out.println("Player "+(i+1)+" has typed the correct word in "+(double)t[i]/1000+" seconds");

		  }
		announceWinner(t);
	}
}
