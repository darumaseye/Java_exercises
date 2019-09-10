package Server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**The server class is the executable class of the package.
 * All starts with the main() method, it asks for the port, creates a Server instance, and start the "service" with Server.start() method.
 * Start() method create a Socket in the port. Then all the incoming connections are passed to the ClientConncetion Class, an instance of which can start the Session.
 * 
 * @see The class Session for further descriptions of it, and its synergies with the Server class
 * @since 2.0alpha
 * @author Jacopo Taccucci (wonty)
 * */

public class Server{

	private static ServerSocket serverSideSocket;
	static ArrayList<Player> players;
	Socket client;
	protected static boolean accept;//TODO MULTISERVER
	
	/**Starts the main function of the Server: Listen for new Connections and Pass them to ClientConnection class
	 * @since 2.0alpha
	 * @param port : Port Number passed to the ServerSocket constructor  
	 * @see IO.output(string s)
	 * @see Player.setConnection()
	 * @see ClientConnection.run()
	 * @see sendBroadcast(ArrayList<Player> player, Comm commandType, String payload)*/
	public void start(int port) throws IOException {
		accept=true;
		players= new ArrayList<Player>();
		Player player;
		serverSideSocket = new ServerSocket(port);
		
		
		while(accept){
			IO.output("Server Up! Waiting for connections...");
			client= serverSideSocket.accept();//waits until a new client asks for connection
			player=new Player(client);
			ClientConnection parallelSocket = new ClientConnection(player);//creates a new ThreadSocket object
			player.setConnection(parallelSocket);
			players.add(player);
			parallelSocket.run();//Single Client connection Handler (New Thread)
			sendBroadcast(players, Comm.STAT, stat(players));
		}	
		serverSideSocket.close();
	}
	
	/**Starts a new session with the actual connected players, passing to the Session constructor an ArrayList of Players
	 * @since 2.0alpha
	 * @see Player.getConnectio()
	 * @see ClientConnection.setsession()
	 * @see Session.run()*/
	/*TODO NEEDED_________________: A semaphore, to substitute the busy waiting
	 * 							  : a solution for the MULTI server (a way to let the Server collecting incoming request, with a flush of the structure after the start of a Session)*/
	public static void startSession(){
		accept=false;
		Session s= new Session(players);
		Iterator<Player> it= players.iterator();
		while(it.hasNext()){
			(it.next().getConnection()).setSession(s);
		}		
		s.run();
		players.clear();
		
	}
	
	/**Returns the Connection Info in a payload of all the clients connected to the Server, to use with send methods
	 * @since 2.0alpha
	 * @param players : Players for the stat
	 * @see Player.getHost()
	 * @see Player.getIp()
	 * @return The string, intended as a payload for Server-> Client message*/
	public static String stat(ArrayList<Player> players){
		Iterator<Player> it= players.iterator();
		String payload="Users Connected, waiting to start a Session:\n";
		Player player;
		while(it.hasNext()){
			player=it.next();
			payload+="\""+player.getHost()+"\":"+"  "+player.getIp()+" "+"\n";
		}
		return payload;
	}
	
	/**Sends a Message to every player of an Array
	 * @since 2.0alpha
	 * @param players : Target players
	 * @param commandType : Type of command (Comm.java)
	 * @param payload : Message's content
	 * @see send(Player player, Comm commandType, String payload)*/
	public static void sendBroadcast(ArrayList<Player> player, Comm commandType, String payload) throws IOException{
		Iterator<Player> it= player.iterator();
		while(it.hasNext()){
			send(it.next(), commandType, payload);
		}
	}
	
	/**Sends a Message to a specific Player
	 * @since 2.0alpha
	 * @param player : Target client
	 * @param commandType : Message type (Comm.java)
	 * @param payload : content of the message
	 * @see Player.getSocket()*/
	private static void send(Player player, Comm commandType, String payload) throws IOException {
		new DataOutputStream(player.getSocket().getOutputStream()).writeBytes(commandType+payload+"\n");
		
	}
	
	/**main Method of the Server, Starts the Server in a specific Port
	 *  @since 2.0alpha
	 *  @param args : not used
	 *  @see Server.start(Int port)
	 *  @see IO.inputInt()*/
	//TODO Pass the port in the argument of the main
	public static void main(String[] args){
		System.out.println("Bro, ur the Serva, just stay there 'n wait all the connections pass through u ;)"
				+ "...gimme the port's number bro");
		Server server=new Server();
		try {
			server.start(IO.inputInt());
		} catch (Exception e) {
			// TODO 
			e.printStackTrace();
		}
	}
	
}


