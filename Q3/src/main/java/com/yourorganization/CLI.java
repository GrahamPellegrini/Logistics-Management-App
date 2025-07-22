package com.yourorganization;

// Importing necessary classes and packages
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.yourorganization.Product.*;
import com.yourorganization.Shipment.*;
import com.yourorganization.Transport.*;
import com.yourorganization.Shipment.Customer.Customer;
import com.yourorganization.Shipment.Customer.CustomerCollection;
import com.yourorganization.Shipment.Decorator.GlobalDiscountDecorator;
import com.yourorganization.Shipment.Decorator.RouteAdjustmentDecorator;
import com.yourorganization.Shipment.Packaging.PackagedProduct;
import com.yourorganization.Shipment.Packaging.Packaging;
import com.yourorganization.Shipment.Stock.Stock;
import com.yourorganization.Shipment.Stock.StockCollection;



public class CLI {
    // Declaring necessary collections and scanner for input
    private Scanner scanner;
    private TransportCollection transportCollection;
    private CustomerCollection customerCollection;
    private ShipmentCollection shipmentCollection;
    private StockCollection stock;

    // Constructor for CLI class. Initializes collections and scanner.
public CLI() {
    scanner = new Scanner(System.in);
    transportCollection = new TransportCollection();
    stock = new StockCollection();
    customerCollection = new CustomerCollection();
    shipmentCollection = new ShipmentCollection();
    }

