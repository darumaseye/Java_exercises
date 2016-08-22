import java.util.*;
import java.io.*;


public class Nguiga
{
	public static int findMin(long[] a){
		long min=a[0];
		int index=0;
		for(int i=1; i<a.length; i++){
			if(a[i]<=min){
				min=a[i];
				index=i;
			}
		}
		return index;
	}

  public static void main(String[] args)
  {

    System.out.println("Welcome to Nguiga!\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression in the input window.\n2. Quick Typing:\nchoose the word with of playing than input that in the window\n...just a tip...is better to not mistake!\n");//Fa comparire la finestra che illustra il regolamento.


    InputStreamReader reader = new InputStreamReader(System.in);
    String s="";
    BufferedReader myInput = new BufferedReader(reader);
start:
   while(true){ 
		System.out.print("Input the number of players:");
		int number_of_players=0;
		try{
		   number_of_players=Integer.parseInt(myInput.readLine());
		}catch (IOException e){System.exit(-1);}
		long t[]=new long[number_of_players];	
		System.out.print("Type\n\"calc\" or \"typing\" to choose the game moode\n \"men�\" to return to this men� and change players\n \"exit\" to exit the game: ");
	    String game_mode ="";
	    try{ game_mode=myInput.readLine();
			}catch (IOException e){System.exit(-1);}
	
	
	
	
	
	    if (game_mode.equals("typing")){
			String digit[]= new String[number_of_players];
			System.out.print("Choose the word: ");
			String chosen_word="";
			do{
				try{
					chosen_word=myInput.readLine();
				}catch (IOException e){System.exit(-1);}
				if(chosen_word.equals("men�")||chosen_word.equals("exit"))
					System.out.println(chosen_word+" is a Nguiga keyword, youcan't use it, choose another please.");
				if(chosen_word.equals("exit"))
					System.exit(0);
				if(chosen_word.equals("men�"))
					continue start;
			}while(!chosen_word.equals("calc")&&!chosen_word.equals("typing")&&!chosen_word.equals("men�")&&!chosen_word.equals("exit"));
	
	
			for(int i=0; i<number_of_players; i++){
	
				System.out.print("You have to enter the word until this is correctet.\nPress \"Enter\"to start immediately: ");
				try{
					s=myInput.readLine();
				}catch (IOException e){System.exit(-1);}
				if(s.equals("exit"))
					System.exit(0);
				if(s.equals("men�"))
					continue start;
	
	
				t[i] = System.currentTimeMillis();
				do {
					System.out.print("Input \""+chosen_word+"\": ");
					try{
						digit[i]=myInput.readLine();
					}catch (IOException e){}
					if(digit[i].equals("exit"))
						System.exit(0);
					if(digit[i].equals("men�"))
						continue start;
				}while (!digit[i].equals(chosen_word));
	
				t[i]=System.currentTimeMillis()-t[i];
				System.out.println("Player "+(i+1)+" has typed the correct word in "+t[i]+" milliseconds");
	
			  }
			 int best=findMin(t);
			 System.out.println("The Winner is....Player "+(best+1)+"!!!!");
	
	    }else if (game_mode.equals("calc")){
			Random rand= new Random();
			int result[]= new int[number_of_players];
			int random[]=new int[6];
			String exp;
			int exactValue;
	
	
			for(int i=0; i<number_of_players; i++){
				System.out.print("You have to enter the solution until this is corrected.\nPress 'Enter'to start immediately: ");
				try{
					s=myInput.readLine();
				}catch (IOException e){System.exit(-1);}
				if(s.equals("exit"))
					System.exit(0);
				if(s.equals("men�"))
					continue start;
	
				for(int j=0; j<6; j++){
					random[j]=rand.nextInt(10);
				}
				exp=random[0]+"+14"+random[1]+"+1"+random[2]+"+(3"+random[3]+"*"+random[4]+")*0-6"+random[5];
				exactValue=random[0]+140+random[1]+10+random[2]-(60+random[5]);
				System.out.println(exactValue);
	
				t[i] = System.currentTimeMillis();
				do {
					System.out.print("Calc "+exp+" = ");
					try{
						s=myInput.readLine();
						result[i]=Integer.parseInt(s);
					}catch (IOException e){System.exit(-1);}
					if(s.equals("exit"))
						System.exit(0);
					if(s.equals("men�"))
						continue start;
	
				}while (result[i]!=exactValue);
	
				t[i]=System.currentTimeMillis()-t[i];
				System.out.println("Player "+(i+1)+" has solved the expression in "+t[i]+" milliseconds");
	
			  }
			 int best=findMin(t);
			 System.out.println("The Winner is....Player "+(best+1)+"!!!!");
	
	
	     }else if (game_mode.equals("exit"))
	    	 System.exit(0);
	     else
	    	 continue;
    }
    /*To Add:
              "Press Enter"________________________________DONE
              Calc of the Winner___________________________DONE
              The Number of players depends on input ______DONE
              Add the character "__________________________DONE
              Semi-Random Expressions______________________DONE
              2 modes: quick calc, quick typing____________DONE
              Loop, and exit_______________________________DONE
              Loop, and exit EVERYWHERE____________________
              Custom Names_________________________________
              Handle the dead heat_________________________
              Times in Seconds_____________________________
              Memorize the Players in file_________________
              Clean Code___________________________________
;*/


 }
}
