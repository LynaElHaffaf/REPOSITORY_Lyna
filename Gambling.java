//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

public class Gambling {
  //Main method that display the code of the methods below
  //Use int num to keep the value of diceRoll() in the second stage
  public static void main(String [] args){
    double totalMoney = Double.parseDouble (args[0]);
    double moneyBet = Double.parseDouble (args [1]);
    System.out.println(passLineBet(totalMoney, moneyBet));
    int num = diceRoll();
    System.out.println(num);
    System.out.println(secondStage(num));
    System.out.println(canPlay(5.25, 2.0));
    
  }
  
  //a method to roll two six-sided dice with the Math.random function
  //use typecasting (int) because the Math.random return a double 
  //Sum of both dice to get an integer between 2 and 12
  public static int diceRoll(){
    int dice1 = (int)(Math.random()*6)+1;
    int dice2 = (int)(Math.random()*6)+1;
    return (dice1 + dice2);
  }
  
  //a method that stimulates the second stage of the Pass Line Bet
  //return an int which is either 7 or the point
  //Use the while loop and the && operator
  public static int secondStage(int point){
    int x = diceRoll(); 
    while ((x != point) && (x!=7)){
      System.out.print(""+ x + " ");
      x = diceRoll();
    }
    return x;
  }
  
  //a method that tells if the player has enough money to play
  //use the condition if else and the && operator
  //the moneBet has to be more than 0 and less than the total money the player has
  public static boolean canPlay (double totalMoney, double moneyBet){
    if ((moneyBet > 0.0) && (moneyBet < totalMoney)){
      return (true);
    }else{
      return (false);
    }
  }
  
  // a method that checks if the player has enough money and stimulate a round of Craps
  // use condition if else to check if enough money 
  // return the total amount of money if can't play
  public static double passLineBet(double totalMoney, double moneyBet){
    if (canPlay(5.25, 2.0) == false){
      System.out.println(" Can't play, no sufficient funds " + totalMoney);
      return totalMoney;
    }else{
      System.out.println("You now have: " + (totalMoney - moneyBet));
    }
    
    
    //stimulation of a round of Craps
    //if 7 or 11 win 
    // if 2, 3 or 12 lose
    // if other roll again 
    //use of the condition if else if and the operator ||
    int x = diceRoll();
    if (x == 7 || x == 11){
      System.out.println("A " + x + " has been rolled. You win!");
      return (totalMoney + totalMoney); 
    }else if (x == 2 || x == 3 || x == 12){
      System.out.println("A " + x + " has been rolled. You lose!");
    }else{
      System.out.println("A " + x + " has been rolled. Roll again!");
      return x;
    }
    return (totalMoney - moneyBet);
  }
}


                     