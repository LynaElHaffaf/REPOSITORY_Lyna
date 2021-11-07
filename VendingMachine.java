//Fill in your name and student number
//Name: Lyna Mariam El Haffaf
//Student Number: 260807052

public class VendingMachine {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("You need to enter two arguments to this program. Try typing 'run VendingMachine 400 215' in Dr. Java, or 'java VendingMachine 400 215' on the command line.");
            return;
        } 
        /*
         * The variables cash, and price are used to store the input arguments 
         * in the order in which they have been provided. 
         */
        int cash = getInputInteger(args[0]);
        int price = getInputInteger(args[1]);
        
        //========================
        //Enter your code below
        //Step 1: display the cash, price and change
        System.out.println("Amount received: " + cash);
        System.out.println("Cost of the item: " + price);
        int change = cash - price; 
        System.out.println("Required change: " + change);
        
        System.out.println(" ");
        
        System.out.println("change: ");
        //Step 2: divide change by the value of one coin (twoonie, loonie...)
        //Step 3: declare new change after giving back the coins
        
        int twoonies = (change / 200);
        change = change - (twoonies * 200);
        //Declare new change after giving back twoonies
        
        int loonie = (change / 100);
        change = change - (loonie * 100);
        //Declare new change after giving back loonie
        
        int quarter = (change / 25);
        change = change - (quarter * 25);
        //Declare new change after giving back quarter
        
        int dime = (change / 10);
        change = change - (dime * 10);
        //Declare new change after giving back dime
        
        int nickel = (change / 5); 
        change = change - (nickel * 5);
        //Declare new change after giving back nickel
        
        //Step 4: display the number of coins needed to give back
        System.out.println(" " + "twoonies x " + twoonies);
        System.out.println(" " + "loonies x " + loonie);
        System.out.println(" " + "quarter x " + quarter);
        System.out.println(" " + "dime x " + dime); 
        System.out.println(" " + "nickel x " + nickel);
        //Enter your code above
        //========================
    }
    
    public static int getInputInteger(String arg) {
        try
        {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
        }
        
        //error, return 0
        return 0;
    }
}
