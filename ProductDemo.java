import java.util.Scanner;

public class ProductDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many products does your store have?");
        final int STOCK_SIZE = sc.nextInt();

        Product[] products = new Product[STOCK_SIZE];

        for (int i = 0; i < products.length; i++) {
            System.out.println("Enter product name:");
            String tempName = sc.next();
            System.out.println("Enter stock information:");
            int tempStock = sc.nextInt();
            products[i] = new Product(tempName, tempStock);
        }

        while (true) {
            System.out.println("Enter product to buy or Q to quit:");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("Q"))
                break;

            boolean found = false;
            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(choice)) {
                    p.buyOne();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No such product!");
            }
        }

        System.out.println("\nFinal stock:");
        for (Product p : products) {
            p.printInfo();
        }
    }
}