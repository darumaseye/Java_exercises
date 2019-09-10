package Server;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/** Represents the Entity Player with:
 * 								-Socket;Ip; Port; Hostname of the connection
 * 								-An Instance of ClientConnection
 * 								-A nickname chosen by the client
 * 								-A variable to store times
 * 								-A temp variable p
 * and methods to manage these private variables	
 * @version 1.2
 * @author Jacopo Taccucci (wonty)
 * @since 1.0.1
 * @updated 2.0alpha
 * @see The class Session and Server for further descriptions
 * */


public class Player{

	private ClientConnection clientConnection;
	private Socket client;
	private InetAddress ip;
	private int port;
	private String hostname;
	private String nickname;
	private double t;
	private double par;

	public Player(Socket client){
		this.t=0;
		this.client=client;
		this.ip=client.getInetAddress();
		this.hostname=this.ip.getHostName();
		this.port=client.getPort();
	}
	
	/**Gets the ClientConnection of the player's instance
	 * @since 2.0alpha
	 * @return ClientConnection that handles the client connection with the server*/
	public ClientConnection getConnection(){
		return this.clientConnection;
	}
	
	/**Sets the ClientConnection of the player's instance
	 * @since 2.0alpha
	 * @param connection : ClientConnection to pass*/
	public void setConnection(ClientConnection connection){
		this.clientConnection=connection;
	}
	
	/**Gets the Socket of the player's instance
	 * @since 2.0alpha
	 * @return Socket with the Server*/
	public Socket getSocket(){
		return this.client;
	}
	
	/**Gets the ip of the connection with Server
	 * @since 2.0alpha
	 * @return InetAddress of the socket*/
	public InetAddress getIp(){
		return this.ip;
	}
	
	/**Gets the Port of the connection with the Server
	 * @since 2.0alpha
	 * @return ClientConnection that handles the client connection with the server*/
	public int getPort(){
		return this.port;
	}
	
	/**Gets the Hostname of the player's instance
	 * @since 2.0alpha
	 * @return String HostName*/
	public String getHost(){
		return this.hostname;
	}
	
	/**Gets the Nickname of the player's instance
	 * @since 2.0alpha
	 * @return String nickname*/
	public String getNick(){
		return this.nickname;
	}
	
	/**Sets the nick name passed, if null uses the hostname
	 * @since 2.0alpha
	 * @param s : nickname or void string*/
	public void setNick(String s){
		if(s.equals("")) this.nickname=this.hostname;
		else this.nickname=s;	
	}
	
	/**Gets the time of the player's instance
	 * @since 1.0.1
	 * return double Time*/
	public double getTime(){
			return t;
	}
	
	/**Sets the time of the instance
	 * @since 1.0.1
	 * @param n double*/
	public void setTime(double n){
			if(n==0) this.t=0;
			else this.t+=this.par;
	}
	
	/**Gets the partial time of the player's instance
	 * @since 1.1.0.3
	 * @return double partial p*/
	public double getPartial(){
		return this.par;
	}
	
	/**Calls the System.currentTimeMillis() on p
	 * @since 1.1.0.3*/
	public void setPartial1(){
		this.par=System.currentTimeMillis();
	}
	
	/**Calcs the difference in seconds between 2 instants 
	 * @since 1.1.0.3*/
	public void setPartial2(){
			this.par=System.currentTimeMillis()-this.par;
			this.par/=1000;
	}
	
	/**Find a Player object in an ArrayList of players
	 * @since 2.0alpha
	 * @param player ArrayList of players
	 * @return int index of the object*/
	public int find(ArrayList<Player> players){
		int index=0;
		Player temp;
		Iterator<Player> it= players.iterator();
		while(it.hasNext()){
			temp=it.next();
			if(temp.port==this.port && temp.hostname==this.hostname && temp.ip.equals(this.ip)){
				break;
			}else index ++;
		}
		return index;
	}
	
}

