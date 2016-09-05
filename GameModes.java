/**
 * @version 1.0
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

public class GameModes{

	public static int number_of_players;
	public static long[] t;


	/**@since 1.1*/
	public static void defNPlayers(){
		System.out.println("Input the number of players:\n");
		number_of_players=Input.inputInt();
		t=new long[number_of_players];

	}


	/**@since 1.0 Just Calc the best player, the deadheat must be handled in future version  */
	public static void announceWinner(long[] a){
		long min=a[0];
		int index=0;
		for(int i=1; i<a.length; i++){
			if(a[i]<=min&&a[i]!=0){
				min=a[i];
				index=i;
			}
		}
		 System.out.println("The Winner is....Player "+(index+1)+"!!!!");
		 System.out.println(".......Restarting........");
		 Nguiga.play();
	}

}
