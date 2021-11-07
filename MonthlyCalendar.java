//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

public class MonthlyCalendar{
  //Main method that display the code of the method below
  //Use system.out.println()
  public static void main (String [] args){
    System.out.println(getMonthNumber("February"));
    System.out.println(getDayOfTheWeek(1, 2, 1999));
    System.out.println(isLeapYear(1999));
    System.out.println(getNumberOfDays(2, 1999));
    displayMonthlyCalendar("September", 2018);
  }
  
  //A method that assign the month with an integer 
  //Use the condition if else if 
  //Use the equalsIgnoreCase for method to not be case sensitive
  //Return the number associated with the month
  public static int getMonthNumber(String month){
    if(month.equalsIgnoreCase("january")){
      return 1;
    } else if(month.equalsIgnoreCase("february")){
      return 2;
    }else if(month.equalsIgnoreCase("march")){
      return 3;
    }else if(month.equalsIgnoreCase("april")){
      return 4;
    }else if(month.equalsIgnoreCase("may")){
      return 5;
    }else if(month.equalsIgnoreCase("june")){
      return 6;
    }else if(month.equalsIgnoreCase("july")){
      return 7;
    }else if(month.equalsIgnoreCase("august")){
      return 8;
    }else if(month.equalsIgnoreCase("september")){
      return 9;
    }else if(month.equalsIgnoreCase("october")){
      return 10;
    }else if(month.equalsIgnoreCase("november")){
      return 11;
    }else if(month.equalsIgnoreCase("december")){
      return 12;
    }else{
      return -1;
    }
  }
  
  //A method that provide the day of the week
  //Use the formula below 
  //Use three integers as input: day, month, year
  public static int getDayOfTheWeek (int d, int m, int y){
    int y0; 
    int x; 
    int m0;
    int d0;
    y0 = y - ((14 - m)/12);
    x = y0 + (y0/4) - (y0/100) + (y0/400);
    m0 = m + (12 * ((14 - m)/12)) - 2;
    d0 = (d + x + ((31 * m0)/12))%7;
    return d0;
  }
  
  //A method that tells if the year is leap or not 
  //Use the condition if else if 
  //Leap year are multiple of 4--> %4==0
  //Century year need to be multiple of 100 and 400 --> %100==0 && %400==0
  public static boolean isLeapYear(int year){
    boolean b = false;
    if (year %4==0){
      b = true;
    }else if ((year %100==0) && (year %400==0)){
      b = true;
    }else{
      b = false;
    }
    return b;
  }
  
  //A method that get the number of days in a month 
  //Use condition if else if 
  //For february might be affected by leap year 
  //so add the operator && and call function isLeapYear()
  //Return the number of days in the month
  public static int getNumberOfDays(int m, int y){
    if (m == 1){
      return 31;
    }else if (m == 2 && isLeapYear(y)){
      return 29;
    }else if ( m == 2 && !isLeapYear(y)){
      return 28; 
    }else if (m == 3){
      return 31; 
    }else if (m == 4){
      return 30; 
    }else if (m == 5){
      return 31; 
    }else if (m == 6){
      return 30;
    }else if (m == 7){
      return 31;
    }else if (m == 8){
      return 31; 
    }else if (m == 9){
      return 30;
    }else if (m == 10){
      return 31; 
    }else if (m == 11){
      return 30; 
    }else if (m == 12){
      return 31; 
    }else {
      return -1;
    }
  }
  
  //a method that display the Calendar for each month
  //Use condition if else to display"There's no such Month" if the input is not a month
  //Declare three integer: monthNumber, days and dayOfTheWeek (calling the method above)
  public static void displayMonthlyCalendar(String m, int y){
    int monthNumber = getMonthNumber(m);
    
    if (monthNumber ==-1){
      System.out.println("There's no such month");
    }else{
      
      int days = getNumberOfDays(monthNumber, y);
      int dayOfTheWeek= getDayOfTheWeek(1, monthNumber, y);
      
      //Use for loop and if statement to display the calendar
      //When int i = 0 display the month and year
      //When int i = 1 display the days of the week (separated by two "\t")
      //When int i = 2 display the number 1 through 30 for example
      for (int i = 0; i < 3; i++){
        if (i == 0){
          System.out.println("                                          " + m + " " + y);
          continue;
        }else if (i == 1){
          System.out.print("Su" + "\t" + "\t" + "Mo" + "\t" + "\t" + "Tu" + "\t" + "\t" + "We" + "\t" + "\t" + "Th" + "\t" + "\t" + "Fr" + "\t" + "\t" + "Sa");
          System.out.println();
          continue;
        }else{
          
          //declare integer count  = 1 for the first day of the month 
          //if else if condition for each number to appear under the right day (using "\t")
          //Use the variable dayOfTheWeek declared above
          //Since between each day there is two "\t", need to add two tabs each time
          int count = 1; 
          if (dayOfTheWeek == 0){
            System.out.println();
          }else if (dayOfTheWeek == 1){
            System.out.print("\t" + "\t");
          }else if (dayOfTheWeek == 2){
            System.out.print("\t" + "\t" + "\t" + "\t");
          }else if (dayOfTheWeek == 3){
            System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t");
          }else if (dayOfTheWeek == 4){
            System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t");
          }else if (dayOfTheWeek == 5){
            System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t" +"\t" + "\t" + "\t" + "\t");
          }else if (dayOfTheWeek == 6){
            System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t" +"\t" + "\t" + "\t" + "\t" + "\t" + "\t");
          }
          
          //Use while loop to display the number of days in each days
          //(dayOfTheWeek+count)%7==0 to start 1 on the right day
          //%7 because there is 7 days in a week
          //so add the dayOfTheWeek to the count and look for the one that can be divided by 7
          // when it can it will reach Saturday and go on a new line
          while ((count <= days)){
            System.out.print(count + "\t" + "\t");
            if ((dayOfTheWeek + count)%7==0){
              System.out.println();
            }
            count++;
          }
        } 
      }
    } 
  }
}