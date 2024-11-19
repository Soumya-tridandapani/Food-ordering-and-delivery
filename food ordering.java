import java.util.*; 
 
// Restaurant class to store restaurant details 
class Restaurant { 
    private String name; 
    private Map<String, Double> menu; // Menu item and price 
 
    public Restaurant(String name) { 
        this.name = name; 
        this.menu = new HashMap<>(); 
    } 
 
    public void addToMenu(String item, double price) { 
        menu.put(item, price); 
    } 
 
    public Map<String, Double> getMenu() { 
        return menu; 
    } 
        public String getName() { 
        return name; 
    } 
} 
 
// User class to store user details 
class User { 
    private String name; 
    private String address; 
7 
 
    // Other user details 
 
    public User(String name, String address) { 
        this.name = name; 
        this.address = address; 
    } 
        public String getName() { 
        return name; 
    } 
 
    // Getters and setters for user details 
} 
 
// Order class to store order details 
class Order { 
    private User user; 
    private Restaurant restaurant; 
    private List<String> items; 
    private double totalPrice; 
 
    public Order(User user, Restaurant restaurant) { 
        this.user = user; 
        this.restaurant = restaurant; 
        this.items = new ArrayList<>(); 
        this.totalPrice = 0.0; 
    } 
 
    public void addItem(String item) { 
        if (restaurant.getMenu().containsKey(item)) { 
            items.add(item); 
            totalPrice += restaurant.getMenu().get(item); 
        } else { 
            System.out.println("Item not found in the menu"); 
        } 
    } 
 
    public double getTotalPrice() { 
        return totalPrice; 
    } 
 
8 
 
    public User getUser() { 
        return user; 
    } 
 
    public Restaurant getRestaurant() { 
        return restaurant; 
    } 
 
    public List<String> getItems() { 
        return items; 
    } 
} 
 
 
// Main class to demonstrate food ordering and delivery service 
 
public class FoodDeliveryService { 
    public static void main(String[] args) { 
        // Create restaurants 
        Restaurant restaurant1 = new Restaurant("Restaurant A"); 
        restaurant1.addToMenu("Pizza", 10.99); 
        restaurant1.addToMenu("Burger", 8.50); 
        restaurant1.addToMenu("Salad", 6.75); 
        restaurant1.addToMenu("Pasta", 12.25); 
        restaurant1.addToMenu("Cheese Sandwich", 7.99); 
        restaurant1.addToMenu("Steak", 15.99); 
        restaurant1.addToMenu("Fried Rice", 9.25); 
        restaurant1.addToMenu("Ice Cream", 4.99); 
        restaurant1.addToMenu("Smoothie", 5.49); 
        restaurant1.addToMenu("Fish Tacos", 11.75); 
        restaurant1.addToMenu("Cheeseburger", 8.99); 
        restaurant1.addToMenu("Margherita Pizza", 10.99); 
        restaurant1.addToMenu("Chicken Alfredo", 12.99); 
        restaurant1.addToMenu("Caesar Salad", 7.49); 
        restaurant1.addToMenu("Chocolate Cake", 5.99); 
        restaurant1.addToMenu("Sushi Platter", 15.99); 
        restaurant1.addToMenu("Vegetarian Wrap", 9.99); 
        restaurant1.addToMenu("Fried Chicken", 11.99); 
        restaurant1.addToMenu("Mango Smoothie", 4.49); 
 
9 
 
        // Add more items to the menu 
 
        // Create a user 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter your name: "); 
        String userName = scanner.nextLine(); 
        System.out.print("Enter your address: "); 
        String userAddress = scanner.nextLine(); 
        User user = new User(userName, userAddress); 
 
        // Display menu and take user input for ordering items 
        Map<String, Double> menu = restaurant1.getMenu(); 
        System.out.println("\nMenu:"); 
        for (Map.Entry<String, Double> item : menu.entrySet()) { 
            System.out.println(item.getKey() + " - $" + item.getValue()); 
        } 
 
        Order order = new Order(user, restaurant1); 
        boolean ordering = true; 
        while (ordering) { 
            System.out.print("\nEnter the item you want to order (or type 'done' 
to finish, 'menu' to see menu again): "); 
            String userInput = scanner.nextLine(); 
            if (userInput.equalsIgnoreCase("done")) { 
                ordering = false; 
            } else if (userInput.equalsIgnoreCase("menu")) { 
                System.out.println("\nMenu:"); 
                for (Map.Entry<String, Double> item : menu.entrySet()) { 
                    System.out.println(item.getKey() + " - $" + item.getValue()); 
                } 
            } else { 
                order.addItem(userInput); 
            } 
        } 
 
        // Display order details 
        System.out.println("\nOrder details:"); 
        System.out.println("User: " + order.getUser().getName()); 
        System.out.println("Restaurant: " + order.getRestaurant().getName()); 
        System.out.println("Items: " + order.getItems()); 
System.out.println("Total Price: $" + order.getTotalPrice()); 
// Add more functionalities like payment, delivery tracking, etc. 
scanner.close(); // Remember to close the scanner 
} 
}