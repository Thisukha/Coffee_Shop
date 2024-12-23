public class Barista implements Runnable {
    // This declares a class named 'Barista' that implements the 'Runnable' interface,
    // meaning instances of this class can be executed by a thread.

    private final CoffeeShop coffeeShop;
    // A reference to the CoffeeShop object. This allows the Barista to access the queues and perform actions on them.
    
    private final String name;
    // The name of the barista. This is passed when the barista is created to distinguish between different baristas.

    private final int baristaNumber;
    // An integer representing the barista's number (1, 2, or 3). This helps identify which queue the barista will work on.

    public Barista(CoffeeShop coffeeShop, String name, int baristaNumber) {
        // Constructor that initializes the Barista with the coffeeShop object, name, and barista number.
        this.coffeeShop = coffeeShop;
        this.name = name;
        this.baristaNumber = baristaNumber;
    }

    @Override
    public void run() {
        // This is the method that will be executed when the thread starts. It keeps running continuously in a loop.
        
        try {
            while (true) {
                // The loop runs continuously until the thread is interrupted. This means the barista will keep processing orders forever.

                // Declare a variable to store the order that the barista will process.
                String order;
                
                // Check which barista number this is (1, 2, or 3) and call the appropriate method from the CoffeeShop class
                // to retrieve an order from the correct queue.
                if (baristaNumber == 1) {
                    order = coffeeShop.prepareOrderBarista1();
                    // If this barista is the first one, fetch the order from Barista 1's queue.
                } else if (baristaNumber == 2) {
                    order = coffeeShop.prepareOrderBarista2();
                    // If this barista is the second one, fetch the order from Barista 2's queue.
                } else {
                    order = coffeeShop.prepareOrderBarista3();
                    // If this barista is the third one, fetch the order from Barista 3's queue.
                }

                // Simulate the order preparation time by making the thread sleep for a random period between 500 ms and 1500 ms.
                Thread.sleep((long) (Math.random() * 1000 + 500));
                // The Thread.sleep() method pauses the current thread (the barista) for a random time.
                // (Math.random() generates a number between 0 and 1, multiplied by 1000 gives a value between 0 and 1000,
                // and adding 500 makes the range 500 ms to 1500 ms).

                // Print a message indicating that the order has been completed.
                System.out.println("\n--- ORDER COMPLETED ---");
                // This message indicates the order is ready.

                // Print the name of the barista who completed the order.
                System.out.printf("Barista: %s%n", name);
                // This line uses the printf method to format and display the barista's name.

                // Print the details of the completed order.
                System.out.printf("Order: %s%n", order);
                // This line shows the details of the order that was completed.

                // Print a separator line for better readability.
                System.out.println("-------------------------\n");
                // This is a simple separator to visually separate the order completion messages.
            }
        } catch (InterruptedException e) {
            // If the thread is interrupted, handle the interruption gracefully by setting the thread's interrupt flag.
            Thread.currentThread().interrupt();
            // This allows the thread to terminate properly if it's interrupted by another part of the code.
        }
    }
}
