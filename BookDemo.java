// Scenario 3
public class BookDemo {
    public static void main(String[] args) {
        // Create first book object
        Book b1 = new Book("Java Basics", 100);

        // b2 refers to the same object as b1
        Book b2 = b1;

        // Call addPages using b2
        b2.addPages(20);

        System.out.println("Book 1 Info:");
        b1.printBook();
        System.out.println("Book 2 Info:");
        b2.printBook();

        // Both show 120 pages because b1 and b2 point to the SAME object.
        // Only ONE object exists in memory here.

        // Extension: Create a new object with the same values
        Book b3 = new Book("Java Basics", 100);

        // Compare references
        System.out.println("b1 == b3? " + (b1.equals(b3)));

        // Compare field values
        System.out.println("b1.pages == b3.pages? " + (b1.pages == b3.pages));

        // b1 == b3 is false because they are different objects in memory.
        // b1.pages == b3.pages is true because the values stored in the fields are equal.
    }
}