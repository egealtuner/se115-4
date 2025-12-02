// Scenario 3
public class Book {
    String title;
    int pages;

    // Constructor
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public void addPages(int extra) {
        pages += extra;
    }

    public void printBook() {
        System.out.println("Title: " + title + " | Pages: " + pages);
    }
}
