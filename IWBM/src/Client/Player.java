package Client;

/**
*In Player class should be implemented:
*										
*										Input of each player
*										Array of times
*										Methods to get and set all variables
*
* All this to create an Array of Objects Player that should replace t array, result array and digit array
* @version 2.0alpha
* @author Jacopo Taccucci (wonty)
* @since 1.0.1
* @see Iwbm class for Description
* 
*/

public class Player{

	private String name;
	private double t=0;
	private double par;

	public Player(String n){
		this.name=n;
		this.t=0;
	}

	/**@since 1.0.1*/
	public String getName(){
		return name;
	}
	
	/**@since 1.0.1*/
	public void setName(String n){
		this.name=n;
	}

	/**Gets the time of the player's instance
	 * @since 1.0.1
	 * @return double Time*/
	public double getTime(){
			return t;
	}
	
	/**Sets the time of the instance
	 * @since 1.0.1
	 * @param n double
	 * @updated 2.0alpha*/
	public void setTime(double n){
			if(n==0) this.t+=0;
			else this.t+=this.par;

	}
	
	/**Calls the System.currentTimeMillis() on p
	 * @since 1.1.0.3**/
	public void setPartial1(){
		this.par=System.currentTimeMillis();
	}
	
	/**Calcs the difference in seconds between 2 instants 
	 * @since 1.1.0.3*/
	public void setPartial2(){
			this.par=System.currentTimeMillis()-this.par;
			this.par/=1000;
	}
	
	/**Gets the partial time of the player's instance
	 * @since 1.1.0.3
	 * @return double partial p*/
	public double getPartial(){
		return this.par;
	}


}