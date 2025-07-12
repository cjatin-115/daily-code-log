import java.util.Scanner;

public class StudentGradeCalc {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to the Student Grade Calculator!");
    System.out.println("This program will calculate your overall grade based on the marks you enter for each subject.");

    System.out.print("Enter the number of subjects: ");
    int n = scan.nextInt();
    int[] marks = new int[n];
    int total = 0;
    
    for( int i = 0; i < n ; i++ ) {
      System.out.print("Enter the marks for subject "+(i + 1) + " : ");
      marks[i] =  scan.nextInt();


      if ( marks[i] < 0 || marks[i] > 100 ) {
        System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
        marks[i] = 0; // Reset the marks for the current subject
        i--; // Decrement i to repeat the input for the same subject
      }
      else { 
        total += marks[i];
      }

    }
    int percentage =total / n ;
    System.out.println("Total Marks: " + total + "/ " + (n * 100));
    System.out.println("Percentage: " + percentage + "%");

    System.out.print("Overall grade based on percentage ");
    if (percentage>=90) {
      System.out.println("Grade: A+");
    } else if (percentage>=80) {
      System.out.println("Grade: A");
    } else if (percentage>=70) {
      System.out.println("Grade: B+");
    } else if (percentage>=60) {
      System.out.println("Grade: B");
    } else if (percentage>=50) {
      System.out.println("Grade: C");
    } else if (percentage>=40) {
      System.out.println("Grade: D");
    } else {
      System.out.println("Grade: F");
    } 

    scan.close();


  }
}
