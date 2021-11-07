//Fill in your name and student number
//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

public class InputAnalyzer {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.out.println("You need to enter three arguments to this program. Try typing 'run InputAnalyzer 2.5 8 9' in Dr. Java, or 'java InputAnalyzer 2.5 8 9' on the command line.");
            return;
        } 
        /*
         * The variables a, b, and c are used to store the input arguments 
         * in the order in which they have been provided. 
         */ 
        double a = getInputDouble(args[0]);
        double b = getInputDouble(args[1]);
        double c = getInputDouble(args[2]);
        
        //========================
        //Enter your code below
        //Step 1: Use boolean for all the arguments to be positive 
        //Use AND (&&)
        //argument >= 0 
      boolean isPositive = ((a>=0) && (b>=0) && (c>=0));
        System.out.println("The numbers " + a + ", " + b + ", " + "and " + c + " " + "are all positive: " + isPositive);
        
        //Step 2: Use boolean for at least one of the arguments to be an even number 
        //Use OR (||)
        //To write an even number need to use x%2==0
        boolean isEven1 = ((a%2==0) || (b%2==0) || (c%2==0));
        System.out.println("At least one between " + a + ", " + b + ", " + "and " + c + " " + "is even: " + isEven1);
      
        //Step 3: Use boolean to know if the arguments have been entered in an increasing number
        //Use AND (&&)
        //a<b<c (increasing order)
        boolean isIncreasing = ((a < b) && (a < c) && (b < c));
        System.out.println("The numbers " + a + ", " + b + ", " + "and " + c + " " + "are in an increasing order: " + isIncreasing);
   
        //Step 4: Use boolean to know  if the arguments are all positive or in increasing order
        //Use AND (&&) and OR (||)
        //argument > 0 || a<b<c
        boolean isPositiveIncreasing = (isPositive || isIncreasing);
        System.out.println("The numbers " + a + ", " + b + ", " + "and " + c + " " + "are either all positive or in an increasing order: " + isPositiveIncreasing); 

        //Step 5: Use boolean to know if the arguments are all positive and not even numbers
        //Use AND (&&) and NOT (!)
        //arguments > 0 and !x%2==0
        boolean isPositiveNotEven = (isPositive && (((!(a%2==0)) && (!(b%2==0)) && (!(c%2==0)))));
        System.out.println("The numbers " + a + ", " + b + ", " + "and " + c + " " + "are all positive and none of them is even: " + isPositiveNotEven);
        //Enter your code above
        //========================
    } 
    
    public static double getInputDouble(String arg)
    {
        try
        {
            return Double.parseDouble(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be a number!");
        }
        
        //error, return 0
        return 0;
    }
}