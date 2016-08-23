/** ----------NGUIGA-----------
 * No Graphic User Interface GAme
 * This is a Little Game without graphic interface.
 * Here's the Main class: Nguiga, handles the various modes in this game; extends the class GameModes that acts like an abstract class.
 * Infact GameMods implements some general methods that all classes  use and implements the input.
 * This is the first version, in which the code was structured in a (as best as i could) Pleasant-to-Read way.
 * 
 * @version 1.0
 * @author Jacopo Taccucci (wonty)
 * @since 1.0
 *
 */
public class Nguiga extends GameModes{
		
	public Nguiga(int numb){
		super(number_of_players);		
	}

	public static void main(String[] args){
		System.out.println("Welcome to Nguiga!\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression in the input window.\n2. Quick Typing:\nchoose the word to play with; than input that in the window\nType Everywhere:\n\"menù\" to return to main menù and change players\n \"exit\" to exit the game.\n LET'S START!\n Input the number of players:");

		while(true){ 
			number_of_players=inputInt();
			System.out.print("Type\n\"calc\" or \"typing\" to choose the game moode: ");
			general_input=inputString();
	
	    if (general_input.equals("typing")){
			new QuickTyping(number_of_players);
			continue;
	
	    }else if (general_input.equals("calc")){
	    	new QuickCalc(number_of_players);
	    	continue;
			
	     }else 
	    	 continue;
    }
}
}
 /**To Add:
              "Press Enter"________________________________DONE
              Calc of the Winner___________________________DONE
              The Number of players depends on input ______DONE
              Add the character "__________________________DONE
              Semi-Random Expressions______________________DONE
              2 modes: quick calc, quick typing____________DONE
              Loop, and exit_______________________________DONE
              Times in Seconds_____________________________DONE
              Loop, and exit EVERYWHERE____________________DONE
              Menù option__________________________________      @** Difficult to implement, needs something that can jump through the code, like the continue branching statement 
              Custom Names_________________________________
              Switch case for tournament mode______________
              Handle the dead heat_________________________      @see AnnounceWinner_Method in class GameModes and TimeCalculation in Class QuickTyping/QuickCalc
              Memorize the Players in file_________________
              Clean Code___________________________________DONE?
              Documentation________________________________DONE?
;*/