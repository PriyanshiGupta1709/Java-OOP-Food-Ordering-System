import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class FoodItem {
    protected int id;
    protected String baseName;
    protected double basePrice;
    protected List<String> customizations;
    protected double additionalPrice;

    public FoodItem(int id, String baseName, double basePrice) {
        this.id = id;
        this.baseName = baseName;
        this.basePrice = basePrice;
        this.customizations = new ArrayList<>();
        this.additionalPrice = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (customizations.isEmpty()) {
            return baseName;
        }
        return baseName + " " + customizations.toString();
    }

    public double getPrice() {
        return basePrice + additionalPrice;
    }

    @Override
    public String toString() {
        return id + ". " + baseName + " - ₹" + String.format("%.2f", basePrice);
    }

    public abstract void customize(Scanner scanner);
    public abstract FoodItem create();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return baseName.equals(foodItem.baseName) &&
               customizations.equals(foodItem.customizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseName, customizations);
    }
}