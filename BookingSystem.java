//Name: Lyna Mariam El Haffaf
//Student Number: 260807052
import java.io.*;
import java.util.Scanner;
public class BookingSystem{
  //a method that create an array with the correct number of double, queen and king type rooms
  //read through the line and pare the number found to an int 
  //Use try/catch to catch the exceptions 
  private static Room[] loadRooms (String fileName){
    int numD = 0;
    int numQ =0;
    int numK=0;
    Room [] room = new Room[0];
    try{
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      
      String a1 = br.readLine();
      String a2 = br.readLine();
      String a3 = br.readLine();
      
      numD = Integer.parseInt(a1);
      numQ = Integer.parseInt(a2);
      numK = Integer.parseInt(a3);
      
      br.close();
      fr.close();
      
    }catch (FileNotFoundException e){
      System.out.println("The file is not found");
    }catch (IOException e){
      System.out.println("IO Exception");
      return room;
    }
    
    //add all three numbers found so that it will equal to the array length 
    //assign the first 10 index to double
    //the 15 following to queen
    //and the last two to king
    room = new Room [numD + numQ + numK];
    for(int i = 0; i<room.length;i++){
      if(i<numD){
        room[i] = new Room ("double");
      }
      if(i>=numD && i<(numD+numQ)){
        room[i] = new Room ("queen");
      }
      if(i>=(numQ+numK) && i<room.length){
        room[i] = new Room ("king"); 
      }
    }
    
    return room;
  }
  
  //a main method that displays the booking system
  public static void main (String [] args){
    //initialize a scanner
    Scanner hotelScanner = new Scanner(System.in);
    System.out.println("Welcome to the COMP 202 booking systemy");
    System.out.println("Please enter the name of the hotel you'd like to book");
    String h = hotelScanner.nextLine();
    Hotel h1 =  new Hotel (h, loadRooms("roomInfo.txt"));
    
    //use try/catch to read the loadReservation file
    try{
      Reservation [] a = h1.loadReservations("reservationsInfo.txt");
    }catch (FileNotFoundException e){
      System.out.println("File not found!");
    }catch (IOException e){
      System.out.println("IO Exception");
    }
    
    //print out the menu
    String stars = "**************************************************************";
    System.out.println(stars);
    //String menu = ("\n" + stars + "\nWelcome to the " + h + " Hotel. Please  choose one of the following options");
    System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
    System.out.println(stars);

    
    //use a while loop to execute the command as long as it's not equal to 5
    //if it is need to go out of the loop and print corresponding message
    int x = hotelScanner.nextInt();
    String name; 
    String type;
    while(x != 5){
      if(x==1){
        System.out.print("Please enter your name: ");
        name =hotelScanner.nextLine();
        name =hotelScanner.nextLine();
        System.out.print("What type of room would you like to reserve?");
        type = hotelScanner.nextLine();
        
        //call createReservation to make a new reservation
        //since it is a nonstatic method call it on the object of the hotel class created before
        int create = h1.createReservation(name, type);
        if(create == -1){
          System.out.println("Sorry " + name + ", we have no available rooms of the desired type.");
        }else{
          System.out.println("You have successfully reserved a " +  type + " room under the name of " + name);
          System.out.println("We look forward having you at " + h + " !");
        }
        System.out.println(stars);
        System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
        System.out.println(stars);
        x = hotelScanner.nextInt();
       

      }
      //print what is necessary and call cancelReservation method from the hotel class
      //call it on the object h1 since it is a non static method
      if(x==2){
        System.out.print("Please enter the name you used to make the reservation");
        name = hotelScanner.nextLine();
        name = hotelScanner.nextLine();
        System.out.print("What type of room did you reserve?");
        type = hotelScanner.nextLine();
        h1.cancelReservation(name, type);
       
        System.out.println(stars);
        System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
        System.out.println(stars);
        x = hotelScanner.nextInt();
        
      }
      //call Invoice from the hotel class on the h1 object and print what is necessary
      if (x==3){
        System.out.print("Please enter your name: ");
        name = hotelScanner.nextLine();
        name = hotelScanner.nextLine();
        h1.printInvoice(name);
      
        System.out.println(stars);
        System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
        System.out.println(stars);       
        x = hotelScanner.nextInt();
       
      }
      //print what is necessary and call the toString method 
      if(x==4){
        System.out.println("Here is the hotel info");
        System.out.println(h1);
        
       
        System.out.println();
        System.out.println(stars);
        System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
        System.out.println(stars);
        x = hotelScanner.nextInt();
       
      }
      //print an incorrect message since there is no options that go above 5
      if(x>5){
        System.out.println("Incorrect option! ");
        System.out.println(stars);
        System.out.println("Welcome to the " + h + " , choose one of the following options: \n1. Make a reservation \n2. Cancel a reservation\n3. See an invoice\n4. See hotel info\n5. Exit the booking system");
        System.out.println(stars);
        x = hotelScanner.nextInt();
        
        
      }
      //exit the booking system and save the reservations
      if(x==5){
        System.out.println("It was a pleasure doing business with you!");
        try{
          h1.saveReservation("reservationsInfo.txt");
        }catch (FileNotFoundException e){
          System.out.println("");
        }catch (IOException e){
          System.out.println("");
        }
      }
    }
  }
}
