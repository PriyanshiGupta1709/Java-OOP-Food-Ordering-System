# Java-OOP-Food-Ordering-System
This is a console-based, object-oriented food ordering application written entirely in Java. It simulates a customizable food ordering experience where a user can browse a menu, personalize items with toppings and options, add them to a cart, and check out.

The project is designed to demonstrate key Object-Oriented Programming (OOP) principles, including Abstraction, Inheritance, Polymorphism, and Encapsulation.

Features

View Menu: Displays a menu of available food items with their base prices (in ₹ INR).

Item Customization: Users can select items like Pizza or Burgers and are prompted with choices for toppings, add-ons, or sizes.

Dynamic Pricing: The price of an item is dynamically calculated based on the selected customizations.

Shopping Cart: A fully functional shopping cart that tracks customized items and their quantities. It can even group identical custom items (e.g., 2x "Pizza [Extra Cheese]").

Checkout: A checkout process that summarizes the cart, confirms the total price, and creates a final order.

Order History: The system saves a history of all completed orders, which can be viewed at any time.

How to Run

This project is a pure Java console application with no external dependencies.

Prerequisites: You must have a Java Development Kit (JDK) installed on your system (e.g., JDK 11 or higher).

Download Files: Place all the .java files ( Main.java, FoodOrderingSystem.java, FoodItem.java, Pizza.java, etc.) into a single folder.

Compile: Open a terminal or command prompt, navigate to that folder, and compile all the Java files:

javac *.java


Run: After compilation, run the main entry point of the application:

java Main


The application will start, and you can interact with it directly in your terminal.

Object-Oriented Design and Class Structure

This project's design is a key strength. The logic is separated into distinct classes, each with a single responsibility.

1. FoodItem.java (Abstract Class)

Purpose: This is the core "template" for all sellable items. It defines the common properties and behaviors that all food items must have, such as a base price, a name, and a method for calculating the final price.

OOP Concept: Abstraction. It is an abstract class, meaning you cannot create a "plain" FoodItem. It also has two abstract methods:

customize(Scanner scanner): Forces all subclasses (like Pizza) to provide their own customization logic.

create(): A factory method that allows the system to create new instances of a specific item (e.g., a new Pizza object).

2. Pizza.java, Burger.java, Salad.java, Soda.java (Concrete Subclasses)

Purpose: These classes represent the specific, concrete items on the menu. Each one extends FoodItem.

OOP Concept: Inheritance. They inherit all the basic properties from FoodItem (like basePrice) but provide their own unique implementation for the customize() method.

Pizza.customize() asks about extra cheese and pepperoni.

Burger.customize() asks about an extra patty and bacon.

This demonstrates Polymorphism: the main system can just call item.customize(), and Java automatically runs the correct version for either a Pizza or a Burger.

3. Menu.java

Purpose: Manages the list of available "prototype" food items. Its job is to display the menu and to provide a "prototype" item (e.g., a base Pizza object) when the user wants to add one to their cart.

OOP Concept: Composition. It "has-a" List<FoodItem>.

4. ShoppingCart.java

Purpose: Manages the user's current session, holding all the customized items they've added.

OOP Concept: Encapsulation. This class is a perfect example. It holds a private Map<FoodItem, Integer>. All logic for adding items, calculating the total, and displaying the cart is contained within this class. The rest of the system doesn't know how the cart works; it just calls methods like cart.addItem() and cart.calculateTotal().

Note: The use of equals() and hashCode() in FoodItem is critical here. It allows the HashMap in the cart to be "smart" and correctly group identical items (e.g., two "Pizza [Pepperoni]" orders are grouped, but a "Pizza [Pepperoni]" and a "Pizza [Extra Cheese]" are treated as two separate items).

5. Order.java

Purpose: A simple data class (or POJO) that holds a snapshot of the shopping cart's contents at the moment of checkout. A unique orderId is generated for each order.

OOP Concept: Encapsulation. It holds private data that is set at the time of creation and is not modified.

6. FoodOrderingSystem.java

Purpose: This is the main "engine" of the application. It acts as the orchestrator or controller. It puts all the other components together.

OOP Concept: Composition. This class "has-a" Menu, "has-a" ShoppingCart, "has-a" Scanner, and "has-a" List<Order> (for the history). It manages the main application loop and tells the other objects when to perform their tasks.

7. Main.java

Purpose: The entry point of the program. Its only responsibility is to create an instance of the FoodOrderingSystem and call its run() method.

OOP Concept: Single Responsibility Principle. This clean separation makes the project easy to start and understand.
