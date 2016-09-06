/** ----------NGUIGA-----------
 * No Graphic User Interface GAme
 * This is a Little Game without graphic interface.
 * Here's the Main class: Nguiga, handles the various modes in this game; extends the class GameModes that acts like an abstract class.
 * Infact GameMods implements some general methods that all classes  use and implements the input.
 * This is the first version, in which the code was structured in a (as best as i could) Pleasant-to-Read way.
 *
 * @version 1.1.0.3
 * @authors Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 *
 */

public class Nguiga /*extends GameModes*/{

	public static String s;
	public static double l;

	public static void main(String[] args){
		System.out.println("Welcome to Nguiga!\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression, 1 mistake -> 1 dead.\n2. Quick Typing:\nchoose the word to play with; than input that as faster as you can\nType Everywhere:\n\"menu\" to return to main menu and change players\n\"exit\" to exit the game.\nLET'S START!\n");

		play();

}
	/**@since 1.1*/
	public static void play(){

		System.out.print("Type\n\"calc\" or \"typing\" to choose the game mode: ");
		s=IO.inputString();


		if (s.equals("typing")){
			QuickTyping.PlayQuickTyping();

	    }else if (s.equals("calc")){
	    	QuickCalc.PlayQuickCalc();
		}
		else play();

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
              Custom Names_________________________________DONE
              Switch case for tournament mode______________
              Handle the dead heat_________________________      @see AnnounceWinner_Method in class GameModes and TimeCalculation in Class QuickTyping/QuickCalc
              Memorize the Players in file_________________DONE
              Clean Code___________________________________DONE?
              Documentation________________________________DONE?
              Menù option__________________________________DONE?     @** Difficult to implement, needs something that can jump through the code, like the continue branching statement
              															IMPLEMENTED with play function=> MEMORY HUNGRY

;*/