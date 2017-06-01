/* Name: Joe McCully
 * Date: March 26, 2013
 * Purpose: To act as the tester for the Montehall program
 * Inputs: tries
 * Outputs: Number of wins with sticking with chosen door and number of wins swapping to other doors
 */
import java.util.*;//imports the util package for use of the scanner class
public class MonteHallTester{//MonteHallTester class is declared here
  public static void main(String [] args){//Main method is declared here
    String playAgain;
    Scanner kb = new Scanner(System.in);//Scanner object is created here
    System.out.println("Default is 10 runs");//Here to tell the user that the default value will be used for runs
    MonteHall test1 = new MonteHall();//MonteHall object is created here with default parameters which is 10
    test1.game();//Number of wins by keeping chosen door and number of wins by swapping doors is calculated here with the parameters of the default object
    do {
    System.out.println("Please input number of runs for the monte hall simulation.");//Tells the user to input the number of runs for the simulation
    MonteHall test2 = new MonteHall(kb.nextInt());//Takes in whatever integer the user inputs and runs that many trials
    test2.game();//Number of wins by keeping chosen door and number of wins by swapping doors is calculated here with the number of trials inputted by the user
    System.out.println("do you want to play again? (yes/no)");
    playAgain = kb.next();
    } while (playAgain.equals("yes"));
  }
}