    // Method to run the CLI application
public void run() {
    boolean running = true;
    while (running) {
        try {
            showMainMenu(); // Displaying the main menu
            int choice = Integer.parseInt(scanner.nextLine()); // Getting user choice
            // Use of parseInt just for int values
            switch (choice) {
                case 1:
                    manageCustomers(); // Managing customers
                    break;
                case 2:
                    manageProducts(); // Managing products
                    break;
                case 3:
                    manageTransport(); // Managing transport
                    break;
                case 4:
                    manageShipments(); // Managing shipments
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load(); 
                    break;   
                case 7:
                    running = false; // Exit the application
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handling invalid choices
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number."); // Handling invalid number format
        }
    }
}

    // Method to show the main menu options
private void showMainMenu() {
    System.out.println("\n--- Logistics Management System ---");
    System.out.println("1. Manage Customers");
    System.out.println("2. Manage Products");
    System.out.println("3. Manage Transport");
    System.out.println("4. Manage Shipments");
    System.out.println("5. Save");
    System.out.println("6. Load");
    System.out.println("7. Exit");
    System.out.print("Enter your choice: "); // Prompt for user input
}
// Method for managing customer-related operations

private void manageCustomers() {
    System.out.println("\n--- Customer Management ---");
    System.out.println("1. Add Customer");
    System.out.println("2. View Customers");
    System.out.println("3. Update Customer");
    System.out.println("4. Delete Customer");
    System.out.println("5. Return to Main Menu");
    System.out.print("Enter your choice: ");

    // Reading the user's choice
    int choice = Integer.parseInt(scanner.nextLine());
    switch (choice) {
        case 1:
            addCustomer(); // Add a new customer
            break;
        case 2:
            viewCustomers(); // View list of customers
            break;
        case 3:
            updateCustomer(); // Update an existing customer
            break;
        case 4:
            deleteCustomer(); // Delete a customer
            break;
        case 5:
            // Return to main menu
            break;
        default:
            System.out.println("Invalid choice. Please try again."); // Handling invalid choices
    }
}

// Method to add a new customer
private void addCustomer() {
    System.out.print("Enter Customer ID: "); // User inputted customer id
    String id = scanner.nextLine();
    // nextLine used for string

    System.out.print("Enter Customer Name: "); // User inputted customer name
    String name = scanner.nextLine();

    // Getting the distance from warehouse
    System.out.print("Enter Distance from Warehouse (in kilometers): ");
    int distanceFromWarehouse;
    try {
        distanceFromWarehouse = Integer.parseInt(scanner.nextLine());
        // praseInt for integer inputs only
    } catch (NumberFormatException e) {
        System.out.println("Invalid input for distance. Please enter a number.");
        return; // Exit if input is invalid
    }

    // Creating and adding the new customer
    Customer newCustomer = new Customer(id, name, distanceFromWarehouse);
    customerCollection.addCustomer(newCustomer);
    System.out.println("Customer added successfully!");
}

// Method to view all customers
private void viewCustomers() {
    System.out.println("\nList of Customers:");
    List<Customer> customerList = customerCollection.getAllCustomers();
    if (customerList.isEmpty()) {
        System.out.println("No customers available."); // Inform if no customers are present
        return;
    }

    // Displaying each customer's details
    for (Customer customer : customerList) {
        System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() +
                           ", Distance from Warehouse: " + customer.getDistanceFromWarehouse() + " km");
    }
}

// Method to update an existing customer
private void updateCustomer() {
    System.out.print("Enter Customer ID to update: ");
    String customerId = scanner.nextLine();

    // Finding the customer to update
    Customer customerToUpdate = customerCollection.getCustomerById(customerId);
    if (customerToUpdate == null) {
        System.out.println("Customer not found."); // Inform if customer doesn't exist
        return;
    }

    // Update process for customer
    System.out.println("Updating Customer: " + customerToUpdate.getName());
    System.out.print("Enter new name (leave blank to keep current): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        customerToUpdate.setName(newName);
    }

    // Update distance from warehouse
    System.out.print("Enter new distance from warehouse in kilometers (leave blank to keep current): ");
    String newDistanceStr = scanner.nextLine();
    if (!newDistanceStr.isEmpty()) {
        try {
            int newDistance = Integer.parseInt(newDistanceStr);
            customerToUpdate.setDistanceFromWarehouse(newDistance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for distance. Please enter a valid number.");
            return;
        }
    }

    System.out.println("Customer updated successfully!");
}

// Method to delete a customer
private void deleteCustomer() {
    System.out.print("Enter Customer ID to delete: ");
    String customerId = scanner.nextLine();

    // Finding the customer to delete
    Customer customerToDelete = customerCollection.getCustomerById(customerId);
    if (customerToDelete == null) {
        System.out.println("Customer not found."); // Inform if customer doesn't exist
        return;
    }

    // Confirmation before deletion
    System.out.println("Are you sure you want to delete Customer: " + customerToDelete.getName() + "? (yes/no)");
    String confirmation = scanner.nextLine();
    if ("yes".equalsIgnoreCase(confirmation)) { // Use of equalsIgnoreCase to remove case sensitivity 
        customerCollection.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    } else {
        System.out.println("Customer deletion cancelled.");
    }
}

// Method for managing product-related operations
private void manageProducts() {
    System.out.println("Product Management");
    System.out.println("1. Add Product");
    System.out.println("2. View Products");
    System.out.println("3. Update Product");
    System.out.println("4. Delete Product");
    System.out.println("5. Order Additional Stock");
    System.out.println("6. Return to Main Menu");
    System.out.print("Enter your choice: ");
    
    // Reading the user's choice
    int choice = Integer.parseInt(scanner.nextLine());
    switch (choice) {
        case 1:
            addProduct(); // Add a new product
            break;
        case 2:
            viewProducts(); // View list of products
            break;
        case 3:
            updateProduct(); // Update an existing product
            break;
        case 4:
            deleteProduct(); // Delete a product
            break;
        case 5:
            orderAdditionalStock(); // Order additional stock for a product
            break;
        case 6:
            // Return to main menu
            break;
        default:
            System.out.println("Invalid choice. Please try again."); // Handling invalid choices
    }
}

// Method for adding new products to the stock
private void addProduct() {
    System.out.println("Select Main Product Type:");
    System.out.println("1. Book");
    System.out.println("2. Clothing");
    System.out.println("3. Computer Game");
    System.out.println("4. Electronic");
    System.out.println("5. Food");
    System.out.println("6. Furniture");
    System.out.print("Enter your choice: ");

    int mainType = Integer.parseInt(scanner.nextLine());
    int subType;

    Product product = null;

    switch (mainType) {
        case 1: // For Books
            System.out.println("Select Book Type:");
            System.out.println("1. Fiction");
            System.out.println("2. Non-Fiction");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"FB001", "Example Fiction Book", new Supplier("S001", "Acme Books"), 
                10, 19.99, "Example Author", "300", "Adventure");
            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"NFB001", "Example Non-Fiction Book", new Supplier("S002", "Knowledge Books"),
                 12, 21.99, "Example Author", "350", "Science");
            }  

