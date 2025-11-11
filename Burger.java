import java.util.Scanner;

public class Burger extends FoodItem {

    public Burger() {
        
        super(2, "Cheeseburger", 440.00);
    }

    @Override
    public void customize(Scanner scanner) {
        System.out.println("Customizing " + baseName + ":");

        System.out.print("  Add extra patty? (+₹200) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Extra Patty");
            this.additionalPrice += 200;
        }

        System.out.print("  Add bacon? (+₹140) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Bacon");
            this.additionalPrice += 140;
        }
    }

    @Override
    public FoodItem create() {
        return new Burger();
    }
}