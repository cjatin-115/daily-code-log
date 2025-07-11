import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumGuessGame {
  public static void main (String[] args){
    Scanner scan = new Scanner(System.in);


    int RandomNum =ThreadLocalRandom.current().nextInt(1,101);
    int UserInput = 0;
    int Attempts = 0;
    int Win =0;

    System.out.println("Welcome to Number Guessing Game!");
    System.out.println("I'm thinking of a number between 1 and 100. You have 7 attempts.");
    System.out.println("------------------------------------------------------------------");


    while (Attempts < 7) {
      System.out.print("Enter your guess: ");
      UserInput = scan.nextInt();
      Attempts++;


      if (UserInput < 1 || UserInput > 100) {
        System.out.println("Please enter a number between 1 and 100.");
        System.out.println("You have used " + Attempts + " attempts out of 7.");
        continue;
      }
      else if(UserInput < RandomNum){
        System.out.println("your guess is too low. Try again.");
        System.out.println("You have used " + Attempts + " attempts out of 7.");
        continue;
      }
      else if (UserInput > RandomNum){
        System.out.println("your guess is too high. Try again.");
        System.out.println("You have used " + Attempts + " attempts out of 7.");
        continue;
      }
      else{
        System.out.println("Congratulations!!, You have guessed correct number "+RandomNum+" in "+Attempts+" attempts");
        Win = 1;
        break;
      }
    }
    if (Win == 0) {
      System.out.println("Sorry, you have used all your attempts. The correct number was " + RandomNum + ". Better luck next time!");
    }
    
    scan.close();
    return;
  }
}
