//Name: Lyna Mariam El Haffaf
//Student Number: 260807052
import  java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.*;
public class Hotel{
  //declare the attributes
  private String name; 
  private Room [] roomInHotel;
  private Reservation[] reservationInHotel;
  
  //a constructor method that create a copy of the Room array by initializing the array
  //then using a for loop to go through the elements
  //populate the new array
  public Hotel (String name, Room [] r){
    this.name = name;
    Room [] copyRoomInHotel = new Room[r.length];
    for (int i = 0;i<r.length;i++){
      copyRoomInHotel[i] = r[i];
    }
    this.roomInHotel = copyRoomInHotel;
  }
  
  //a private method to add a reservation to the reservation array
  private void addReservation(Reservation reservationInHotel){
    //create an array that has space for one extra course (if the room wanted exist and is not null)
    Reservation [] newReservation;
    if(this.reservationInHotel == null){
      newReservation = new Reservation[1];
    }else{
      newReservation = new Reservation[this.reservationInHotel.length+1];
      //copy old elements 
      for(int i = 0; i<this.reservationInHotel.length;i++){
        newReservation[i] = this.reservationInHotel[i];
      }
    }
    //add the extra room 
    newReservation[newReservation.length -1]=reservationInHotel;
    this.reservationInHotel = newReservation;
  }
  
  //a method that remove the reservation from the array
  //create a count which will be the length of the array and a boolean b
  //go through the element of the array of reservation 
  //if the reservation found isn't null then increment the count and verify if the name and the type is the correct one
  //If the name and type correspond than change the availability of the room
  private void removeReservation(String name, String type){
    int count =0;
    boolean b = false;
    for(int i=0;i<this.reservationInHotel.length;i++){
      if(this.reservationInHotel[i]!= null){
        count++;
        String roomName = this.reservationInHotel[i].getName();
        String roomType = this.reservationInHotel[i].getRoom().getType();
        if(roomName.equalsIgnoreCase(name) && (roomType.equalsIgnoreCase(type))){
          b=true;
          this.reservationInHotel[i].getRoom().changeAvailability();
        }
      }
    }
    //if b is false, create a new array and use the length of the previous array -1
    //declare a variable y and set it to 0
    //go through the element of the new array and as long as j isn't equal to the count then
    //populate the new array with the old one and assign the new array to the old one 
    //if b is true than throw the exception
    if(b){
       Reservation [] newReservation = new Reservation[this.reservationInHotel.length -1];
       int y =0;
       for(int j =0;j<newReservation.length;j++){
         if(j!=count){
           newReservation[y]=this.reservationInHotel[j];
           y++;
         }
       }
       this.reservationInHotel = newReservation;
    }
    if(!b){
      throw new NoSuchElementException ("No reservation have been made under this name!");
    }
  }
  
  //a method that create a new reservation
  //if the roomFound is null return -1
  // else change the availability and call addReservation
  public int createReservation(String name, String type){
    // create new array 
    Room roomFound = Room.findAvailableRoom(this.roomInHotel, type); 
    if(roomFound == null){
      return -1; 
    }else{
      Reservation newReserv = new Reservation (roomFound, name);
      newReserv.getRoom().changeAvailability();
      addReservation(newReserv);
    }
    return this.reservationInHotel.length;
  }
  
  //a method that cancel the reservation
  //use try catch to catch the NoSuchElementException
  //call remove Reservation
  public void cancelReservation(String name, String type){
    int x = 0; 
    try {
      removeReservation(name, type);
    }catch (NoSuchElementException e){
      System.out.println("No reservation under such name has been made for the given type of room.");
      x++;
    }
      if(x==0){
      System.out.println("You're reservation has been cancelled!");
    }
  }
  
  
  //a method that print the due amount under a given name
  //of the name if gound then get the price for the room type reserved 
  //if the invoice is of 0 then print a statement that says so 
  //else print the price
  public void printInvoice(String name){
    double price = 0; 
    for(int i =0; i<reservationInHotel.length;i++){
      if((name).equalsIgnoreCase(reservationInHotel[i].getName())){
        price = price + reservationInHotel[i].getRoom().getPrice();
      }
    }
    if(price == 0){
      System.out.println(name + "'s invoice is of $" + 0.0);
    }else{
      System.out.println(name + "'s invoice is of $" + price);
    }
  }
  
  //a toString method to display the availability of the room 
  //check if the type correspond to double, queen or king 
  //if so increment the corresponding variable by one 
  public String toString(){
    int d =0;
    int q=0;
    int k=0;
    for(int i = 0; i<roomInHotel.length;i++){
      if(this.roomInHotel[i].getAvailability()){
        
        if((this.roomInHotel[i].getType()).equalsIgnoreCase("double")){
          d++;
        }
        if((this.roomInHotel[i].getType()).equalsIgnoreCase("queen")){
          q++;
        }
        
        if((this.roomInHotel[i].getType()).equalsIgnoreCase("king")){
          k++;
        }
      }else{
        continue;
      }
    }
    return "Hotel name: " +  this.name + "\n" + "Available Rooms: " + d + " double, " + q + " queen, " + k + " king.";
  }
  
  //a method that read through a file 
  //if the current line read isn't null than split when get to a \t 
  //and call create reservation with the array split to read the name and type in the file
  //return the reservation array
  public Reservation[] loadReservations (String fileName) throws IOException{
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    String currentLine = br.readLine();
    while(currentLine != null) {
      String [] parts = currentLine.split("\t");
      createReservation(parts[0],parts[1]);
      currentLine = br.readLine();
    }
    br.close();
    fr.close();
    return this.reservationInHotel;
  }
  
  //a method that save the reservation by writing on a file 
  //use a for loop to go through the element of the reservationInHotel array
  //write the name and the type of the room under which the reservation is made 
  public void saveReservation (String fileName)throws IOException{
    FileWriter fw = new FileWriter(fileName);
    BufferedWriter bw = new BufferedWriter(fw);
    for(int i = 0; i<this.reservationInHotel.length; i++){
      String name = this.reservationInHotel[i].getName();
      String type = this.reservationInHotel[i].getRoom().getType();
      bw.write(name + "\t" + type);
      bw.newLine();
    }
    bw.close();
    fw.close();
  }
}

