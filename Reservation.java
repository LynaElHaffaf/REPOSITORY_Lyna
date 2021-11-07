//Name: Lyna Mariam El Haffaf
//Student Number: 260807052
public class Reservation{
  //attributes
  private String name; 
  private Room roomReserved;
  
  //constructors
  public Reservation (Room roomReserved, String name){
    this.name = name;
    this.roomReserved = roomReserved;
  }
  //a method that get the name of the reservation
  public String getName(){
    return this.name; 
  }
  
  //a method that get the room 
  public Room getRoom(){
    return this.roomReserved;
  }
}