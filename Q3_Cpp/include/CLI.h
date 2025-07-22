#ifndef CLI_H
#define CLI_H

#include "Product/Supplier.h"
#include "Product/Product.h"
#include "Shipment/Customer/Customer.h"
#include "Transport/TransportCollection.h"
#include "Shipment/Customer/CustomerCollection.h"
#include "Shipment/ShipmentCollection.h"
#include "Shipment/Stock/StockCollection.h"

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <memory>



class CLI {
private:
    TransportCollection transportCollection;
    CustomerCollection customerCollection;
    ShipmentCollection shipmentCollection;
    StockCollection stock;

    void showMainMenu();

    void manageCustomers(); 
    void addCustomer();
    void viewCustomers();
    void updateCustomer();
    void deleteCustomer();
    
    void manageProducts();
    void addProduct();
    void viewProducts();
    void updateProduct();
    void deleteProduct();
    void orderAdditionalStock();

    void manageTransport();
    void addTransport();
    void viewTransports();
    void updateTransport();
    void deleteTransport();

    void manageShipments();
    void createShipment();
    void viewShipments();
    void updateShipment();
    void deleteShipment();
    void dispatchShipment();

public:
    CLI();
    void run();
};

#endif // CLI_H
