#include "../../include/Shipment/Shipment.h"
#include <iostream>
#include <chrono>
#include <vector>
#include <algorithm>
#include <memory>

// Constructor for Shipment
Shipment::Shipment(std::string id, std::shared_ptr<Customer> customer, std::shared_ptr<Transport> transport, const std::vector<std::shared_ptr<PackagedProduct>>& packagedProducts)
    : id(id), customer(customer), transport(transport), packagedProducts(packagedProducts), totalCost(0.0) {
    recalculateTotalCost();
}

// Recalculates the total cost of the shipment
void Shipment::recalculateTotalCost() {
    double productAndPackagingCost = 0.0;
    for (const auto& packagedProduct : packagedProducts) {
        productAndPackagingCost += packagedProduct->calculateTotalProductCost();
    }
    double transportationCost = calculateTransportationCost();
    totalCost = productAndPackagingCost + transportationCost;
}

// Adds a product to the shipment
void Shipment::addPackagedProduct(std::shared_ptr<PackagedProduct> packagedProduct) {
    if (!isDispatched()) {
        packagedProducts.push_back(packagedProduct);
        recalculateTotalCost();
    }
}

// Removes a product from the shipment
void Shipment::removePackagedProduct(const std::string& productId) {
    if (!isDispatched()) {
        packagedProducts.erase(
            std::remove_if(packagedProducts.begin(), packagedProducts.end(), 
                [&productId](const std::shared_ptr<PackagedProduct>& p) {
                    return p->getProduct()->getId() == productId;
                }),
            packagedProducts.end()
        );
        recalculateTotalCost();
    }
}

// Calculates transportation cost
double Shipment::calculateTransportationCost() {
    double distance = calculateTotalDistance();
    return transport->calculateDeliveryCost(distance);
}

// Calculates total distance for the shipment
double Shipment::calculateTotalDistance() {
    return customer->getDistanceFromWarehouse();
}

// Calculates estimated delivery time
std::chrono::system_clock::time_point Shipment::calculateEstimatedDeliveryTime() {
    double distance = calculateTotalDistance();
    auto travelDuration = std::chrono::minutes(static_cast<long>(transport->calculateDeliveryTime(distance).count()));
    return dispatchTime + travelDuration;
}

// Dispatches the shipment
void Shipment::dispatchShipment() {
    if (isDispatched()) {
        std::cerr << "Shipment Already Dispatched" << std::endl;
        return;
    }
    dispatchTime = std::chrono::system_clock::now();
    estimatedDeliveryDateTime = calculateEstimatedDeliveryTime();
    DispatchStatus = true;
    // Printing shipment details (for demonstration purposes)
    std::cout << "Shipment dispatched successfully!" << std::endl;
    // Additional code required to print time details and totalCost
}

// Getters
std::string Shipment::getId() const {
    return id;
}

std::shared_ptr<Customer> Shipment::getCustomer() const {
    return customer;
}

std::shared_ptr<Transport> Shipment::getTransport() const {
    return transport;
}

std::vector<std::shared_ptr<PackagedProduct>> Shipment::getPackagedProducts() const {
    return packagedProducts;
}

double Shipment::getTotalCost() const {
    return totalCost;
}

bool Shipment::isDispatched() const {
    return DispatchStatus;
}

// Setters
void Shipment::setId(const std::string& id) {
    this->id = id;
}

void Shipment::setCustomer(std::shared_ptr<Customer> customer) {
    if (!isDispatched()) {
        this->customer = customer;
    }
}

void Shipment::setTransport(std::shared_ptr<Transport> transport) {
    if (!isDispatched()) {
        this->transport = transport;
    }
}

void Shipment::setPackagedProducts(const std::vector<std::shared_ptr<PackagedProduct>>& packagedProducts) {
    if (!isDispatched()) {
        this->packagedProducts = packagedProducts;
        recalculateTotalCost();
    }
}