            break;
        case 2: // For Clothing
            System.out.println("Select Clothing Type:");
            System.out.println("1. Jeans");
            System.out.println("2. T-Shirt");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"J001", "Quality Jeans", new Supplier("S003", "Denim World"), 
                5, 29.99, "Denim", "Blue", "32");
            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"TS001", "Cool T-Shirt", new Supplier("S004", "Fashion Hub"), 
                3, 14.99, "Cotton", "Red", "M");
            }

            break;
        case 3: // For Computer Games
            System.out.println("Select Computer Game Type:");
            System.out.println("1. Action Game");
            System.out.println("2. Puzzle Game");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"AG001", "Action Game", new Supplier("S005", "Game Studio"),
                2, 59.99, "GameDev", "12", "Action");

            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"PG001", "Puzzle Game", new Supplier("S006", "Puzzle Creators"), 
                2, 39.99, "PuzzleDev", "3", "Easy");
            }

            break;
        case 4: // For Electronics
            System.out.println("Select Electronic Type:");
            System.out.println("1. Smartphone");
            System.out.println("2. Television");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"SP001", "Smartphone", new Supplier("S007", "Tech Giants"),
                1, 499.99, "TechBrand", "ModelX", "128");
            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"TV001", "Television", new Supplier("S008", "Electronics Inc"),
                4, 799.99, "ElectroBrand", "ModelY", "55");
            }

            break;
        case 5: // For Food
            System.out.println("Select Food Type:");
            System.out.println("1. Canned Food");
            System.out.println("2. Fruit");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"CF001", "Canned Beans", new Supplier("S009", "Food Corp"),
                10, 2.99, "2024-12-31", "true", "Beans");
            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"F001", "Apple", new Supplier("S010", "Fresh Farms"),
                15, 0.99, "2024-12-31", "true", "Red Apple");
            }
            
            break;
        case 6: // For Furniture
            System.out.println("Select Furniture Type:");
            System.out.println("1. Chair");
            System.out.println("2. Table");

            if(scanner.nextLine() == "1"){
                subType = 1;
                product = ProductFactory.createProduct(mainType,subType,"CH001", "Office Chair", new Supplier("S011", "Furniture Co"),
                20, 109.99, "Leather", "120x60x60 cm", "true");
            }
            else{
                subType = 2;
                product = ProductFactory.createProduct(mainType,subType,"T001", "Dining Table", new Supplier("S012", "Woodworks"),
                30, 299.99, "Wood", "200x100x75 cm", "Rectangle");
            }

            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            return;
    }

    // Asking for product quantity
    System.out.print("Enter quantity: ");
    int quantity = Integer.parseInt(scanner.nextLine());

    // Adding product to stock
    stock.addProduct(product, quantity);
    System.out.println(product.getName() + " added successfully!");
}

// Method to display all products in stock
private void viewProducts() {
    System.out.println("List of Products:"); // Title for the products list
    for (Stock item : stock.getAllStockItems()) { // Loop through each stock item
        Product product = item.getProduct(); // Getting the product from the stock item
        // Printing product details
        System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                           ", Supplier: " + product.getSupplier().getName() +
                           ", Packaging Units: " + product.getPackagingUnits() +
                           ", Price: " + product.getPrice() +
                           ", Quantity: " + item.getQuantity());
    }
}

