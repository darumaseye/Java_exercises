package Client;
import java.net.Socket;




/** ----------IWBM-----------
 * IWBM stands for I Wanna Be a MUD. Born as Nguiga, IWBM is the Online Version of Nguiga.
 * It's only a simple textual game but...
 * Beware you out there! 'cause Nguiga wanna grow more :)
 *
 * @version 2.0alpha
 * @authors Jacopo Taccucci (wonty)
 * @since 1.0
 *
 */
/*TODO _______________________:Regular Expression for the InetAddress
 *							  : Automatic port if port left blank*/
public class IWBM{

	private static String s;
	public static double l;
	public static Player player;
	private static int port;
	static Socket server;
	private static Client connection;

	/**Main Method of the Client Side. Creates a client object passing ip,port and a player object; Send a Start Request (Comm.STRT) and delegates all the work to te Client class with rec method
	 * @since 2.0alpha
	 * @param args Not Used
	 * @see IO
	 * @see Client*/
	public static void main(String[] args){
		IO.outln("Welcome to Nguiga!\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression, 1 mistake -> 1 dead;\n2. Quick Typing:\nchoose the word to play with; than input that as faster as you can;\n3.Tournament: Who's the best?\nType Everywhere:\n\"menu\" to return to main menu and change players\n\"exit\" to exit the game.\nLET'S START!\n");
		IO.outln("Scegli un Nickname");
		s=IO.inputString("");
		player = new Player(s);
		s="";
		IO.outln("All starts with the connection...please type the Ip Address of the Server, and a port for the conncetion (leave blank for an automatic port)");
		s=IO.inputString("Type the IP Address of the Server (ex. 602.1.203.430)");
		port=IO.inputInt("Type the port (leave blank for an automatic port)");
		
		connection = new Client(s,port,player);
		
		while((IO.inputString("Type Start when you (and all the players) are ready").equals("START"))){}
		
		connection.send(Comm.STRT, "");
		
		connection.rec();
		

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
              Tournament mode______________________________DONE  @ does not show in outputfile all  results for each mode, due to the handling of Times
              Handle the dead heat_________________________DONE    @see AnnounceWinner_Method in class GameModes and TimeCalculation in Class QuickTyping/QuickCalc
              Memorize the Players in file_________________DONE
              Clean Code___________________________________DONE?
              Documentation________________________________DONE?
              Online_______________________________________
              Menù option__________________________________DONE?     @** Difficult to implement, needs something that can jump through the code, like the continue branching statement
              															IMPLEMENTED with play function=> MEMORY HUNGRY

;*/