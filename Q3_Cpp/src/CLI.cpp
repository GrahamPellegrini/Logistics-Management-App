#include "../include/CLI.h"

#include "../include/Shipment/ShipmentCollection.h"
#include "../include/Shipment/Shipment.h"

#include "../include/Shipment/Stock/Stock.h"
#include "../include/Shipment/Stock/StockCollection.h"
#include "../include/Shipment/Packaging/PackagedProduct.h"
#include "../include/Shipment/Packaging/PackageCollection .h"
#include "../include/Shipment/Packaging/Packaging.h"
#include "../include/Transport/Aircraft.h"
#include "../include/Transport/Truck.h"
#include "../include/Transport/Ship.h"




#include "../include/Product/Product.h"
#include "../include/Product/Supplier.h"

#include "../include/Product/Book/FictionBook.h"
#include "../include/Product/Book/NonFictionBook.h"
#include "../include/Product/Clothing/Jeans.h"
#include "../include/Product/Clothing/TShirt.h"
#include "../include/Product/ComputerGame/ActionGame.h"
#include "../include/Product/ComputerGame/PuzzleGame.h"
#include "../include/Product/Electronic/Smartphone.h"
#include "../include/Product/Electronic/Television.h"
#include "../include/Product/Food/CannedFood.h"
#include "../include/Product/Food/Fruit.h"
#include "../include/Product/Furniture/Chair.h"
#include "../include/Product/Furniture/Table.h"
CLI::CLI() {
}

void CLI::showMainMenu() {
    std::cout << "\n--- Logistics Management System ---" << std::endl;
    std::cout << "1. Manage Customers" << std::endl;
    std::cout << "2. Manage Products" << std::endl;
    std::cout << "3. Manage Transport" << std::endl;
    std::cout << "4. Manage Shipments" << std::endl;
    std::cout << "5. View Stock" << std::endl;
    std::cout << "6. Exit" << std::endl;
    std::cout << "Enter your choice: ";
}

void CLI::run() {
    bool running = true;
    while (running) {
        try {
            showMainMenu();
            int choice;
            std::cin >> choice;

            switch (choice) {
                case 1:
                    manageCustomers();
                    break;
                case 2:
                    manageProducts();
                    break;
                case 3:
                    manageTransport();
                    break;
                case 4:
                    manageShipments();
                    break;
                case 5:
                    stockviewer();
                case 6:
                    running = false;
                    std::cout << "Exiting the system..." << std::endl;
                    break;
                default:
                    std::cout << "Invalid choice. Please try again." << std::endl;
            }
        } catch (...) {
            std::cout << "Invalid input. Please enter a number." << std::endl;
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        }
    }
}   

    // Method for managing customer-related operations
void CLI::manageCustomers() {
    std::cout << "\n--- Customer Management ---" << std::endl;
    std::cout << "1. Add Customer" << std::endl;
    std::cout << "2. View Customers" << std::endl;
    std::cout << "3. Update Customer" << std::endl;
    std::cout << "4. Delete Customer" << std::endl;
    std::cout << "5. Return to Main Menu" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;

    switch (choice) {
        case 1:
            addCustomer();
            break;
        case 2:
            viewCustomers();
            break;
        case 3:
            updateCustomer();
            break;
        case 4:
            deleteCustomer();
            break;   
        case 5:
            // Return to main menu
            break;
        default:
            std::cout << "Invalid choice. Please try again." << std::endl;
    }
}

// Method to add a new customer
void CLI::addCustomer() {
    std::string id, name;
    int distanceFromWarehouse;

    std::cout << "Enter Customer ID: ";
    std::cin.ignore(); // To consume any newline left in the input buffer
    std::getline(std::cin, id);

    std::cout << "Enter Customer Name: ";
    std::getline(std::cin, name);

    std::cout << "Enter Distance from Warehouse (in kilometers): ";
    std::cin >> distanceFromWarehouse;

    if(std::cin.fail()) { // Checking for input failure
        std::cin.clear(); // Clearing the error state
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignoring leftover input
        std::cout << "Invalid input for distance. Please enter a number." << std::endl;
        return;
    }

    // Creating and adding the new customer
    auto newCustomer = std::make_shared<Customer>(id, name, distanceFromWarehouse);
    customerCollection.addCustomer(newCustomer);
    std::cout << "Customer added successfully!" << std::endl;
}

