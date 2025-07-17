import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Books {
  private String title;
  private String author;
  private boolean isAvailable;

  public Books(String title, String author) {
    this.title = title;
    this.author = author;
    this.isAvailable = true;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public boolean getAvailable() {
    return isAvailable;
  }

  public void setBorrowed() {
    this.isAvailable = false;
  }

  public void setReturned() {
    this.isAvailable = true;
  }

  public String View() {
    return "Title: " + title + "\nAuthor: " + author + "\nAvailable: " + (isAvailable ? "Yes" : "No");
  }

}

public class Library {
  Scanner scan = new Scanner(System.in);
  ArrayList<Books> books = new ArrayList<>();

  public void addBook() {
    System.out.print("Enter the title of the book");
    String TitleIn = scan.nextLine();
    System.out.print("Enter the author of the book : ");
    String AuthorIn = scan.nextLine();
    Books book = new Books(TitleIn, AuthorIn);
    books.add(book);
    System.out.println("Book added successfully !!");
  }

  public void borrowBook() {
    System.out.print("Enter the book you want to borrow : ");
    String TitleIn = scan.nextLine();
    try {
      for (Books book : books) {
        if (book.getTitle().equalsIgnoreCase(TitleIn) && book.getAvailable()) {
          book.setBorrowed();
          System.out.println("You have successfully borrowed the book: " + book.getTitle());
          return;
        } else {
          System.out.println("Book not available or does not exist.");
          return;
        }
      }
    } catch (Exception e) {
      System.out.println("An error occurred while borrowing the book: " + e.getMessage());
    }
  }

  public void returnBook() {
    System.out.print("Enter the book you want to return :");
    String TitleIn = scan.nextLine();
    try {
      for (Books book : books) {
        if (book.getTitle().equalsIgnoreCase(TitleIn) && !book.getAvailable()) {
          book.setReturned();
          System.out.println("You have successfully returned the book: " + book.getTitle());
          return;
        } else {
          System.out.println("Book not borrowed or does not exist.");
          return;
        }
      }
    } catch (Exception e) {
      System.out.println("An error occurred while returning the book: " + e.getMessage());
    }
  }

  public void viewBooks() {
    if (books.isEmpty()) {
      System.out.println("No books available.\n\n");
    } else {
      System.out.print("Available Books:\n");
      for (int i = 0; i < books.size(); i++) {
        System.out.println("Book " + (i + 1) + ":");
        System.out.println(books.get(i));
        System.out.println();
      }
    }
  }

  public void showMenu() {

    System.out.println("Virtual library:");
    System.out.println("1. Add Book");
    System.out.println("2. View Books");
    System.out.println("3. Borrow Book");
    System.out.println("4. Update Book");
    System.out.println("5. Return Book");
    System.out.println("6. Exit");

    int choice = 0;

    while (true) {
      try {

        System.out.print("Enter your choice: ");
        choice = scan.nextInt();
        scan.nextLine(); // Clear the newline character
        switch (choice) {
          case 1:
            addBook();
            break;
          case 2:
            viewBooks();
            break;
          case 3:
            borrowBook();
            break;
          case 4:
            returnBook();
            break;
          case 5:
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
    Library library = new Library();
    library.showMenu();
  }

}