import java.util.Scanner;

public class SimpleInterest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the Principal: ")  ;
    float principal = sc.nextFloat();

    System.out.print("Enter the rate of Interest: ");
    float rate = sc.nextFloat();

    System.out.print("Enter the time :");
    float time = sc.nextFloat();

    float interest = (principal*rate*time)/100;
    System.out.println("Simple Interest = "+ interest);
  }
}