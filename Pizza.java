import java.util.Scanner;

public class Pizza extends FoodItem {

    public Pizza() {
        super(1, "Margherita Pizza", 720.00);
    }

    @Override
    public void customize(Scanner scanner) {
        System.out.println("Customizing " + baseName + ":");

        System.out.print("  Add extra cheese? (+₹120) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Extra Cheese");
            this.additionalPrice += 120;
        }

        System.out.print("  Add pepperoni? (+₹160) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Pepperoni");
            this.additionalPrice += 160;
        }
    }

    @Override
    public FoodItem create() {
        return new Pizza();
    }
}