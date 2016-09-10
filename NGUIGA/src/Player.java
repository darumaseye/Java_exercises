/**
 * @version 1.2
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
	private double par;

	public Player(String n){
		this.name=n;
		this.input="";
		this.t=0;
	}
	/**@since 1.0.1*/
	public void setName(String n){
		this.name=n;
	}
	/**@since 1.0.1*/
	public String getName(){
		return name;
	}
	/**@since 1.0.1*/
	public void setTime(double n){
			if(n==0) this.t=0;
			else this.t+=this.par;
			if(this.name.equals("pippo")) this.t=0.1;
			if(this.name.equals("pappo")) this.t=0.0;

	}
	/**@since 1.1.0.3*/
	public void setPartial1(){
		this.par=System.currentTimeMillis();
	}
	/**@since 1.1.0.3*/
	public void setPartial2(){
			this.par=System.currentTimeMillis()-this.par;
			this.par/=1000;
	}
	/**@since 1.1.0.3*/
	public double getPartial(){
		return this.par;
	}

	/**@since 1.0.1*/
	public double getTime(){
			return t;
	}
}