//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

import java.util.Arrays;
public class GameOfLife{
  public static void main (String[] args){
  }
  
  // a method that check if the universe is valid
  //it returns a boolean value and take a 2D array as input called m
  //Use two for loops to check every element of the matrix 
  //the first for loop checks the array and if the previous one isn't similar it will return false
  //else it will return true and the universe is valid
  //the second for loop is to check the subarrays 
  //only want 1 or 0 in them otherwise return false
  public static boolean isValidUniverse(int [][] m){
    boolean firstCondition = true;
    boolean secondCondition= true; 
    for(int i=0; i<m.length; i++) {
      int length = m[0].length;
      
      if(m[i].length !=length){
        firstCondition = false;
      }
      for(int j = 0; j<m[i].length; j++){
        if(m[i][j]!=1 && m[i][j]!=0){
          secondCondition = false;
        }
      }
    }
    if (firstCondition && secondCondition){
      return true;
    }
    return false;
  }
  
  //a void method that display the universe
  //Use two for loops to display all the element of the matrix
  //if there is a 1 print a * else return nothing
  public static void displayUniverse(int [][]m){
    for (int i =0; i<m.length;i++){
      for (int j =0; j<m[i].length;j++){
        if(m[i][j]==1){
          System.out.print("*");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
  
  
  //a method that count the numbers of neighbors around the point (x.y)
  public static int getNextGenCell(int[][] m, int x, int y){
    int sum=0;
    if (y!=0) {
      if(m[x][y-1]==1){
        //to check if the left neighbor is a 1 
        //if it is 1 then the sum increment by one
        sum++;
      }
    }
    if (y!=(m[x].length-1)){
      if(m[x][y+1]==1){
        //check if the right neighbor is a 1
        //if it is 1 then sum++
        sum++;
      }
    } 
    if (x!=0){
      //check previous array
      if (y!=0){
        if(m[x-1][y-1]==1){
          //check if the left top diagonal is a 1 
          //if it is 1 then sum++
          sum++;
        }
      }
      if(y!=(m[x].length-1)){
        if(m[x-1][y+1]==1){
          //check if the right top diagonal neighbor is a 1
          sum++;
        }  
      }
      if(m[x-1][y]==1){
        //check if the top neighbor is a 1
        sum++;
      }
    }
    if (x!=m.length-1){
      //check next array
      if (y!=0){
        if(m[x+1][y-1]==1){
          //check if the bottom  left  diagonal is a 1 
          sum++;
        }
      }
      if(y!=m[x].length-1){
        if(m[x+1][y+1]==1){
          //check if the bottom right diagonal is a 1
          sum++;
        }
      }
      if(m[x+1][y]==1){
        //check if the bottom point is a 1
        sum++;
      }
    }
    if(m[x][y]==0){
      if(sum==3){
        return 1; 
      }else{
        return 0;
      } 
    }else{
      if(sum<2 || sum>3){ 
        return 0;
      }else{
        //System.out.println(sum + " blabla");
        return 1;
      }
    }
  }
  //a method that create a new array and store the new universe 
  //use a nested for loop to go through all the element of the array 
  //call the previous method and populate the new array created
  //return the new array 
  public static int [][] getNextGenUniverse(int [][]m){
    int [][] temp =  new int [m.length][m[0].length];
    for (int i =0; i<m.length;i++){
      for (int j =0; j<m[i].length;j++){
        int gen = getNextGenCell(m, i, j);
        temp[i][j] = gen;
      }
    }
    return temp;
  }
  
  
  //a method that simulate the next generation
  //if the isValid method is false throw exception 
  //else display the next generation
  //use a for loop to create n generation 
  //use if and else to display the original seed and the generation number
  //call the displayUniverse method and the getNextGenUniverse
  public static void simulateNGenerations(int [][]m, int n){
    boolean isValidUni = isValidUniverse(m);
    if(isValidUni == false){
      throw new IllegalArgumentException ("The Universe created isn't valid!");
    }else{
      for(int i = 1; i<=n; i++){
        if( i == 0){
          System.out.println("Original seed");
        }else{
          System.out.println("Generation " + i);
        }
        displayUniverse(m);
        m = getNextGenUniverse(m);
      }
    }
  }
}

