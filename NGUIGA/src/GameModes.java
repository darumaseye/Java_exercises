/**
 * @version 1.1.0.3
 * @author Jacopo Taccucci (wonty) & SquallorX (since 1.1)
 * @since 1.0
 * @see Nguiga class for Description
 * */

public class GameModes{

	public static int number_of_players;
	public static Player[] array_of_players;


	/**@since 1.1*/
	public static void defPlayers(){
		System.out.println("Input the number of players:");
		number_of_players=IO.inputInt();
		array_of_players = new Player[number_of_players];
		for(int i=0; i<number_of_players; i++){
			System.out.println("Player "+(i+1)+",please choose a nickname!(just press \"Enter\" for the default one)");
			String s=IO.inputString();
			if(s.equals("")) array_of_players[i]= new Player("Player "+(i+1));
			else array_of_players[i]= new Player(s);
		}

	}
	/**@since 1.1.0.2 Just Calc the best player, the deadheat must be handled in future version  */
	public static void announceWinner(String q){
		double min=array_of_players[0].getTime();
		int index=0;
		for(int i=1; i<number_of_players; i++){
			if(array_of_players[i].getTime()<=min&&array_of_players[i].getTime()!=0){
				min=array_of_players[i].getTime();
				index=i;
			}
		}
		 System.out.println("The Winner is...."+array_of_players[index].getName()+"!!!!");
		String s="";
		 do{
			System.out.println("Do you want to save progress in a file [y/n]");
		 	s=IO.inputString();
		 	}
		 while(!s.equals("y")&&!s.equals("n"));
		 if(s.equals("y")){
			 System.out.println("Oh! Thank You!\nYou are a good man Sir\nPlease insert the path of the file:");
			 IO.output(array_of_players,IO.inputString(),q);
		}else if(s.equals("n"))
			System.out.println("ok :( ....\n");

		 System.out.println(".......Restarting........");
		 Nguiga.play();
	}

}