// Method for updating a product's details
private void updateProduct() {
    System.out.print("Enter Product ID to update: "); // Asking for product ID
    String productId = scanner.nextLine();

    // Find the product in stock
    Stock stockItemToUpdate = null;
    for (Stock item : stock.getAllStockItems()) { // Looping through the stock items
        if (item.getProduct().getId().equals(productId)) {
            stockItemToUpdate = item; // Assigning the stock item if ID matches
            break; // Break loop once product is found
        }
    }

    if (stockItemToUpdate == null) {
        System.out.println("Product not found."); // Message if product is not found
        return; // Exiting the method
    }

    Product productToUpdate = stockItemToUpdate.getProduct(); // Get the product to update

    // Asking for new product name
    System.out.print("Enter new name (" + productToUpdate.getName() + "): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        productToUpdate.setName(newName); // Update name if input is not empty
    }

    // Asking for new product price
    System.out.print("Enter new price (" + productToUpdate.getPrice() + "): ");
    String newPriceStr = scanner.nextLine();
    if (!newPriceStr.isEmpty()) {
        double newPrice = Double.parseDouble(newPriceStr); // Parsing string to double
        productToUpdate.setPrice(newPrice); // Update price
    }

    // Asking for new packaging units
    System.out.print("Enter new packaging units (" + productToUpdate.getPackagingUnits() + "): ");
    String newPackagingUnitsStr = scanner.nextLine();
    if (!newPackagingUnitsStr.isEmpty()) {
        int newPackagingUnits = Integer.parseInt(newPackagingUnitsStr); // Parsing string to int
        productToUpdate.setPackagingUnits(newPackagingUnits); // Update packaging units
    }

    System.out.println("Product updated successfully!"); // Confirming update
}

// Method for deleting a product from stock
private void deleteProduct() {
    System.out.print("Enter Product ID to delete: "); // Asking for the product ID to delete
    String productId = scanner.nextLine();

    // Attempting to remove the product from stock
    boolean removed = stock.removeProduct(productId);
    if (removed) {
        System.out.println("Product removed successfully!"); // Confirmation if product is successfully removed
    } else {
        System.out.println("Product not found."); // Message if product is not found in stock
    }
}

// Method to order more stock for a product
private void orderAdditionalStock() {
    System.out.print("Enter Product ID for additional stock: "); // Prompting for product ID
    String productId = scanner.nextLine();

    System.out.print("Enter additional quantity: "); // Prompting for how much more to order
    int additionalQuantity = Integer.parseInt(scanner.nextLine()); // Convert input to integer

    // Try to add more stock to the product
    boolean added = stock.addAdditionalStock(productId, additionalQuantity);
    if (added) {
        System.out.println("Additional stock ordered successfully!"); // Success message
    } else {
        System.out.println("Product not found."); // Error message if product doesn't exist
    }
}

// Method for managing transportation options
private void manageTransport() {
    System.out.println("Transport Management"); // Title for transport management section
    System.out.println("1. Add Transport"); // Option for adding transport
    System.out.println("2. View Transports"); // Option for viewing all transports
    System.out.println("3. Update Transport"); // Option for updating a transport
    System.out.println("4. Delete Transport"); // Option for deleting a transport
    System.out.println("5. Return to Main Menu"); // Option to return to main menu
    System.out.print("Enter your choice: "); // Prompt for user's choice

    int choice = Integer.parseInt(scanner.nextLine()); // Reading user's choice
    switch (choice) {
        case 1:
            addTransport(); // Call method to add transport
            break;
        case 2:
            viewTransports(); // Call method to view transports
            break;
        case 3:
            updateTransport(); // Call method to update transport
            break;
        case 4:
            deleteTransport(); // Call method to delete transport
            break;
        case 5:
            // Returning to main menu
            break;
        default:
            System.out.println("Invalid choice. Please try again."); // Message for invalid choice
    }
}

