public class CoffeeShopExample {  // Define the CoffeeShopExample class
    public static void main(String[] args) {  // Main method, entry point of the application
        CoffeeShop coffeeShop = new CoffeeShop();  // Create an instance of CoffeeShop

        // Create 10 customers
        Thread[] customers = new Thread[10];  // Declare an array to hold 10 customer threads
        for (int i = 0; i < 10; i++) {  // Loop through to create 10 customers
            customers[i] = new Thread(new Customer(coffeeShop, "Customer " + (i + 1)));  // Create a new thread for each customer and assign it a unique ID
        }

        // Create 3 baristas
        Thread barista1 = new Thread(new Barista(coffeeShop, "Barista 1", 1));  // Create a new thread for Barista 1
        Thread barista2 = new Thread(new Barista(coffeeShop, "Barista 2", 2));  // Create a new thread for Barista 2
        Thread barista3 = new Thread(new Barista(coffeeShop, "Barista 3", 3));  // Create a new thread for Barista 3

        // Start all threads
        for (Thread customer : customers) {  // Loop through the customer threads
            customer.start();  // Start each customer thread
        }

        barista1.start();  // Start Barista 1 thread
        barista2.start();  // Start Barista 2 thread
        barista3.start();  // Start Barista 3 thread
    }
}
