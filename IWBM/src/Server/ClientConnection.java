package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**ClientConnectio class creats a New Thread to handle a single Conncetion with a client.
 * The method run (implemented from Runnable) that practically creates the thread is used by the class server in the first phase (when the server accepts incoming requests)
 * After that all the work is left to the Parser that throws for each method a different Job.
 * N.B. In Order to access the Structures of the Session (ArrayList Player that contains the accessible times and nicknames) each ClientConnection instance is linked to the Session Instance through the Server class thanks to setsession method  
 * 
 * @since 2.0alpha
 * @author Jacopo Taccucci (wonty)*/

public class ClientConnection implements Runnable{
	Server server;
	BufferedReader inputStream;
	Session session;
	Player player;
	
	/**Costructor of the class: creates an InputStream from the Player 
	 * @since 2.0alpha
	 * @param player : Target player for the ClientConnection*/
	public ClientConnection (Player player){
		this.player=player;
		//this.server=server;
		try{
			inputStream = new BufferedReader (new InputStreamReader ((player.getSocket()).getInputStream()));
		}catch (Exception ex) {}
		
	}
	
	/** Read the Stream from the client and Calls the Protocol Parser for each line of Client's input
	 * @since 2.0alpha
	 * @see ClientConnection.protocolParser()*/
	public void run(){ 
		String line;

		try {
			while (true){
				line=inputStream.readLine();
				protocolParser(line);
				}
			
		}catch (IOException ex){}
		
	}
	
	/**Intended to Set the Session LINKED to the Client of the Instance
	 * @since 2.0alpha
	 * @param session : linked Session*/
	//TODO Check if is actually linked to the client
	public void setSession(Session session){
		this.session=session;
	}

	/**Protocol Parser: used by run method divides the Output from a Client in 2 parts, CommandType representing the Protocol's Message (enums in Comm.java)
	 * 																					Payload of the Protocol's message
	 * Then different methods of class session will be called
	 * @since 2.0alpha 
	 * @param line : Output line from the client
	 * @see Server.startSession
	 * @see Session*/
	public void protocolParser(String line){ 
		Comm commandType;
		String payload;
		commandType=Comm.valueOf(line.substring(0, 4));
		payload=line.substring(4,line.length());
		
		switch (commandType){
			case NICK: this.session.setNick(this.player, payload); break;
			case STRT: Server.startSession();/*TODO Countdown & if(at least 2 clients connected)*/ break;
			
			case VOTE: break;
			case G001: this.session.setVote(1); break;
			case G002: this.session.setVote(2); break;
			case G111: this.session.setVote(3); break;			
			
			case TIME: this.session.setTime(this.player, payload); break;
			
			case RESS: break;
			case RESI: break;
			case GMSG: break;
			case STAT: break;
			case CANC: break;
			case WINN: break;
		}
	}
}