/** PayOff.java - Concentric Circles
 * <p>Problem Statement: Using recursive techniques, create a program to solve 
 *                       mortgage / loan payoffs
 * </p>
 * 
 * <p>Algorithm: <br />
 * 1. Create main class <br/>
 * 2. Create original amount, annual interest, and monthly payment final static variables
 * 3. Create a recursive method. <br/>
 * 4. In it, create a monthlyInterest which is the annual interest divided by 12 and then
 *    multiplied by the current balance. <br/>
 * 5. Create an outstandingBalance, which is the current balance + the monthly interest -
 *    the monthly payment.<br/>
 * 6. Create an if statement, that notifies the user if the amount they are paying each
 *    month is not enough. Return. <br/>
 * 7. Create an if-else statement. If it is paid off, track how many months it takes,
 *    add up the interest, print out the information, and return.<br/>
 * 8. Else, track how many months it takes, add up the interest, and recursively call
 *    the method. <br/>
 * 9. Then call the method in main. <br/>
 * 10.Compile and test. <br/>
 *
 *
 * 
 * </p>
 * 
 *   @author Ethan Grant
 *   @version Module 14, Hw 2
 */
public class Payoff {
    // variables
    public static final double ORIGINAL_AMOUNT = 180000.0;
    public static final double ANNUAL_INTEREST = 0.0625;
    public static final double MONTHLY_PAYMENT = 1850.0;
    
    // Recursive method
    /**
     * Calculates if the mortgage/loan is going to be paid off, how much, and when.
     * @param currentBalance The current balance of the mortgage/loan
     * @param totalInterestPaid total interest paid
     * @param numberOfMomths Number of months paying off mortgage/loan
     * 
     */
    public static void Recursive(double currentBalance, double totalInterestPaid,int numberOfMonths) {
        //The interest for each month and the new outstanding balance are calculated at the beginning of every month
        double monthlyInterest = ANNUAL_INTEREST / 12 * currentBalance;
        double outstandingBalance= currentBalance + monthlyInterest - MONTHLY_PAYMENT;
        
        // if not enough to pay
        if(MONTHLY_PAYMENT <= monthlyInterest) {
            System.out.println("Monthly payment is less than monthly interest");
            System.out.println("The first month interest is $" + String.format("%,.2f",monthlyInterest));
            System.out.println("The first month payment is $" + String.format("%,.2f",MONTHLY_PAYMENT));
            return;
        }
        // if paid off
        if (outstandingBalance <= 0) {
            // Tracker
            numberOfMonths++;
            // adds them up
            totalInterestPaid += monthlyInterest;
            // print out info
            System.out.println("Mortage/loan will pay off in " + numberOfMonths + " months.");
            System.out.println("Total interest paid is $" + String.format("%,.2f",totalInterestPaid));
            //end it
            return;
        }
        // if not paid off
        else {
            // Tracker
            numberOfMonths++;
            //adds them up
            totalInterestPaid += monthlyInterest;
            // Recursively call method
            Recursive(outstandingBalance, totalInterestPaid,numberOfMonths);
        }
    }
    public static void main(String[] args) {
        // call the method
        Recursive(ORIGINAL_AMOUNT,0.0,0);
    }
}
