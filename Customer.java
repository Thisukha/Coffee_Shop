public class Customer implements Runnable {  // Define the Customer class that implements Runnable
    private final CoffeeShop coffeeShop;  // Declare a reference to a CoffeeShop object
    private final String customerId;  // Declare a variable to hold the customer ID
    private static int orderCounter = 0;  // Declare a static counter to keep track of order numbers

    public Customer(CoffeeShop coffeeShop, String customerId) {  // Constructor to initialize the CoffeeShop and customer ID
        this.coffeeShop = coffeeShop;  // Initialize the coffeeShop field with the provided CoffeeShop object
        this.customerId = customerId;  // Initialize the customerId field with the provided customer ID
    }

    @Override
    public void run() {  // Implement the run method required by the Runnable interface
        try {
            while (true) {  // Loop indefinitely, as the customer keeps placing orders
                int orderNum = ++orderCounter;  // Increment and get the next order number
                String order = String.format("Order #%03d from Customer %s", orderNum, customerId);  // Format the order string with the order number and customer ID
                coffeeShop.placeOrder(order);  // Call the placeOrder method on the coffeeShop to place the order
                // Random time between 1 to 5 seconds before placing the next order
                Thread.sleep((long) (Math.random() * 4000 + 1000));  // Sleep for a random time between 1 to 5 seconds before placing the next order
            }
        } catch (InterruptedException e) {  // Catch interrupted exception if the thread is interrupted
            Thread.currentThread().interrupt();  // Set the interrupt flag of the current thread
        }
    }
}
