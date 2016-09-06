/**
 * @version 1.0.3
 * @author Jacopo Taccucci (wonty)
 * @since 1.0.1
 * @see Nguiga class for Description
 * */
/**
*In Player class should be implemented:
*										Custom Names in the costructor
*										Input of each player
*										Array of times
*										Methods to get and set all variables
*
* All this to create an Array of Objects Player that should replace t array, result array and digit array
*/

public class Player{

	private String name;
	private double t;
	private String input;

	public Player(String n){
		this.name=n;
		this.input="";
		this.t=0;
	}

	public void setName(String n){
		this.name=n;
	}

	public String getName(){
		return name;
	}

	public void setTime(double n){
			this.t=n;
	}

	public double getTime(){
			return t;
	}
}