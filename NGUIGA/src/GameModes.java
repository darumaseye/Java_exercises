/**
 * @version 1.2
 * @author Jacopo Taccucci (wonty) & SquallorX (for 1.1.0)
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
		sort();
		int a=theresLoosers();
		int b=checkDeadHeat();

		if(a!=number_of_players){
			if(b!=0)System.out.print("\nThe Game finished with a Dead Heat!\nThe Winners are....");
			else System.out.print("\nThe Winner is....");
				for(int i=a;i<=a+b;i++){
					System.out.print(array_of_players[i].getName());
					if(i!=b)
					System.out.print(" & ");
				}
				System.out.println("!!!!\n");

		}else{if(number_of_players==1) System.out.println("\nMmh One Player One Looser...ok....\n");
		else System.out.println("\nBad News for you...it seems all of you are Loosers....\n");

			}

		String s="";
		 do{
			System.out.println("Do you want to save progress in a file? [y/n]");
		 	s=IO.inputString();
		 	}
		 while(!s.equals("y")&&!s.equals("n"));
		 if(s.equals("y")){
			 System.out.println("Oh! Thank You!\nYou are a good man Sir\nPlease insert the path of the file, or just the name(with the correct extension):");
			 IO.output(array_of_players,IO.inputString(),q);
		}else if(s.equals("n"))
			System.out.print("ok :( ....");

		 System.out.println(".......Restarting........\n");
		 Nguiga.play();
	}
	/**@since 1.1.0.6*/
	public static int theresLoosers(){
			int j=0;
			for(int i=0;i<number_of_players;i++){
				if(array_of_players[i].getTime()==0) j++;
				else break;
			}
			return j;
		}
	/**@since 1.1.0.6*/
	public static int checkDeadHeat(){
		int i=theresLoosers();
		if(i>=number_of_players)
		return 0;
		else{
			double min=array_of_players[i].getTime();
			int num=0;
			i++;
			while(i<number_of_players&&array_of_players[i].getTime()==min){
				num++;
				i++;
			}
			return num;
		}
	}
	/**@since 1.1.0.5*/
	public static void sort(){
		sortRic(0,number_of_players-1);
	}
	/**@since 1.1.0.5*/
	public static void sortRic(int sx, int dx){
		if(sx+1<dx){
			int p=partition(sx,dx);
			sortRic(sx,p-1);
			sortRic(p+1,dx);
		}
	}
	/**@since 1.1.0.5*/
	public static int partition(int sx, int dx){
		double pivot = array_of_players[dx].getTime();
		int i=sx-1;

		for(int j=sx;j<=dx-1; j++){
			if(array_of_players[j].getTime()<=pivot){
				i++;
				scambia(i,j);
			}
		}
			scambia(i+1,dx);
			return i+1;

	}
	/**@since 1.1.0.5*/
	public static void scambia(int i, int j){
		Player temp=array_of_players[i];
		array_of_players[i]=array_of_players[j];
		array_of_players[j]=temp;
	}

}
