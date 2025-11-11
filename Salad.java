import java.util.Scanner;

public class Salad extends FoodItem {

    public Salad() {
        super(3, "Caesar Salad", 580.00);
    }

    @Override
    public void customize(Scanner scanner) {
        System.out.println("Customizing " + baseName + ":");

        System.out.print("  Add grilled chicken? (+₹240) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Grilled Chicken");
            this.additionalPrice += 240;
        }

        System.out.print("  Add extra dressing? (+₹40) (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            this.customizations.add("Extra Dressing");
            this.additionalPrice += 40;
        }
    }

    @Override
    public FoodItem create() {
        return new Salad();
    }
}