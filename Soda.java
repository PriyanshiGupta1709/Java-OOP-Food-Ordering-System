import java.util.Scanner;

public class Soda extends FoodItem {

    public Soda() {
        super(4, "Soda", 120.00);
    }

    @Override
    public void customize(Scanner scanner) {
        System.out.println("Customizing " + baseName + ":");
        System.out.println("  1. Small (+₹0)"); 
        System.out.println("  2. Medium (+₹40)");
        System.out.println("  3. Large (+₹80)");
        System.out.print("  Choose size (1-3): ");
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "2":
                this.customizations.add("Medium");
                this.additionalPrice += 40; 
                break;
            case "3":
                this.customizations.add("Large");
                this.additionalPrice += 80;
                break;
            default:
                this.customizations.add("Small");
                break;
        }
    }

    @Override
    public FoodItem create() {
        return new Soda();
    }
}