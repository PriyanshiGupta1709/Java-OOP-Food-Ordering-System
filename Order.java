import java.util.Map;

public class Order {
    private static int orderCount = 0; 
    private int orderId;
    private Map<FoodItem, Integer> orderedItems;
    private double totalAmount;

    public Order(Map<FoodItem, Integer> orderedItems, double totalAmount) {
        this.orderId = ++orderCount;
        this.orderedItems = orderedItems;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }
    public void displayOrderDetails() {
        System.out.println("--- Order ID: " + orderId + " ---");
        for (Map.Entry<FoodItem, Integer> entry : orderedItems.entrySet()) {
    
            System.out.println(entry.getKey().getName() + " (x" + entry.getValue() + ")");
        }
        
        System.out.println("Total Paid: ₹" + String.format("%.2f", totalAmount));
        System.out.println("--------------------");
    }
}