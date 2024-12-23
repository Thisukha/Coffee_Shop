import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// The CoffeeShop class simulates a coffee shop where orders are placed and processed by baristas.
public class CoffeeShop {
    // Declare the queues for the three baristas. These queues hold the orders.
    private final BlockingQueue<String> baristaQueue1;
    private final BlockingQueue<String> baristaQueue2;
    private final BlockingQueue<String> baristaQueue3;
    
    // Maximum size of each barista's queue (number of orders a barista can handle).
    private final int maxSize = 10;

    // Constructor for the CoffeeShop class.
    public CoffeeShop() {
        // Initialize each barista's queue with a maximum size.
        this.baristaQueue1 = new ArrayBlockingQueue<>(maxSize);
        this.baristaQueue2 = new ArrayBlockingQueue<>(maxSize);
        this.baristaQueue3 = new ArrayBlockingQueue<>(maxSize);

        // Print a welcome message when the CoffeeShop is created.
        System.out.println("***** Welcome to the Barista *****\n");
    }

    // Method to place an order in the coffee shop. It will assign the order to the first available barista's queue.
    public void placeOrder(String order) throws InterruptedException {
        // Continuously try to place the order in one of the barista queues.
        while (true) {
            // Check if Barista 1's queue has space and if so, place the order in Barista 1's queue.
            if (baristaQueue1.size() < maxSize) {
                baristaQueue1.put(order);  // Place the order in Barista 1's queue
                System.out.printf("\nNEW ORDER: %s%nAssigned to: Barista 1's Queue%n", order);  // Print the order details
                break;  // Exit the loop once the order has been placed
            } 
            // If Barista 1's queue is full, check if Barista 2's queue has space.
            else if (baristaQueue2.size() < maxSize) {
                System.out.println("\nBarista 1 is full at the moment, switching to Barista 2...");  // Inform the user about the switch
                baristaQueue2.put(order);  // Place the order in Barista 2's queue
                System.out.printf("NEW ORDER: %s%nAssigned to: Barista 2's Queue%n", order);  // Print the order details
                break;  // Exit the loop once the order has been placed
            } 
            // If Barista 2's queue is also full, check if Barista 3's queue has space.
            else if (baristaQueue3.size() < maxSize) {
                System.out.println("\nBarista 2 is full at the moment, switching to Barista 3...");  // Inform the user about the switch
                baristaQueue3.put(order);  // Place the order in Barista 3's queue
                System.out.printf("NEW ORDER: %s%nAssigned to: Barista 3's Queue%n", order);  // Print the order details
                break;  // Exit the loop once the order has been placed
            } 
            // If all baristas' queues are full, print a message and wait before retrying.
            else {
                // All barista queues are full, print a message to inform the user.
                System.out.println("\n***** All Baristas are full! *****");
                System.out.println("***** Please wait until a barista is free *****");

                // Wait for 1 second before trying to place the order again.
                Thread.sleep(1000); // Wait for a moment before retrying
            }
        }
    }

    // Method to prepare an order from Barista 1's queue.
    public String prepareOrderBarista1() throws InterruptedException {
        // Take the order from Barista 1's queue (blocking if the queue is empty).
        return baristaQueue1.take();
    }

    // Method to prepare an order from Barista 2's queue.
    public String prepareOrderBarista2() throws InterruptedException {
        // Take the order from Barista 2's queue (blocking if the queue is empty).
        return baristaQueue2.take();
    }

    // Method to prepare an order from Barista 3's queue.
    public String prepareOrderBarista3() throws InterruptedException {
        // Take the order from Barista 3's queue (blocking if the queue is empty).
        return baristaQueue3.take();
    }
}
