//Name: Lyna Mariam El Haffaf
//Student Number: 260807052
public class Room{
  //attributes
  private String type;
  private double price; 
  private boolean availability; 
  
  //constructor
  //need the correct type of room so compare type with double, queen or king
  //using .equalsIgnoreCase
  //set the price of each rooms using if statements
  //if the type don't correspond throw exception
  public Room (String type){
    if((type).equalsIgnoreCase("double") || (type).equalsIgnoreCase("queen")|| (type).equalsIgnoreCase("king")){
      
      if((type).equalsIgnoreCase("double")){
        this.price = 90.0;
      } 
      if ((type).equalsIgnoreCase("queen")){
        this.price = 110.0;
      }
      if((type).equalsIgnoreCase("king")){
        this.price=150.0;
      }
      this.type = type;
      this.availability = true;
    }
    else{
      throw new IllegalArgumentException ("No room of such type can be created!");
    }
  }
  
  //a method that get the type of the room
  public String getType(){
    return this.type;
  }
  
  //a method that get the price of the room
  public double getPrice(){
    return this.price;
  }
  
  //a method that get the availability of the room
  //if the room is available return true
  public boolean getAvailability(){
    return this.availability;
  }
  
  //a method that changes the availability of the room
  //if the room was available before return false
  //else return true
  public void changeAvailability(){
    if(this.availability == true){
      this.availability = false;
    }else{
      this.availability = true; 
    }
  }
  
  //a method that find the available rooms
  //takes an array and a string as input and is static
  //the for loop go through the element of the array and checks if the correct type is present
  //it then calls getAvailability and make it available 
  //return result which is the array of Room created
  public static Room findAvailableRoom (Room [] list, String type){
    Room result = null; 
    for (int i = 0; i<list.length;i++){
      if((list[i].getType()).equalsIgnoreCase(type)){
        if(list[i].getAvailability() == true){
          result = list[i];
          return result;
        }
      }
    }
    return result;
  }
}