// Method to view all customers
void CLI::viewCustomers() {
    std::cout << "\nList of Customers:" << std::endl;
    auto customerList = customerCollection.getAllCustomers();
    if (customerList.empty()) {
        std::cout << "No customers available." << std::endl;
        return;
    }

    for (const auto& customer : customerList) {
        std::cout << "ID: " << customer->getId() 
                  << ", Name: " << customer->getName() 
                  << ", Distance from Warehouse: " << customer->getDistanceFromWarehouse() << " km" << std::endl;
    }
}

// Method to update an existing customer
void CLI::updateCustomer() {
    std::string customerId, newName; 
    std::string newDistanceStr;
    int newDistance;

    std::cout << "Enter Customer ID to update: ";
    std::cin.ignore();
    std::getline(std::cin, customerId);

    auto customerToUpdate = customerCollection.getCustomerById(customerId);
    if (customerToUpdate == nullptr) {
        std::cout << "Customer not found." << std::endl;
        return;
    }

    std::cout << "Updating Customer: " << customerToUpdate->getName() << std::endl;
    std::cout << "Enter new name (leave blank to keep current): ";
    std::getline(std::cin, newName);
    if (!newName.empty()) {
        customerToUpdate->setName(newName);
    }

    std::cout << "Enter new distance from warehouse in kilometers (leave blank to keep current): ";
    std::getline(std::cin, newDistanceStr);
    if (!newDistanceStr.empty()) {
        try {
            newDistance = std::stoi(newDistanceStr);
            customerToUpdate->setDistanceFromWarehouse(newDistance);
        } catch (...) {
            std::cout << "Invalid input for distance. Please enter a valid number." << std::endl;
            return;
        }
    }

    std::cout << "Customer updated successfully!" << std::endl;
}

// Method to delete a customer
void CLI::deleteCustomer() {
    std::string customerId, confirmation;

    std::cout << "Enter Customer ID to delete: ";
    std::cin.ignore();
    std::getline(std::cin, customerId);

    auto customerToDelete = customerCollection.getCustomerById(customerId);
    if (customerToDelete == nullptr) {
        std::cout << "Customer not found." << std::endl;
        return;
    }

    std::cout << "Are you sure you want to delete Customer: " << customerToDelete->getName() << "? (yes/no) ";
    std::getline(std::cin, confirmation);
    if (confirmation == "yes") {
        customerCollection.deleteCustomer(customerId);
        std::cout << "Customer deleted successfully." << std::endl;
    } else {
        std::cout << "Customer deletion cancelled." << std::endl;
    }
}

// Method for managing product-related operations
void CLI::manageProducts() {
    std::cout << "Product Management" << std::endl;
    std::cout << "1. Add Product" << std::endl;
    std::cout << "2. View Products" << std::endl;
    std::cout << "3. Update Product" << std::endl;
    std::cout << "4. Delete Product" << std::endl;
    std::cout << "5. Order Additional Stock" << std::endl;
    std::cout << "6. Return to Main Menu" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;
    std::cin.ignore(); // Clearing the newline character from the buffer

    switch (choice) {
        case 1:
            addProduct();
            break;
        case 2:
            viewProducts();
            break;
        case 3:
            updateProduct();
            break;
        case 4:
            deleteProduct();
            break;
        case 5:
            orderAdditionalStock();
            break;
        case 6:
            // Return to main menu
            break;
        default:
            std::cout << "Invalid choice. Please try again." << std::endl;
    }
}

