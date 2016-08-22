import fond.io.*;

public class Nguiga
{
  public static void main(String[] args)
  {

    System.out.println("Welcome to Nguiga! \nThis is a 2 players game.\nThe Winner is the fastest player in solving the request.\n1.Quick Calc:\nSolve the expression in the input window.\n2. Quick Typing:\nchoose the word with of playing\nthan input that in the window\n...just a tip...\nis better to not mistake!");//Fa comparire la finestra che illustra il regolamento.

    InputWindow opzioni_gioco = new InputWindow();
    String scelta_gioco = opzioni_gioco.readString("Type 'calc' or 'typing' to choose the game mood");

    if (scelta_gioco.equals("typing")){

       InputWindow parola_iniziale = new InputWindow();// Fa comparire la finestra per scegliere la parola
       String parola_scelta = parola_iniziale.readString("Choose the word");//come sopra

       InputWindow winwaitmano1 = new InputWindow();// 1° FInestra di INput per Iniziare
       String variniziamano1 = winwaitmano1.readString("Type 'Start' and click 'ok'\nto start immediatly,\n you should input the word\nuntil this will be correct");
       long t0 = 0;
       if (variniziamano1.equals("Start")){
          t0 = System.currentTimeMillis();
          String digit1 = "";
          do {
			  InputWindow inputgmer1 = new InputWindow ();//Finestra di input 1° giocatore
              digit1 = inputgmer1.readString("Input "+parola_scelta);
		     }
		  while (!digit1.equals(parola_scelta));
       }//parentesi conclusiva primo if secondario

       long t1 = System.currentTimeMillis();
	   long diff1 = t1-t0;
	   System.out.println("Il Giocatore 1 ha digitato la parola scelta in "+diff1+" millisecondi");//RIsultati 1°giocatore Personalizzazionedei nomi

       System.gc();

       InputWindow winwaitmano2 = new InputWindow();// 2° FInestra di INput per Iniziare
       String variniziamano2 = winwaitmano2.readString("Digita 'inizia' e clicca 'ok'\nper far comparire la finestra di gioco,\n ti verrà richiesto di scrivere la parola \nfinché questa non sarà corretta");
       long t2 = 0;
       if (variniziamano2.equals("inizia")){
          String digit2 = "";
          t2 = System.currentTimeMillis();
          do {
              InputWindow inputgmer2 = new InputWindow ();//Finestra di Input 2° giocatore
              digit2 = inputgmer2.readString("Inserisci "+parola_scelta);
		     }
          while (!parola_scelta.equals(digit2));// Faccio ripetere la digitazione della parola fin quando non è corretta
       }//parentesi conclusiva secondo if secondario

       long t3 = System.currentTimeMillis();
	   long diff2 = t3-t2;
       System.out.println("IL Giocatore 2 ha digitato la parola scelta in "+diff2+" millisecondi");//Risultati 2°giocatore

       if (diff1<diff2){
		   System.out.println("Il Vincitore è....Il giocatore 1!!!!");
	      }
	   if (diff1>diff2){
		   System.out.println("Il Vincitore è....Il giocatore 2!!!!");
	      }
    }//parentesi conclusiva if principale

    if (scelta_gioco.equals("mente")){

	   InputWindow winwaitmente1 = new InputWindow();// 1° FInestra di INput per Iniziare
	   String variniziamente1 = winwaitmente1.readString("Digita 'inizia' e clicca 'ok'\nper far comparire la finestra di gioco,\n ti verrà richiesto di rifare il calcolo \nfinché questo non sarà corretto");
       long t0 = 0;

       if (variniziamente1.equals("inizia")){
          String digit1 = "";
          t0 = System.currentTimeMillis();
		  do {
		      InputWindow inputgmer1 = new InputWindow ();//Finestra di Input 1° giocatore
		      digit1 = inputgmer1.readString("Calcola 8+147+15+(32*3)*0-61");
		     }
		  while (!digit1.equals("109"));// Faccio ripetere il calcolo fin quando non è corretto
       }//parentesi conlcusiva primo if del 2° if primario

	  long t1 = System.currentTimeMillis();
	  long diff1 = t1-t0;
	  System.out.println("Il giocatore 1 ha risolto l'espressione in "+diff1+" millisecondi");

      InputWindow winwaitmente2 = new InputWindow();// 1° FInestra di INput per Iniziare
	  String variniziamente2 = winwaitmente1.readString("Digita 'inizia' e clicca 'ok'\nper far comparire la finestra di gioco,\n ti verrà richiesto di rifare il calcolo \nfinché questo non sarà corretto");
      long t2 = 0;
	         if (variniziamente2.equals("inizia")){
	  		  String digit2 = "";
	  		  t2 = System.currentTimeMillis();
	          //int digit2 = 0;
	  		  do {
				  int a=
	  		      InputWindow inputgmer2 = new InputWindow ();//Finestra di Input 1° giocatore
	  		      digit2 = inputgmer2.readString("Calcola 28+136+5+(64*9)*0-86");
			     }
	  		  while (!digit2.equals("83"));// Faccio ripetere il calcolo fin quando non è corretto
            }//parentesi conlcusiva secondo if del 2° if primario

      long t3 = System.currentTimeMillis();
	  long diff2 = t3-t2;
	  System.out.println("Il giocatore 2 ha risolto l'espressione in "+diff2+" millisecondi");
	  if (diff1<diff2){
	     System.out.println("Il Vincitore è....Il giocatore 1!!!!");
	  }
	  if (diff1>diff2){
	  	 System.out.println("Il Vincitore è....Il giocatore 2!!!!");
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
    Versione con calcoli casuali*/

 }
}