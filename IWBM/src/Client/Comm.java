package Client;
/**Enum class for the Type of message in the Communication Protocol 
 * @since 2.0alpha
 * @author Jacopo Taccucci (wonty)*/

public enum Comm {
		NICK, /** Private Message Client-> Server: containing the NickName of a client
		 		*WITH PAYLOAD*/
		
		STRT, /** Private Message Client-> Server: reserved for starting a Session
		        *NO PAYLOAD*/
		
		CANC, /** Private Message Client-> Server: reserved for canceling a start request
		        *NO PAYLOAD*/
		
		TIME, /** Private Message Client-> Server: containing the time of a single game
		        *WITH PAYLOAD*/
		
		VOTE, /** Private Message Client-> Server: containing the Client's vote of the Start phase
		        *WITH PAYLOAD*/
		
		RESS, /** Private Message Client-> Server: containing String result
		        *WITH PAYLOAD*/
		
		RESI, /** Private Message Client-> Server: containing Integer result
		        *WITH PAYLOAD*/
		
		GMSG, /** General Message 
		        *WITH PAYLOAD*/
		
		STAT, /** Broadcast Message: Define a message for Connection's Statistics 
		        *WITH PAYLOAD*/
		
		G001, /** Broadcast Message Server -> Client: QuickTyping chosen
	        	*NO PAYLOAD*/
		
		G002, /** Broadcast Message Server -> Client: QuickCalc chosen
	         	*NO PAYLOAD*/
		
		G111, /**Broadcast Message Server -> Client: Tournament chosen
	        	*NO PAYLOAD*/
		
		WINN, /** bROADCAST Message Server -> The Winner Is...
		 		*WITH PAYLOAD*/
		
		XXXX, /**Broadcast Message Server -> Client: Session Terminated
    	*NO PAYLOAD*/
}