// Method for adding new products to the stock
void CLI::addProduct() {
    std::cout << "Select Product Type to Add:" << std::endl;
    std::cout << "1. Fiction Book" << std::endl;
    std::cout << "2. Non-Fiction Book" << std::endl;
    std::cout << "3. Jeans" << std::endl;
    std::cout << "4. T-Shirt" << std::endl;
    std::cout << "5. Action Game" << std::endl;
    std::cout << "6. Puzzle Game" << std::endl;
    std::cout << "7. Smartphone" << std::endl;
    std::cout << "8. Television" << std::endl;
    std::cout << "9. Canned Food" << std::endl;
    std::cout << "10. Fruit" << std::endl;
    std::cout << "11. Chair" << std::endl;
    std::cout << "12. Table" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;
    std::cin.ignore();  // Clear newline character left in the buffer

    std::shared_ptr<Product> product;

    switch (choice) {
        case 1:
            product = std::make_shared<FictionBook>("FB001", "Fiction Book", "S001", 10, 19.99, "Example Author", 300, "Adventure");
            break;
        case 2:
            product = std::make_shared<NonFictionBook>("NFB001", "Non-Fiction Book", "S002", 12, 21.99, "Example Author", 350, "Science");
            break;
        case 3:
            product = std::make_shared<Jeans>("J001", "Quality Jeans", "S003", 5, 29.99, "Denim", "Blue", 32);
            break;
        case 4:
            product = std::make_shared<TShirt>("TS001", "Cool T-Shirt", "S004", 3, 14.99, "Cotton", "Red", "M");
            break;
        case 5:
            product = std::make_shared<ActionGame>("AG001", "Action Game", "S005", 2, 59.99, "GameDev", 12, "Action");
            break;
        case 6:
            product = std::make_shared<PuzzleGame>("PG001", "Puzzle Game", "S006", 2, 39.99, "PuzzleDev", 3, "Easy");
            break;
        case 7:
            product = std::make_shared<Smartphone>("SP001", "Smartphone", "S007", 1, 499.99, "TechBrand", "ModelX", 128);
            break;
        case 8:
            product = std::make_shared<Television>("TV001", "Television", "S008", 4, 799.99, "ElectroBrand", "ModelY", 55);
            break;
        case 9:
            product = std::make_shared<CannedFood>("CF001", "Canned Beans", "S009", 10, 2.99, "2024-12-31", true, "Beans");
            break;
        case 10:
            product = std::make_shared<Fruit>("F001", "Apple", "S010", 15, 0.99, "2024-12-31", true, "Red Apple");
            break;
        case 11:
            product = std::make_shared<Chair>("CH001", "Office Chair", "S011", 20, 109.99, "Leather", "120x60x60 cm", true);
            break;
        case 12:
            product = std::make_shared<Table>("T001", "Dining Table", "S012", 30, 299.99, "Wood", "200x100x75 cm", "Rectangle");
            break;
        default:
            std::cout << "Invalid choice. Please try again." << std::endl;
            return;
    }

    int quantity;
    std::cout << "Enter quantity: ";
    std::cin >> quantity;

    stock.addProduct(product, quantity); 
    std::cout << product->getName() << " added successfully!" << std::endl;
}

// Method to display all products in stock
void CLI::viewProducts() {
    std::cout << "List of Products:" << std::endl;

    auto stockItems = stock.getAllStockItems(); // Assuming this returns a collection of Stock items
    if (stockItems.empty()) {
        std::cout << "No products available." << std::endl;
        return;
    }

    for (const auto& item : stockItems) {
        auto product = item.getProduct(); // Assuming getProduct() returns a shared_ptr to a Product
        // Displaying product details
        std::cout << "ID: " << product->getId()
                  << ", Name: " << product->getName()
                  << ", Supplier: " << product->getSupplier().getName()
                  << ", Packaging Units: " << product->getPackagingUnits()
                  << ", Price: " << product->getPrice()<< std::endl;
    }
}

// Method for updating a product's details
void CLI::updateProduct() {
    std::string productId, newName, newPriceStr, newPackagingUnitsStr;
    double newPrice;
    int newPackagingUnits;

    std::cout << "Enter Product ID to update: ";
    std::getline(std::cin, productId);

    // Find the product in stock
    auto stockItemToUpdate = std::find_if(stock.getAllStockItems().begin(), stock.getAllStockItems().end(),
                                          [&productId](const auto& item) {
                                              return item.getProduct()->getId() == productId;
                                          });

    if (stockItemToUpdate == stock.getAllStockItems().end()) {
        std::cout << "Product not found." << std::endl;
        return;
    }

    auto productToUpdate = (*stockItemToUpdate).getProduct();

    // Asking for new product name
    std::cout << "Enter new name (" << productToUpdate->getName() << "): ";
    std::getline(std::cin, newName);
    if (!newName.empty()) {
        productToUpdate->setName(newName);
    }

    // Asking for new product price
    std::cout << "Enter new price (" << productToUpdate->getPrice() << "): ";
    std::getline(std::cin, newPriceStr);
    if (!newPriceStr.empty()) {
        try {
            newPrice = std::stod(newPriceStr);
            productToUpdate->setPrice(newPrice);
        } catch (const std::exception& e) {
            std::cout << "Invalid input for price. Please enter a valid number." << std::endl;
            return;
        }
    }

    // Asking for new packaging units
    std::cout << "Enter new packaging units (" << productToUpdate->getPackagingUnits() << "): ";
    std::getline(std::cin, newPackagingUnitsStr);
    if (!newPackagingUnitsStr.empty()) {
        try {
            newPackagingUnits = std::stoi(newPackagingUnitsStr);
            productToUpdate->setPackagingUnits(newPackagingUnits);
        } catch (const std::exception& e) {
            std::cout << "Invalid input for packaging units. Please enter a valid number." << std::endl;
            return;
        }
    }

    std::cout << "Product updated successfully!" << std::endl;
}

