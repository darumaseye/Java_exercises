package Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**Class Session is intended to actually represent a Game Session, and to Handle every game phase.
 * This is composed by:
 * 				- ArrayList of Players
 * Each Session of Nguiga starts when a single client, connected to the Server, sends a START request (Comm.STRT);
 * Then, the ArrayList of clients connected to the server is passed to the Session Costructor and run() method
 * implemented from Runnable, creates a New Thread that interacts with the ClientConnections
 * The handled game's phases are:
 * 							1. Start:  a Nickname request(Comm.NICK) is sent,
 * 							2. Game :  Composed by:
 *												a. vote : every player chose a mode;
 * 												b. play : session sends a game message (Comm.Gxxx)
 * 												c.ending: Session receive Times from clients (Comm.TIME)
 * 							3. Ending: Disconnection
 * Note1: when Server(Session) calcs the winner, first step is to sort the ArraList, so it's sufficient to calc the NUMBER of winners to handle deadheat.
 * @since 2.0alpha
 * @author Jacopo Taccucci (wonty)*/

/*TODO NEEDED_______________:Handle disconnections in phase 2b...in every phase actually :/ 
 * 							:Possibility to Repeat Session in phase  2c (***RESET TIME VARIABLES IN CASE***)
 * 							:Implements phase 3
 * 							:Proper handle of Exceptions
 * 							: */

public class Session extends Server implements Runnable {
	
	private ArrayList<Player> players;
	int number_of_Players=0;
	int solved_requests=0;
	int vote=0;
	String game="";
	
	/**Constructor of Session 
	 * @since 2.0alpha
	 * @param players : ArrayList of Players*/
	public Session(ArrayList<Player> players){
		Iterator<Player> it=players.iterator();
		while(it.hasNext())  {  this.players.add(it.next());   }
		this.number_of_Players = players.size();
	}
	
