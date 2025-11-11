import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<FoodItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        items.add(new Pizza());
        items.add(new Burger());
        items.add(new Salad());
        items.add(new Soda());
    }

    public void displayMenu() {
        System.out.println("--- MENU (Base Prices) ---");
        for (FoodItem item : items) {
            System.out.println(item);
        }
        System.out.println("--------------------------");
    }

    public FoodItem getPrototypeItemById(int id) {
        for (FoodItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Not found
    }
}
