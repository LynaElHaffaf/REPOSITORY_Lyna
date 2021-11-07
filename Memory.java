//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Memory{
  public static void main (String [] args){
    playMemory();
  }
  
  //a method that generate the numbers of cards
  //create an array that has the same n numbers repeated twice
  public static int[] generateCards(int n){
    int [] numbers = new int [2*n];
    for(int i = 0; i<n; i++){
      numbers[i]=i+1;
    }
    for (int i =n; i<2*n;i++){
      numbers[i]=(i+1)-n;
    }
    return numbers;
  }  
  
  //a method that shuffle the numbers in the array
  //Use Random to mix the numbers randomly 
  //Use a for loop to shuffle the cards 100000 times 
  //create an temp to swap the cards
  public static void shuffleCards(int [] cards){
    Random j = new Random(123);
    for(int i = 0; i<100000;i++){
      int number1 = j.nextInt(cards.length); 
      int number2 = j.nextInt(cards.length); 
      int temp = cards[number1];
      cards[number1] = cards[number2];
      cards[number2] = temp; 
    }
  }
  
  //a method that display the cards
  //if i =x display i 
  //if i = y diplay i
  //if cards[i] = -1 display * because the cards has already been guessed
  //else diplay a "-"
  public static void displayCards(int [] cards, int x, int y){
    for(int i=0; i<cards.length; i++){
      if (i == x){
        System.out.print(cards[i] + "\t");
      }else if (i == y){
        System.out.print(cards[i] + "\t");
      }else if (cards[i]==-1){
        System.out.print("*\t");
      }else{
        System.out.print("-\t");
      }
    }
    System.out.println();
  }
  
  //a method that check if the guess is valid 
  //use a for loop to go through the length of the array
  //if the guess is out of range display a message saying so
  //else if cards[x]==-1 or cards[x]==-1 display that this card has already been guessed
  public static boolean isValidGuess(int [] cards, int x, int y){
    for(int i=0;i<cards.length;i++){
      if((x <0 || x >cards.length) || ( y <0 || y >cards.length)){
        System.out.println("One of your guesses is out of range. Your guesses should be numbers between 0 and " + cards.length);
        return false;
      }else if (cards[x]==-1 || cards[y]==-1){
        System.out.println("You have already correctly guessed one of these cards. You wasted a guess!");
        return false;
      }else{ 
        return true;
        
      }
    }
    return false;
  }
  
  //a method that check if the guess is correct and update the cards 
  //if the guess is correct update the cards to be -1
  //else need to display a message to try again
  public static void checkAndUpdate(int [] cards, int x, int y){
    for (int i = 0; i<cards.length;i++){
      if(cards[x]==cards[y]){
        System.out.println("Good job, you got it!");
        cards[x]=-1;
        cards[y]=-1;
        break;
      }else{
        System.out.println("Sorry!:( Try again!");
        break;
      }
    }
  }
  
  //a method that tells if the game is completed
  //when a cards isn't equal to -1 the game isn't completed
  //else it is complete
  public static boolean gameCompleted (int [] cards){
    for(int i =0;i<cards.length;i++){
      if(cards[i]!=-1){
        return false;
      }else{
        return true;
      }
    }
    return true;
  }
  
  //a method that set the game
  //use scanner to ask questions and for the player to input it's guess
  //put a countGuess to output the numbers of tries the players needed
  //Use a while loop to restart the game until it is completed
  //when the game is finished display a message that says so
  public static void playMemory(){
    int countGuesses =0;
    Scanner c = new Scanner(System.in);
    System.out.println("Welcome to Memory!");
    System.out.println("Please chose the size of your game.");
    int size = c.nextInt();
    if(size<=0){
      System.out.println("The game can't be built. Need positive number");
    }else{
      int [] cards = generateCards(size);
      shuffleCards(cards);
      //System.out.print(Arrays.toString(cards));
      System.out.println("Enter your first guess:");
      int guess = c.nextInt();
      System.out.println("Enter your second guess:");
      int guess2 = c.nextInt();
      countGuesses++;
      while (gameCompleted(cards) != true) {
        if (isValidGuess(cards, guess, guess2) == true) {
          displayCards(cards, guess, guess2);
          checkAndUpdate(cards, guess, guess2);
          System.out.println("Enter your first guess:");
          guess = c.nextInt();
          System.out.println("Enter your second guess:");
          guess2 = c.nextInt();
          countGuesses++;
        }
      }
      System.out.println("Great job, you got it!");
      System.out.println("Congratulation! You finished the game with only " + countGuesses + " tries!");
    }
  }
}