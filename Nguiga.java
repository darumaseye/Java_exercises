import java.util.*;


public class Nguiga
{
  public static void main(String[] args)
  {

    System.out.println("Welcome to Nguiga! \nThis is a 2 players game.\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression in the input window.\n2. Quick Typing:\nchoose the word with of playing\nthan input that in the window\n...just a tip...\nis better to not mistake!");//Fa comparire la finestra che illustra il regolamento.

    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    System.out.print("Type 'calc' or 'typing' to choose the game mood: ");
    String scelta_gioco = input.nextLine();

    if (scelta_gioco.equals("typing")){
		String digit1,digit2;

       System.out.print("Choose the word: ");
       String parola_scelta = input.nextLine();//come sopra

	   System.out.print("Press 'Enter'\nto start immediatly,\n you should input the word\nuntil this will be correct: ");
       String variniziamano1 = input.nextLine();
       long t0 = 0;
          t0 = System.currentTimeMillis();
          do {
			  System.out.print("Input "+parola_scelta+": ");//Finestra di input 1° giocatore
              digit1 = input.nextLine();
		     }
		  while (!digit1.equals(parola_scelta));
       //parentesi conclusiva primo if secondario

       long t1 = System.currentTimeMillis();
	   long diff1 = t1-t0;
	   System.out.println("Player 1 has typed the correct word in "+diff1+" milliseconds");//RIsultati 1°giocatore Personalizzazionedei nomi

       System.gc();

       System.out.print("Press 'Enter'\nto start immediatly,\n you should input the word\nuntil this will be correct: ");// 2° FInestra di INput per Iniziare
       String variniziamano2 = input2.nextLine();
       long t2 = 0;
          t2 = System.currentTimeMillis();
          do {
              System.out.print("Input "+parola_scelta+": ");//Finestra di Input 2° giocatore
              digit2 = input.nextLine();
		     }
          while (!parola_scelta.equals(digit2));// Faccio ripetere la digitazione della parola fin quando non è corretta
       //parentesi conclusiva secondo if secondario

       long t3 = System.currentTimeMillis();
	   long diff2 = t3-t2;
       System.out.println("Player 2 has typed the correct word in "+diff2+" milliseconds");//Risultati 2°giocatore

       if (diff1<diff2){
		   System.out.println("The Winner is....Player 1!!!!");
	      }
	   if (diff1>diff2){
		   System.out.println("The Winner is....Player 2!!!!");
	      }
    }//parentesi conclusiva if principale

    if (scelta_gioco.equals("calc")){
		int result1, result2;

	   System.out.print("Press 'Enter'\nto start immediatly,\n you should input the solution \nuntil this is corrected: ");
	   String variniziamente1 = input.nextLine();
       long t0 = 0;
       t0 = System.currentTimeMillis();
		do {
		      System.out.print("Calc 8+147+15+(32*3)*0-61 = ");//Finestra di Input 1° giocatore
		      result1 = input.nextInt();
		     }
		while (result1!=109);// Faccio ripetere il calcolo fin quando non è corretto
       //parentesi conlcusiva primo if del 2° if primario

	  long t1 = System.currentTimeMillis();
	  long diff1 = t1-t0;
	  System.out.println("Player 1 has solved the expression in "+diff1+" ms");

      System.out.print("Press 'Enter'\nto start immediatly,\n you should input the solution \nuntil this is corrected: ");// 1° FInestra di INput per Iniziare
	  String variniziamente2 = input2.nextLine();
      long t2 = 0;
      t2 = System.currentTimeMillis();
	  do {
	  	System.out.print("Calc 28+136+5+(64*9)*0-86= ");//Finestra di Input 1° giocatore
	  	result2 = input.nextInt();
		}
	  while (result2!=83);// Faccio ripetere il calcolo fin quando non è corretto
           //parentesi conlcusiva secondo if del 2° if primario

      long t3 = System.currentTimeMillis();
	  long diff2 = t3-t2;
	  System.out.println("Player 2 has solved the expression in "+diff2+" ms");
	  if (diff1<diff2){
	     System.out.println("The Winner is....Player 1!!!!");
	  }
	  if (diff1>diff2){
	  	 System.out.println("The Winner is....Player 2!!!!");
	  }
     }//parentesi del 2° if primario
    /*Da aggiungere:
              Tasto Inizia, blocco main qualcosa che separa;RISOLTO FUNZIONE IF
              Calcolo del giocatore Vincente;
              Condizioni Per la parola scelta se la parola è sbagliata vince l'altro;
              Controllare come azzerare le variabili;RISOLVERE CON BLOCCO DI ISTRUZIONI
              Aumentare numero partecipanti secondo INPUT;
              Capire come scrivere il travirgolette in una stringa o in una variabile qualsiasi;
              Elaborare una Versione con i Numeri;
              Menù di Scelta Velocità di Calcolo o Velocità di Scrittura
              semplificare la procedura di inizio
              aggiungere finestra che a fine gioco fa riiniziare scegliendo la modalità
              Versione con calcoli casuali
              Custom Names
              Tempi in secondi
              Log*/


 }
}