	/**Creates a new Thread for a New Session
	 * @since 2.0alpha
	 * @see Session.phase1()
	 * @see Session.phase2()
	 * @see Session.phase3()*/
	//TODO Complete ending
	public void run(){
		try {
			phase1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			phase2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			phase3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**Handles 1° phase: Nicknames and game mode
	 * @throws IOException
	 * @since 2.0alpha 
	 * @see Session.sndReq(ArrayList<Player> players, Comm commandType, String payload)*/
	public void phase1() throws IOException{
		sndReq(players, Comm.NICK, "Choose a NickName\n");
	}
	
	/**Handles 2° phase: Game
	 * @throws IOException
	 * @since 2.0alpha
	 * @see Server.sendBroadcast(ArrayList<Player> player, Comm commandType, String payload)
	 * @see Session.sndReq(ArrayList<Player> players, Comm commandType, String payload)
	 * @see Player.getNick()
	 * @see Player.getIp()*/
	public void phase2() throws IOException{
		int avg;
		Iterator<Player> it= players.iterator();
		String payload="Users Connected in this Session:\n";
		Player player;
		while(it.hasNext()){
			player=it.next();
			payload+="\""+player.getNick()+"\":"+"  "+player.getIp()+" "+"\n";
		}
		sendBroadcast(players, Comm.STAT, payload);
		sndReq(players, Comm.VOTE, "Type \n1: for QuickTyping\n2: for quick Calc\n3: for Tournament");
		avg=this.vote/number_of_Players;
		switch (avg){
		case 1: sendBroadcast(players, Comm.G001, ""); game="QuickTyping"; break;
		case 2: sendBroadcast(players, Comm.G002, ""); game="QuickCalc"; break;
		case 3: sendBroadcast(players, Comm.G111, ""); game="Tournament"; break;
		}
		
	}
	
	/**Handles 3° phase: Ending
	 * @throws IOException 
	 * @since 2.0alpha
	 * @see Session.sndReq(ArrayList<Player> players, Comm commandType, String payload)
	 * @see Server.sendBroadcast(ArrayList<Player> player, Comm commandType, String payload)*/
	public void phase3() throws IOException{
		sndReq(players, Comm.TIME, "");
		sendBroadcast(players, Comm.WINN, this.announceWinner(game));
		sendBroadcast(players, Comm.GMSG, "Session Terminated");
	}
	
	/**Sends a Broadcast Request for a specific protocol message to all the clients of the session
	 * @since 2.0alpha
	 * @param players : Target Players for broadcast
	 * @param commandType : Type of command of the Protocol
	 * @param payload : Message's payload
	 * @see Server.sendBroadcast(ArrayList<Player> player, Comm commandType, String payload)
	 * @see Session.waitAll()*/
	public synchronized void sndReq(ArrayList<Player> players, Comm commandType, String payload){
		try {
			sendBroadcast(players, commandType, payload);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitAll();
	}
	
	/**Used by ClientConnection's Instances to access the nickname attribute in Session.players 
	 * @since 2.0alpha
	 * @param player : target player
	 * @param nick : Nickname to set
	 * @see Player.find()
	 * @see Player.setNick()
	 * */
	public synchronized void setNick(Player player, String nick){
		int index=player.find(this.players);
		this.players.get(index).setNick(nick);
		this.solved_requests++;

	}
	
	/**Used by ClientConnection's Instances to access the Instance variable: Vote 
	 * @since 2.0alpha
	 * @param vote : Integer vote to add*/
	public synchronized void setVote(int vote){
		this.vote+=vote;
		this.solved_requests++;
	}

	/**Used by ClientConnection's Instances to access the Time attribute in Session.players
	 * @since 2.0alpha
	 * @param player : target player 
	 * @param payload : Time-in-String to set 
	 * @see Player.setime()
	 * @see Player.find()*/
	public synchronized void setTime(Player player,String payload){
		int index=player.find(this.players);
		int time=Integer.valueOf(payload);
		this.players.get(index).setTime(time);
		this.solved_requests++;
	}
	
	/**Waits the answer of all clients, using busy waiting  
	 * @since 2.0alpha
	 * @deprecated WARNING!!!! DEADLOCK */
	public void waitAll(){
		while(solved_requests!=number_of_Players){}
		solved_requests=0;
	}

	/**Returns a payload for the Broadcast message containing the String that announces the winner
	 * @since 1.1.0.2 Just Calcs the best player  
	 * @updated 2.0alpha for Server
	 * @see Session.theresLoosers()
	 * @see Session.checkDeadHeat()
	 * @see Player.getNick()
	 * @param game : a String containing the type of the last game played
	 * @return The payload (String) containing the Winner, used with sendBroadcast() method*/
	public String announceWinner(String game){
		String payload="";
		sort();
		int a=theresLoosers();
		int b=checkDeadHeat();

		if(a!=number_of_Players){
			if(b!=0)payload="\nThe Game finished with a Dead Heat!\nThe Winners are....";
			else payload="\nThe Winner is....";
				for(int i=a;i<=a+b;i++){
					payload+=this.players.get(i).getNick();
					if(i!=b)
					payload+=" & ";
				}
				payload+="!!!!\n";

		}else{if(number_of_Players==1) System.out.println("\nMmh One Player One Looser...ok....\n");
		else payload="\nBad News for you...it seems all of you are Loosers....\n";

			}

		return payload;
		 //TODO Nguiga_Client.play();
	}
	
	/**Returns how many players ended with time=0
	 * @since 1.1.0.6
	 * @updated 2.0alpha for Server
	 * @return The Number of loosers*/
	public int theresLoosers(){
			int j=0;
			for(int i=0;i<number_of_Players;i++){
				if(this.players.get(i).getTime()==0) j++;
				else break;
			}
			return j;
		}
	
	/**Handler Of Deadheat
	 * @since 1.1.0.6
	 * @updated 2.0alpha for Server
	 * @see Session.theresLoosers()
	 * @return The number of Winners*/
	public int checkDeadHeat(){
		int i=theresLoosers();
		if(i>=number_of_Players)
		return 0;
		else{
			double min=this.players.get(i).getTime();
			int num=0;
			i++;
			while(i<number_of_Players&&this.players.get(i).getTime()==min){
				num++;
				i++;
			}
			return num;
		}
	}
	
	/**Invoker of the QuickSort implemented for the ArrayList on "Time" attribute
	 * @since 1.1.0.5
	 * @updated 2.0alpha for Server
	 * @see Session.sortRec()*/
	public void sort(){
		this.sortRec(0,number_of_Players-1);
	}
	
	/**Recursive method of the QuickSort on the partitioned ArrayList
	 * @since 1.1.0.5
	 * @updated 2.0alpha for Server
	 * @see Session.partition()*/
	public void sortRec(int sx, int dx){
		if(sx+1<dx){
			int p=this.partition(sx,dx);
			sortRec(sx,p-1);
			sortRec(p+1,dx);
		}
	}
	
	/**Partition method of QuickSort
	 * @since 1.1.0.5
	 * @updated 2.0alpha for Server
	 * @see Session.switchPlayers()
	 * @return pivot*/
	public int partition(int sx, int dx){
		double pivot= this.players.get(dx).getTime();
		int i=sx-1;

		for(int j=sx;j<=dx-1; j++){
			if(this.players.get(j).getTime()<=pivot){
				i++;
				switchPlayers(i,j);
			}
		}
			switchPlayers(i+1,dx);
			return i+1;

	}
	
	/**Switches the players of an ArrayList
	 * @since 1.1.0.5
	 * @updated 2.0alpha for Server*/
	public void switchPlayers(int i, int j){
		Player temp=this.players.get(i); 
		this.players.set(i, this.players.get(j));
		this.players.set(j,temp);
	}

}