// Method for adding new transport
private void addTransport() {
    System.out.println("Select Transport Type to Add:");
    System.out.println("1. Aircraft");
    System.out.println("2. Ship");
    System.out.println("3. Truck");
    System.out.print("Enter your choice: ");

    int choice = Integer.parseInt(scanner.nextLine());
    Transport transport = null;

    System.out.print("Enter Transport ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter Speed: ");
    double speed = Double.parseDouble(scanner.nextLine());
    System.out.print("Enter Cost Per Km: ");
    double costPerKm = Double.parseDouble(scanner.nextLine());
    System.out.print("Enter Route (comma-separated): ");
    List<String> routes = Arrays.asList(scanner.nextLine().split(","));
    // Reads array through , seperation of strings

    switch (choice) {
        case 1:
            transport = TransportFactory.createTransport("aircraft", id, speed, costPerKm, routes);
            break;
        case 2:
            transport = TransportFactory.createTransport("seavessel", id, speed, costPerKm, routes);
            break;
        case 3:
            transport = TransportFactory.createTransport("truck", id, speed, costPerKm, routes);
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            return;
    }

    if (transport != null) {
        transportCollection.addTransport(transport);
        System.out.println("Transport added successfully!");
    }
}

// Method to display all transports 
private void viewTransports() {
    System.out.println("List of Transports:"); // Title for the transports list

    // Loop through each transport item
    for (Transport transport : transportCollection.getAllTransports()) {

        // Check if the transport is an Aircraft
        if (transport instanceof Aircraft) {
            Aircraft aircraft = (Aircraft) transport; // Casting transport to Aircraft
            // Printing details of the aircraft
            System.out.println("Aircraft - ID: " + aircraft.getId() + ", Speed: " + aircraft.getSpeed() + " km/h, Cost per Km: " + aircraft.getCostPerKm() + ", Air Spaces: " + aircraft.getAirSpaces());
        
        // Check if the transport is a Ship
        } else if (transport instanceof Ship) {
            Ship ship = (Ship) transport; // Casting transport to Ship
            // Printing details of the ship
            System.out.println("Ship - ID: " + ship.getId() + ", Speed: " + ship.getSpeed() + " km/h, Cost per Km: " + ship.getCostPerKm() + ", Sea Routes: " + ship.getSeaRoutes());
        
        // Check if the transport is a Truck
        } else if (transport instanceof Truck) {
            Truck truck = (Truck) transport; // Casting transport to Truck
            // Printing details of the truck
            System.out.println("Truck - ID: " + truck.getId() + ", Speed: " + truck.getSpeed() + " km/h, Cost per Km: " + truck.getCostPerKm() + ", Motorways: " + truck.getMotorways());
        }
    }
}

// Method to update a transport's details
private void updateTransport() {
    System.out.print("Enter Transport ID to update: "); // Asking for transport ID
    String transportId = scanner.nextLine(); // Read transport ID from user

    // Find the transport in the collection
    Transport transportToUpdate = null;
    for (Transport transport : transportCollection.getAllTransports()) {
        // Comparing the transport ID's
        if (transport.getId().equals(transportId)) {
            transportToUpdate = transport; // Found the transport
            break; // Exit the loop once transport is found
        }
    }

    // Check if transport was found
    if (transportToUpdate == null) {
        System.out.println("Transport not found."); // Transport not found
        return; // Exit the method if transport is not found
    }

    // Update common attributes (example: speed and costPerKm)
    System.out.print("Enter new speed (current: " + transportToUpdate.getSpeed() + "): "); // Asking for new speed
    String newSpeedStr = scanner.nextLine(); // Reading new speed
    if (!newSpeedStr.isEmpty()) { // Check if new speed is provided
        double newSpeed = Double.parseDouble(newSpeedStr); // Converting speed to double
        transportToUpdate.setSpeed(newSpeed); // Updating the speed
    }

    System.out.print("Enter new cost per km (current: " + transportToUpdate.getCostPerKm() + "): "); // Asking for new cost per km
    String newCostPerKmStr = scanner.nextLine(); // Reading new cost per km
    // Note string used first for isEmpty() function 
    if (!newCostPerKmStr.isEmpty()) { // Check if new cost per km is provided
        double newCostPerKm = Double.parseDouble(newCostPerKmStr); // Convert cost to double
        transportToUpdate.setCostPerKm(newCostPerKm); // Update the cost per km
    }
    System.out.println("Transport updated successfully!"); // Confirming the update
}

