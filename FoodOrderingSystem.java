import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FoodOrderingSystem {
    private Menu menu;
    private ShoppingCart cart;
    private List<Order> orderHistory;
    private Scanner scanner;

    public FoodOrderingSystem() {
        this.menu = new Menu();
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public void run() {
        System.out.println("Welcome to the Food Ordering System!");
        boolean isRunning = true;

        while (isRunning) {
            printMainMenu();
            int choice = getUserIntInput();

            switch (choice) {
                case 1:
                    menu.displayMenu();
                    break;
                case 2:
                    handleAddItemToCart(); 
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    handleCheckout();
                    break;
                case 5:
                    displayOrderHistory();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Display Menu");
        System.out.println("2. Add Item to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. View Order History");
        System.out.println("6. Exit");
        System.out.print("Please enter your choice: ");
    }
    private void handleAddItemToCart() {
        menu.displayMenu();
        System.out.print("Enter the ID of the item you want to add: ");
        int id = getUserIntInput();
        
        FoodItem prototypeItem = menu.getPrototypeItemById(id);

        if (prototypeItem == null) {
            System.out.println("Invalid item ID. Please try again.");
            return;
        }
        FoodItem newItem = prototypeItem.create();

        newItem.customize(scanner);

        System.out.print("Enter quantity for " + newItem.getName() + ": ");
        int quantity = getUserIntInput();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }
        cart.addItem(newItem, quantity);
    }

    private void handleCheckout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to check out.");
            return;
        }

        double total = cart.calculateTotal();
        System.out.println("Your total is: ₹" + String.format("%.2f", total));
        System.out.print("Confirm checkout? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            Order newOrder = new Order(cart.getItems(), total);
            orderHistory.add(newOrder);

            System.out.println("Checkout successful! Your order ID is " + newOrder.getOrderId());
            
            cart.clearCart();
        } else {
            System.out.println("Checkout cancelled.");
        }
    }

    private void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders have been placed yet.");
            return;
        }

        System.out.println("--- ORDER HISTORY ---");
        for (Order order : orderHistory) {
            order.displayOrderDetails();
        }
    }

    private int getUserIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1; 
        }
    }
}
