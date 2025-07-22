#ifndef SHIPMENT_H
#define SHIPMENT_H

#include "Customer/Customer.h"
#include <memory>
#include <vector>
#include <chrono>
#include "Packaging/PackagedProduct.h"
#include "../Transport/Aircraft.h"

class Shipment {
private:
    std::string id; // Unique ID for each shipment
    std::shared_ptr<Customer> customer; // The customer associated with this shipment
    std::shared_ptr<Transport> transport; // The mode of transport used for the shipment
    std::vector<std::shared_ptr<PackagedProduct>> packagedProducts; // List of products in the shipment
    double totalCost; // Total cost of the shipment
    // Dispatching variables
    std::chrono::system_clock::time_point dispatchTime; // Time when shipment is dispatched
    std::chrono::system_clock::time_point estimatedDeliveryDateTime; // Expected delivery date and time
    bool DispatchStatus; // Flag to check if shipment has been dispatched

    // Private methods
    void recalculateTotalCost();
    double calculateTransportationCost();
    double calculateTotalDistance();
    std::chrono::system_clock::time_point calculateEstimatedDeliveryTime();

public:
    // Constructor for Shipment
    Shipment(std::string id, std::shared_ptr<Customer> customer, std::shared_ptr<Transport> transport, const std::vector<std::shared_ptr<PackagedProduct>>& packagedProducts);

    // Methods to manage the shipment
    void addPackagedProduct(std::shared_ptr<PackagedProduct> packagedProduct);
    void removePackagedProduct(const std::string& productId);
    void dispatchShipment();

    // Getters and setters
    std::string getId() const;
    void setId(const std::string& id);
    std::shared_ptr<Customer> getCustomer() const;
    void setCustomer(std::shared_ptr<Customer> customer);
    std::shared_ptr<Transport> getTransport() const;
    void setTransport(std::shared_ptr<Transport> transport);
    std::vector<std::shared_ptr<PackagedProduct>> getPackagedProducts() const;
    void setPackagedProducts(const std::vector<std::shared_ptr<PackagedProduct>>& packagedProducts);
    double getTotalCost() const;
    bool isDispatched() const;
};

#endif // SHIPMENT_H