// Method for deleting a transport
private void deleteTransport() {
    System.out.print("Enter Transport ID to delete: "); // Asking for the transport ID to delete
    String transportId = scanner.nextLine(); // Read the transport ID from user input

    // Remove the transport from the collection
    boolean removed = transportCollection.deleteTransport(transportId);
    if (removed) {
        System.out.println("Transport removed successfully!"); // Confirming transport removal if successful
    } else {
        System.out.println("Transport not found."); // Message if transport is not in the collection
    }
}

// Method for managing shipments
private void manageShipments() {
    System.out.println("Shipment Management"); // Displaying the title for shipment management options
    // Display options for shipment management
    System.out.println("1. Create Shipment");
    System.out.println("2. View Shipments");
    System.out.println("3. Update Shipment");
    System.out.println("4. Delete Shipment");
    System.out.println("5. Dispatch Shipment");
    System.out.println("6. Return to Main Menu");
    System.out.print("Enter your choice: "); // Prompt for user to enter their choice

    int choice = Integer.parseInt(scanner.nextLine()); // Read the user's choice
    switch (choice) { // Switch case based on the user's choice
        case 1:
            createShipment(); // Call method to create a shipment
            break;
        case 2:
            viewShipments(); // Call method to view shipments
            break;
        case 3:
            updateShipment(); // Call method to update a shipment
            break;
        case 4:
            deleteShipment(); // Call method to delete a shipment
            break;
        case 5:
            dispatchShipment(); // Call method to dispatch a shipment
            break;    
        case 6:
            // Return to main menu, no action needed
            break;
        default:
            System.out.println("Invalid choice. Please try again."); // Handling invalid choices
    }
}

// Method for creating a new shipment
private void createShipment() {

    System.out.print("Enter Shipment ID: "); // Asking for Shipment ID
    String shipmentId = scanner.nextLine(); // Reading Shipment ID from input

    // Select Customer
    System.out.print("Enter Customer ID: "); // Asking for Customer ID
    String customerId = scanner.nextLine(); // Reading Customer ID
   
    Customer customer = customerCollection.getCustomerById(customerId);
    if (customer == null) {
        System.out.println("Customer not found."); // Customer not found in the collection
        return; // Exit the method if customer is not found
    }

    //Select Transport
    System.out.print("Enter Transport ID: "); // Asking for Transport ID
    String transportId = scanner.nextLine(); // Reading Transport ID
    
    Transport transport = transportCollection.getTransportById(transportId);
    if (transport == null) {
        System.out.println("Transport not found."); // Transport not found in the collection
        return; // Exit the method if transport is not found
    }

    // Select Products through Packaged Products
    List<PackagedProduct> packagedProducts = new ArrayList<>();
    boolean addingProducts = true;
    while (addingProducts) {
        System.out.print("Enter Product ID to add to shipment (or 'done' to finish): "); // Prompt to add product ID or finish
        String productId = scanner.nextLine(); // Reading product ID
        if ("done".equalsIgnoreCase(productId)) {
            addingProducts = false; // Exit the loop if user enters 'done'
            continue;
        }

        Product product = stock.getProductById(productId); 
        if (product == null) {
            System.out.println("Product not found."); // Product not found in the stock
            continue; // Continue asking for product IDs
        }

        System.out.print("Enter quantity of product: "); // Ask for quantity of product
        int quantity = Integer.parseInt(scanner.nextLine()); // Reading quantity

        // Check if there is enough stock
        Stock stockItem = stock.getStockItem(product);
        if (stockItem == null || stockItem.getQuantity() < quantity) {
            System.out.println("Insufficient stock for product: " + product.getName()); // Insufficient stock message
            continue; // Continue asking for product IDs
        }

        // Deduct the quantity from stock
        stock.removeProduct(product, quantity); // Removing product from stock

        Packaging packaging = new Packaging("Default", 1, 0.5); // Example packaging
        packagedProducts.add(new PackagedProduct(product, packaging, quantity)); // Adding packaged product to list
    }
    
    Shipment newShipment = new Shipment(shipmentId, customer, transport, packagedProducts); // Creating new shipment
    shipmentCollection.addShipment(newShipment); // Adding the new shipment to collection

    System.out.println("Shipment created successfully!"); // Confirming the creation of shipment
}

