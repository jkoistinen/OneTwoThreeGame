//import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
/**
 * Write a description of class Game here.
 * 
 * @author Jaakko Koistinen 
 * @version 2015-12-08
 */
public class Game {
public static void main(String[] args) {
    List<String> playerList = new LinkedList<>();
    
    //System.out.println("Skriv in antal spelare...");
    
    //Scanner keyboard = new Scanner(System. in );
    //int numplayers = keyboard.nextInt();
    
    int numplayers = 2;
    
    //System.out.println("Skriv in antal rundor du vill spela...");
    //int numrounds = keyboard.nextInt();
    
    int numrounds = 10;
    
    OneTwoThreeGame myGame = new OneTwoThreeGame(numrounds);
    
    System.out.println("Du valde"+" "+numplayers+" "+"spelare.");
    
    String rundor = "rundor";
    if(numrounds == 1){
    rundor = "runda";
    }
    
    System.out.println("Du valde"+" "+numrounds+" "+rundor+".");
    
    //Generate names for players (Spelare 1, Spelare 2 etc...) 
    for(int i = 1; i <= numplayers; i++) {
        String name = "Spelare"+" "+i;
        playerList.add(name);
    }
   
   //Player objects will be stored in PlayerObject[]
   Player[] PlayerObject = new Player[numplayers];
   
   //Create all player objects
    for(int j = 0; j < playerList.size(); j++) {
        PlayerObject[j] = new Player( playerList.get(j) );
    }
    
    
    //Game runs here
    for(int i = 1; i <= numrounds; i++) {
    System.out.println("Runda"+" "+i+" "+"av"+" "+numrounds+":");
    
    for(int j = 0; j < playerList.size(); j++) {
        //System.out.println("Namn:"+PlayerObject[j].name);
        int rollDice = myGame.playRound();
        PlayerObject[j].addPoints(rollDice);
        String spelare = PlayerObject[j].getName();
        int points = rollDice;
        System.out.println(spelare+" "+":"+rollDice+" "+"poäng");
    }
    //Find the winner of this round
    //Also add 1 to winning Playerobject (add method in Player)
    int max = 0;
    int winningplayerobject = 0;
    for(int k = 0; k < playerList.size(); k++) {
      int inspected = PlayerObject[k].getPoints(i-1);
     
      //System.out.println("Looking at PlayerObject:"+k);
      
      if (inspected > max) {
          max = inspected;
          winningplayerobject = k;
      }
      
      }
    //Check if we have an tie (2 or more players have same score)
    int counter = 0;
    boolean isTie = false;
    for(int l = 0; l < playerList.size(); l++) {
     int inspected = PlayerObject[l].getPoints(i-1);
     if(inspected == max){
         counter = counter + 1;
        }
        
    }
    if(counter > 1){
         isTie = true;
        }
    
    if (isTie) {
    System.out.println("Oavgjort, flera spelare har samma max poäng!"+"("+max+")");
    } else {
      String spelare = PlayerObject[winningplayerobject].getName();
      System.out.println("Vinnare av runda"+" "+i+" "+"med"+" "+max+" "+"poäng är:"+spelare);
      //give point for winning the round
      PlayerObject[winningplayerobject].incrementRoundsWon();
      
    }
    
    
    }
    //check who won in total
    System.out.println("-------------------------------------------------");
    int max = 0;
    int winningplayerobject = 0;
    for(int m = 0; m < playerList.size(); m++) {
        int total = PlayerObject[m].totroundswon;
        String spelare = PlayerObject[m].getName();
        System.out.println(spelare+" "+"vann totalt:"+" "+total+" "+"gånger");
        if (total > max) {
          max = total;
          winningplayerobject = m;
      }
      //
    
    }
    // check if we have a tie in total
    int counter = 0;
    boolean isTie = false;
    for(int n = 0; n < playerList.size(); n++) {
    int current = PlayerObject[n].totroundswon;
    int winner = PlayerObject[winningplayerobject].totroundswon;
     if(current == winner){
         counter = counter + 1;
        }   
    }
    if(counter > 1){
        isTie = true;
    }
    if (isTie) {
    System.out.println("Oavgjort, flera spelare har samma max totalpoäng!");
    } else {
        System.out.println("Vinnare är:"+PlayerObject[winningplayerobject].getName());
    }
    
    }
}