// Method for deleting a product from stock
void CLI::deleteProduct() {
    std::string productId;

    std::cout << "Enter Product ID to delete: ";
    std::getline(std::cin, productId);

    // Attempting to remove the product from stock
    bool removed = stock.removeProductById(productId); // Assuming stock.removeProduct() returns a boolean
    if (removed) {
        std::cout << "Product removed successfully!" << std::endl; // Confirmation if product is successfully removed
    } else {
        std::cout << "Product not found." << std::endl; // Message if product is not found in stock
    }
}

// Method to order more stock for a product
void CLI::orderAdditionalStock() {
    std::string productId;
    int additionalQuantity;

    std::cout << "Enter Product ID for additional stock: ";
    std::getline(std::cin, productId);

    std::cout << "Enter additional quantity: ";
    std::cin >> additionalQuantity;
    std::cin.ignore(); // Clearing the newline character from the buffer

    // Attempt to add more stock to the product
    bool added = stock.addAdditionalStock(productId, additionalQuantity); // Assuming this function exists and returns a boolean
    if (added) {
        std::cout << "Additional stock ordered successfully!" << std::endl; // Success message
    } else {
        std::cout << "Product not found." << std::endl; // Error message if product doesn't exist
    }
}

// Method for managing transportation options
void CLI::manageTransport() {
    std::cout << "Transport Management" << std::endl;
    std::cout << "1. Add Transport" << std::endl;
    std::cout << "2. View Transports" << std::endl;
    std::cout << "3. Update Transport" << std::endl;
    std::cout << "4. Delete Transport" << std::endl;
    std::cout << "5. Return to Main Menu" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;
    std::cin.ignore(); // Clearing the newline character from the buffer

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
            std::cout << "Invalid choice. Please try again." << std::endl; // Message for invalid choice
    }
}

// Method for adding new transport
void CLI::addTransport() {
    std::cout << "Select Transport Type to Add:" << std::endl;
    std::cout << "1. Aircraft" << std::endl;
    std::cout << "2. Ship" << std::endl;
    std::cout << "3. Truck" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;
    std::cin.ignore(); // Clear newline character left in the buffer

    std::shared_ptr<Transport> transport;

    switch (choice) {
        case 1: {
            std::vector<std::string> airSpaces = {"Air Space A", "Air Space B"};
            transport = std::make_shared<Aircraft>("AC001", 500, 2.0, airSpaces);
            break;
        }
        case 2: {
            std::vector<std::string> seaRoutes = {"Sea Route X", "Sea Route Y"};
            transport = std::make_shared<Ship>("SH001", 30, 1.5, seaRoutes);
            break;
        }
        case 3: {
            std::vector<std::string> motorways = {"Highway 1", "Highway 2"};
            transport = std::make_shared<Truck>("TR001", 80, 0.8, motorways);
            break;
        }
        default:
            std::cout << "Invalid choice. Please try again." << std::endl;
            return;
    }

    if (transport != nullptr) {
        transportCollection.addTransport(transport); // Assuming a method to add transport
        std::cout << "Transport added successfully!" << std::endl;
    }
}

// Method to display all transports 
void CLI::viewTransports() {
    std::cout << "List of Transports:" << std::endl;

    for (const auto& transport : transportCollection.getAllTransports()) {
        // Using dynamic_pointer_cast to determine the type of transport
        auto aircraft = std::dynamic_pointer_cast<Aircraft>(transport);
        auto ship = std::dynamic_pointer_cast<Ship>(transport);
        auto truck = std::dynamic_pointer_cast<Truck>(transport);

        if (aircraft) {
            std::cout << "Aircraft - ID: " << aircraft->getId()
                      << ", Speed: " << aircraft->getSpeed()
                      << " km/h, Cost per Km: " << aircraft->getCostPerKm()
                      << ", Air Spaces: ";
            for (const auto& airSpace : aircraft->getAirSpaces()) {
                std::cout << airSpace << " ";
            }
            std::cout << std::endl;
        } else if (ship) {
            std::cout << "Ship - ID: " << ship->getId()
                      << ", Speed: " << ship->getSpeed()
                      << " km/h, Cost per Km: " << ship->getCostPerKm()
                      << ", Sea Routes: ";
            for (const auto& seaRoute : ship->getSeaRoutes()) {
                std::cout << seaRoute << " ";
            }
            std::cout << std::endl;
        } else if (truck) {
            std::cout << "Truck - ID: " << truck->getId()
                      << ", Speed: " << truck->getSpeed()
                      << " km/h, Cost per Km: " << truck->getCostPerKm()
                      << ", Motorways: ";
            for (const auto& motorway : truck->getMotorways()) {
                std::cout << motorway << " ";
            }
            std::cout << std::endl;
        }
    }
}