// Method to display all shipments
private void viewShipments() {
    System.out.println("List of Shipments:"); // Printing the title for the list of shipments

    // Loop through each shipment in the collection
    for (Shipment shipment : shipmentCollection.getAllShipments()) {
        Customer customer = shipment.getCustomer(); // Get the customer from the shipment
        Transport transport = shipment.getTransport(); // Get the transport from the shipment

        System.out.println("Shipment Details:"); // Print the details of the shipment
        // Display customer details
        System.out.println("Customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
        // Display transport details
        System.out.println("Transport: " + transport.getId()); // Add more transport details as needed

        System.out.println("Packaged Products in Shipment:"); // Title for the list of packaged products
        // Loop through packaged products in the shipment
        for (PackagedProduct packagedProduct : shipment.getPackagedProducts()) {
            Product product = packagedProduct.getProduct(); // Get the product from the packaged product
            // Print details of the product
            System.out.println("- Product: " + product.getName() + " (ID: " + product.getId() + "), Quantity: " + packagedProduct.getQuantity());
        }

        // Print the total cost of the shipment
        System.out.println("Total Cost: " + shipment.getTotalCost());
        System.out.println("-------------------------------------------------"); // Separator for each shipment
    }
}

private Shipment applyShipmentDecorators(Shipment shipment) {
    Shipment decoratedShipment = shipment; // Start with the original shipment

    System.out.println("1. Apply Global Discount");
    System.out.println("2. Add Route Stage");
    System.out.println("3. Remove Route Stage");
    System.out.print("Enter your choice: ");
    int choice = Integer.parseInt(scanner.nextLine());

    Transport transport = decoratedShipment.getTransport();
    List<String> routes = transport.getRoutePlan();

    switch (choice) {
        case 1:
                System.out.print("Enter discount percentage: ");
                double discount = Double.parseDouble(scanner.nextLine());
                decoratedShipment = new GlobalDiscountDecorator(decoratedShipment, discount);
                break;
        case 2:
                if(shipment.isDispatched()){
                    System.out.println("Route Stages are: "+ routes);
                    System.out.print("Enter new route stage to add: ");
                    String newRoute = scanner.nextLine();

                    decoratedShipment = new RouteAdjustmentDecorator(decoratedShipment, routes);
                    ((RouteAdjustmentDecorator) decoratedShipment).addRouteStage(newRoute);
                    break;
                }
                else{
                    System.out.print("This function is only used after dispatch");
                }
            case 3:
                if(shipment.isDispatched()){
                    System.out.println("Route Stages are: " + routes);
                    System.out.print("Enter route stage to remove: ");
                    String routeToRemove = scanner.nextLine();
            
                    // Check if the route to remove exists in the list
                    if (routes.contains(routeToRemove)) {
                        decoratedShipment = new RouteAdjustmentDecorator(decoratedShipment, routes);
                        ((RouteAdjustmentDecorator) decoratedShipment).removeRouteStage(routeToRemove);
                        System.out.println("Route stage removed successfully.");
                    } else {
                        System.out.println("Route stage not found: " + routeToRemove);
                    }
                    break;
                }
                else{
                    System.out.print("This function is only used after dispatch");
                }
            default:
                System.out.println("Invalid choice.");
            break;
    }
    return decoratedShipment;
}


// Method for updating an existing shipment
private void updateShipment() {
    System.out.print("Enter Shipment ID to update: "); // Asking for the ID of the shipment to update
    String shipmentId = scanner.nextLine(); // Reading shipment ID from input

    Shipment shipmentToUpdate = shipmentCollection.getShipmentById(shipmentId);
    if (shipmentToUpdate == null) {
        System.out.println("Shipment not found."); // If shipment is not found in the collection
        return; // Exit the method if shipment is not found
    }

    // Check if the shipment has been dispatched
    if (shipmentToUpdate.isDispatched()) {
        System.out.println("Cannot update a dispatched shipment."); // Message if shipment is already dispatched
        return; // Exit the method if shipment is dispatched
    }

    // Update transport
    System.out.print("Enter new Transport ID (current: " + shipmentToUpdate.getTransport().getId() + ", or 'skip'): "); // Asking for new transport ID or to skip
    String newTransportId = scanner.nextLine(); // Reading new transport ID
    if (!"skip".equalsIgnoreCase(newTransportId)) { // Check if user wants to update the transport
        Transport newTransport = transportCollection.getTransportById(newTransportId); // Get new transport by ID
        if (newTransport != null) {
            shipmentToUpdate.setTransport(newTransport); // Update the transport of the shipment
        } else {
            System.out.println("Transport not found."); // Transport not found in the collection
        }

    System.out.println("Would you like to add any modifications to the shipment?"); // Implementation of decorator classes
    System.out.println("1. Yes");
    System.out.println("2. No");
    int modifications = Integer.parseInt(scanner.nextLine());
    if(modifications == 1){
        applyShipmentDecorators(shipmentToUpdate); // Calls new applyShipmentDecorators class 
    }
    else{
        // no modifcations
    }
        
    }
    System.out.println("Shipment updated successfully!"); // Confirming the update of the shipment
}

// Method to delete a shipment
private void deleteShipment() {
    System.out.print("Enter Shipment ID to delete: "); // Prompting user to enter the ID of the shipment to delete
    String shipmentId = scanner.nextLine(); // Reading the Shipment ID
    
    Shipment shipmentToDelete = shipmentCollection.getShipmentById(shipmentId);
    if (shipmentToDelete == null) {
        System.out.println("Shipment not found."); // Informing that the shipment wasn't found in the collection
        return; // Exit the method if shipment is not found
    }

    // Check if the shipment has been dispatched
    if (shipmentToDelete.isDispatched()) {
        System.out.println("Cannot delete a dispatched shipment."); // Informing that a dispatched shipment can't be deleted
        return; // Exit the method if shipment is already dispatched
    }

    // Remove the shipment from the collection
    boolean removed = shipmentCollection.removeShipment(shipmentId);
    if (removed) {
        System.out.println("Shipment deleted successfully!"); // Confirming successful deletion
    } else {
        System.out.println("Error deleting shipment."); // Handling error in deleting the shipment
    }
}

// Method to dispatch a shipment
private void dispatchShipment() {
    System.out.print("Enter Shipment ID to dispatch: "); // Asking for the ID of the shipment to dispatch
    String shipmentId = scanner.nextLine(); // Reading the Shipment ID from user input

    Shipment shipment = shipmentCollection.getShipmentById(shipmentId); // Getting the shipment by ID
    if (shipment == null) {
        System.out.println("Shipment not found."); // Informing if the shipment is not found
        return; // Exiting the method if shipment is not found
    }

    if (shipment.isDispatched()) {
        System.out.println("Shipment has already been dispatched."); // Informing if the shipment is already dispatched
        return; // Exiting the method if shipment is already dispatched
    }

    // Dispatch the shipment
    shipment.dispatchShipment(); // This sets the isDispatched flag to true, indicating shipment has been dispatched
}

private void save(){
    transportCollection.save("File");
    customerCollection.save("File");
    stock.save("File");
    shipmentCollection.save("File");
}

private void load(){
    transportCollection.load("File");
    customerCollection.load("File");
    stock.load("File");
    shipmentCollection.load("File");
}

public static void main(String[] args) {
        // Starting point of the application
        new CLI().run(); // Creating an instance of CLI and running the application
    }
}
