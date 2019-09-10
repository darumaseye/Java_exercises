package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**Client Class is the main client-side class of the project
 * It's intended to establish the connection with the server; to listening for requests from the Server and to handle the protocol parsing of IWBM, answering to the server's requests with the send method
 * @since 2.0alpha
 * @author Jacopo Taccucci (wonty)
 * @see IWBM*/

/*TODO _____________________:A better solution for the ending phase
 * 							:Add the possibility to restart the same Session*/

public class Client {
	
	private Socket server;
	private DataOutputStream oStream;
	private BufferedReader iStream;
	private Player player;
	
	/**Constructor: Creates the connection with the server, the Buffered Input Stream and the  the DataOuputStream
	 * @since 2.0alpha
	 * @param ip Server ip
	 * @param port Server port*/
	public Client(String ip, int port, Player player){
		try {
			server = new Socket(ip,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.oStream= new DataOutputStream (server.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.iStream= new BufferedReader ( new InputStreamReader (server.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.player=player;
	}
	
	/**Sends a Specific message to the Server linked to this Instance
	 * @since 2.0alpha
	 * @param commandType 
	 * @param payload*/
	public void send(Comm commandType, String payload){
		try {
			this.oStream.writeBytes(commandType+payload);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Listens for messages from the Server and calls the parser 
	 * @since 2.0alpha*/
	public void rec(){
		String line="";
		try {
			line = iStream.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.protocolParser(line);
	}

	/**Kernel of Client-side, ProtocolParser interprets messages passed by rec() method, answering to each Server's request. At the end of interpretation calls rec() method for a cicle
	 * @since2.0alpha
	 * @param line Message content*/
	public void protocolParser(String line){
		Comm commandType;
		String payload;
		commandType=Comm.valueOf(line.substring(0, 4));
		payload=line.substring(4,line.length());
		switch (commandType){
			case NICK: this.send(Comm.NICK, IO.inputString(payload)); break;
			case STRT: break;
			
			case VOTE: {int n=IO.inputInt("Vote a Game to play:\n1 for QuickTyping\n2 for QuickCalc\n3 for Tournament");
						while(n!=1&&n!=2&&n!=3){n=IO.inputInt("Vote a Game to play:\n1 for QuickTyping\n2 for QuickCalc\n3 for Tournament");}
						switch (n){
						case 1: this.send(Comm.G001, ""); break;
						case 2: this.send(Comm.G002, ""); break;
						case 3: this.send(Comm.G111, ""); break;}
						break;}
			
			case G111: 
			case G001: QuickTyping.PlayQuickTyping(this.player); 
						if(commandType==Comm.G001) { this.send(Comm.TIME, ""+this.player.getTime()); break; }
			case G002: QuickCalc.PlayQuickCalc(this.player); 
						this.send(Comm.TIME, ""+this.player.getTime());
						break;
						
			
			case TIME: { double n= this.player.getTime();
						this.send(Comm.TIME, ""+n);		
						break;}
			
			case RESS: break;
			case RESI: break;
			case GMSG: IO.outln(payload);break;
			case STAT: IO.outln(payload);break;
			case CANC: break;
			case WINN: IO.outln(payload);break;
			case XXXX: break;
		}
		if(commandType!=Comm.XXXX) this.rec();
		else System.exit(0);
	}
}