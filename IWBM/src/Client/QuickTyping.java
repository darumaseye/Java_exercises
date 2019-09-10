package Client;
/**Handles the QuickTyping game
 * @version 1.2
 * @author Jacopo Taccucci (wonty) & SquallorX (for 1.1.0)
 * @since 1.0
 * @see Nguiga class for Description
 * */
//TODO Send evrthing to Server
public class QuickTyping{

	public static String chosen_word;
	public static String digit;

	/**Static Method for the game
	 * @since 1.0
	 * @param player Used instead of extending the class with the main class,
	 * @see IO
	 * @see Player.setPartial()
	 * @see Player.setPlartial1()
	 * @see Player.setPartial2()
	 * @see Player.setTime()*/
	public static void PlayQuickTyping(Player player){

		digit="";
		System.out.print("\nWelcome to QuickTyping Mode!\n");
		System.out.print("Choose the word (Remember: \"menu\" and \"exit\" are reserved keywords): ");
		chosen_word=IO.inputString("");



			System.out.print("\nTurn of "+player.getName()+"\nYou have to enter the word until this is corrected.\nPress \"Enter\"to start immediately: ");
			IO.inputString("");

			player.setPartial1();
			do {
				System.out.print("Input \""+chosen_word+"\": ");
				digit=IO.inputString("");
			}while (!digit.equals(chosen_word));
			player.setPartial2();
			player.setTime(1);
			
			System.out.println(player.getName()+" has typed the correct word in "+player.getPartial()+" seconds");

	}
}
