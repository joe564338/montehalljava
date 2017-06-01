/* Name: Joe McCully
 * Date: March 26, 2013
 * Purpose: To solve the monte hall problem
 * Inputs: none
 * Outputs: Number of wins with sticking with chosen door and number of wins swapping to other doors
 */
import java.util.*;//imports the util package for use of the random class
public class MonteHall{//MonteHall class is declared here
  private int tries;//Variable for number of runs for simulation
  private int playerDoor;//variable for the door the player picks
  private int swapDoor;//variable for the door that is not picked by the player or monte
  private int monteDoor;//variable for the door that is picked by monte
  private int goatDoor1;//variable for the first goat door
  private int goatDoor2;//variable for the second goat door
  private int carDoor;// variable for the door with the car
  private int montePick;//variable that is used when the player picks the car so then monte picks one of the goat doors
  private int counterPlayer = 0;//variable for the number of wins the player gets when sticking with the player chosen door
  private int counterSwap = 0;//variable for the number of wins the player gets with swapping to the other door
  private int counterTries = 0;//variable that is used to count the number of tries that have been done in the simulation
  Random rand = new Random();//Random object is created here 
  public MonteHall(){//default parameters for the Montehall object are created here with tries being set to 10
    tries = 10;
  }
  
  public MonteHall(int intries){//instance variables are created here
    tries = intries;
  }
  
  public void game(){//method that calculates the number of wins for sticking with the player chosen door and the number of wins for switching to the other door is created here
    while (counterTries < tries){//While loop that controls the number of runs with the simulation 
    goatDoor1 = rand.nextInt(3);//chooses the door for the first goat with a random number from 0-2
    while (goatDoor2 == goatDoor1){//while loop that prevents the second goat from being in the same door as the first goat
      goatDoor2 = rand.nextInt(3);//chooses the door for the second goat with a random number from 0-2
    }
    while (carDoor == goatDoor1 || carDoor == goatDoor2){//while loop that prevents the car from being in the same door as either goat
      carDoor = rand.nextInt(3);//chooses the door for the car with a random number from 0-2
    }
    playerDoor = rand.nextInt(3);//player door is chosen by a random number from 0-2
    montePick = rand.nextInt(2);//number generated for the scenario that the player picks the door with the car behind it, the number is used to decide which goat door monte picks
    if (playerDoor == goatDoor1){//if loop that checks if the player door is the first goat door
      monteDoor = goatDoor2;//the door that monte picks if the player picks the first goat door
    }
    else if (playerDoor == goatDoor2){//if loop that checks if the player picked the second goat door
      monteDoor = goatDoor1;//the door that monte picks if the player picks the second goat door
    }
    else if (playerDoor == carDoor){//If loop that checks if the player picked the door with the car
      if (montePick == 0){//if loop that checks if the door that monte picks is goatDoor1
        monteDoor = goatDoor1;//sets the door that monte picks to goatDoor1
      }
      else if (montePick == 1){////if loop that checks if the door that monte picks is goatDoor2
        monteDoor = goatDoor2;//sets the door that monte picks to goatDoor2
      }
    }
    while (swapDoor == playerDoor || swapDoor == monteDoor){//while loop that prevents the swap door from being the same as the player door or the door that monte picks
      swapDoor = rand.nextInt(3);//Chooses the door for the swap door with a random number from 0-2
    }
    if (swapDoor == carDoor){//if loop that checks if the swap door is the same as the door with the car
      counterSwap++;// adds one to the counter for swap door wins
    }
    else if (playerDoor == carDoor){//checks if the player door is the same as the door with the car
      counterPlayer++;//adds one to the counter for player door wins
    }
    counterTries++;//adds one to the counter for tries everytime the simulation runs through
    }
    System.out.println("Wins by sticking with your chosen door " + counterPlayer);//Outputs the number of wins with sticking with the player chosen door
    System.out.println("Wins by swapping to the other door " + counterSwap);//Outputs the number of wins with swapping doors
  }
}