// Method to update a transport's details
void CLI::updateTransport() {
    std::string transportId, newSpeedStr, newCostPerKmStr;
    double newSpeed, newCostPerKm;

    std::cout << "Enter Transport ID to update: ";
    std::getline(std::cin, transportId);

    auto transportToUpdate = transportCollection.getTransportById(transportId);
    if (!transportToUpdate) {
        std::cout << "Transport not found." << std::endl;
        return;
    }

    std::cout << "Enter new speed (current: " << transportToUpdate->getSpeed() << "): ";
    std::getline(std::cin, newSpeedStr);
    if (!newSpeedStr.empty()) {
        newSpeed = std::stod(newSpeedStr);
        transportToUpdate->setSpeed(newSpeed);
    }

    std::cout << "Enter new cost per km (current: " << transportToUpdate->getCostPerKm() << "): ";
    std::getline(std::cin, newCostPerKmStr);
    if (!newCostPerKmStr.empty()) {
        newCostPerKm = std::stod(newCostPerKmStr);
        transportToUpdate->setCostPerKm(newCostPerKm);
    }

    std::cout << "Transport updated successfully!" << std::endl;
}

// Method for deleting a transport
void CLI::deleteTransport() {
    std::string transportId;

    std::cout << "Enter Transport ID to delete: ";
    std::getline(std::cin, transportId);

    bool removed = transportCollection.deleteTransport(transportId);
    if (removed) {
        std::cout << "Transport removed successfully!" << std::endl;
    } else {
        std::cout << "Transport not found." << std::endl;
    }
}

// Method for managing shipments
void CLI::manageShipments() {
    std::cout << "Shipment Management" << std::endl;
    std::cout << "1. Create Shipment" << std::endl;
    std::cout << "2. View Shipments" << std::endl;
    std::cout << "3. Update Shipment" << std::endl;
    std::cout << "4. Delete Shipment" << std::endl;
    std::cout << "5. Dispatch Shipment" << std::endl;
    std::cout << "6. Return to Main Menu" << std::endl;
    std::cout << "Enter your choice: ";

    int choice;
    std::cin >> choice;
    std::cin.ignore(); // Clearing the newline character from the buffer

    switch (choice) {
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
            // Returning to main menu
            break;
        default:
            std::cout << "Invalid choice. Please try again." << std::endl;
    }
}

// Method for creating a new shipment
void CLI::createShipment() {
    std::string shipmentId, customerId, transportId, productId;
    int quantity;
    std::cout << "Enter Shipment ID: ";
    std::getline(std::cin, shipmentId);

    std::cout << "Enter Customer ID: ";
    std::getline(std::cin, customerId);
    auto customer = customerCollection.getCustomerById(customerId);
    if (!customer) {
        std::cout << "Customer not found." << std::endl;
        return;
    }

    std::cout << "Enter Transport ID: ";
    std::getline(std::cin, transportId);
    auto transport = transportCollection.getTransportById(transportId);
    if (!transport) {
        std::cout << "Transport not found." << std::endl;
        return;
    }

    std::vector<PackagedProduct> packagedProducts;
    bool addingProducts = true;
    while(addingProducts) {
        std::cout << "Enter Product ID to add to shipment (or 'done' to finish): ";
        std::getline(std::cin, productId);
        if (productId == "done") {
            break;
        }

        auto product = stock.getProductById(productId);
        if (!product) {
            std::cout << "Product not found." << std::endl;
            continue;
        }

        std::cout << "Enter quantity of product: ";
        std::cin >> quantity;
        std::cin.ignore(); // Clear newline character

        auto stockItem = stock.getStockItem(product);
        if (!stockItem || stockItem.getQuantity() < quantity) {
            std::cout << "Insufficient stock for product: " << product.getName() << std::endl;
            continue;
        }

        stock.removeProduct(product, quantity); // Assuming this updates the stock

        Packaging packaging("Default", 1, 0.5); // Example packaging
        packagedProducts.push_back(PackagedProduct(product, packaging, quantity));
    }
    
    Shipment newShipment(shipmentId, customer, transport, packagedProducts);
    shipmentCollection.addShipment(newShipment);
    std::cout << "Shipment created successfully!" << std::endl;
}

