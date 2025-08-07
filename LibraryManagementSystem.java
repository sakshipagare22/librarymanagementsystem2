import java.util.*;

// Class representing a Book
class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }
}

// Class representing a User
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Class representing the Library
class Library {
    List<Book> books = new ArrayList<>();
    Map<Integer, Integer> issuedBooks = new HashMap<>(); // bookId -> userId

    void addBook(Book book) {
        books.add(book);
    }

    void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    issuedBooks.put(bookId, userId);
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    issuedBooks.remove(bookId);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void showAvailableBooks() {
        System.out.println("Available books:");
        for (Book b : books) {
            if (!b.isIssued) {
                System.out.println("ID: " + b.id + ", Title: " + b.title);
            }
        }
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        library.addBook(new Book(1, "The Alchemist"));
        library.addBook(new Book(2, "Java Programming"));
        library.addBook(new Book(3, "Data Structures"));

        User user = new User(101, "Sakshi");

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, user.userId);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
