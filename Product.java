public class Product {
    private String name;
    private int stock;

    // Constructor
    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // Decrease stock if available
    public void buyOne() {
        if (stock > 0) {
            stock--;
            System.out.println("Bought 1 " + name);
        } else {
            System.out.println(name + " is Out of stock!");
        }
    }

    // Show product info
    public void printInfo() {
        System.out.println(name + " stock = " + stock);
    }

    // Getter for name
    public String getName() {
        return name;
    }
}