// Method to display all shipments
void CLI::viewShipments() {
    std::cout << "List of Shipments:" << std::endl;

    for (const auto& shipment : shipmentCollection.getAllShipments()) {
        auto customer = shipment.getCustomer();
        auto transport = shipment.getTransport();

        std::cout << "Shipment Details:" << std::endl;
        std::cout << "Customer: " << customer.getName() << " (ID: " << customer.getId() << ")" << std::endl;
        std::cout << "Transport: " << transport.getId() << std::endl;

        std::cout << "Packaged Products in Shipment:" << std::endl;
        for (const auto& packagedProduct : shipment.getPackagedProducts()) {
            auto product = packagedProduct.getProduct();
            std::cout << "- Product: " << product.getName() << " (ID: " << product.getId() << "), Quantity: " << packagedProduct.getQuantity() << std::endl;
        }

        std::cout << "Total Cost: " << shipment.getTotalCost() << std::endl;
        std::cout << "-------------------------------------------------" << std::endl;
    }
}

// Method for updating an existing shipment
void CLI::updateShipment() {
    std::string shipmentId;
    std::cout << "Enter Shipment ID to update: ";
    std::getline(std::cin, shipmentId);

    auto shipmentToUpdate = shipmentCollection.getShipmentById(shipmentId);
    if (!shipmentToUpdate) {
        std::cout << "Shipment not found." << std::endl;
        return;
    }

    if (shipmentToUpdate->isDispatched()) {
        std::cout << "Cannot update a dispatched shipment." << std::endl;
        return;
    }

    std::string newTransportId;
    std::cout << "Enter new Transport ID (current: " << shipmentToUpdate->getTransport().getId() << ", or 'skip'): ";
    std::getline(std::cin, newTransportId);

    if (newTransportId != "skip") {
        auto newTransport = transportCollection.getTransportById(newTransportId);
        if (newTransport) {
            shipmentToUpdate->setTransport(newTransport);
        } else {
            std::cout << "Transport not found." << std::endl;
        }
    }

    std::cout << "Shipment updated successfully!" << std::endl;
}

// Method to delete a shipment
void CLI::deleteShipment() {
    std::string shipmentId;
    std::cout << "Enter Shipment ID to delete: ";
    std::getline(std::cin, shipmentId);

    auto shipmentToDelete = shipmentCollection.getShipmentById(shipmentId);
    if (!shipmentToDelete) {
        std::cout << "Shipment not found." << std::endl;
        return;
    }

    if (shipmentToDelete->isDispatched()) {
        std::cout << "Cannot delete a dispatched shipment." << std::endl;
        return;
    }

    if (shipmentCollection.removeShipment(shipmentId)) {
        std::cout << "Shipment deleted successfully!" << std::endl;
    } else {
        std::cout << "Error deleting shipment." << std::endl;
    }
}

// Method to dispatch a shipment
void CLI::dispatchShipment(){
    std::string shipmentId;
    std::cout << "Enter Shipment ID to dispatch: ";
    std::getline(std::cin, shipmentId);

    auto shipment = shipmentCollection.getShipmentById(shipmentId);
    if (!shipment) {
        std::cout << "Shipment not found." << std::endl;
        return;
    }

    if (shipment->isDispatched()) {
        std::cout << "Shipment has already been dispatched." << std::endl;
        return;
    }

    shipment->dispatchShipment();  
    std::cout << "Shipment dispatched successfully." << std::endl;
}

void CLI::stockviewer(){
    std::cout << "\nList of Stock:" << std::endl;
    auto stockList = stockCollection.getAllStockItems();
    if (stockList.empty()) {
        std::cout << "No Stock available." << std::endl;
        return;
    }

    for (const auto& stock : stockList) {
        std::cout << viewProducts(stock.product) 
                  << ", Product Quantity: " << customer->getQuantity()<< std::endl;
    }

}

int main(void){
    CLI cli;
    cli.run();
    return 0;
};



