import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

class Tasks {
  private String title;
  private boolean status;
  private String description;
  private String date;

  public Tasks(String title, String description, String date) {
    this.title = title;
    this.description = description;
    this.date = date;
    this.status = false;
  }

  public String getTitle() {
    return title;
  }

  public String getdate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public boolean getStatus() {
    return status;
  }

  public void MarkDone() {
    this.status = true;
  }

  public void updateTask(String title, String description, String date) {
    this.title = title;
    this.description = description;
    this.date = date;
  }

  public String toString() {
    return " Title: " + title + "\nDescription: " + description + "\nDate: " + date + "\nStatus: "+ (status ? "Done" : "Not Done");
  }
}

public class ToDoList {
  ArrayList<Tasks> tasks = new ArrayList<>();
  Scanner scan = new Scanner(System.in);

  public void addTask() {
    System.out.print("Enter the title :");
    String title = scan.nextLine();
    System.out.print("Enter the description :");
    String description = scan.nextLine();
    System.out.print("Enter the date : ");
    String date = scan.nextLine();
    Tasks task = new Tasks(title, description, date);
    tasks.add(task);
    System.out.print("Task added successfully!\n\n\n");
  }

  public void viewTasks() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks available.\n\n");
    } else {
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println("Task " + (i + 1) + ":");
        System.out.println(tasks.get(i));
        System.out.println();
      }
    }
  }

  public void MarkAsDone() {

    try {
      System.out.print("Enter the task number to mark as done :");
      int taskNumber = scan.nextInt();
      if (taskNumber < 0 || taskNumber > tasks.size()) {
        System.out.print("Invalid task number. Please try again.\n\n");
      } else {
        tasks.get(taskNumber - 1).MarkDone();
        System.out.print("the Task " + taskNumber + " is marked as done .\n\n\n");
      }
    } catch (InputMismatchException e) {
      System.out.print("the input is not valid please try again.\n\n");
      scan.next(); // Clear the invalid input
    }
  }

  public void updateTask() {
    try {
      System.out.print("Enter the task number to update :");
      int taskNumber = scan.nextInt();
      if (taskNumber < 0 || taskNumber > tasks.size()) {
        System.out.print("Invalid task number. Please try again.\n\n");
      } else {
        scan.nextLine(); // Clear the newline character
        System.out.print("Enter the new title :");
        String title = scan.nextLine();
        System.out.print("Enter the new description :");
        String description = scan.nextLine();
        System.out.print("Enter the new date : ");
        String date = scan.nextLine();
        tasks.get(taskNumber - 1).updateTask(title, description, date);
        System.out.print("Task updated successfully!\n\n\n");
      }
    } catch (InputMismatchException e) {
      System.out.print("The input is not valid please try again.\n\n");
      scan.next(); // Clear the invalid input
    }
  }

  public void deleteTask() {
    try {
      System.out.print("Enter the task number to delete :");
      int taskNumber = scan.nextInt();
      if (taskNumber < 0 || taskNumber > tasks.size()) {
        System.out.print("Invalid task number. Please try again.\n\n");
      } else {
        tasks.remove(taskNumber - 1);
        System.out.print("Task deleted successfully!\n\n\n");
      }
    } catch (InputMismatchException e) {
      System.out.print("The input is not valid please try again.\n\n");
      scan.next(); // Clear the invalid input
    }
  }

  public void showMenu() {

    System.out.println("To-Do List Menu:");
    System.out.println("1. Add Task");
    System.out.println("2. View Tasks");
    System.out.println("3. Mark Task as Done");
    System.out.println("4. Update Task");
    System.out.println("5. Delete Task");
    System.out.println("6. Exit");
    

    int choice = 0;

    while (true) {
      try {

        System.out.print("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine(); // Clear the newline character
        switch (choice) {
          case 1:
            addTask();
            break;
          case 2:
            viewTasks();
            break;
          case 3:
            MarkAsDone();
            break;
          case 4:
            updateTask();
            break;
          case 5:
            deleteTask();
            break;
          case 6:
            System.out.print("Exiting the To-Do List. Goodbye!\n");
            return;
          default:
            System.out.print("Invalid choice. Please try again.\n");
            break;
        }
      } catch (InputMismatchException e) {
        System.out.print(choice + " is not a valid input. Please try again.\n");
        scan.next(); // Clear the invalid input
      }
    }
  }

  public static void main(String[] args) {
    ToDoList todoList = new ToDoList();
    todoList.showMenu();
  }
}
